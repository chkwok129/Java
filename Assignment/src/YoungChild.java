
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import java.util.ArrayList;
import java.util.List;

public class YoungChild extends Person {
	//Editted by Chit Hang Kwok
		//This program is to add all the YoungChild relationship. If they have no relation it will throws an exception.
	public YoungChild(String Name, String Gender, String Status, int Age, String State) {
		super(Name, Status, Gender, Age, State);
		// TODO Auto-generated constructor stub
	}


	List<Adult> parentslist = new ArrayList<Adult>();
	public class NoParentException extends Exception{}

	//This method is to identify the parent of the Children. They can only add two parent on the list.
	public void parents(Object obj) {
		if (this.parentslist.size() == 2) {
			System.out.println("Fail to add parents");
		}
		else if (obj instanceof Adult) {
			Adult a = (Adult) obj;
			System.out.println("You add parents");
			this.parentslist.add(a);
			if (!(a.childrenlist.contains(this))) {
				a.childrenlist.add(this);
			}
		}
	}
	
	//This method is to identify the relationship of the parent categories.
	public void identify(Object obj) throws Exception{
		try {
			if (this.parentslist.size() < 2) { 
				throw new NoParentException();
			}
			if (!(this.parentslist.get(0).couplelist.contains(this.parentslist.get(1)))) { 
				throw new NoParentException();
			}
			if (this.parentslist.contains(obj)) {
				Adult a = (Adult) obj;
				System.out.println(a.getName() + " " + this.getName() + " parents");
			}
			else {
				System.out.println("They are not family");
			}
		}catch(NoParentException e){
			System.err.println("No parents");
		}
		
	}
	
	

	
}
