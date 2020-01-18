
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddingPerson implements Initializable{
	//Editted by Chit Hang Kwok
	//This program is to add the peoples information to the sql database.
	@FXML private Label NameL;
	@FXML private Label StatusL;
	@FXML private Label GenderL;
	@FXML private Label AgeL;
	@FXML private Label StateL;
	
	@FXML private TextField NameList;
	@FXML private TextField StatusList;
	@FXML private TextField GenderList;
	@FXML private TextField AgeList;
	@FXML private TextField StateList;
	
	static ArrayList<Person> profile = new ArrayList<Person>();
	
	@FXML Text text;
	@FXML private Button bt1;
	@FXML private Button bt2;
	
	@FXML private TableView<Person> tablePerson;
	@FXML private TableColumn<Person, String> ColumnName;
	@FXML private TableColumn<Person, String> ColumnStatus;
	@FXML private TableColumn<Person, String> ColumnGender;
	@FXML private TableColumn<Person, Integer> ColumnAge;
	@FXML private TableColumn<Person, String> ColumnState;
	
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private ObservableList<Person> data;
	
	public class NoSuchAgeException extends Exception{}
	public class TooYoungException extends Exception{}
	public class NotToBeFriendsException extends Exception{}
	public class NoAvailableException extends Exception{}
	public class NotToBeCoupledException extends Exception{}
	public class NotToBeColleagueException extends Exception{}
	public class NotToBeClassmateException extends Exception{}
	
	@FXML public void Add(ActionEvent event) throws Exception, TooYoungException, NotToBeFriendsException,
	NoAvailableException,NotToBeCoupledException, NotToBeColleagueException,NotToBeClassmateException{

	String NLIST=NameList.getText();
	String SLIST=StatusList.getText();
	String GLIST=GenderList.getText();
	Integer ALIST = Integer.valueOf(AgeList.getText());
	String STLIST=StateList.getText();
		String sql = "INSERT INTO people(Name, Status , Gender, Age, State) VALUES (?,?,?,?,?)";
		
		FileWriter writer = null;
			try {
			
			writer = new FileWriter("C:\\Users\\PC\\Desktop\\AllPersonFile\\peoples.txt", true);
			
			
 		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
			writer.append("" + NLIST + " , " + SLIST + " , " + GLIST + " , " + ALIST + " , " + STLIST + " ");
			
			writer.close();
	 		
	 		 try {
	 			
	 		
	 			 pst = con.prepareStatement(sql);
	 			 
	 		 
	 		pst.setString(1, NLIST);
	 		pst.setString(2, SLIST);
	 		pst.setString(3, GLIST);
	 		pst.setInt(4, ALIST);
	 		pst.setString(5, STLIST);
	 		
	 		
	 		
	 		
	 		
	 		int i = pst.executeUpdate();
	 		
 			if (i == 1) {
	 		  //System.out.println("data insert successfully");
 					Alert alert = new Alert(AlertType.INFORMATION, "data insert successfully", ButtonType.OK);
	 				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
	 				alert.show();
 			}if (ALIST >= 0 && ALIST <=2) {
 				YoungChild y = new YoungChild(NLIST, SLIST, GLIST, ALIST, STLIST);
 				Alert alert1 = new Alert(AlertType.INFORMATION, "You have add this person as YoungChild", ButtonType.OK);
					alert1.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert1.show();
 					
 				y.setAge(ALIST);
 			//	y.setFile(file);
 				y.setName(NLIST);
 				y.setGender(GLIST);
 				y.setStatus(SLIST);
 				y.setState(STLIST);
 				
 				profile.add(y);
 					
 			}
 			
 			else if (ALIST <= 16 && ALIST > 2) {
 				Child c = new Child(NLIST, SLIST, GLIST, ALIST, STLIST);
 				Alert alert1 = new Alert(AlertType.INFORMATION, "You have add this person as Child", ButtonType.OK);
				alert1.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert1.show();
 					
 				c.setAge(ALIST);
 			//	c.setFile(file);
 				c.setName(NLIST);
 				c.setGender(GLIST);
 				c.setStatus(SLIST);
 				c.setState(STLIST);
 				
 				profile.add(c);
 			}
 			
 			else if (ALIST > 16 || ALIST < 149) {
 				Adult a = new Adult(NLIST, SLIST, GLIST, ALIST, STLIST);
 				Alert alert1 = new Alert(AlertType.INFORMATION, "You have add this person as Adult.", ButtonType.OK);
					alert1.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert1.show();
 					
 				a.setAge(ALIST);
 			//	a.setFile(file);
 				a.setName(NLIST);
 				a.setGender(GLIST);
 				a.setStatus(SLIST);
 				a.setState(STLIST);
 					
 				profile.add(a);
 			}
 			if (ALIST < 0 || ALIST > 149)
 				try{
 				throw new NoSuchAgeException();
 		
 				 
	 		 }catch(NoSuchAgeException e1)	{	
	 			Alert alert4 = new Alert(AlertType.INFORMATION, "People cannot have Age less than zero or greater than 150", ButtonType.OK);
				alert4.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert4.show();
	 		 }
 			
 			
 			
 			}catch(SQLException ex) {
	 			Logger.getLogger(AddingPerson.class.getName()).log(Level.SEVERE, null, ex);
	 		}catch (Exception e) {
	 			e.printStackTrace(System.out);
	 		
	 		}
	 		
	 		finally {
	 		
	 		pst.close();
	            if (con != null) {
		        text.setText("Database connection successfully");
		        text.setVisible(true);
		        }else {
		        	text.setText("Database Connection Failure");;
		        }
	            }
	 		
	}
	
	 public void BackToPreviousMenu(ActionEvent event) throws Exception{
     	
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
	
		
		con = DBConnection.pmartConnection();
		
		data=FXCollections.observableArrayList();
			setCellTable();
			LoadDataFromDatabase();
		
	
		
	}
       
	private void setCellTable() {
		ColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		ColumnStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
		ColumnGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
		ColumnAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
		ColumnState.setCellValueFactory(new PropertyValueFactory<>("State"));
		
	}
	private void LoadDataFromDatabase() {
		try {
	
   		pst = con.prepareStatement("Select * from people");
   		rs=pst.executeQuery();
   		while(rs.next())
   		{
   			data.add(new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
   		}
		}catch(SQLException ex) {
 			Logger.getLogger(AddingPerson.class.getName()).log(Level.SEVERE, null, ex);
 		}
		tablePerson.setItems(data);
	}
	public String toString() {
		return (NameList + " " + StatusList + "" + GenderList + "" + AgeList + " " + StateList);
	}
}
      
       
    

	
