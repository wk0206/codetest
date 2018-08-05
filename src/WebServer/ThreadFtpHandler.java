package WebServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

class ThreadFtpHandler extends Thread   
{   
  final static String CRLF = ""+(char)13+(char)10;   
    Socket csock;   
    Socket dsock;   
    FTPServer parent;   
    int id;   
    int state = 0;   
    byte usermode = 1;   
    String cmd = "";   
    String param = "";   
    String user = "";   
    String password = "";   
    String reply = "";   
    String currentdir = "c:\\";   
    String rootdir;   
    String requestfile = "";   
    boolean isrest = false;   
    int restoffset = 0;   
    int mode = 0;   
    int type = 0;   
    int filestruct = 0;   
    String remotehost = "";   
    String localhost = "";   
    int  localdport =0;   
    int localcport = 0;   
    int remotecport = 0;   
    int remotedport = 0;   
    PrintWriter ctrlout;   
    boolean checkPassword(String s)   
        {   
   
          int i = 0;   
   
            for(i=0;i<parent.userinfo.size();i++)   
            {   
               if(((UserInfo)parent.userinfo.get(i)).name.compareToIgnoreCase(user)==0)   
                    {   
                        rootdir = ((UserInfo)parent.userinfo.get(i)).workdir;   
                        currentdir = ((UserInfo)parent.userinfo.get(i)).workdir;   
                        usermode = ((UserInfo)parent.userinfo.get(i)).mode;   
                        return true;                   
                    }   
               if(((UserInfo)parent.userinfo.get(i)).name.equals(user) && ((UserInfo)parent.userinfo.get(i)).password.equals(param))   
                    {   
                      rootdir = ((UserInfo)parent.userinfo.get(i)).workdir;   
                        currentdir = ((UserInfo)parent.userinfo.get(i)).workdir;   
                        usermode = ((UserInfo)parent.userinfo.get(i)).mode;   
                        return true;   
                    }   
            }   
      return false;   
    }   
    public int parseInput(String s)   
    {   
         int pos = 0;   
             int pos1 = 0;   
             int i = -1;   
             cmd = "";   
             param = "";   
             pos = s.indexOf(' ');   
             if(pos==-1)   
              cmd = s;   
             else   
             cmd = s.substring(0,pos);   
             if(pos>=s.length())   
                param = "";   
             else   
              param = s.substring(pos+1,s.length());   
             cmd = cmd.toUpperCase();      
             if(cmd.equals("USER"))   
                i = 1;   
             if(cmd.equals("PASS"))   
                i = 2;   
             if(cmd.equals("ACCT"))   
                i = 3;   
         if(cmd.equals("CDUP"))   
                i = 4;   
             if(cmd.equals("SMNT"))   
                i = 5;   
             if(cmd.equals("CWD"))   
                i = 6;   
             if(cmd.equals("QUIT"))   
                i = 7;   
         if(cmd.equals("REIN"))   
                i = 8;   
             if(cmd.equals("PORT"))   
                i = 9;   
             if(cmd.equals("PASV"))   
                i = 10;   
             if(cmd.equals("TYPE"))   
                i = 11;   
         if(cmd.equals("STRU"))   
                i = 12;   
             if(cmd.equals("MODE"))   
                i = 13;   
             if(cmd.equals("RETR"))   
                i = 14;   
             if(cmd.equals("STOR"))   
                i = 15;   
         if(cmd.equals("STOU"))   
                i = 16;   
             if(cmd.equals("APPE"))   
                i = 17;   
             if(cmd.equals("ALLO"))   
                i = 18;   
             if(cmd.equals("REST"))   
                i = 19;   
         if(cmd.equals("RNFR"))   
                i = 20;   
             if(cmd.equals("RNTO"))   
                i = 21;   
             if(cmd.equals("ABRO"))   
                i = 22;   
             if(cmd.equals("DELE"))   
                i = 23;   
         if(cmd.equals("RMD"))   
                i = 24;   
             if(cmd.equals("XMKD"))   
                i = 25;                
             if(cmd.equals("MKD"))   
                i = 25;   
             if(cmd.equals("PWD"))   
                i = 26;   
             if(cmd.equals("LIST"))   
                i = 27;   
         if(cmd.equals("NLST"))   
                i = 28;   
             if(cmd.equals("SITE"))   
                i = 29;   
             if(cmd.equals("SYST"))   
                i = 30;   
             if(cmd.equals("HELP"))   
                i = 31;   
         if(cmd.equals("NOOP"))   
                i = 32;   
             if(cmd.equals("XPWD"))   
                i = 33;   
     return i;   
   
    }   
    public boolean commandUSER()   
    {   
         if(cmd.equals("USER"))   
               {   
                  reply = "331 User name okay, need password";   
                        user = param;   
                  state = FtpState.FS_WAIT_PASS;   
                        return false;   
                 }   
         else   
               {   
                   reply = "501 Syntax error in parameters or arguments";   
                     return true;   
                 }   
    }   
    public boolean commandPASS()   
    {   
             if(cmd.equals("PASS"))   
               {   
                 if(checkPassword(param))   
                        {   
                              reply = "230 User logged in, proceed";   
                            state = FtpState.FS_LOGIN;   
                                System.out.println("Message: user "+user+"Form "+remotehost+"Login");   
                                return false;   
                        }   
                        else   
                            {   
                            reply = "530 Not logged in";   
                                return true;   
                            }   
                     }   
                    else   
                       {   
                       reply = "501 Syntax error in parameters or arguments";   
                             return true;   
                         }   
    }   
    private void errorCMD()   
    {   
       reply = "500 Syntax error, command unrecognized";   
    }   
  private boolean commandCDUP()   
    {   
       File f = new File(currentdir);   
         if(f.getParent()!=null && (!currentdir.equals(rootdir)))   
            {   
              currentdir = f.getParent();   
              reply = "200 Command okay";   
            }   
         else   
            {   
              reply = "550 Current directory has no parent";   
            }   
       return false;   
    }   
    private boolean commandCWD()   
    {   
       File f = new File(param);   
         String s = "";   
         String s1 = "";   
         if(currentdir.endsWith("\\"))   
            {   
              s = currentdir;   
            }   
         else   
            {   
              s = currentdir + "\\";   
            }   
         File f1 = new File(s+param);   
       if(f.isDirectory()&& f.exists())   
            {   
                  
              if(param.equals("..")|| param.equals("..\\"))   
                  {   
                      if(currentdir.compareToIgnoreCase(rootdir)==0)   
                        {   
                          reply = "550 The directory does not exists";   
                            return false;   
                        }   
                      s1 = new File(currentdir).getParent();   
                        if(s1!=null )   
                        {   
                          currentdir = s1;   
                            reply = "250 Requested file action okay, directory change to "+currentdir;   
                        }   
                        else   
                        {   
                          reply = "550 The directory does not exists";   
                            return false;   
                        }   
                    }   
                else if(param.equals(".") || param.equals(".\\") )   
                {   
   
                }   
                else   
                {   
               currentdir = param;   
                    reply = "250 Requested file action okay, directory change to "+currentdir;   
                 //System.out.println(f.getParent());   
                }   
                   
            }   
         else if(f1.isDirectory()&& f1.exists())   
            {   
              currentdir = s + param;   
                //System.out.println();   
                reply = "250 Requested file action okay, directory change to "+currentdir;   
            }   
         else   
            {   
              reply = "501 Syntax error in parameters or arguments";   
            }   
            return false;   
    }   
    public boolean commandQUIT()   
    {   
       reply = "221 Service closing control connection";   
            return true;   
    }   
    public boolean commandREST()   
    {   
       reply = "350 Service closing control connection";   
         try   
            {   
              restoffset = Integer.parseInt(param);   
            }   
            catch(NumberFormatException e)   
            {   
              reply = "501 Syntax error in parameters or arguments";   
              return false;   
            }   
         isrest = true;   
         return false;   
    }   
   
