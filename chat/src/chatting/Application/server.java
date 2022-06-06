package chatting.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class server extends JFrame implements ActionListener {

JPanel p1;
JTextField t1 ;
	JButton b1;
	static JTextArea jt ;
	static ServerSocket skt ;
	static Socket sok ;
	static DataInputStream din ;
	static DataOutputStream dout ;
	server(){
		
	    p1 = new JPanel();		//panel upper header add icons add in this panel not in frame
        p1.setLayout(null);
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/Application/ico/3.png"));
		  Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
	       ImageIcon i3 = new ImageIcon(i2);
	       JLabel l1 = new JLabel(i3);
		l1.setBounds(5,17,30,30);
		p1.add(l1);			//add arrow button in panel
		
		l1.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent ae) {	//exit on click
			System.exit(0);
		}
		});
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/Application/ico/1.png"));
		  Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
	       ImageIcon i6 = new ImageIcon(i5);
	       JLabel l2 = new JLabel(i6);
		l2.setBounds(40,5,60,60);
		p1.add(l2);	
		
	    ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatting/Application/ico/phone.png"));
	       Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
	       ImageIcon i13 = new ImageIcon(i12);
	       JLabel l6 = new JLabel(i13);
	       l6.setBounds(350, 20, 35, 30);
	       p1.add(l6);
	       
	       ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatting/Application/ico/3icon.png"));
	       Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
	       ImageIcon i16 = new ImageIcon(i15);
	       JLabel l7 = new JLabel(i16);
	       l7.setBounds(410, 20, 13, 25);
	       p1.add(l7);
		
		 ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/Application/ico/video.png"));
	       Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
	       ImageIcon i9 = new ImageIcon(i8);
	       JLabel l5 = new JLabel(i9);
	       l5.setBounds(290, 20, 30, 30);
	       p1.add(l5);
	       
	       
		
		 JLabel l3 = new JLabel("Nilesh");
	       l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
	       l3.setForeground(Color.WHITE);
	       l3.setBounds(110, 15, 100, 18);
	       p1.add(l3);   
	       
	       
	       JLabel l4 = new JLabel("Active Now");
	       l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
	       l4.setForeground(Color.WHITE);
	       l4.setBounds(110, 35, 100, 20);
	       p1.add(l4);  
	       
	       
	       t1 = new JTextField();
	       t1.setBounds(5, 500, 300, 40);
	       t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
	       add(t1);
	       
	       b1 = new JButton("Send");
	       b1.setBounds(310,500,123,40);
	       b1.addActionListener(this);
	       add(b1);
		
	       jt = new JTextArea();
	       
	       jt.setBounds(4,75,440,420);
	       jt.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
	       jt.setEditable(false);	//we are not able to edit text in text area
	    //   jt.setBackground(Color.pink);
	       jt.setLineWrap(true);	//next line kai leye
	       jt.setWrapStyleWord(true);
	       add(jt);
	       
		setLayout(null);
		setSize(450,600);
		setLocation(300,200);
		//setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
		String out = t1.getText();
		jt.setText(jt.getText()+"\n\t\t\t"+out); // old+ new msg append ho jaege
		dout.writeUTF(out);
		t1.setText("");	//text fild empity kai leye
		}catch (Exception ae) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new server().setVisible(true);
		
		String msginput = "";
		  try{
	            skt = new ServerSocket(6001);
	            while(true){
	                sok = skt.accept();
	                din = new DataInputStream(sok.getInputStream());
	                dout = new DataOutputStream(sok.getOutputStream());
	            
		        while(true){
		                msginput = din.readUTF();
		                jt.setText(jt.getText()+"\n"+msginput);
		        }	                
	            }
	            
	        }catch(Exception e){
	        	}
	        }
	}

	

