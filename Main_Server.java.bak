import java.io.*;
import java.net.*;
import java.util.*;


class Main_Server

{
	 static String query="";
	 static String str="";
	 static String addr="";
	 static String source="";
	 static String destination="";
	 static String f="";
	 static TreeSet v;
	 static File ff;
	 static InetAddress in;
	 static String sst="";
	 static String b="";
	 static boolean bool=false;
	 static boolean boolea=false;
	 static ReCore re;
	 static String neaddr="";
	 static Core co;
	 static String pass="";
	 Main_Server()
	 {

	 }

	 public static void main(String a[])

	 {
	  try {


			  ServerSocket ss=new ServerSocket(8888);
			  while(true)
			  {
			  System.out.println("Waiting ");
			  Socket s=ss.accept();
			  System.out.println("Connected ");

			  while(true)
			  {
			  InputStream ins=s.getInputStream();
			  OutputStream ous=s.getOutputStream();
			  ObjectOutputStream oos=new ObjectOutputStream(ous);
			  ObjectInputStream ois=new ObjectInputStream(ins);
			  //DataOutputStream dos=new DataOutputStream(ous);
			  co=new Core();
			  v=new TreeSet();
			  System.out.println("B4 read ");
			  String fd=(String)ois.readObject();
			  System.out.println("OBJECTXxxxxxxxxxxxxx"+fd);
			    if(fd.equals("request"))
	            {
				  System.out.println("Req Rec");
                  addr=co.findCore();
                  System.out.println("Core Address : "+addr);
                  oos.writeObject(addr);
                  break;

                }
                if(fd.equals("file"))
                {
				  System.out.println("File transfer is requested ");
				  source=(String)ois.readObject();
				  destination=(String)ois.readObject();
				  System.out.println("Source :"+source);
				  System.out.println("Destination :"+destination);
				  FileWriter fw=new FileWriter("encc.txt");
				  BufferedWriter bw=new BufferedWriter(fw);
					pass ="";
				  pass=(String)ois.readObject();
				  Pack p=new Pack();
				  p.Pack1(pass);
				  System.out.println("The Enc File is "+pass);
					
				  bw.write(pass,0,pass.length());
				  bw.flush();
				  ff=new File("encc.txt");
				  /*while((f=(String)ois.readObject())!=null)
				  {

					  bw.write(f,0,f.length());
					  bw.flush();
					  bw.newLine();
					  System.out.println(f);
				  }*/
				  //fw.close();
				  //bw.close();
				  String inet=(InetAddress.getLocalHost()).getHostName();
				  System.out.println("The local address is :"+inet);
				  System.out.println("The destined address is ddddddddddd:"+destination);
				  
				  if(destination.equalsIgnoreCase(inet))
				  {
				  	System.out.println("Destination is myself*******************************gf ");
					  new Destination();
					  Destination.ServSoc(pass,source,destination);
					  System.out.println("Destination is myself ");
					  bool=true;
					  break;
					  //s.close();
				  }
				  else if(!bool)
				  {
				  	System.out.println("Boolean  ");
					 BufferedReader bf=new BufferedReader(new FileReader("f2.txt"));
					 while((sst=bf.readLine())!=null)
					  		  {
					  			  try
					  			  {
					  			  if(destination.equals(sst))
					  		      {

							          co.sendFileToCore(destination,source,destination,pass);
							          System.out.println("Success to destination ");
							          boolea=true;
							          break;

								  }
					  			  //System.out.println("Inetaddress : "+in+" "+sst);
					  			  //System.out.println("Address : "+b);
					  		      }
					  		      catch(Exception e)
					  		      {
					  				  System.out.println("Error in finding the core ");
					  				  continue;
					  			  }
		                      }
				  }
				  if(!boolea && !bool)
				  {
					  //BufferedReader nn=new BufferedReader(new FileReader("nextmesh.txt"));
					  re=new ReCore();
					  neaddr=re.reqCore();
		              co.sendFileToCore(neaddr,source,destination,pass);
		              break;
				  }

                break;
			    }


		       }
			  }

		   }

	  catch(IOException ie)
		  {
			  System.out.println(ie);
		  }
	  catch(Exception e)
	      {
			  System.out.println(e);
		  }


	  }

  }


