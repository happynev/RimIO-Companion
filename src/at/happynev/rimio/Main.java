package at.happynev.rimio;

import com.sun.net.httpserver.HttpServer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

import java.net.InetSocketAddress;

public class Main extends Application {
    private static HttpServer server;

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(Settings.getInstance().getProperty("listenPort", "5500"));
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new RimIORequestHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        launch(args);
    }

    private static void saveWindowPos(Stage primaryStage) {
        Settings.getInstance().setProperty("sceneX", "" + primaryStage.getX());
        Settings.getInstance().setProperty("sceneY", "" + primaryStage.getY());
        Settings.getInstance().setProperty("sceneWidth", "" + primaryStage.getWidth());
        Settings.getInstance().setProperty("sceneHeight", "" + primaryStage.getHeight());
        Settings.getInstance().setProperty("sceneMaximized", "" + primaryStage.isMaximized());
    }

    private static void restoreWindowPos(Stage primaryStage) {
        double sceneX = Double.parseDouble(Settings.getInstance().getProperty("sceneX", "20"));
        double sceneY = Double.parseDouble(Settings.getInstance().getProperty("sceneY", "20"));
        double sceneWidth = Double.parseDouble(Settings.getInstance().getProperty("sceneWidth", "1500"));
        double sceneHeight = Double.parseDouble(Settings.getInstance().getProperty("sceneHeight", "900"));
        boolean sceneMaximized = Boolean.parseBoolean(Settings.getInstance().getProperty("sceneMaximized", "false"));
        primaryStage.setX(sceneX);
        primaryStage.setY(sceneY);
        primaryStage.setWidth(sceneWidth);
        primaryStage.setHeight(sceneHeight);
        primaryStage.setMaximized(sceneMaximized);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView mv=new MainView();
        primaryStage.setTitle("Rimworld Information Overload");
        primaryStage.setScene(mv.getScene());
        restoreWindowPos(primaryStage);
        primaryStage.setOnCloseRequest(
                event -> {
                    server.stop(0);
                    saveWindowPos(primaryStage);
                }
        );
        primaryStage.showingProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(newValue) {
                Platform.runLater(() -> mv.adjustForWindow(primaryStage));
            }
        });
        primaryStage.show();
    }
}
