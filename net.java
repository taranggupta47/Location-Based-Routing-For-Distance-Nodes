import java.io.*;
import java.util.*;
class net
{
static Vector vnode;
public net()
	{
		try
		{
			String dat = "";
			String tmp = "";
			int n;
			Process p=Runtime.getRuntime().exec("net view");
			//BufferedInputStream bir = new BufferedInputStream(p.getInputStream());
			DataInputStream bir = new DataInputStream(p.getInputStream());
			tmp=bir.readLine();
			while(tmp!=null)
			{
			if(tmp.startsWith("\\"))
			{
				String t=tmp.substring((tmp.lastIndexOf("\\")+1),tmp.length()-(tmp.indexOf("\\")+1));
				dat +=t.trim()+"\n";
			}
			tmp=bir.readLine();  

			}
	
System.out.println(dat);	
	FileOutputStream fos = new FileOutputStream("net.txt");
			
			fos.write(dat.getBytes());
	DataInputStream input=new DataInputStream(new FileInputStream("net.txt"));
	String s="";
	s=input.readLine();
	vnode=new Vector();
	while(s!=null)
	{
		vnode.addElement(s.trim());	
		s=input.readLine();
	}
	System.out.println(vnode);

			
		}
		catch(Exception e){ }
	}

	}