    public boolean commandPORT()   
    {   
      int pos = 0;   
        int pos1 = 0;   
        int i = 0;   
    int[] a = new int[6];   
    try   
    {   
        while((pos1=param.indexOf(',',pos1))!=-1)   
        {   
          a[i] = Integer.parseInt(param.substring(pos,pos1));   
            pos1 = pos1 + 1;   
            pos = pos1;   
            i = i + 1;   
        }   
        a[i] = Integer.parseInt(param.substring(pos,param.length()));   
    }   
    catch(NumberFormatException e)   
    {   
       reply = "501 Syntax error in parameters or arguments";   
         return false;   
    }   
      remotehost = a[0]+"."+a[1]+"."+a[2]+"."+a[3];   
        remotedport = a[4]*256+a[5];   
        reply = "200 Command okay";   
      return false;   
    }   
    public boolean commandTYPE()   
    {   
      if(param.equals("A"))   
    {   
          type = FtpState.FTYPE_ASCII;   
            reply = "200 Command okay Change to ASCII mode";   
        }   
        else if(param.equals("I"))   
        {   
         type = FtpState.FTYPE_IMAGE;   
         reply = "200 Command okay Change to BINARY mode";   
        }   
        else   
        {   
          reply = "504 Command not implemented for that parameter";   
        }   
      return false;   
    }   
    public boolean commandSTRU()   
    {   
      if(param.equals("F"))   
    {   
          mode = FtpState.FSTRU_FILE;   
            reply = "200 Command okay Change to File mode";   
        }   
        else if(param.equals("P"))   
        {   
         reply = "504 Command not implemented for that parameter";   
        }   
        else   
        {   
          reply = "501 Syntax error in parameters or arguments";   
        }   
      return false;   
    }   
public boolean commandMODE()   
{   
   if(param.equals("S"))   
        {   
              mode = FtpState.FMODE_STREAM;   
            reply = "200 Command okay Change to Stream mode";   
        }   
        else if(param.equals("C"))   
        {   
            reply = "504 Command not implemented for that parameter";   
        }   
        else   
        {   
          reply = "501 Syntax error in parameters or arguments";   
        }   
      return false;   
}   
public boolean commandHELP()   
{   
  String s;   
    s = "This is Help"+CRLF;   
    s = s + "Specified param";   
    reply = s;   
  return false;   
}   
public boolean commandRETR()   
{   
  requestfile = param;   
    File f =  new File(requestfile);   
  if(!f.exists())   
    {   
      f = new File(addsep(currentdir)+param);   
        if(!f.exists())   
        {   
       reply = "550 File not found";   
       return  false;   
        }   
        requestfile = addsep(currentdir)+param;   
    }   
     
  if(isrest)   
    {   
        
    }   
    else   
    {   
     if(type==FtpState.FTYPE_IMAGE)   
        {   
        try   
        {   
        ctrlout.println("150");   
        dsock = new Socket(remotehost,remotedport,InetAddress.getLocalHost(),20);   
        BufferedInputStream  fin = new BufferedInputStream(new FileInputStream(requestfile));   
        PrintStream dout = new PrintStream(dsock.getOutputStream(),true);   
        byte[] buf = new byte[1024];   
        int l = 0;   
      ctrlout.println("125");   
            while((l=fin.read(buf,0,1024))!=-1)   
            {   
              dout.write(buf,0,l);   
            }   
             ctrlout.println("250");   
         fin.close();   
     dout.close();   
         ctrlout.println("226");   
         dsock.close();   
         reply =""; //"226 Closing data connection";   
   
        }   
        catch(Exception e)   
        {   
            System.out.println(e);   
            reply = "451 Requested action aborted: local error in processing";   
            return false;   
        }   
   
    }   
    if(type==FtpState.FTYPE_ASCII)   
    {   
      try   
        {   
        ctrlout.println("150");   
        dsock = new Socket(remotehost,remotedport,InetAddress.getLocalHost(),20);   
    BufferedReader  fin = new BufferedReader(new FileReader(requestfile));   
      PrintWriter dout = new PrintWriter(dsock.getOutputStream(),true);   
        String s;   
        ctrlout.println("125");   
        while((s=fin.readLine())!=null)   
        {   
           dout.println(s);   
        }   
         ctrlout.println("250");   
         fin.close();   
     dout.close();   
         ctrlout.println("226");   
         dsock.close();   
         reply ="";   
        }   
        catch(Exception e)   
        {   
            System.out.println(e);   
            reply = "451 Requested action aborted: local error in processing";   
            return false;   
        }   
    }   
    }   
  return false;   
}   
private String strspace(int l,String s)   
{   
   int i = 0;   
     String tmp = s;   
   if((l-s.length())>0)   
        {   
          for(i=0;i<l-s.length();i++)   
            {   
              tmp = tmp + " ";   
            }   
        }   
        return tmp;   
}   
private String strspacebef(int l,String s)   
{   
   int i = 0;   
     String tmp = "";   
   if((l-s.length())>0)   
        {   
          for(i=0;i<l-s.length();i++)   
            {   
              tmp = tmp + " ";   
            }   
        }   
        tmp = tmp + s;   
        return tmp;   
}   
public boolean commandLIST()   
{   
      try   
        {   
         dsock = new Socket(remotehost,remotedport,InetAddress.getLocalHost(),20);   
     PrintWriter dout = new PrintWriter(dsock.getOutputStream(),true);   
         int l = 0;   
         int i = 0;   
         String s = "";   
        if(param.equals("") || param.equals("LIST"))   
            {   
             ctrlout.println("150");   
         File f = new File(currentdir);   
                 String[] d = f.list();   
                 System.out.println(d);   
                    System.out.println(strspace(19,"1 onwer group"));   
                 for(i=0;i<d.length;i++)   
                    {   
   
                      File f1 = new File(addsep(currentdir)+d[i]);   
                        if(f1.isDirectory())   
                        {   
                         // s = f1.getName()+strspace(20,f1.getName())+"<DIR>"+strspace(12," ")+(new Date(f1.lastModified()).toString());   
                         //  s = strspace(10,"drwxrwxrwx")+strspacebef(28-9,"1 onwer group")+strspacebef(44-28,f1.length()+"")+strspacebef(59-44,(new Date(f1.lastModified()).toString()))+f1.getName();   
             s = strspace(10,"drwxrwxrwx")+strspacebef(22,"   1   onwer     group")+strspacebef(9,f1.length()+"")+strspacebef(59-44,(new Date(f1.lastModified()).toString()))+f1.getName();   
                  //   s = strspace(10,"drwxrwxrwx")+strspace(22,"   1   onwer     group")+strspacebef(10,f1.length()+"")+strspacebef(14,"Nov 20 20:21 ")+f1.getName();   
   
                        //System.out.println("DIR");   
                        }   
                        else   
                        {   
                         // s = f1.getName()+strspace(20,f1.getName())+"     "+f1.length()+strspace(12,String.valueOf(f1.length()))+(new Date(f1.lastModified()).toString());   
                         //s = strspace(10,"-rwxrwxrwx")+strspacebef(28-9,"1 onwer group")+strspacebef(44-28,f1.length()+"")+strspacebef(59-44,(new Date(f1.lastModified()).toString()))+f1.getName();   
                             s = strspace(10,"-rwxrwxrwx")+strspace(22,"   1   onwer     group")+strspacebef(9,f1.length()+"")+strspacebef(59-44,(new Date(f1.lastModified()).toString()))+f1.getName();   
                   //  s = strspace(10,"-rwxrwxrwx")+strspace(22,"   1   onwer     group")+strspacebef(10,f1.length()+"")+strspacebef(14,"Nov 20 20:21 ")+f1.getName();   
   
                    }   
                      dout.println(s);   
                        //System.out.println(s);   
                    }   
            }   
         else   
            {   
         File  f1 = new File(addsep(currentdir)+param);   
           if(f1.exists())   
                {   
                  ctrlout.println("150");   
                    if(f1.isDirectory())   
                        {   
                          //s = f.getName()+strspace(20,f.getName())+"<DIR>"+strspace(12," ")+(new Date(f.lastModified()).toString());   
                        //   s = strspace(10,"drwxrwxrwx")+strspacebef(28-9,"1 onwer group")+strspacebef(44-28,f1.length()+"")+strspacebef(59-44,(new Date(f1.lastModified()).toString()))+f1.getName();   
                s = strspace(10,"drwxrwxrwx")+strspacebef(22,"   1   onwer     group")+strspacebef(9,f1.length()+"")+strspacebef(59-44,(new Date(f1.lastModified()).toString()))+f1.getName();   
                    //  System.out.println("DIR");   
                        }   
                        else   
                        {   
                         s = strspace(10,"-rwxrwxrwx")+strspace(22,"   1   onwer     group")+strspacebef(9,f1.length()+"")+strspacebef(59-44,(new Date(f1.lastModified()).toString()))+f1.getName();   
                        }   
                    dout.println(s);   
                }   
            else   
                {   
                  reply = "550 File not found";   
                    dsock.close();   
              dout.close();   
                    return false;   
                }   
            }   
   
         dout.close();   
         dsock.close();   
         reply = "226 Closing data connection";   
        }   
        catch(Exception e)   
        {   
            System.out.println(e);   
            reply = "451 Requested action aborted: local error in processing";   
            return false;   
        }   
   
       return false;   
}   
private String addsep(String s)   
{   
    if(!s.endsWith("\\"))   
    {   
       s = s + "\\";   
    }   
 return s;   
}   
public boolean consoleHELP()   
{   
  return false;   
}   
public boolean commandNLST()   
{   
      try   
        {   
         dsock = new Socket(remotehost,remotedport,InetAddress.getLocalHost(),20);   
     PrintWriter dout = new PrintWriter(dsock.getOutputStream(),true);   
     String[] d = null;   
         String s = addsep(currentdir)+param;   
            int i = 0;   
         File f = null;   
         if(param.equals("") || param.equals("NLST"))   
            {   
              f = new File(currentdir);   
            }   
         else   
            {   
         f = new File(s);   
           if(f.exists() && f.isDirectory() )   
                {   
                  f = new File(s);   
                }   
             else if(f.exists() && !f.isDirectory())   
                {   
                  ctrlout.println("150");   
                  dout.println(param);   
                  dsock.close();   
              dout.close();   
            ctrlout.println("226");   
                    return false;   
                }   
                else   
                {   
                  reply = "550 File not found";   
                    dsock.close();   
              dout.close();   
                    return false;   
                }   
            }   
           d = f.list();   
             ctrlout.println("150");   
             for(i=0;i<d.length;i++)   
                {   
                  dout.println(d[i]);   
                }   
         dsock.close();   
         dout.close();   
       ctrlout.println("226");   
         reply = "";   
        }   
        catch(Exception e)   
        {   
            System.out.println(e);   
            reply = "451 Requested action aborted: local error in processing";   
            return false;   
        }   
   
       return false;   
}   
public boolean commandPWD()   
{   
  reply = "257 "+currentdir;   
  return false;   
}   
public boolean commandNOOP()   
{   
  reply = "200 OK";   
    return false;   
}   
public boolean commandABRO()   
{   
  try   
    {   
      dsock.close();   
    }   
    catch(Exception e)   
    {   
   
    }   
    reply = "421 Service not available, closing control connection";   
    return false;   
}   
public boolean commandSTOR()   
{   
   if(param.equals(""))   
        {   
          reply = "501 Syntax error in parameters or arguments";   
          return false;   
        }   
   String requestfile = addsep(currentdir)+param;   
     if(type==FtpState.FTYPE_IMAGE)   
        {   
        try   
        {   
        ctrlout.println("150");   
        dsock = new Socket(remotehost,remotedport,InetAddress.getLocalHost(),20);   
    BufferedOutputStream  fout = new BufferedOutputStream(new FileOutputStream(requestfile));   
      BufferedInputStream din = new BufferedInputStream(dsock.getInputStream());   
        byte[] buf = new byte[1024];   
        int l = 0;   
      ctrlout.println("125");   
        while((l=din.read(buf,0,1024))!=-1)   
        {   
           fout.write(buf,0,l);   
        }   
     ctrlout.println("250");   
         din.close();   
     fout.close();   
         ctrlout.println("226");   
         dsock.close();   
        }catch(Exception e)   
        {   
   
        }   
    }   
         if(type==FtpState.FTYPE_ASCII)   
        {   
        try   
        {   
        ctrlout.println("150");   
        dsock = new Socket(remotehost,remotedport,InetAddress.getLocalHost(),20);   
    PrintWriter  fout = new PrintWriter(new FileOutputStream(requestfile));   
      BufferedReader din = new BufferedReader(new InputStreamReader(dsock.getInputStream()));   
        String s = "";   
        int l = 0;   
      ctrlout.println("125");   
        while((s=din.readLine())!=null)   
        {   
           fout.println(s);   
        }   
     ctrlout.println("250");   
         din.close();   
     fout.close();   
         ctrlout.println("226");   
         dsock.close();   
        }catch(Exception e)   
        {   
   
        }   
    }   
  return false;   
}   
public int validatePath(String s)   
{   
   File f = new File(s);   
   if(f.exists() && !f.isDirectory())   
        {   
          String s1 = s.toLowerCase();   
            String s2 = rootdir.toLowerCase();   
            if(s1.startsWith(s2))   
            {   
                return 1;   
            }   
            else   
            return 0;   
               
        }   
        f= new File(addsep(currentdir)+s);   
     if(f.exists() && !f.isDirectory())   
        {   
          String s1 = (addsep(currentdir)+s).toLowerCase();   
            String s2 = rootdir.toLowerCase();   
            System.out.println("2");               
            if(s1.startsWith(s2))   
            {   
                return 2;      
            }   
            else   
            return 0;   
        }   
        return 0;   
}   
public boolean commandDELE()   
{   
  int r = validatePath(param);   
  if(r==0)   
        {   
          reply = "550 Request action not taken";   
        return false;   
        }   
  if(r==1)   
    {   
        File f = new File(param);   
            f.delete();   
    }   
  if(r==2)   
    {   
            File f= new File(addsep(currentdir)+param);   
            f.delete();   
      }   
        reply = "250 Request file action ok,complete";   
    return false;   
}   
public boolean commandMKD()   
{   
  int r = validatePath(param);   
  if(r==0)   
        {   
          reply = "550 Request action not taken";   
        return false;   
        }   
  if(r==1)   
    {   
        File f = new File(param);   
            f.mkdir();   
    }   
  if(r==2)   
    {   
            File f= new File(addsep(currentdir)+param);   
            f.mkdir();   
      }   
        reply = "250 Request file action ok,complete";   
    return false;    
}   
public ThreadFtpHandler(Socket s,int c,FTPServer f)   
    {   
      csock = s;   
        id = c;   
        parent = f;   
    }   
   
