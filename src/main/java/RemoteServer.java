  
import java.rmi.registry.Registry;

import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;



public class RemoteServer implements RemoteInterface{
	
	static Hashtable <String,String> userDic = new Hashtable<String, String>();
	Hashtable <String,BusinessPlan> bpDic;
	
	public RemoteServer() {}
	
	/*public BusinessPlan getPlanByYear(int year)
	{
		
	}*/
	public String login(User user)
	{
		if(userDic.contains(user.name))
		{
			if(user.password == userDic.get(user.name))
			{
				return "Welcome "+user.name;
			}
			
		}
		return "Failure to authenticate";

	}
	public String sayHello() throws RemoteException {
		return "Hello, world!";
	}

	public static void main (String[] argv) {
		 try {
			 //create a new superuser to add to the userdic
			 	
			 	userDic.put("User1","Password");
			 //create a bp to add to bpdic
			 //create & initialize the business plan object 1: VMOSA
				BusinessPlan VMOSAplan = new VMOSA("test1","CSC",2009);
				VMOSAplan.setName("VMOSAtest1");
				VMOSAplan.setDescription("This is the VMOSA business Plan");
				VMOSAplan.setTimeStamp(00000);
				VMOSAplan.setDate("2020/03/03");
				VMOSAplan.setAssessment("Goal Achieved!");
			//bind server
	            RemoteServer obj = new RemoteServer();
	            RemoteInterface stub = (RemoteInterface) UnicastRemoteObject.exportObject(obj, 0);

	            // Bind the remote object's stub in the registry
	            Registry registry = LocateRegistry.getRegistry();
	            registry.bind("Hello", stub);

	            System.err.println("Server ready");
	        } catch (Exception e) {
	            System.err.println("Server exception: " + e.toString());
	            e.printStackTrace();
	        }
	}
}

