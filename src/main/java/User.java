import java.io.Serializable;

//class for users
public class User implements Serializable {

	String name;
	String password;
	String department;
	boolean isAdmin;
	
	public User(String name, String password,String department, boolean isAdmin)
	{
		this.name = name;
		this.password = password;
		this.department = department;
		this.isAdmin = isAdmin;
	}
}
