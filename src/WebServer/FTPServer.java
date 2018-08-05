package WebServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;   
   
class UserInfo   
{   
  String name;   
    String password;   
    String workdir;   
    byte mode;   
}   
   
public class FTPServer   
{   
  ArrayList users = new ArrayList();   
  ArrayList userinfo = new ArrayList();   
        class FtpConsole extends Thread   
    {   
       BufferedReader cin ;   
             String concmd = "";   
         String conparam = "";   
         private int consoleQUIT()   
         {   
           System.exit(0);   
           return 0;   
         }   
         private int consoleLIST()   
         {   
                  int i = 0;   
              for(i=0;i<users.size();i++)   
                        {   
                          System.out.println(i+":"+((ThreadFtpHandler)(users.get(i))).user + " From " +((ThreadFtpHandler)(users.get(i))).csock.getInetAddress().toString());   
                        }   
   
            return 0;   
         }   
                private boolean validUserName(String s)   
                {   
              int i = 0;   
                    for(i=0;i<userinfo.size();i++)   
                    {   
                      if(((UserInfo)userinfo.get(i)).name.equals(s))   
                        {   
                          return false;   
                        }   
                    }   
                    return true;   
                }   
                private int consoleLISTUSER()   
                {   
                 int i = 0;   
                 UserInfo u;    
                 String s = "";   
                 String s1 = "";   
                 for(i=0;i<userinfo.size();i++)   
                    {   
                       u = (UserInfo)userinfo.get(i);   
                         if(u.mode==1)   
                             s1 = "Normal";   
                         else if(u.mode==3)   
                             s1 = "SuperUser";   
                         s = "Name: "+u.name+" ;  WorkDir: "+u.workdir+" ;  Mode :"+s1;   
                         System.out.println(s);   
                    }   
                 System.out.println("Total user: "+userinfo.size());   
                 return 0;   
                }   
                private int consoleADDUSER()   
                {   
                  cin = new BufferedReader(new InputStreamReader(System.in));   
                    UserInfo u = new UserInfo();   
          String s = "";   
                    try   
                    {   
                        System.out.print("User name:");   
                      s = cin.readLine();   
                        if(s!="")   
                        {   
                           if(!validUserName(s))   
                                {   
                                  System.out.println(s+" already exits");   
                                    return 0;   
                                }   
                        }   
                        else   
                        {   
                          return 0;    
                        }   
                   u.name = s;      
                     System.out.print("Password:");   
                     s = cin.readLine();   
                        if(s!="")   
                        {   
       
                u.password = s;;     
                        }   
                        else   
                        {   
                          return 0;    
                        }               
                      System.out.print("User directory:");   
                      s = cin.readLine();   
                        if(s!="")   
                        {   
                          File f = new File(s);   
                            if(!f.exists())   
                            {   
                              f.mkdir();   
                            }   
                            u.workdir = s;;     
                        }   
                        else   
                        {   
                          return 0;    
                        }      
                  System.out.print("User Mode(1 for normal user,3 for superuser):");   
                      s = cin.readLine();   
                    if(s!="")   
                        {   
                          try   
                            {   
                           u.mode =(byte)Integer.parseInt(s);   
                            }   
                            catch(Exception e)   
                            {   
                             System.out.println("please input 1 or 3");   
                             return 0;   
                            }   
                        }   
                        else   
                        {   
                          return 0;    
                        }               
             userinfo.add(u);   
                     saveUserInfo();       
                    }   
                    catch(Exception e)   
                    {   
                         
                    }   
                    return 0;   
                }   
          private int consoleDELUSER()   
                {   
                  int i = 0;   
                    String s = "";   
                    if(conparam.equals(""))   
                    {   
                     System.out.println("Please input username");   
                     return 0;   
                    }   
                    for(i=0;i<userinfo.size();i++)   
                    {   
                        s = ((UserInfo)userinfo.get(i)).name;   
                            if(s.equals(conparam))   
                             {   
                                  System.out.println("User "+conparam+" deleted");   
                  userinfo.remove(i);   
                                    saveUserInfo();   
                                    return 0;   
                             }   
                    }   
                System.out.println("User "+conparam+" not exists");                    
                  return 0;   
                }   
                private int consoleEDITUSER()   
                {   
                    int i = 0;   
                    int j = 0;   
                    UserInfo u = new UserInfo();   
                    String s = "";   
                    if(conparam.equals(""))   
                    {   
                     System.out.println("Please input username");   
                     return 0;   
                    }   
                    for(i=0;i<userinfo.size();i++)   
                    {   
                        s = ((UserInfo)userinfo.get(i)).name;   
                            if(s.equals(conparam))   
                             {       
                            try   
                               {   
                                    String s1 = "";   
                                    String s2 = "";   
                                  cin = new BufferedReader(new InputStreamReader(System.in));    
                                System.out.println("User Name("+s+"):") ;   
                                  s1 = cin.readLine();   
                                    if(!s1.equals(""))   
                                     {   
                                         for(j=0;j<userinfo.size();j++)   
                                            {   
                                              s2 = ((UserInfo)userinfo.get(j)).name;   
                                              if(s1.equals(s2))   
                                                  {   
                                                     System.out.println("User "+s1+" already exists");   
                                                     return 0;   
                                                    }   
                                            }   
                                        u.name = s1;       
                                     }   
                                    System.out.println("User password("+((UserInfo)userinfo.get(i)).password+"):");   
                  s1 = cin.readLine();   
                                    if(!s1.equals(""))   
                                    {   
                                       u.password = s1;   
                                    }   
                                    System.out.println("User work directory("+((UserInfo)userinfo.get(i)).workdir+"):");   
                  s1 = cin.readLine();                                 
                                 if(!s1.equals(""))   
                                    {   
                                       u.workdir = s1;   
                                    }                                      
                                System.out.println("User work mode:"+((UserInfo)userinfo.get(i)).mode+"):");   
                  s1 = cin.readLine();                                     
                                    if(Integer.parseInt(s1)!=((UserInfo)userinfo.get(i)).mode)   
                                    {   
                                        if((!s1.equals("3")) ||(!s1.equals("1")) )   
                                            {   
                                               System.out.println("mode must be 1 or 3");   
                                                 return 0;    
                                            }   
                                            else   
                                            {   
                                                        u.mode = (byte)Integer.parseInt(s1);   
                                            }   
                                    }                          
                                    userinfo.remove(i);   
                                    userinfo.add(u);   
                                    saveUserInfo();   
                                    return 0;   
   
                               }catch(Exception e)   
                                {   
                                    System.out.println(e);   
                                }      
            }   
                    }   
            System.out.println("User "+conparam+" not exists");    
                  return 0;     
                }   
                private void printHelp(String topic)   
                {   
                      System.out.println("adduser <username> :add new user");   
                        System.out.println("deleteuser  <username> :delete a user");   
                        System.out.println("edituser <username> :edit user infomation");   
                        System.out.println("quit  :quit");   
                        System.out.println("listuser  :list all user connect to server");   
                        System.out.println("help :show  this help");   
                }   
                private int consoleHELP()   
                {   
           printHelp(conparam);   
                   return 0;   
                }   
                private int parseInput(String s)   
                {   
   
                        String s1 = "";   
                      int pos = 0;   
                  int pos1 = 0;   
                  concmd = "";   
                  conparam = "";   
                  pos = s.indexOf(' ');   
                  if(pos==-1)   
                    concmd = s;   
                  else   
                    concmd = s.substring(0,pos);   
   
                  if(pos>=s.length())   
                      conparam = "";   
                  else   
                    conparam = s.substring(pos+1,s.length());   
                  s1 = concmd.toUpperCase();   
   
                  if(s1.equals("LIST"))   
                    return 0;   
                  else if(s1.equals("QUIT")||s1.equals("EXIT"))   
                    return 1;   
                  else if(s1.equals("ADDUSER"))   
                    return 2;   
                  else if(s1.equals("DELUSER"))   
                    return 3;   
                  else if(s1.equals("EDITUSER"))   
                    return 4;   
                  else if(s1.equals("ADDDIR"))   
                    return 5;   
                  else if(s1.equals("REMOVEDIR"))   
                    return 6;   
                  else if(s1.equals("HELP") ||s1.equals("?"))   
                    return 7;   
                    else if(s1.equals("LISTUSER"))   
                    return 8;                          
                  return -1;   
   
                }   
   
