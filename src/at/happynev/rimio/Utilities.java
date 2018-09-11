package at.happynev.rimio;

import com.sun.javafx.scene.control.skin.TableViewSkin;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.css.PseudoClass;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Utilities {
    private static Method columnToFitMethod;

    static {
        try {
            columnToFitMethod = TableViewSkin.class.getDeclaredMethod("resizeColumnToFitContent", TableColumn.class, int.class);
            columnToFitMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double vx = x2 - x1;
        double vy = y2 - y1;
        return Math.sqrt(vx * vx + vy * vy);
    }

    public static String toWebRGB(Color color) {
        return String.format("#%02X%02X%02X", (int) (color.getRed() * 255), (int) (color.getGreen() * 255), (int) (color.getBlue() * 255));
    }

    public static void addCssClassSwitch(Node n, PseudoClass c, ObservableValue<Boolean> v) {
        n.pseudoClassStateChanged(c, v.getValue());
        v.addListener((observable, oldValue, newValue) -> n.pseudoClassStateChanged(c, newValue));
    }

    public static ColumnConstraints getColumnConstraint(Label label) {
        Text measure = new Text(label.getText());
        measure.setFont(label.getFont());
        double prefWidth = measure.getLayoutBounds().getWidth();
        return new ColumnConstraints(prefWidth, prefWidth, Double.MAX_VALUE, Priority.SOMETIMES, HPos.LEFT, true);
    }

    public static void autoFitColumn(TableColumn<?, ?> c) {
        try {
            if (c.getTableView() != null && c.getTableView().getSkin() != null) {
                columnToFitMethod.invoke(c.getTableView().getSkin(), c, -1);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void bindColumnToRemainingSize(TableColumn<?, ?> column) {
        TableView<?> table = column.getTableView();
        DoubleExpression remainingWidth = table.widthProperty().subtract(10);
        for (TableColumn<?, ?> col : table.getColumns()) {
            if (!col.equals(column)) {
                remainingWidth = remainingWidth.subtract(col.widthProperty());
            }
        }
        column.prefWidthProperty().bind(remainingWidth);
    }

    public static void bindPseudoClass(Node node, BooleanProperty enabled, PseudoClass cl) {
        node.pseudoClassStateChanged(cl, enabled.getValue());
        enabled.addListener((observable, oldValue, newValue) -> node.pseudoClassStateChanged(cl, newValue));
    }

    public static void replicatePseudoClasses(Collection<Node> nodes, String... watchedClasses) {
        List<String> watchList = Arrays.asList(watchedClasses);
        for (Node n : nodes) {
            Set<Node> others = new HashSet<>(nodes);
            others.remove(n);
            n.getPseudoClassStates().addListener((SetChangeListener<? super PseudoClass>) change -> {
                PseudoClass add = change.getElementAdded();
                PseudoClass del = change.getElementRemoved();
                if (add != null && watchList.contains(add.getPseudoClassName())) {
                    for (Node o : others) {
                        o.pseudoClassStateChanged(add, true);
                    }
                }
                if (del != null && watchList.contains(del.getPseudoClassName())) {
                    for (Node o : others) {
                        o.pseudoClassStateChanged(del, false);
                    }
                }
            });
        }
    }

    public static void selectDirectory(TextField textfield) {
        DirectoryChooser dc = new DirectoryChooser();
        File current = new File(textfield.getText());
        if (textfield.getText().isEmpty()) {
            current = new File(".");
        }
        if (current.isDirectory()) {
            dc.setInitialDirectory(current);
        }
        File chosen = dc.showDialog(null);
        if (chosen != null && chosen.isDirectory()) {
            textfield.setText(chosen.toString());
        }
    }

    public static File findMapImage(String directory, String worldSeed) {
        File dir = new File(directory);
        if (!dir.isDirectory()) {
            return null;
        }
        File worlddir = new File(directory, worldSeed);
        String matchRegex = ".*" + worldSeed + ".*\\.(jpe?g|png)$";
        if (worlddir.isDirectory()) {
            dir = worlddir;
        }

        File lastMatch = null;
        File[] files = dir.listFiles((dir1, name) -> name.matches(matchRegex));
        for (File f : files) {
            lastMatch = f;
        }
        return lastMatch;
    }

    public static class TableViewUnselectableModel<T> extends TableView.TableViewSelectionModel<T> {

        public TableViewUnselectableModel(TableView<T> tableView) {
            super(tableView);
        }

        @Override
        public ObservableList<TablePosition> getSelectedCells() {
            return FXCollections.emptyObservableList();
        }

        @Override
        public void selectLeftCell() {

        }

        @Override
        public void selectRightCell() {

        }

        @Override
        public void selectAboveCell() {

        }

        @Override
        public void selectBelowCell() {

        }

        @Override
        public void clearSelection(int i, TableColumn tableColumn) {

        }

        @Override
        public void clearAndSelect(int i, TableColumn tableColumn) {

        }

        @Override
        public void select(int i, TableColumn tableColumn) {

        }

        @Override
        public boolean isSelected(int i, TableColumn tableColumn) {
            return false;
        }

        @Override
        public ObservableList<Integer> getSelectedIndices() {
            return FXCollections.emptyObservableList();
        }

        @Override
        public ObservableList<T> getSelectedItems() {
            return FXCollections.emptyObservableList();
        }

        @Override
        public void selectIndices(int i, int... ints) {

        }

        @Override
        public void selectAll() {

        }

        @Override
        public void clearAndSelect(int i) {

        }

        @Override
        public void select(int i) {

        }

        @Override
        public void select(Object o) {

        }

        @Override
        public void clearSelection(int i) {

        }

        @Override
        public void clearSelection() {

        }

        @Override
        public boolean isSelected(int i) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public void selectPrevious() {

        }

        @Override
        public void selectNext() {

        }

        @Override
        public void selectFirst() {

        }

        @Override
        public void selectLast() {

        }
    }
}
