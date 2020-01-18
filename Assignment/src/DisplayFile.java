




import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class DisplayFile implements Initializable{
	//Editted by Chit Hang Kwok
	//This program is to open the txt file and see the peoples details or relationship between them plus
	// the photo for each people.
	//I have set the default location into Desktop. Please get the file document on there.
	@FXML private Button bt1;
	
	@FXML private Button bt2;
	
	@FXML private Button bt3;
	
    
	private Desktop desktop = Desktop.getDesktop();
	
	public void Button1Action(ActionEvent event) throws Exception {
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("FileChooser.fxml"));
		FileChooser fc = new FileChooser();
		//fc.setInitialDirectory(new File("C:\\Users\\PC\\Desktop\\AllPersonFile"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("txt files", "*.txt"));
		File selectFile = fc.showOpenDialog(null);
		
		if (selectFile != null) {
			openFile(selectFile);
			
		}else {
			System.out.println("file is not valid");
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
		
	}
	
	public void Button2Action(ActionEvent event) throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("FileChooser.fxml"));
		FileChooser fc = new FileChooser();
		//fc.setInitialDirectory(new File("C:\\Users\\PC\\Desktop\\AllPersonFile"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("txt files", "*.txt", "image file", "*.jpg*"));
		List<File> selectFiles = fc.showOpenMultipleDialog(null);
		
		if (selectFiles != null) {
			
			
				 for (File file : selectFiles) {
                    openFile(file);
			
	
			
				 }
	}else {
			System.out.println("file is not valid");
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
		
	}
	
        public void BackToPreviousMenu(ActionEvent event) throws Exception{
        	
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	
	}
	
	
        private String readFile(File selectFile){	
		StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
         
        try {
 
            bufferedReader = new BufferedReader(new FileReader(selectFile));
             
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisplayFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisplayFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
               Logger.getLogger(DisplayFile.class.getName()).log(Level.SEVERE, null, ex);
           }
        } 
         
       return stringBuffer.toString();
   }

	
	    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                FileChooser.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
	
}