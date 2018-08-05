package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class client
{
	public static void main(String[] args)
	{
		try
		{
			String url = "//localhost:8808/SAMPLE-SERVER";
			rmiInterface RmiObject = (rmiInterface) Naming.lookup(url);
			System.out.println(" 1 + 2 = " + RmiObject.sum(1, 2));
		}
		catch (RemoteException rex)
		{
			System.out.println("Error in lookup: " + rex.toString());
		}
		catch (java.net.MalformedURLException me)
		{
			System.out.println("Malformed URL: " + me.toString());
		}
		catch (java.rmi.NotBoundException ne)
		{
			System.out.println("NotBound: " + ne.toString());
		}
	}
}
