package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Upper section of the application
        TextArea jsonToStringText = new TextArea();
        jsonToStringText.setPromptText("Insert JSON to convert to a String");
        Button jsonToStringBtn = new Button("Convert to String");
        HBox jsonToStringBtnHbox = new HBox(jsonToStringBtn);
        jsonToStringBtnHbox.setAlignment(Pos.CENTER);
        jsonToStringBtnHbox.setPadding(new Insets(5));
        VBox jsonToString = new VBox(jsonToStringText, jsonToStringBtnHbox);
        jsonToString.setPadding(new Insets(15));

        // Lower section of the application
        TextArea stringToJsonText = new TextArea();
        stringToJsonText.setPromptText("Insert String to convert to JSON");
        Button stringToJsonBtn = new Button("Convert to JSON");
        HBox stringToJsonBtnHbox = new HBox(stringToJsonBtn);
        stringToJsonBtnHbox.setAlignment(Pos.CENTER);
        stringToJsonBtnHbox.setPadding(new Insets(5));
        VBox stringToJson = new VBox(stringToJsonText, stringToJsonBtnHbox);
        stringToJson.setPadding(new Insets(15));

        // Root of the application
        VBox center = new VBox(jsonToString, stringToJson);
        BorderPane root = new BorderPane();
        root.setCenter(center);

        jsonToStringBtn.setOnAction((event) -> {
            // Convert from a String to JSON
            String converted = Converter.toJson(jsonToStringText.getText());
            stringToJsonText.setText(Converter.toString(converted));
        });

        stringToJsonBtn.setOnAction((event) -> {
            // Convert from JSON to a String
            String converted = Converter.toJson(stringToJsonText.getText());
            jsonToStringText.setText(converted);
        });

        primaryStage.setTitle("JSON Converter");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