                public FtpConsole()   
                {   
                  cin = new BufferedReader(new InputStreamReader(System.in));   
                }   
                public void run()   
                    {   
                        boolean ok = false;   
              String input = "";   
                            int i = 0;   
                            while(!ok)   
                            {   
                          System.out.print("console:");   
                                try   
                                {   
                              input = cin.readLine();   
                                }   
                                catch(IOException e)   
                                {   
                                  System.out.println(e);   
                                }   
   
                                //System.out.println(concmd+conparam+users);   
                                //System.out.println(conparam);   
                                switch(parseInput(input))   
                                {   
                                    case 0:   
                                      consoleLIST();   
                                      break;   
                                    case 1:   
                                      consoleQUIT();   
                                        break;   
                                    case 2:   
                                      consoleADDUSER();   
                                      break;   
                                    case 3:   
                                      consoleDELUSER();   
                                      break;   
                                    case 4:   
                                      consoleEDITUSER();   
                                      break;   
                                    case 5:   
                                      break;   
                                    case 7:   
                                      consoleHELP();   
                                        break;   
                                    case 8:   
                                     consoleLISTUSER();   
                                      break;   
                                }   
   
                            }   
                    }   
    }   
    public void saveUserInfo()   
    {   
      int i = 0;   
        String s = "";   
        try   
        {   
          BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("user.cfg")));   
        for(i=0;i<userinfo.size();i++)   
          {   
              
                 s =((UserInfo)userinfo.get(i)).name+";"+((UserInfo)userinfo.get(i)).password+";"+((UserInfo)userinfo.get(i)).workdir+";"+((UserInfo)userinfo.get(i)).mode+";";    
                 bout.write(s);   
                 bout.newLine();   
          }   
            bout.close();   
        }catch(IOException e)   
        {   
          System.out.println(e);   
        }   
    }   
    public void loadUserInfo()   
    {   
    String p = getClass().getResource("user.cfg").toString();   
  p = p.substring(6,p.length());   
    p = p.replace('/','\\');   
    if(new File(p).exists())   
        {   
          try   
          {   
   
                 String s;   
                 String s1;   
                 int pos = 0;   
                 int pos1 = 0;   
                 int i = 0;   
                 int j = 0;   
   
           BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(p)));   
                    while((s=fin.readLine())!=null)   
                    {   
   
                            if(s.startsWith("#"))   
                            continue;   
                            UserInfo u = new UserInfo();   
                            pos = pos1 = 0;   
                            j = 0;   
                         while((pos=s.indexOf(';',pos1))!=-1 )   
                            {   
                              s1 = s.substring(pos1,pos);   
                                pos1 = pos + 1;   
                                switch(j)   
                                {   
                                  case 0:   
                                      u.name = s1;   
                                        break;   
                                    case 1:   
                                      u.password = s1;   
                                        break;   
                                    case 2:   
                                      u.workdir = s1;   
                                      break;   
                                    case 3:   
                                      u.mode = (byte)Integer.parseInt(s1);   
                                        break;   
                                }   
                                j++;   
                            }   
                            userinfo.add(u);   
                          i++;   
                    }   
                    for(i=0;i<2;i++)   
                    fin.close();   
          }   
          catch(Exception e)   
          {   
            System.out.println(e);   
          }   
        }   
    }   
    public FTPServer()   
    {   
    FtpConsole fc = new FtpConsole();   
        fc.start();   
           int counter = 1;   
         int id = 0;   
              String CRLF = ""+(char)13+(char)10;   
                loadUserInfo();   
             try   
            {   
             ServerSocket ftpserver = new ServerSocket(21);   
   
                //BurfferedReader = new BufferedReader(new )   
                for(;;)   
                {   
   
                    Socket s = ftpserver.accept();   
                    //System.out.println("connect"+s.getPort());   
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));   
                PrintWriter out = new PrintWriter(s.getOutputStream(),true);   
                    //System.out.println("Service ready for new user"+counter);   
                    out.println("220 Service ready for new user"+counter+CRLF);   
                    //System.out.println(s.getPort());   
                    ThreadFtpHandler fh = new ThreadFtpHandler(s,id,this);   
                    fh.start();   
                    users.add(fh);   
                    counter++;   
                    id++;   
                }   
            }   
            catch(Exception e)   
            {   
            }   
   
    }   
   public static void main(String[] args)   
        {   
	   FTPServer ftpserver = new FTPServer();   
        }   
   
} 

class FtpState   
{   
  final static int FS_WAIT_LOGIN = 0;   
    final static int FS_WAIT_PASS = 1;   
    final static int FS_LOGIN = 2;   
    final static int FTYPE_ASCII = 0;   
    final static int FTYPE_IMAGE  = 1;   
    final static int FMODE_STREAM = 0;   
    final static int FMODE_COMPRESSED = 1;   
    final static int FSTRU_FILE = 0;   
    final static int FSTRU_PAGE = 1;   
   
}   
