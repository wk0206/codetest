package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class server
{
	public static void main(String[] args)
	{
		try
		{
			LocateRegistry.createRegistry(8808);
			interfaceImpl server = new interfaceImpl();
			Naming.rebind("//localhost:8808/SAMPLE-SERVER", server);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
        catch (MalformedURLException e)
        {
	        e.printStackTrace();
        }
	}
}
