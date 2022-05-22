package PoliceRecordManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class createFIR extends JFrame implements ActionListener{
	JLabel tn,create,l_date,l_station,l_fir,l_location,l_complaint,l_accName,l_accAge,l_appName,l_appPhn,l_appAdd,l_status;
	JLabel date_msg,firid_msg,apname_msg,acname_msg,phno_msg,age_msg,image;
	JTextField t_fir,t_location,t_accName,t_accAge,t_appName,t_appPhn;
	JDateChooser t_date;
	JComboBox t_status,t_station;
	JTextArea t_complaint,t_appAdd;
	JButton button,home;
	Container co;
	createFIR()throws IOException{
		co=getContentPane();
		co.setLayout(new BorderLayout());
		//Label
//		tn=new JLabel("Tamil Nadu Department of Police");
//		tn.setFont(new Font("verdana",Font.BOLD,25));
		create=new JLabel("File FIR");
		create.setFont(new Font("verdana",Font.BOLD,20));
		l_date=new JLabel("Date of crime happened :  ");
		l_station=new JLabel("Station within the range :  ");
		l_fir=new JLabel("Fir id :  ");
		l_location=new JLabel("Location of the crime :  ");
		l_appName=new JLabel("Applicant name :  ");
		l_appAdd=new JLabel("Applicant address :  ");
		l_appPhn=new JLabel("Applicant phone number :  ");
		l_complaint=new JLabel("Complaint : ");
		l_accName=new JLabel("Accused name :  ");
		l_accAge=new JLabel("Accused Age:  ");
		l_status=new JLabel("Complaint status :  ");
		
		//ERROR LABELS
		date_msg = new JLabel("Incorrect Date format");
	   	firid_msg = new JLabel("Invalid FIR Id");
	   	apname_msg = new JLabel("Enter a valid name");
	   	acname_msg = new JLabel(" Enter a valid name");
	   	phno_msg = new JLabel("Invalid Phone number");
	   	age_msg = new JLabel("Invalid age");
	   	 
	   	date_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	   	firid_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	   	apname_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	   	acname_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	   	phno_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	   	age_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	   	   	 
	   	date_msg.setForeground(Color.red);
	   	firid_msg.setForeground(Color.red);
	   	apname_msg.setForeground(Color.red);
	   	acname_msg.setForeground(Color.red);
	   	phno_msg.setForeground(Color.red);
	   	age_msg.setForeground(Color.red);
	   	
	    date_msg.setBounds(650,250,200,20);
	   	 firid_msg.setBounds(650,350,200,20);
	   	 apname_msg.setBounds(650,450,200,20);
	   	 phno_msg.setBounds(1280,250,200,20);
	   	 acname_msg.setBounds(1280,450,200,20);
	   	 age_msg.setBounds(1280,500,200,20);
	   	 
	   	 date_msg.setVisible(false);
	  	 firid_msg.setVisible(false);
	  	 apname_msg.setVisible(false);
	  	 phno_msg.setVisible(false);
	  	 acname_msg.setVisible(false);
	  	 age_msg.setVisible(false);
	  	 
	  	 co.add(date_msg);
		 co.add(firid_msg);
		 co.add(phno_msg);
		 co.add(acname_msg);
		 co.add(apname_msg);
		 co.add(age_msg);
		
		
//		tn.setBounds(500, 20, 600, 30);
		create.setBounds(700, 150, 150, 30);
		l_date.setBounds(100, 250, 250, 30);
		l_station.setBounds(100, 300, 250, 30);
		l_fir.setBounds(100, 350, 250, 30);
		l_location.setBounds(100, 400, 250, 30);
		l_appName.setBounds(100, 450, 250, 30);
		l_appAdd.setBounds(100, 500, 230, 30);
		l_appPhn.setBounds(800, 250, 230, 30);
		l_complaint.setBounds(800, 300, 230, 30);
		l_accName.setBounds(800, 450, 230, 30);
		l_accAge.setBounds(800, 500, 230, 30);
		l_status.setBounds(800, 550, 230, 30);
		
		l_date.setFont(new Font("Times new roman", Font.PLAIN, 20));
		l_station.setFont(new Font("Times new roman", Font.PLAIN, 20));
		l_fir.setFont(new Font("Times new roman", Font.PLAIN, 20));
		l_location.setFont(new Font("Times new roman", Font.PLAIN, 20));
		l_complaint.setFont(new Font("Times new roman", Font.PLAIN, 20));
		l_accName.setFont(new Font("Times new roman", Font.PLAIN, 20));
		l_accAge.setFont(new Font("Times new roman", Font.PLAIN, 20));
		l_appName.setFont(new Font("Times new roman", Font.PLAIN, 20));
		l_appAdd.setFont(new Font("Times new roman", Font.PLAIN, 20));
		l_appPhn.setFont(new Font("Times new roman", Font.PLAIN, 20));
		l_status.setFont(new Font("Times new roman", Font.PLAIN, 20));
		
//		co.add(tn);
		co.add(create);
		co.add(l_date);
		co.add(l_station);
		co.add(l_fir);
		co.add(l_location);
		co.add(l_complaint);
		co.add(l_accName);
		co.add(l_accAge);
		co.add(l_appName);
		co.add(l_appPhn);
		co.add(l_appAdd);
		co.add(l_status);
		
		
		//TextField
		t_date=new JDateChooser();
		t_fir=new JTextField();
		t_location=new JTextField();
		t_accName=new JTextField();
		t_accAge=new JTextField();
		t_appName=new JTextField();
		t_appPhn=new JTextField();
		
		t_appAdd=new JTextArea();
		t_complaint=new JTextArea();
		
		t_date.setBounds(400, 250, 150, 30);
		t_fir.setBounds(400, 350, 150, 30);
		t_location.setBounds(400, 400, 150, 30);
		t_appName.setBounds(400, 450,150, 30);
		t_appAdd.setBounds(400, 500, 200, 100);
		t_appPhn.setBounds(1030, 250, 150, 30);
		t_complaint.setBounds(1030, 300, 200, 100);
		t_accName.setBounds(1030, 450, 150, 30);
		t_accAge.setBounds(1030, 500, 150, 30);
		
		//comboBox
		t_status=new JComboBox();
		t_status.addItem("pending");
		t_status.addItem("accepted");
		t_status.addItem("rejected");
		t_status.setBounds(1030, 550, 150, 30);
		t_station=new JComboBox();
		t_station.addItem("B2-RS.Puram");
		t_station.addItem("B1-Selvapuram");
		t_station.addItem("A2-Vadavalli");
		t_station.addItem("S2-Townhall");
		t_station.addItem("A1-Singanallur");
		t_station.addItem("S1-Gandhipuram");
		t_station.setBounds(400, 300, 150, 30);
		
		t_date.setFont(new Font("Times new roman", Font.PLAIN, 15));
		t_station.setFont(new Font("Times new roman", Font.PLAIN, 15));
		t_fir.setFont(new Font("Times new roman", Font.PLAIN, 15));
		t_location.setFont(new Font("Times new roman", Font.PLAIN, 15));
		t_complaint.setFont(new Font("Times new roman", Font.PLAIN, 15));
		t_accName.setFont(new Font("Times new roman", Font.PLAIN, 15));
		t_accAge.setFont(new Font("Times new roman", Font.PLAIN, 15));
		t_appName.setFont(new Font("Times new roman", Font.PLAIN, 15));
		t_appAdd.setFont(new Font("Times new roman", Font.PLAIN, 15));
		t_appPhn.setFont(new Font("Times new roman", Font.PLAIN, 15));
		t_status.setFont(new Font("Times new roman", Font.PLAIN, 15));
		
		co.add(t_date);
		co.add(t_station);
		co.add(t_fir);
		co.add(t_location);
		co.add(t_complaint);
		co.add(t_accName);
		co.add(t_accAge);
		co.add(t_appName);
		co.add(t_appPhn);
		co.add(t_appAdd);
		co.add(t_status);
		
		//Button
		button=new JButton("Add FIR");
		button.setBounds(650, 680, 80, 25);
		co.add(button);
		button.addActionListener(this);
		home=new JButton("Home");
		home.setBounds(10,120,70,30);
		co.add(home);
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new level2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		JPanel panel = new JPanel();
//		BufferedImage bimg;
//		bimg = ImageIO.read(new File("C:\\Users\\19tuc\\eclipse-workspace\\DataStructure\\bin\\PoliceRecordManagementSystem\\images\\tnpolicebanner.jpg"));
//		JLabel ill=new JLabel(new ImageIcon(bimg));
//		panel.add(ill);
		co.add(panel);
		co.setBackground(Color.white);
		//Panel
		setBounds(100, 100, 1400, 900);
		setVisible(true);
		setTitle("Tamil Nadu Police Department-File Fir");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==button) {
			try {
				
				String station=(String) t_station.getSelectedItem();
				String fir=t_fir.getText();
				String loc=t_location.getText();
				String com=t_complaint.getText();
				String acc=t_accName.getText();
				String accage=t_accAge.getText();
				String app=t_appName.getText();
				String appAdd=t_appAdd.getText();
				String status=(String) t_status.getSelectedItem();
				String phone=t_appPhn.getText();
				if(validation(accage,acc,app,fir,phone))
    		 	{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMACHANDRAN","rc6601");
					
					String str="insert into fir2 values(?,?,?,?,?,?,?,?,?,?,?)";
					
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					String sqd=sdf.format(t_date.getDate());				
					
					int fage=Integer.parseInt(accage);
					long phno=Long.parseLong(phone);
					
					PreparedStatement psmt=conn.prepareStatement(str);
					psmt.setString(1, sqd);
					psmt.setString(2, station);
					psmt.setString(3, fir);
					psmt.setString(4, loc);
					psmt.setString(5, app);
					psmt.setString(6, appAdd);
					psmt.setLong(7, phno);
					psmt.setString(8, com);
					psmt.setString(9, acc);
					psmt.setInt(10, fage);
					psmt.setString(11, status);
					
					psmt.execute();
					conn.setAutoCommit(true);
					JOptionPane.showMessageDialog(this, "data added successfully!!!");
					
					t_station.setSelectedItem(null);
					t_fir.setText("");
					t_location.setText("");
					t_appName.setText("");
					t_appAdd.setText("");
					t_appPhn.setText("");
					t_complaint.setText("");
					t_accName.setText("");
					t_accAge.setText("");
					t_status.setSelectedItem(null);
					
					conn.close();
					
				}
				else
				 {
					 JOptionPane.showMessageDialog(rootPane, "Check the values entered");
				 }
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
		}
		
		
	}
	//Form values validation
		public boolean validation(String age,String acname,String apname,String firid,String phno)
		{
			int flag=0;
			
			if(!this.checkAge(age))
			{
				age_msg.setVisible(true);
				flag=1;
			}
			
			if(!this.checkFirid(firid))
			{
				firid_msg.setVisible(true);
				flag=1;
			}
			if(!this.checkName(apname))
			{
				apname_msg.setVisible(true);
				flag=1;
			}
			if(!this.checkName(acname))
			{
				acname_msg.setVisible(true);
				flag=1;
			}
			
			if(flag==0)
			{
				return true;
			}
			else {
				return false;
			}
		}
		
		//check for valid age
		public boolean checkAge(String age)
		{
			if(Pattern.matches("[0-9 &&[^a-zA-z]]*$",age))
			{
				int a=Integer.parseInt(age);
				if(a>18 || a<110)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		
		//check for valid name
		public boolean checkName(String name)
		{
			for(int i=0;i<name.length();i++)
			{
				if(Character.isDigit(name.charAt(i)))
				{
					return false;
				}		
			}	
			return true;
		}
		
		//check for valid phone number
		public boolean checkPhno(String phno)
		{
			
			if(Pattern.matches("[0-9 &&[^a-zA-z]]*$",phno))
			{
				if(phno.length()==10)
				{
					return true;
				}
				else
				{
					return false;
				}
			}	
			else 
			{
				return false;
			}
		}
		
		//check for valid age
		public boolean checkFirid(String id)
		{
			if(id.charAt(0)!='T')
			{
				return false;
			}
			if(id.charAt(1)!='N')
			{
				return false;
			}
			if(id.charAt(2)!='P')
			{
				return false;
			}
			if(id.charAt(3)!='D')
			{
				return false;
			}
			
			return true;
		}
		
	public static void main(String[] args) throws IOException{
		new createFIR();
	}
}
