




import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;





public class MainController implements Initializable{
	//Editted by Chit Hang Kwok
	//This program is to open the Login Page and I have set it to username: user and Password: pass so that 
	//you can go to the submenu.
	
	@FXML private Text lblStatus;
	
	@FXML private TextField txtUsername;
	
	@FXML private TextField txPassword;
	
	@FXML private Button bt1;
	
	public void Login(ActionEvent event) throws Exception{
		try {
		if (txtUsername.getText().equals("user") && txPassword.getText().equals("pass")) {
			lblStatus.setText("Login Success");
			
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Submenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	} else {
		lblStatus.setText("Login Failure");
		}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}	
		