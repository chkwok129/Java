


import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hsqldb.Server;

import java.sql.Statement;
//import org.hsqldb.Server;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MiniNet extends Application{
	
	//Editted by Chit Hang Kwok
	//This program is to open all the gui file.

		// TODO Auto-generated constructor stub
	  public void start(Stage primaryStage) throws Exception{
			try {
		    primaryStage.setTitle("DisplayFile");
			Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
			Scene scene = new Scene(root);
		    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	
	  

	public static void main(String[] args) throws Exception, SQLException, ClassNotFoundException {
		Server hsqlServer = null;
		Connection connection = null;
		ResultSet rs = null;
		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "TestDB");
		hsqlServer.setDatabasePath(0, "file:MYDB");
		hsqlServer.start();
		// making a connection
		Connection con = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
			stmt = con.createStatement();
			
			//result = stmt.executeUpdate("DROP TABLE people");
			//result = stmt.executeUpdate("DROP TABLE relation");
			//result = stmt.executeUpdate("CREATE TABLE people (Name VARCHAR(50) NOT NULL,Status VARCHAR(20) NOT NULL, Gender VARCHAR(20) NOT NULL, Age INT NOT NULL, State VARCHAR(30) NOT NULL,PRIMARY KEY (Name));");
			result = stmt.executeUpdate("CREATE TABLE relation (Name1 VARCHAR(50) NOT NULL,Name2 VARCHAR(50) NOT NULL, Relationship VARCHAR(50) NOT NULL, PRIMARY KEY (Name1, Name2));");
			//Warning, your compiler might not like the newlines in the SQL query(
	
		
		
		
	

		} catch (SQLException e2) {
		e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
		e2.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		System.out.println("Table created successfully");
		// end of stub code for in/out stub
		}
			WriteFile();
			launch(args);	

}

	public static void display(List list) {
	int i = 1;
	for (Iterator it = list.iterator(); it.hasNext(); ) {
		Person p = (Person)it.next();	
		System.out.println(i + "------------------"+ p.getName());
		i++;
	}
	}
	
	public static void WriteFile() {

		FileWriter writer = null;

		try {
			writer = new FileWriter("C:\\Users\\PC\\Desktop\\peoples.txt");

			writer.write("Alex Smith, 'AlexSmith.jpg', 'student at RMIT', M, 35, WA \n");
			writer.write("Ben Turner, 'BenTurner.jpg', 'manager at ZFX', M, 45, VIC \n");
			writer.write("Hannah White, 'HannahWhite.jpg', 'student at PLC', M, 12, VIC \n");
			writer.write("Zoe Foster, 'ZoeFoster.jpg', 'Founder of ZFX', M, 33, VIC \n");
			writer.write("Mary Turner, 'MaryTurner.jpg', 'looking for job', F, 2, VIC \n");
			writer.write("John Smith, 'JohnSmith.jpg', 'student at PLC', M, 12, VIC \n");
			writer.write("Mary Hopkin, 'MaryHopkin.jpg', 'House Worker', F, 38, TAS \n");
			writer.write("Alex Turner, 'AlexTurner.jpg', 'student at Latrobe', M, 22, VIC \n");
			writer.write("Klay Thomas, 'Klay Thomas.jpg', 'House Worker', F, 33, NSW \n");
			writer.close();// flushes the stream.
			
			FileWriter writer1 = null;
			
			writer1 = new FileWriter("C:\\Users\\PC\\Desktop\\relations.txt");

			writer1.write("Alex Smith, Ben Turner, friend \n");
			writer1.write("Ben Turner, Mary Hopkin, couple \n");
			writer1.write("Ben Turner, Mary Turner, parent \n");
			writer1.write("Mary Hopkin, Mary Turner, parent \n");
			writer1.write("Alex Turner, Mary Hopkin, parent \n");
			writer1.write("Alex Turner, Ben Turner, parent \n");
			writer1.write("Alex Smith, Klay Thomas, couple \n");
			writer1.write("Alex Turner, John Smith, friend \n");
			writer1.write("John Smith, Klay Thomasr, parent \n");
			writer1.write("Alex Smith, Zoe Foster, colleague \n");
			writer1.write("John Smith, Hannah White, classmate \n");
			
			
			
			writer1.close();// flushes the stream.

		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
	
}

}        

