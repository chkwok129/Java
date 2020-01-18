
public class Relation{
	//Editted by Chit Hang Kwok. This program is to create a sql table for two Person's Relation. Both of them are uniquely
	//identify as the Primary Key of the relationship. It is not replaceable.
	private Person person;
	private Person person1;
	private String Name1; 
	private String Name2; 
	private String Relationship;
	
	
	public Relation(String Name1, String Name2, String Relationship){
		
		this.Name1 = Name1;
		this.Name2 = Name2;
		this.Relationship=Relationship;
	}
	
	

	
	public String getName1() {
		return Name1;
	}
	
	public void setName1() {
		this.Name1=Name1;
	}
	
	public String getName2() {
		return Name2;
	}
	
	public void setName2() {
		this.Name2=Name2;
	}
	
	public String getRelationship() {
		return Relationship;
	}
	
	public void setRelationship() {
		this.Relationship=Relationship;
	}
	
	
	
}
