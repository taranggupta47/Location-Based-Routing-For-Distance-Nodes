import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.event.*;

class FileOpen extends JFrame 
{
	 JLabel jl1;
	 JLabel jl3;
	 JLabel jl5;
	 JButton jb1;
	 JButton jb2;
	 JTextField jt1;
	
	 String msg="";
	 static JTextArea jta;
	 JScrollPane jsp;
	 Container c;
	 
	 
	 JLabel jl7;
	 JList jlist;
	 String str="";
	 Core co;
	 ReCore rc;
	 String pass="";
	 String path="";
	 String coreaddr="";
	 String core="";
	 String nextcore="";
	 String dest="";
	 String dest1="";
	 File f;
	 File fgs;
	 Vector v = new Vector();

	 FileOpen()

	 {
		 new net();
		 v = net.vnode;
		 jl1=new JLabel("Enter The Destination Name ");
		 
		 jl3=new JLabel(" ");
		 jl5=new JLabel("Next Core Address ");
		 jb1=new JButton("Send");
		 jb2=new JButton("Reset");
		 
		 jt1=new JTextField(10);
		 
		
		 
		 jl7=new JLabel("NEXTMESH");
		 jta=new JTextArea();
		 jsp=new JScrollPane(jta);
		 jlist=new JList(v);
		 c=getContentPane();
		 c.setLayout(null);
		 c.add(jl1);
		 c.add(jt1);
		
		 c.add(jl3);
		
		 c.add(jb1);
		 c.add(jb2);
		 c.add(jsp);
		 
		 c.add(jl5);
		 
		 c.add(jl7);
		
		 c.add(jlist);
		
		 jl1.setBounds(70,110,200,25);
		 jt1.setBounds(300,110,100,25);
		
		 jsp.setBounds(410,110,280,400);
		 jb1.setBounds(150,235,100,25);
		 jb2.setBounds(300,235,100,25);
		
    	 jl7.setBounds(700,75,75,50);
		 jlist.setBounds(700,110,200,400);
		 jl3.setBounds(70,440,600,25);
		 jl5.setBounds(70,475,600,25);
		 setSize(800,600);
		 setVisible(true);
		 setLocationRelativeTo(null);
		
		

		
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae)
			{
				
				co=new Core();
				rc=new ReCore();

				try {
				coreaddr=co.findCore();
				jl3.setText("The Core Address is : "+coreaddr);
				String d=((InetAddress.getLocalHost()).getHostAddress());
				System.out.println("The local address is : "+d);
				dest=jt1.getText();
				
				jl5.setText(dest);
				pass=co.met1();
				if(coreaddr.equals((InetAddress.getLocalHost()).getHostAddress()))
				{
			 
                     nextcore=rc.reqCore();
                     System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwww"+nextcore);
                     if(nextcore.equalsIgnoreCase("false"))
                     {
                     	jl5.setText("The Next Mesh Not Found");
                     }
                     else
                     {
                     	jl5.setText("The Next Mesh Core is :"+nextcore);
                     }
                     
                     co.sendFileToCore(nextcore,(InetAddress.getLocalHost()).getHostAddress(),dest,pass);
                     
                     co.sendFileToCore(nextcore,(InetAddress.getLocalHost()).getHostAddress(),dest1,pass);
			
				}
				else
				{
					co.sendFileToCore(coreaddr,(InetAddress.getLocalHost()).getHostAddress(),dest,pass);
					
					co.sendFileToCore(coreaddr,(InetAddress.getLocalHost()).getHostAddress(),dest1,pass);
					System.out.println("Successful transfer of file ");
					jl5.setText("The Next Mesh Core is :"+coreaddr);
					
				 }

			}
			catch(Exception e) { System.out.println(e);
			}

			}
});
	 
		jb2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae)
			{
			jt1.setText("");
			
			jta.setText("");
			} 
			});

			 jlist.addListSelectionListener(new ListSelectionListener() { 
 			public void valueChanged(ListSelectionEvent le) 
 			{ 
 				System.out.println("\njList1_valueChanged(ListSelectionEvent e) called."); 
 				if(!le.getValueIsAdjusting()) 
 				{ 
					try
					{
						Object o = jlist.getSelectedValue(); 
 						System.out.println("" + ((o==null)? "null" : o.toString()) + " is selected."); 
		 				String router=o.toString();
 						System.out.println("\nRouter is" +  router);
						FileOutputStream fos = new FileOutputStream("NEXTMESH.txt");
						fos.write(router.getBytes());
					}
					catch (Exception ee)
					{
						ee.printStackTrace();
					}
 				
 				}
			}
 			 
	 } );
   }

	 public static void main(String a[])

	 {
		 new FileOpen();
	 }
 }
