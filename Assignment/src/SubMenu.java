
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
//import javafx.scene.control.TableViewBuilder;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SubMenu implements Initializable{

	//Editted by Chit Hang Kwok
	// This program is to show the submenu and you can choose the function you want.
	private Button bt1;
	
	private Button bt2;
	
	private Button bt3;
	
	private Button bt4;
	
	private Button bt5;
	
	private Button bt6;
	
	public void DisplayPersonInfo (ActionEvent event) throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("FileChooser.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	
	}
	
	public void AddPerson (ActionEvent event) throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("AddPerson.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	
	}
	
	public void SelectPerson(ActionEvent event) throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("DeletePerson.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	
	}
	
	public void PersonConnect(ActionEvent event) throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Connection.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	
	}
	
	public void PersonIdentity(ActionEvent event) throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("DeleteConnection.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	
	}
	
	public void BackToPreviousMenu(ActionEvent event) throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	
	}
	
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}	
	

