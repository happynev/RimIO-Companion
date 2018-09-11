package at.happynev.rimio;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

class RimIORequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(t.getRequestBody(), StandardCharsets.UTF_8));
        String data=reader.lines().collect(Collectors.joining("\n"));
        String response = "received";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
        Platform.runLater(() -> DataController.getInstance().currentGameData.setValue(data));
    }
}
