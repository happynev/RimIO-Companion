package at.happynev.rimio;

import com.sun.javafx.css.Stylesheet;
import javafx.application.Platform;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.util.*;

public class MainView {
    private final static Stylesheet css = new Stylesheet(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("RimIO.css")).toString());
    private final static PseudoClass cssAlertClass = PseudoClass.getPseudoClass("alert");
    private final static PseudoClass cssSelectedClass = PseudoClass.getPseudoClass("gameselected");
    private final static PseudoClass cssDraftedClass = PseudoClass.getPseudoClass("drafted");
    private final static PseudoClass cssDeadClass = PseudoClass.getPseudoClass("dead");
    private final static PseudoClass cssThinClass = PseudoClass.getPseudoClass("thin");
    private final static PseudoClass cssBiggerDisplay = PseudoClass.getPseudoClass("biggerDisplay");
    private final static PseudoClass cssSmallerDisplay = PseudoClass.getPseudoClass("smallerDisplay");
    private final static PseudoClass cssHorizontalBorders = PseudoClass.getPseudoClass("horizontalBorders");
    private final static PseudoClass cssVerticalBorders = PseudoClass.getPseudoClass("verticalBorders");
    private final static PseudoClass cssMoodFine = PseudoClass.getPseudoClass("moodFine");
    private final static PseudoClass cssMoodWarning = PseudoClass.getPseudoClass("moodWarning");
    private final static PseudoClass cssMoodDanger = PseudoClass.getPseudoClass("moodDanger");
    private final static PseudoClass cssWork = PseudoClass.getPseudoClass("work");
    private final static PseudoClass cssColonist = PseudoClass.getPseudoClass("colonist");
    private final static PseudoClass cssPrisoner = PseudoClass.getPseudoClass("prisoner");
    private final static PseudoClass cssEnemy = PseudoClass.getPseudoClass("enemy");
    private final static PseudoClass cssHover = PseudoClass.getPseudoClass("hover");
    private final static Set<TableColumn<?, ?>> autofitColumns = new HashSet<>();
    private final static Map<String, BooleanProperty> configToggles = new HashMap<>();
    private final static Map<String, Collection<Node>> pawnMarkers = new HashMap<>();
    private DataController dataController = DataController.getInstance();
    private TextArea textShowRequest = new TextArea();
    private SplitPane mainDivision;
    private Pane mapViewContainer;
    private Pane pawnViewContainer;
    private Pane settingsViewContainer;
    private Scene scene;
    private DoubleProperty portraitScale = new SimpleDoubleProperty(0.8);

    public MainView() {
        buildSettingsView();
        buildPawnView();
        buildMapView();
        buildMainScene();
    }

    private static void bindToSettings(String ident, BooleanProperty p, boolean defaultValue) {
        boolean value = Boolean.parseBoolean(Settings.getInstance().getProperty(ident, "" + defaultValue));
        p.set(value);
        p.addListener((observable, oldValue, newValue) -> Settings.getInstance().setProperty(ident, "" + newValue));
        configToggles.put(ident, p);
    }

    private static void bindToSettings(String ident, StringProperty p, String defaultValue) {
        String value = Settings.getInstance().getProperty(ident, defaultValue);
        p.set(value);
        p.addListener((observable, oldValue, newValue) -> Settings.getInstance().setProperty(ident, newValue));
    }

    private static void bindToSettings(String ident, IntegerProperty p, int defaultValue) {
        int value = Integer.parseInt(Settings.getInstance().getProperty(ident, "" + defaultValue));
        p.set(value);
        p.addListener((observable, oldValue, newValue) -> Settings.getInstance().setProperty(ident, "" + newValue));
    }

    private static void bindToSettings(String ident, DoubleProperty p, double defaultValue) {
        double value = Double.parseDouble(Settings.getInstance().getProperty(ident, "" + defaultValue));
        p.set(value);
        p.addListener((observable, oldValue, newValue) -> Settings.getInstance().setProperty(ident, "" + newValue));
    }

    private static void bindColumnWidthToSettings(String ident, TableColumn<?, ?> col) {
        double value = Double.parseDouble(Settings.getInstance().getProperty(ident, "70"));
        col.prefWidthProperty().set(value);
        col.widthProperty().addListener((observable, oldValue, newValue) -> Settings.getInstance().setProperty(ident, "" + newValue));
    }

    private void buildPawnView() {
        pawnViewContainer = new VBox();
        pawnViewContainer.getChildren().add(buildPawnList());
    }

    private void buildSettingsView() {
        settingsViewContainer = new VBox();
        settingsViewContainer.setMaxWidth(Double.MAX_VALUE);
        HBox header = new HBox(2);
        header.setAlignment(Pos.TOP_RIGHT);
        ImageView compIcon = ArtAssets.getImageViewDefault(ArtAssets.COMPONENT);
        compIcon.setFitHeight(20);
        ToggleButton toggleShowSettings = new ToggleButton("Component settings", compIcon);
        toggleShowSettings.setAlignment(Pos.BASELINE_RIGHT);
        toggleShowSettings.setContentDisplay(ContentDisplay.RIGHT);
        bindToSettings("showSettings", toggleShowSettings.selectedProperty(), false);
        header.getChildren().add(toggleShowSettings);
        GridPane settingsPane = new GridPane();
        settingsPane.setHgap(5);
        settingsPane.pseudoClassStateChanged(cssVerticalBorders, true);
        settingsViewContainer.getChildren().addAll(header, settingsPane);
        settingsPane.visibleProperty().bind(toggleShowSettings.selectedProperty());
        settingsPane.managedProperty().bind(settingsPane.visibleProperty());

        Label headerColonistColumns = new Label("Select Columns to show for colonists:");
        CheckBox enableColumnPortrait = new CheckBox("Portrait");
        CheckBox enableColumnName = new CheckBox("Colonist Name");
        CheckBox enableColumnMood = new CheckBox("Mood");
        CheckBox enableColumnJob = new CheckBox("Current Job");
        CheckBox enableColumnNeeds = new CheckBox("Needs");
        CheckBox enableColumnSkills = new CheckBox("Skill Bars");
        CheckBox enableColumnHealth = new CheckBox("Health");
        CheckBox enableColumnTraits = new CheckBox("Traits");
        bindToSettings("enableColonistColumnPortrait", enableColumnPortrait.selectedProperty(), true);
        bindToSettings("enableColonistColumnName", enableColumnName.selectedProperty(), true);
        bindToSettings("enableColonistColumnMood", enableColumnMood.selectedProperty(), true);
        bindToSettings("enableColonistColumnJob", enableColumnJob.selectedProperty(), true);
        bindToSettings("enableColonistColumnNeeds", enableColumnNeeds.selectedProperty(), true);
        bindToSettings("enableColonistColumnSkills", enableColumnSkills.selectedProperty(), true);
        bindToSettings("enableColonistColumnHealth", enableColumnHealth.selectedProperty(), true);
        bindToSettings("enableColonistColumnTraits", enableColumnTraits.selectedProperty(), true);

        Pane panePortraitDetails = new VBox();
        panePortraitDetails.visibleProperty().bind(enableColumnPortrait.selectedProperty());
        panePortraitDetails.managedProperty().bind(enableColumnPortrait.selectedProperty());
        CheckBox enablePortraitDetailMood = new CheckBox("Show Mood");
        bindToSettings("enableColonistPortraitDetailMood", enablePortraitDetailMood.selectedProperty(), false);
        enablePortraitDetailMood.setVisible(false);// no mood until layout issues solved
        panePortraitDetails.getChildren().addAll();

        Pane paneNameDetails = new VBox();
        paneNameDetails.visibleProperty().bind(enableColumnName.selectedProperty());
        paneNameDetails.managedProperty().bind(enableColumnName.selectedProperty());
        RadioButton enableNameDetailFull = new RadioButton("Show Full Name");
        RadioButton enableNameDetailNick = new RadioButton("Show Nickname");
        CheckBox enableNameDetailTitle = new CheckBox("Show Label");
        ToggleGroup nameDetailToggle = new ToggleGroup();
        enableNameDetailFull.setToggleGroup(nameDetailToggle);
        enableNameDetailNick.setToggleGroup(nameDetailToggle);
        bindToSettings("enableColonistNameDetailFull", enableNameDetailFull.selectedProperty(), false);
        bindToSettings("enableColonistNameDetailNick", enableNameDetailNick.selectedProperty(), true);
        bindToSettings("enableColonistNameDetailTitle", enableNameDetailTitle.selectedProperty(), true);
        paneNameDetails.getChildren().addAll(enableNameDetailFull, enableNameDetailNick, enableNameDetailTitle);

        Pane paneSkillDetails = new VBox();
        paneSkillDetails.visibleProperty().bind(enableColumnSkills.selectedProperty());
        paneSkillDetails.managedProperty().bind(enableColumnSkills.selectedProperty());
        CheckBox enableSkillDetailDisabled = new CheckBox("Show Disabled");
        CheckBox enableSkillDetailPassionNone = new CheckBox("Show No Passion");
        CheckBox enableSkillDetailPassionMinor = new CheckBox("Show Minor Passion");
        CheckBox enableSkillDetailPassionMajor = new CheckBox("Show Major Passion");
        bindToSettings("enableColonistSkillDetailDisabled", enableSkillDetailDisabled.selectedProperty(), true);
        bindToSettings("enableColonistSkillDetailPassionNone", enableSkillDetailPassionNone.selectedProperty(), true);
        bindToSettings("enableColonistSkillDetailPassionMinor", enableSkillDetailPassionMinor.selectedProperty(), true);
        bindToSettings("enableColonistSkillDetailPassionMajor", enableSkillDetailPassionMajor.selectedProperty(), true);
        paneSkillDetails.getChildren().addAll(enableSkillDetailDisabled, enableSkillDetailPassionNone, enableSkillDetailPassionMinor, enableSkillDetailPassionMajor);

        int col = 0;
        int row = 0;
        settingsPane.add(headerColonistColumns, col, row);
        col++;
        settingsPane.add(enableColumnPortrait, col, row);
        settingsPane.add(panePortraitDetails, col, row + 1);
        col++;
        settingsPane.add(enableColumnMood, col, row);
        col++;
        settingsPane.add(enableColumnName, col, row);
        settingsPane.add(paneNameDetails, col, row + 1);
        col++;
        settingsPane.add(enableColumnJob, col, row);
        col++;
        settingsPane.add(enableColumnNeeds, col, row);
        col++;
        settingsPane.add(enableColumnSkills, col, row);
        settingsPane.add(paneSkillDetails, col, row + 1);
        col++;
        settingsPane.add(enableColumnHealth, col, row);
        col++;
        settingsPane.add(enableColumnTraits, col, row);
        col++;
        col = 0;
        row++;
        row++;

        Label headerMapSettings = new Label("Select Settings for Overview Map:");
        CheckBox enableMapShowColonist = new CheckBox("Show Colonists");
        CheckBox enableMapShowWork = new CheckBox("Show Job Targets");
        CheckBox enableMapImage = new CheckBox("Use Map Image");
        TextField textMapDirectory = new TextField();
        textMapDirectory.setEditable(false);
        textMapDirectory.setPromptText("Choose Map Image Directory");
        textMapDirectory.setPrefColumnCount(40);
        Button buttonChooseMapDirectory = new Button("...");
        buttonChooseMapDirectory.setOnAction(event -> Utilities.selectDirectory(textMapDirectory));

        HBox enableMapImageDetail = new HBox(textMapDirectory, buttonChooseMapDirectory);

        enableMapImageDetail.visibleProperty().bind(enableMapImage.selectedProperty());
        enableMapImage.managedProperty().bind(enableMapImage.selectedProperty());
        bindToSettings("enableMapShowColonist", enableMapShowColonist.selectedProperty(), true);
        bindToSettings("enableMapShowWork", enableMapShowWork.selectedProperty(), true);
        bindToSettings("enableMapImage", enableMapImage.selectedProperty(), true);
        bindToSettings("textMapDirectory", textMapDirectory.textProperty(), "");

        settingsPane.add(headerMapSettings, col, row);
        col++;
        settingsPane.add(enableMapShowColonist, col, row);
        col++;
        settingsPane.add(enableMapShowWork, col, row);
        col++;
        settingsPane.add(enableMapImage, col, row, 3, 1);
        settingsPane.add(enableMapImageDetail, col, row + 1, 3, 1);
        col++;

        for (String configToggle : configToggles.keySet()) {
            if (configToggle.startsWith("enableColonistColumn")) {
                configToggles.get(configToggle).addListener((observable, oldValue, newValue) -> pawnViewContainer.getChildren().setAll(buildPawnList()));
            }
        }
    }

    private Node buildPawnList() {
        System.out.println("building colonist table");
        Pane pawnListContainer = new VBox();

        TableView<PawnInstance> tableColonists = new TableView<>();
        VBox.setVgrow(pawnListContainer, Priority.ALWAYS);
        VBox.setVgrow(tableColonists, Priority.ALWAYS);
        //tableColonists.setMaxHeight(Double.MAX_VALUE);
        tableColonists.setSelectionModel(new Utilities.TableViewUnselectableModel<>(tableColonists));
        //tableColonists.setColumnResizePolicy(param -> false);
        tableColonists.setSortPolicy(param -> false);
        addPawnTableColumns(tableColonists, "Colonist");
        tableColonists.setRowFactory(param -> new TableRow<PawnInstance>() {
                    @Override
                    protected void updateItem(PawnInstance item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            BooleanExpression isInAlertState = item.isDowned.or(item.health.lessThanOrEqualTo(0.2f));
                            Utilities.addCssClassSwitch(this, cssAlertClass, isInAlertState);
                            Utilities.addCssClassSwitch(this, cssSelectedClass, item.isSelected);
                            Utilities.addCssClassSwitch(this, cssDeadClass, item.isDead);
                            Utilities.addCssClassSwitch(this, cssDraftedClass, item.isDrafted);

                            Set<Node> replication = new HashSet<>(pawnMarkers.getOrDefault(item.getPawnId(), Collections.emptyList()));
                            replication.add(this);
                            Utilities.replicatePseudoClasses(replication, cssHover.getPseudoClassName());
                        }
                    }
                }
        );
        tableColonists.setItems(new FilteredList<>(DataController.getInstance().pawns, pawnInstance -> pawnInstance.isColonist.get()));
        pawnListContainer.getChildren().addAll(tableColonists);
        return pawnListContainer;
    }

    private void addPawnTableColumns(TableView<PawnInstance> table, String propPrefix) {
        List<TableColumn<PawnInstance, ?>> ret = new ArrayList<>();
        TableColumn<PawnInstance, Image> columnPortrait = new TableColumn<>("Portrait");
        TableColumn<PawnInstance, String> columnLabel = new TableColumn<>("Name");
        TableColumn<PawnInstance, Number> columnMood = new TableColumn<>("Mood");
        TableColumn<PawnInstance, PawnInstance.Job> columnJob = new TableColumn<>("Current Job");
        TableColumn<PawnInstance, String> columnTraits = new TableColumn<>("Traits");
        TableColumn<PawnInstance, String> columnSkills = new TableColumn<>("Skill Bars");
        TableColumn<PawnInstance, String> columnNeeds = new TableColumn<>("Needs");
        TableColumn<PawnInstance, String> columnHealth = new TableColumn<>("Health");
        columnPortrait.setPrefWidth(10 + ArtAssets.BIG_ICON_SIZE * portraitScale.get());
        columnLabel.setCellValueFactory(param -> param.getValue().label);
        columnMood.setCellValueFactory(param -> param.getValue().needs.get("Mood"));
        columnTraits.setCellValueFactory(param -> new SimpleStringProperty("dummy"));
        columnNeeds.setCellValueFactory(param -> new SimpleStringProperty("dummy"));
        columnSkills.setCellValueFactory(param -> new SimpleStringProperty("dummy"));
        columnHealth.setCellValueFactory(param -> new SimpleStringProperty("dummy"));
        columnLabel.setSortable(true);
        columnLabel.setCellFactory(param -> new PawnTableCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    String detailPrefix = "enable" + propPrefix + "NameDetail";
                    String[] nicknameAndTitle = item.split(",\\s*", 2);
                    Label name = new Label();
                    name.pseudoClassStateChanged(cssBiggerDisplay, true);
                    Utilities.addCssClassSwitch(name, cssDraftedClass, pawn.isDrafted);
                    name.textProperty().bind(new When(configToggles.get(detailPrefix + "Full")).then(pawn.fullName).otherwise(pawn.nickName));
                    Label title = new Label(nicknameAndTitle[1]);
                    title.visibleProperty().bind(configToggles.get(detailPrefix + "Title"));
                    title.managedProperty().bind(title.visibleProperty());
                    setGraphic(new VBox(name, title));
                }
            }
        });
        columnJob.setCellValueFactory(param -> param.getValue().currentJob);
        columnPortrait.setCellValueFactory(param -> param.getValue().portrait);
        //PORTRAIT
        columnPortrait.setCellFactory(param -> new PawnTableCell<Image>() {
            @Override
            protected void updateItem(Image item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    Pane portraitPane = createPawnPortrait(pawn, propPrefix);
                    setGraphic(portraitPane);
                }
            }
        });

        //MOOD
        columnMood.setCellFactory(param -> new PawnTableCell<Number>() {
            @Override
            protected void updateItem(Number item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    Pane container = new Pane();
                    ProgressBar bar = createNeedBar(pawn, "Mood");
                    bar.prefWidthProperty().bind(container.widthProperty());
                    bar.prefHeightProperty().bind(container.heightProperty());
                    container.getChildren().add(bar);
                    setGraphic(container);
                }
            }
        });

        //JOB
        columnJob.setCellFactory(param -> new PawnTableCell<PawnInstance.Job>() {
            @Override
            protected void updateItem(PawnInstance.Job item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    Label label = new Label(item.getFullText());
                    label.setWrapText(true);
                    setGraphic(label);
                }
            }
        });

        //NEEDS
        columnNeeds.setCellFactory(param -> new PawnTableCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    getTableColumn().setResizable(false); //prevent autosize. doesnt work atm. should be fixed in java 8u192 due in oct 2018?
                    FlowPane needGrid = new FlowPane();
                    Pane shrinkContainer = new Pane(needGrid);
                    needGrid.prefWidthProperty().bind(this.widthProperty());
                    needGrid.prefWrapLengthProperty().bind(this.widthProperty());
                    shrinkContainer.minHeightProperty().bind(needGrid.heightProperty());
                    needGrid.getStyleClass().add("pane");
                    for (String need : new String[]{"Food", "Rest", "Recreation", "Beauty", "Comfort", "Outdoors"}) {
                        Pane needPane = new StackPane();
                        ProgressBar bar = createNeedBar(pawn, need);
                        Label label = new Label(need);
                        label.pseudoClassStateChanged(cssSmallerDisplay, true);
                        needPane.getChildren().addAll(bar, label);
                        needGrid.getChildren().add(needPane);
                    }
                    setGraphic(shrinkContainer);
                    Platform.runLater(() -> getTableColumn().setResizable(true));
                }
            }
        });

        //SKILLS
        columnSkills.setCellFactory(param -> new PawnTableCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    getTableColumn().setResizable(false); //prevent autosize. doesnt work atm. should be fixed in java 8u192 due in oct 2018?
                    FlowPane skillGrid = new FlowPane();
                    Pane shrinkContainer = new Pane(skillGrid);
                    skillGrid.prefWidthProperty().bind(this.widthProperty());
                    skillGrid.prefWrapLengthProperty().bind(this.widthProperty());
                    shrinkContainer.minHeightProperty().bind(skillGrid.heightProperty());
                    skillGrid.getStyleClass().add("pane");
                    for (PawnInstance.SkillData skill : pawn.skills) {
                        Pane skillPane = createPawnSkillBar(pawn, skill, propPrefix);
                        skillGrid.getChildren().add(skillPane);
                    }
                    setGraphic(shrinkContainer);
                    Platform.runLater(() -> getTableColumn().setResizable(true));
                }
            }
        });

        //HEALTH
        columnHealth.setCellFactory(param -> new PawnTableCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    Pane container = new FlowPane();
                    pawn.hediffs.addListener((ListChangeListener<? super PawnInstance.Hediff>) c -> {
                        List<Pane> allDiffs = new ArrayList<>(); //too lazy to do this with obervablelist
                        for (PawnInstance.Hediff hediff : pawn.hediffs) {

                        }
                        container.getChildren().setAll(allDiffs);
                    });

                    setGraphic(container);
                }
            }
        });

        //TRAITS
        columnTraits.setCellFactory(param -> new PawnTableCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    Pane vbox = new VBox();
                    pawn.traits.addListener((ListChangeListener<? super String>) c -> {
                        //build new, regardless of change
                        reAddTraits(vbox, pawn.traits);
                    });
                    reAddTraits(vbox, pawn.traits);
                    setGraphic(vbox);
                }
            }

            private void reAddTraits(Pane p, List<String> traits) {
                p.getChildren().clear();
                for (String trait : traits) {
                    p.getChildren().add(new Label(trait));
                }
            }
        });
        if (configToggles.get("enable" + propPrefix + "ColumnPortrait").get()) {
            table.getColumns().add(columnPortrait);
            bindColumnWidthToSettings(propPrefix + "ColumnWidthPortrait", columnPortrait);
        }
        if (configToggles.get("enable" + propPrefix + "ColumnName").get()) {
            table.getColumns().add(columnLabel);
            bindColumnWidthToSettings(propPrefix + "ColumnWidthLabel", columnLabel);
        }
        if (configToggles.get("enable" + propPrefix + "ColumnMood").get()) {
            table.getColumns().add(columnMood);
            bindColumnWidthToSettings(propPrefix + "ColumnWidthMood", columnLabel);
        }
        if (configToggles.get("enable" + propPrefix + "ColumnJob").get()) {
            table.getColumns().add(columnJob);
            bindColumnWidthToSettings(propPrefix + "ColumnWidthJob", columnJob);
        }
        if (configToggles.get("enable" + propPrefix + "ColumnNeeds").get()) {
            table.getColumns().add(columnNeeds);
            bindColumnWidthToSettings(propPrefix + "ColumnWidthNeeds", columnNeeds);
        }
        if (configToggles.get("enable" + propPrefix + "ColumnSkills").get()) {
            table.getColumns().add(columnSkills);
            bindColumnWidthToSettings(propPrefix + "ColumnWidthSkills", columnSkills);
        }
        if (configToggles.get("enable" + propPrefix + "ColumnHealth").get()) {
            table.getColumns().add(columnHealth);
            bindColumnWidthToSettings(propPrefix + "ColumnWidthHealth", columnHealth);
        }
        if (configToggles.get("enable" + propPrefix + "ColumnTraits").get()) {
            table.getColumns().add(columnTraits);
            bindColumnWidthToSettings(propPrefix + "ColumnWidthTraits", columnTraits);
        }

        if (configToggles.get("enable" + propPrefix + "ColumnJob").get()) {
            //Utilities.bindColumnToRemainingSize(columnJob);
        }
        autofitColumns.add(columnPortrait);
        autofitColumns.add(columnLabel);
        autofitColumns.add(columnNeeds);
        autofitColumns.add(columnSkills);
        autofitColumns.add(columnHealth);
        autofitColumns.add(columnTraits);
    }

    private BooleanExpression checkForDisplay(String propPrefix, PawnInstance.SkillData skill) {
        String detailPrefix = "enable" + propPrefix + "SkillDetail";
        BooleanProperty showDisabled = configToggles.get(detailPrefix + "Disabled");
        BooleanProperty showPassionNone = configToggles.get(detailPrefix + "PassionNone");
        BooleanProperty showPassionMinor = configToggles.get(detailPrefix + "PassionMinor");
        BooleanProperty showPassionMajor = configToggles.get(detailPrefix + "PassionMajor");
        BooleanExpression ret = BooleanExpression.booleanExpression(skill.enabled.or(showDisabled));
        ret = ret.and(skill.passion.isEqualTo("None").not().or(showPassionNone));
        ret = ret.and(skill.passion.isEqualTo("Minor").not().or(showPassionMinor));
        ret = ret.and(skill.passion.isEqualTo("Major").not().or(showPassionMajor));
        return ret;
    }

    public void autoFitPawnTable() {
        for (TableColumn<?, ?> col : autofitColumns) {
            if (col != null) {
                Utilities.autoFitColumn(col);
            }
        }
    }

    private Pane createPawnPortrait(PawnInstance p, String propPrefix) {
        if (p.portrait.get() == null) {
            return null;
        }
        String detailPrefix = "enable" + propPrefix + "PortraitDetail";
        StackPane ret = new StackPane();
        double width = p.portrait.get().getWidth();//assume static dimensions
        double height = p.portrait.get().getHeight();//assume static dimensions
        ret.prefWidthProperty().bind(portraitScale.multiply(width));
        ret.prefHeightProperty().bind(portraitScale.multiply(height));
        ret.maxHeightProperty().bind(portraitScale.multiply(height));

        ProgressBar moodBar = createNeedBar(p, "Mood");
        Group moodBarGroup = new Group(moodBar);
        moodBar.getTransforms().add(new Rotate(-90, 0, 0));
        moodBar.prefWidthProperty().bind(ret.heightProperty());
        moodBar.prefHeightProperty().bind(ret.widthProperty());
        //ret.prefHeightProperty().addListener((observable, oldValue, newValue) -> translateToBottom.setX((double) newValue));
        moodBarGroup.visibleProperty().bind(configToggles.get(detailPrefix + "Mood"));
        moodBarGroup.managedProperty().bind(moodBar.visibleProperty());

        ImageView portrait = new ImageView();
        portrait.fitWidthProperty().bind(ret.prefWidthProperty());
        portrait.setSmooth(true);
        portrait.setPreserveRatio(true);
        portrait.imageProperty().bind(p.portrait);

        ImageView overlayDead = ArtAssets.getImageViewDefault(ArtAssets.DEAD);
        overlayDead.fitHeightProperty().bind(ret.heightProperty());
        overlayDead.visibleProperty().bind(p.isDead);

        ImageView statusIdle = ArtAssets.getImageViewDefault(ArtAssets.IDLE);
        ImageView statusSleeping = ArtAssets.getImageViewDefault(ArtAssets.SLEEPING);
        ImageView statusMedicalRest = ArtAssets.getImageViewDefault(ArtAssets.MEDICALREST);
        ImageView statusMental = ArtAssets.getImageViewDefault(ArtAssets.MENTAL_NONAGGRO);
        ImageView statusMentalAggro = ArtAssets.getImageViewDefault(ArtAssets.MENTAL_AGGRO);
        ImageView statusDrafted = ArtAssets.getImageViewDefault(ArtAssets.DRAFT);
        statusDrafted.setFitWidth(20);

        statusIdle.visibleProperty().bind(p.isIdle);
        statusSleeping.visibleProperty().bind(p.isSleeping);
        statusMedicalRest.visibleProperty().bind(p.isMedicalRest);
        statusMental.visibleProperty().bind(p.isInMentalState);
        statusMentalAggro.visibleProperty().bind(p.isInAggroMentalState);
        statusDrafted.visibleProperty().bind(p.isDrafted);

        StackPane.setAlignment(statusIdle, Pos.TOP_LEFT);
        StackPane.setAlignment(statusSleeping, Pos.TOP_RIGHT);
        StackPane.setAlignment(statusMedicalRest, Pos.TOP_RIGHT);
        StackPane.setAlignment(statusMental, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(statusMentalAggro, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(statusDrafted, Pos.BOTTOM_RIGHT);

        ret.getChildren().addAll(moodBarGroup, portrait, statusIdle, statusSleeping, statusMedicalRest, statusMental, statusMentalAggro, statusDrafted, overlayDead);
        return ret;
    }

    private ProgressBar createNeedBar(PawnInstance p, String need) {
        ProgressBar bar = new ProgressBar();
        FloatProperty value = p.needs.get(need);
        bar.progressProperty().addListener((observable, oldValue, newValue) -> {
            bar.pseudoClassStateChanged(cssMoodDanger, false);
            bar.pseudoClassStateChanged(cssMoodWarning, false);
            bar.pseudoClassStateChanged(cssMoodFine, false);
            if ((double) newValue < 0.25d) {
                bar.pseudoClassStateChanged(cssMoodDanger, true);
            } else if ((double) newValue < 0.5d) {
                bar.pseudoClassStateChanged(cssMoodWarning, true);
            } else {
                bar.pseudoClassStateChanged(cssMoodFine, true);
            }
        });
        bar.progressProperty().bind(value);
        Tooltip toolTip = new Tooltip();
        toolTip.textProperty().bind(Bindings.concat(need + ": ").concat(value.multiply(100).asString("%.0f")).concat("%\n"));
        bar.setTooltip(toolTip);
        return bar;
    }

    private Pane createPawnSkillBar(PawnInstance p, PawnInstance.SkillData skill, String propPrefix) {
        StackPane ret = new StackPane();
        ret.setAlignment(Pos.TOP_CENTER);
        ProgressBar skillLevel = new ProgressBar();
        skillLevel.progressProperty().bind(skill.level.divide(20.0f));

        ProgressBar skillProgress = new ProgressBar();
        skillProgress.progressProperty().bind(skill.xpProgress);
        skillProgress.pseudoClassStateChanged(cssThinClass, true);

        VBox progressBars = new VBox(skillLevel, skillProgress);
        Label skillLabel = new Label(skill.getName());
        skillLabel.pseudoClassStateChanged(cssSmallerDisplay, true);
        Pane passionContainer = new Pane();
        passionContainer.prefHeightProperty().bind(skillLabel.heightProperty());
        passionContainer.prefWidthProperty().bind(skillLabel.heightProperty());
        if (skill.passion.get().equals("Major")) {
            ImageView passionFlame = ArtAssets.getImageViewDefault(ArtAssets.PASSIONMAJOR);
            passionFlame.fitHeightProperty().bind(skillLabel.heightProperty());
            passionContainer.getChildren().add(passionFlame);
        } else if (skill.passion.get().equals("Minor")) {
            ImageView passionFlame = ArtAssets.getImageViewDefault(ArtAssets.PASSIONMINOR);
            passionFlame.fitHeightProperty().bind(skillLabel.heightProperty());
            passionContainer.getChildren().add(passionFlame);
        } else {

        }
        if (skill.enabled.get()) {
            ret.getChildren().addAll(progressBars, passionContainer, skillLabel);
        } else {
            skillLevel.setVisible(false);//to keep layout
            skillProgress.setVisible(false);
            ret.getChildren().addAll(progressBars, skillLabel);
        }
        Tooltip toolTip = new Tooltip();
        toolTip.textProperty().bind(Bindings
                .concat(skill.getName().concat(":\nLevel: "))
                .concat(skill.level).concat("\n")
                .concat("XP for next level: ").concat(skill.xpProgress.multiply(100).asString("%.0f")).concat("%\n")
                .concat(skill.currentXp).concat("/").concat(skill.levelupXp)
        );

        Tooltip.install(ret, toolTip);
        ret.visibleProperty().bind(checkForDisplay(propPrefix, skill));
        ret.managedProperty().bind(ret.visibleProperty());
        return ret;
    }

    private void buildMapView() {
        mapViewContainer = new VBox(2);
        Pane mapImageContainer = new Pane();
        createPawnOverviewMap(mapImageContainer);

        VBox.setVgrow(textShowRequest, Priority.ALWAYS);
        DataController.getInstance().currentGameData.addListener((observable, oldValue, newValue) -> textShowRequest.setText(newValue));
        textShowRequest.textProperty().set(Settings.getInstance().getProperty("lastData", "nix"));
        Button testButton = new Button("Test");
        testButton.setOnAction(event -> {
            int pos = textShowRequest.getCaretPosition();
            DataController.getInstance().currentGameData.set(textShowRequest.getText());
            textShowRequest.positionCaret(pos);
            Settings.getInstance().setProperty("lastData", textShowRequest.getText());
        });
        mapViewContainer.getChildren().addAll(mapImageContainer, textShowRequest, testButton);
    }

    private void createPawnOverviewMap(Pane container) {
        ImageView map = new ImageView();

        map.setSmooth(true);
        map.setPreserveRatio(true);
        DataController.getInstance().currentGameData.addListener((observable, oldValue, newValue) -> {
            if (configToggles.get("enableMapImage").get()) {
                File newImage = Utilities.findMapImage(Settings.getInstance().getProperty("textMapDirectory"), DataController.getInstance().worldSeed.get());
                if (newImage != null) {
                    try {
                        Image img = new Image(newImage.toURI().toURL().toString(), true);
                        img.progressProperty().addListener((observable1, oldValue1, newValue1) -> {
                            if (newValue1.floatValue() == 1.0f) {
                                map.setImage(img);
                            }
                        });
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("didnt find anything for seed " + DataController.getInstance().worldSeed.get() + " in " + Settings.getInstance().getProperty("textMapDirectory"));
                }
            }
        });
        container.getChildren().add(map);
        map.fitWidthProperty().bind(container.widthProperty());
        dataController.pawns.addListener((ListChangeListener<? super PawnInstance>) c -> {
            DoubleBinding mapScale = map.fitWidthProperty().divide(DataController.getInstance().maps.get(0).getSizeX());
            c.next();
            for (PawnInstance p : c.getAddedSubList()) {
                System.out.println("map pawn " + p.nickName + " added");
                List<Node> markers = createPawnMapMarkers(p, mapScale);
                if (!pawnMarkers.containsKey(p.getPawnId())) {
                    pawnMarkers.put(p.getPawnId(), markers);
                } else {
                    System.out.println("map pawn " + p.nickName + " already has markers");
                }
                container.getChildren().addAll(markers);
            }
            for (PawnInstance p : c.getRemoved()) {
                System.out.println("map pawnmarkers " + p.nickName + " removed " + container.getChildren().removeAll(pawnMarkers.get(p.getPawnId())));
            }
        });
    }

    private List<Node> createPawnMapMarkers(PawnInstance pawn, DoubleBinding mapScale) {
        List<Node> markers = new ArrayList<>();
        Circle pawnLoc = new Circle(5);
        Line workPathA = new Line();
        Circle workLocA = new Circle(4);
        Line workPathB = new Line();
        Circle workLocB = new Circle(4);
        Line workPathC = new Line();
        Circle workLocC = new Circle(4);
        markers.add(workPathA);
        markers.add(workPathB);
        markers.add(workPathC);
        markers.add(workLocA);
        markers.add(workLocB);
        markers.add(workLocC);
        markers.add(pawnLoc);

        workPathA.getStyleClass().addAll("workPath");
        workPathB.getStyleClass().addAll("workPath");
        workPathC.getStyleClass().addAll("workPath");
        workLocA.getStyleClass().addAll("locationMarker");
        workLocB.getStyleClass().addAll("locationMarker");
        workLocC.getStyleClass().addAll("locationMarker");
        pawnLoc.getStyleClass().addAll("locationMarker");

        //todo: changelistener
        Utilities.bindPseudoClass(pawnLoc, pawn.isColonist, cssColonist);
        Utilities.bindPseudoClass(pawnLoc, pawn.isEnemy, cssEnemy);
        Utilities.bindPseudoClass(pawnLoc, pawn.isPrisoner, cssPrisoner);

        workLocA.pseudoClassStateChanged(cssWork, true);
        workLocB.pseudoClassStateChanged(cssWork, true);
        workLocC.pseudoClassStateChanged(cssWork, true);

        Tooltip toolTip = new Tooltip();
        toolTip.textProperty().bind(pawn.nickName);
        Utilities.replicatePseudoClasses(markers, cssHover.getPseudoClassName());

        for (Node n : markers) {
            Tooltip.install(n, toolTip);
        }
        BooleanBinding showColonist = configToggles.get("enableMapShowColonist").and(pawn.isColonist);
        int sizey = DataController.getInstance().maps.get(0).getSizeY();
        pawnLoc.centerXProperty().bind(pawn.locationX.multiply(mapScale));
        pawnLoc.centerYProperty().bind(pawn.locationY.subtract(sizey).multiply(mapScale.multiply(-1)));
        pawnLoc.visibleProperty().bind(showColonist);

        workLocA.centerXProperty().bind(pawn.jobTargetAX.multiply(mapScale));
        workLocA.centerYProperty().bind(pawn.jobTargetAY.subtract(sizey).multiply(mapScale.multiply(-1)));
        workLocA.visibleProperty().bind(pawn.jobTargetAX.greaterThan(-1).and(configToggles.get("enableMapShowWork")));

        workLocB.centerXProperty().bind(pawn.jobTargetBX.multiply(mapScale));
        workLocB.centerYProperty().bind(pawn.jobTargetBY.subtract(sizey).multiply(mapScale.multiply(-1)));
        workLocB.visibleProperty().bind(pawn.jobTargetBX.greaterThan(-1).and(configToggles.get("enableMapShowWork")));

        workLocC.centerXProperty().bind(pawn.jobTargetCX.multiply(mapScale));
        workLocC.centerYProperty().bind(pawn.jobTargetCY.subtract(sizey).multiply(mapScale.multiply(-1)));
        workLocC.visibleProperty().bind(pawn.jobTargetCX.greaterThan(-1).and(configToggles.get("enableMapShowWork")));

        workPathA.visibleProperty().bind(workLocA.visibleProperty().and(showColonist));
        workPathA.startXProperty().bind(pawnLoc.centerXProperty());
        workPathA.startYProperty().bind(pawnLoc.centerYProperty());
        workPathA.endXProperty().bind(workLocA.centerXProperty());
        workPathA.endYProperty().bind(workLocA.centerYProperty());

        workPathB.visibleProperty().bind(workLocB.visibleProperty().and(showColonist));
        workPathB.startXProperty().bind(workLocA.centerXProperty());
        workPathB.startYProperty().bind(workLocA.centerYProperty());
        workPathB.endXProperty().bind(workLocB.centerXProperty());
        workPathB.endYProperty().bind(workLocB.centerYProperty());

        workPathC.visibleProperty().bind(workLocC.visibleProperty().and(showColonist));
        workPathC.startXProperty().bind(workLocB.centerXProperty());
        workPathC.startYProperty().bind(workLocB.centerYProperty());
        workPathC.endXProperty().bind(workLocC.centerXProperty());
        workPathC.endYProperty().bind(workLocC.centerYProperty());

        return markers;
    }

    private void buildMainScene() {
        BorderPane root = new BorderPane();
        root.getStylesheets().add(css.getUrl());
        scene = new Scene(root, 1500, 900);
        mainDivision = new SplitPane(pawnViewContainer, mapViewContainer);
        root.setTop(settingsViewContainer);
        root.setCenter(mainDivision);
        DataController.getInstance().tick.addListener((observable, oldValue, newValue) -> afterDataUpdate());
    }

    public Scene getScene() {
        return scene;
    }

    public void adjustForWindow(Stage primaryStage) {
        //must be done after window show, otherwise it is reset...
        mainDivision.getDividers().get(0).setPosition(Double.parseDouble(Settings.getInstance().getProperty("mainDividerPosition", "0.5")));
        mainDivision.getDividers().get(0).positionProperty().addListener((observable, oldValue, newValue) -> Settings.getInstance().setProperty("mainDividerPosition", "" + newValue));
    }

    public void afterDataUpdate() {
        autoFitPawnTable();
    }

    public static class PawnTableCell<T> extends TableCell<PawnInstance, T> {
        protected PawnInstance pawn;

        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            if ((item != null || empty) && getIndex() >= 0 && getTableView().getItems().size() > getIndex()) {
                pawn = getTableView().getItems().get(getIndex());
            }
        }
    }
}
