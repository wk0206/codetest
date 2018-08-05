package rmi;


import java.rmi.RemoteException;  
import java.rmi.server.UnicastRemoteObject;  
  
public class interfaceImpl extends UnicastRemoteObject implements rmiInterface  
{  
    private static final long serialVersionUID = 1L;  
  
    protected interfaceImpl() throws RemoteException  
    {  
        super();  
    }  
  
    public int sum(int a, int b)  
    {  
        return a + b;  
    }  
}  