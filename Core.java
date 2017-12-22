import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
class Core

{
	static String g1="";
	static String n=" ";
	static String core="";
	static String nul=null;
	static File fk;
  public static void main(String a[])
  {
  }

 static String findCore() throws Exception
	  {
		  String s="";
		  String k="";
		  InetAddress in;
		  TreeSet v=new TreeSet();
		  String b="";
     	  BufferedReader bf=new BufferedReader(new FileReader("f2.txt"));
		  while((s=bf.readLine())!=null)
		  {
			  try
			  {
			  in=InetAddress.getByName(s);
			  b=in.getHostAddress();
		      v.add(b);
			  System.out.println("Inetaddress : "+in);
			  System.out.println("Address : "+b);
		      }
		      catch(Exception e)
		      {
				  System.out.println("Error in finding the core ");
					 
				  continue;
			  }
		  }
		  bf.close();
		  core=(String)v.last();
		  System.out.println("The Core Node's Address Is : "+core);
		  return core;

	 }

static void sendFileToCore(String core,String source,String destination,String msg) throws Exception
	      {
		try
		{
	         String str="",str1="";
	 		 
	 		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+core);
	 		 Socket s=new Socket(core,8888);
	 		 ObjectOutputStream obop=new ObjectOutputStream(s.getOutputStream());
	 		 obop.writeObject("file");
	 		 obop.writeObject(source);

	 		 System.out.println("The Source address is : "+source);
	 		 obop.writeObject(destination);
	 		 System.out.println("The destined address is : "+destination);
	 		 obop.writeObject(msg);
             obop.writeObject(nul);
		JOptionPane.showMessageDialog(null, "File Transfered");
			}catch(Exception ee)
			{
				
			}
	 	     }

	 		 


public static String met1()

	{

		int i;
		int b[]=new int[5000];
		int a[]=new int[5000];
		String g=" ";
		char x[]=new char[5000];
		char d,s;
		String s1;
		try

		{
			n=FileOpen.jta.getText();
			int len=n.length();
			System.out.println("StringLength:"+len);
			System.out.print("Ascii-CODE:");

			for(i=0;i<len;i++)

			{

				int aa= n.charAt(i);
				System.out.print("\t"+ aa);
				a[i]=aa;
			}

			System.out.print("\n");
			System.out.print("HEX-CODE:");

			for(i=0;i<len;i++)

			{
				g=" ";
				b[i]=a[i]%16;
				a[i]=a[i]/16;

				if(a[i]==10)

				{
					s='A';
					g=g+s;

				}

				else if(a[i]==11)

				{
					s='B';
					g=g+s;

				}

				else if(a[i]==12)

				{
					s='C';
					g=g+s;

				}

				else if(a[i]==13)

				{
					s='D';
					g=g+s;

				}

				else if(a[i]==14)

				{
					s='E';
					g=g+s;

				}

				else if(a[i]==15)

				{
					s='F';
					g=g+s;

				}

				else

				{
					s=(char) a[i];
					g=g+a[i];

				}

				if(b[i]==10)

				{
					s='A';
					g=g+s;
					System.out.print(g.trim());

				}

				else if(b[i]==11)

				{
					s='B';
					g=g+s;
					System.out.print(g.trim());
				}

				else if(b[i]==12)

				{
					s='C';
					g=g+s;
					System.out.print(g.trim());
				}

				else if(b[i]==13)

				{
					s='D';
					g=g+s;
					System.out.print(g.trim());
				}

				else if(b[i]==14)

				{
					s='E';
					g=g+s;
					System.out.print(g.trim());
				}

				else if(b[i]==15)

				{
					s='F';
					g=g+s;
					System.out.print(g.trim());
				}

				else

				{
				        s=(char) b[i];
					g=g+b[i];
					System.out.print(g.trim());
				}

				g1=g1+g.trim();


			}
			FileWriter fr=new FileWriter("encc.txt");
			BufferedWriter bw=new BufferedWriter(fr);
			bw.write(g1,0,g1.length());
			bw.flush();
			//fk=new File("encc.txt");


		 }

		catch(Exception e)

		{
			System.out.println(e);
		}
		return(g1);
		//System.out.println("Struibg"+g1);
	}


}