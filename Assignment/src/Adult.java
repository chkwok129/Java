
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

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;


public class Adult extends Person {
	//Editted by Chit Hang Kwok
	//This program is to add all the Adult relationship. If they have no relation it will throws an exception.
	public Adult(String Name, String Status, String Gender, int Age, String State) {
		super(Name, Status, Gender, Age, State);
		// TODO Auto-generated constructor stub
	}
//Define the categories of each relation when you compare two person in the relation list.
	List<Adult> friendslist = new ArrayList<Adult>();
	List<Adult> couplelist = new ArrayList<Adult>();
	List<Adult> colleaguelist = new ArrayList<Adult>();
	List<Adult> parentslist = new ArrayList<Adult>();
	List<Person> classmatelist = new ArrayList<Person>();
	List<Person> childrenlist = new ArrayList<Person>();
	
	public class TooYoungException extends Exception{}
	public class NotToBeFriendsException extends Exception{}
	public class NoAvailableException extends Exception{}
	public class NotToBeCoupledException extends Exception{}
	public class NotToBeColleagueException extends Exception{}
	public class NotToBeClassmateException extends Exception{}


	//This method is to identify friend define by Age of two person.If they are not the same group type them throws an Exception
	public void friend(Object obj) throws Exception{
		try {
			if (obj instanceof Adult) {
				Adult a = (Adult) obj;
				this.friendslist.add(a); 			
				System.out.println("You add friends");
				if (!(a.friendslist.contains(this))) {
					a.friendslist.add(this);		
				}					
			} 
			if (obj instanceof Child) {
			
				throw new NotToBeFriendsException(); //Children cannot be friend with Adult
			}
			if (obj instanceof YoungChild) {
				throw new TooYoungException(); //Young Children cannot talk therefore they cannot have friends.
				
			}
		}catch (NotToBeFriendsException e){
				Alert alert2 = new Alert(AlertType.INFORMATION, "Child cannot be friend with Adult", ButtonType.OK);
				alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert2.show();
			//System.err.println("Cannot make friends with a child ");
		}catch (TooYoungException e) {
			Alert alert3 = new Alert(AlertType.INFORMATION, "Young Child cannot have friend.", ButtonType.OK);
				alert3.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert3.show();
			//System.err.println("Cannot make friends with a young child");
		}
	
	}
	//This method is to identify two person relationship in couple. If one have got marry another cannot be couple again.
	public void couple(Object obj) throws Exception{
		try {
			if (!(obj instanceof Adult)) {
				throw new NotToBeCoupledException();//Child and YougChild cannot get married.
			}
			
			Adult a = (Adult) obj;
			if (this.couplelist.size() == 1 || a.couplelist.size() == 1) {
				throw new NoAvailableException();    //They have got married before so cannot get married again except divorce.
			}
			else {
				this.couplelist.add(a);
				System.out.println("You add couple");
				if (!(a.couplelist.contains(this))) {
					a.couplelist.add(this);				
				}						
			}
		}catch(NoAvailableException e) {
			Alert alert4 = new Alert(AlertType.INFORMATION, "They cannot get married again.", ButtonType.OK);
				alert4.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert4.show();
			//System.err.println("Has been coupled with others");
		}catch(NotToBeCoupledException e) {
			Alert alert5 = new Alert(AlertType.INFORMATION, "Only Adult can get Married.", ButtonType.OK);
				alert5.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert5.show();
			//System.err.println("Not an Adult");
		}
			
	}
	//This method is to define the colleague relationship between two people if they are working together and they are over 16.
	public void colleague(Object obj) throws Exception{
		try {
			if (!(obj instanceof Adult)) {
				throw new NotToBeColleagueException();//Child and youngchild cannot be colleague because they are too young.
			}
			else {
				Adult a = (Adult) obj;
				this.colleaguelist.add(a);
				System.out.println("You add colleagues");
				if (!(a.colleaguelist.contains(this))) {
					a.colleaguelist.add(this);						
				}
			}
		}catch (NotToBeColleagueException e) {
			Alert alert6 = new Alert(AlertType.INFORMATION, "YoungChild or Child cannot be colleague cause they have no right to work.", ButtonType.OK);
				alert6.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert6.show();
			//System.err.println("Cannot connect a child or young child in a colleague relation");
		}	
	}
	
	//This method define the parent relationship if they have more than two parent it is not allowed.
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
	//This method define the children relation only when they are child and YoungChild
	public void children(Object obj) {
		if (obj instanceof YoungChild) {
			YoungChild y = (YoungChild) obj;
			this.childrenlist.add(y);
			System.out.println("You add children");
			if (!(y.parentslist.contains(this))) {
				y.parentslist.add(this);					
			}
		}
		if (obj instanceof Child) {
			Child c = (Child) obj;
			this.childrenlist.add(c);
			System.out.println("You add children");
			if (!(c.parentslist.contains(this))) {
				c.parentslist.add(this);
			}
		}
		else {
			System.out.println(" You cannot add adult as your children");
		}
	}
	//This method define the classmate relationship if they are YoungChild they cannot be classmate.
	public void classmates(Object obj) throws Exception{
		try {
			if (obj instanceof YoungChild) {
				throw new NotToBeClassmateException();
			}
			if (obj instanceof Child) {
				Child c = (Child) obj;
				this.classmatelist.add(c);
				System.out.println("You add classmates");
				if (!(c.classmatelist.contains(this))) {
					c.classmatelist.add(this);
				}
			}
			if (obj instanceof Adult) {
				Adult a = (Adult) obj;
				this.classmatelist.add(a);
				System.out.println("You add classmates");
				if (!(a.classmatelist.contains(this))) {
					a.classmatelist.add(this);
				}
			}
		}catch (NotToBeClassmateException e) {
			System.err.println("Cannot connect a young child in a classmate relation");
		}
	}
	//This method is to put two person in parent, colleague, classmate, children, friend and couple relationship.
	public void identify(Object obj) {
		if (this.friendslist.contains(obj)) {
			Child c = (Child) obj;
			System.out.println(c.getName() + " " + this.getName() + " friends");
		}
		else {
			System.out.println("They are not friends");
		}
		
		if (this.classmatelist.contains(obj)) {
			Person p = (Person) obj;
			System.out.println(p.getName() + " " + this.getName() + " classmates");
		}
		else {
			System.out.println("They are not classmates");
		}
		
		if (this.parentslist.contains(obj)) {
			Adult a = (Adult) obj;
			System.out.println(a.getName() + " " + this.getName() + " parents");
		}else 
		
		if (this.couplelist.contains(obj)) {
			Adult a = (Adult) obj;
			System.out.println(a.getName() + " " + this.getName() + " couple");
		} 
		else {
			System.out.println("They are not couple");
		}
		
		if (this.colleaguelist.contains(obj)) { 
			Adult a = (Adult) obj;
			System.out.println(a.getName() + " " + this.getName() + " colleagues");
		}
		else {
			System.out.println("They are not colleagues");
		}
		
		if (this.childrenlist.contains(obj)) { 
			Person p = (Person) obj;
			System.out.println(p.getName() + " " + this.getName() + " child");
		}
		else {
			System.out.println("They are not family");
		}
	}
}