    public void run()   
    {   
   
        String input = "";   
        boolean done = false;   
        int command;   
      try   
        {   
          BufferedReader ctrlin = new BufferedReader(new InputStreamReader(csock.getInputStream()));   
        ctrlout = new PrintWriter(csock.getOutputStream(),true);   
            state = FtpState.FS_WAIT_LOGIN;   
      while(!done)   
        {   
           input = ctrlin.readLine();   
             command = parseInput(input);   
             System.out.println("Command:"+cmd+" paramter:"+param);   
           switch(state)   
                {   
                   case FtpState.FS_WAIT_LOGIN:   
              {   
   
                                done = commandUSER();   
                             }   
                         break;   
                     case FtpState.FS_WAIT_PASS:   
                          {   
   
                          }   
                            done = commandPASS();   
                            break;   
                     case FtpState.FS_LOGIN:   
                        {   
                                switch(command)   
                                {   
                                  case -1:   
                                     errorCMD();   
                                     break;   
                                    case 4:   
                                     done = commandCDUP();   
                                     break;   
                                    case 6:   
                                     done = commandCWD();   
                                     break;   
                                  case 7:   
                                     done = commandQUIT();   
                                      break;   
                                    case 19:   
                                      done = commandREST();   
                                      break;   
                                    case 9:   
                                      done = commandPORT();   
                                        break;   
                                    case 11:   
                                      done = commandTYPE();   
                                        break;   
                                    case 12:   
                                      done = commandSTRU();   
                                        break;   
                                    case 13:   
                                      done = commandMODE();   
                                        break;   
                                    case 14:   
                                      done = commandRETR();   
                                        break;   
                                    case 15:   
                                      done = commandSTOR();   
                                        break;   
                                    case 22:   
                                      done = commandABRO();   
                                        break;   
                                    case 23:   
                                      done = commandDELE();   
                                        break;   
                                    case 25:   
                                      done = commandMKD();   
                                        break;   
                                    case 26:   
                                    case 33:   
                                      done = commandPWD();   
                                        break;   
                                    case 27:   
                                      done = commandLIST();   
                                        break;   
                                    case 28:   
                                      done = commandNLST();   
                                        break;   
                                    case 31:   
                                      done = commandHELP();   
                                        break;   
                                    case 32:   
                                      done = commandNOOP();   
                                        break;   
                                }   
                        }   
                        break;   
                }   
             ctrlout.println(reply);   
        }   
          csock.close();   
            for(int i=0;i<parent.users.size();i++)   
            {   
              if(((ThreadFtpHandler)(parent.users.get(i))).id==id)   
              parent.users.remove(id);   
                System.out.println("Message: user "+user+"Form "+remotehost+"Quit");   
                System.out.print("console:");   
            }   
        }   
        catch(Exception e)   
        {   
           System.out.println(e);   
        }   
    }   
} 
