package application;
	
import java.util.Base64;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	try {
		GridPane grid= new GridPane();
	
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
		Scene scene = new Scene(grid,500,500);
		
		Label etiqueta = new Label("Palabra");
		grid.add(etiqueta, 0, 1);
		TextField palabra= new TextField();
		grid.add(palabra, 1, 1);
		Button encriptar= new Button("encriptar");
		grid.add(encriptar, 1, 2);
		Button desencriptar= new Button("desencriptar");
		grid.add(desencriptar, 2, 2);
		Label resultado= new Label();
		grid.add(resultado, 2, 1);
		encriptar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				byte[] palabras=  palabra.getText().getBytes(); 
				String palabraEncriptada= Base64.getEncoder().encodeToString(palabras);
				resultado.setText(palabraEncriptada);
				
			}
			
		});
		
		desencriptar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				String a =  resultado.getText(); 
				Base64.Decoder palabra = Base64.getDecoder();
				byte[] resultado1  = palabra.decode(a);
				String desenc= new String(resultado1);
				resultado.setText(desenc);
			}
			
		});
		
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		launch(args);
	}
}
