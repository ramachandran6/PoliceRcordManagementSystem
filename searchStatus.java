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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class searchStatus extends JFrame{
	JLabel l_loc;
	JComboBox t_loc;
	JButton loc,home,searchHome;
	Container co;
	JTable table;
	JFrame jt;
	String[] column= {"Date","Station","FIR id","Location","ApplicantName","ApplicantAddress","ApplicantPhone","Complaint","AccusedName","AccusedAge","ComplaintStatus" };
	searchStatus() throws IOException{
		co=getContentPane();
		co.setLayout(new BorderLayout());
		
//		JLabel tn=new JLabel("Tamil Nadu Department of Police");
//		tn.setBounds(350, 20, 600, 30);
//		tn.setFont(new Font("verdana",Font.BOLD,25));
//		co.add(tn);
		l_loc=new JLabel("Enter Status Name: ");
		l_loc.setFont(new Font("verdana",Font.BOLD,15));
		l_loc.setBounds(330, 150, 200, 30);
		co.add(l_loc);
		
		//Text
		t_loc=new JComboBox();
		t_loc.setBounds(550, 150, 100, 30);
		co.add(t_loc);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMACHANDRAN","ramachandran6601");
			String str="select status from fir2";
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(str);
			while(rs.next()) {
				t_loc.addItem(rs.getString("status"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		//button
		loc=new JButton("Search");
		loc.setBounds(450, 350, 80, 25);
		co.add(loc);
		loc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj=e.getSource();
				if(obj==loc) {
					jt=new JFrame();
					jt.setLayout(null);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					DefaultTableModel dm=new DefaultTableModel();
					
					dm.setColumnIdentifiers(column);
					
					table=new JTable();
					table.setModel(dm);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table.setFillsViewportHeight(true);
					JScrollPane scroll = new JScrollPane(table);

			        scroll.setHorizontalScrollBarPolicy(

			                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

			        scroll.setVerticalScrollBarPolicy(

			                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					
					String date="";
					String station="";
					String firid="";
					String location="";
					String complaint="";
					String accused="";
					String phone="";
					String applicant="";
					String accage="";
					String address="";
					String status="";
					try {
						String l=(String)t_loc.getSelectedItem();
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMACHANDRAN","rc6601");
						String q="select * from fir2 where status=?";
						PreparedStatement ps=conn.prepareStatement(q);
						ps.setString(1, l);
						JScrollPane scroll1 = new JScrollPane(table);

						ResultSet rs=ps.executeQuery();
						dm.addRow(column);
						while(rs.next()){
							date=rs.getString("filedate");
							station=rs.getString("stationname");
							firid=rs.getString("firid");
							location=rs.getString("location");
							applicant=rs.getString("applicantname");
							address=rs.getString("applicantaddress");
							phone=Long.toString(rs.getLong("applicantphno"));
							complaint=rs.getString("complaint");
							accused=rs.getString("accusedname");
							accage=Integer.toString(rs.getInt("accusedage"));
							status=rs.getString("status");
							
							String tbData[] = {date,station,firid,location,applicant,address,phone,complaint,accused,accage,status};
//							dm.addRow(new Object[] {date,station,firid,location,complaint,accused,place,applicant,phone,address,status});
							dm.addRow(tbData);
							conn.setAutoCommit(true);
						}
						
						jt.add(scroll1);
						jt.add(table);
						table.setBounds(100, 100, 1000, 400);
						jt.setBounds(100, 100, 1200, 600);
						jt.setVisible(true);
						//conn.close();
						
					}
					catch(Exception ex) {
						System.out.println(ex);
					}
				}
				
			}
		});
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
		searchHome=new JButton("back");
		searchHome.setBounds(870,120,100,30);
		co.add(searchHome);
		searchHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new searchFIR();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		JPanel panel = new JPanel();
//		BufferedImage bimg=ImageIO.read(new File("C:\\Users\\19tuc\\eclipse-workspace\\DataStructure\\bin\\PoliceRecordManagementSystem\\images\\tnpolicebanner.jpg"));
//		JLabel ill=new JLabel(new ImageIcon(bimg));
//		panel.add(ill);
		co.add(panel);
		co.setBackground(Color.white);
		setBounds(100, 100, 1000, 600);
		setVisible(true);
		setTitle("Tamil Nadu Police Department--Search By Status");
	}
	public static void main(String[] args) throws IOException {
		new searchStatus();
	}
}

