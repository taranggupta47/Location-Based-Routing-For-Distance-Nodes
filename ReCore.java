import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;

class ReCore
{
	static String add="";

public static void main(String a[])
    {
	try{
        String add=reqCore();
	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa"+add);
	} catch(Exception e) { System.out.println(e); }
    }

public static String reqCore() 
	 	 {
			 System.out.println("The local 1");
				 BufferedReader brf;
			 String h="";
			 System.out.println("Socket side ");
	 		 String s1="";
	 		 String s2="request";
	 		 String addr="";
	 		 Socket s;
			 String sss="";
	         boolean b=true;
	 		 //ObjectInputStream obip;
	 		 //ObjectOutputStream obop;
	 		 try
	 		 {
	 		
	 		 	BufferedReader br =null;
	 		 BufferedWriter bw;
	 		 FileReader fr=new FileReader("NEXTMESH.txt");
	 		brf=new BufferedReader(fr);
	 		 System.out.println("Socket side after file read ");
	 	
				//System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr"+s1);
	 		 while((s1=brf.readLine())!=null)
	          {
	     		 if(b)
	 			 {
				System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr"+s1);
				sss = s1;
					  System.out.println("B4 try ");
	                  try
	                  {
						  s=new Socket(s1,8888);
	                  System.out.println("after connection ");
	                  InputStream is=s.getInputStream();
	                  OutputStream os=s.getOutputStream();
	                  //ObjectInputStream ois=new ObjectInputStream(is);
	                  ObjectOutputStream oos=new ObjectOutputStream(os);
	                  //os.write(1);
	                  oos.writeObject("request");
	 		          ObjectInputStream obip=new ObjectInputStream(s.getInputStream());
	 		          add=(String)obip.readObject();
	 		          b=false;
	 		          System.out.println("The Next Core Address :"+add);
                      }

	 		          catch(Exception e)
	 		          {
						JOptionPane.showMessageDialog(null, "Next Intermediate Node Is Fail");
						System.out.println(e);
							return "false";
					
					  }
					   
					}
					}
						}catch(Exception ee)
	 		{}
	 		 
              return sss;



     }
}