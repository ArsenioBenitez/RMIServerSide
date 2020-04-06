import java.rmi.registry.LocateRegistry;

import java.rmi.registry.Registry;

public class RMIClient {
	
	BusinessPlan bp;
	static RemoteInterface stub;
	User user;
	
	@SuppressWarnings("unused")
	private RMIClient() {}
	
	public RMIClient(User user)
	{
		this.user = user;
	}

	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];
	    try {
	         Registry registry = LocateRegistry.getRegistry(host);
	         stub = (RemoteInterface) registry.lookup("Hello");
	         // this is where all the calling to the server will take place
	         User user1 = new User("User1","123","CSC",true);
	         //first call should call the login
	         
	         String response = stub.sayHello();
	         String loginResponse = stub.login(user1);
	         System.out.println("response: " + response);
	         System.out.println("Login: " + loginResponse);
	    } catch (Exception e) {
	            System.err.println("Client exception: " + e.toString());
	            e.printStackTrace();
	    }
	}
	

}
