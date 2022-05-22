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
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class assignCases extends JFrame{
	JLabel tn,title,loffname,loffid,lfirid,lassidate,lstatus;
	JTextField offname,offid,firid,assidate,status;
	JButton search,assign;
	Container co;
	assignCases() throws IOException{
		co=getContentPane();
		co.setLayout(new BorderLayout());
		//Label
//		tn=new JLabel("Tamil Nadu Department of Police");
//		tn.setFont(new Font("verdana",Font.BOLD,25));
		title=new JLabel("Assign Cases");
		title.setFont(new Font("verdana",Font.BOLD,20));
		loffname=new JLabel("Enter Officer Name : ");
		loffid=new JLabel("Enter Officer Id : ");
		lfirid=new JLabel("Enter FIR id : ");
		lassidate=new JLabel("Enter Assigned Date : ");
		lstatus=new JLabel("Enter Status : ");

//		tn.setBounds(270, 20, 600, 30);
		title.setBounds(400, 100, 200, 30);
		loffname.setBounds(300, 150, 200, 30);
		loffid.setBounds(300, 200, 200, 30);
		lfirid.setBounds(300, 250, 200, 30);
		lassidate.setBounds(300, 300, 200, 30);
		lstatus.setBounds(300, 350, 200, 30);
		
//		co.add(tn);
		co.add(title);
		co.add(loffname);
		co.add(loffid);
		co.add(lfirid);
		co.add(lassidate);
		co.add(lstatus);
		
		//JText
		offname=new JTextField();
		offid=new JTextField();
		firid=new JTextField();
		assidate=new JTextField();
		status=new JTextField();
		
		offname.setBounds(500, 150, 150, 30);
		offid.setBounds(500, 200, 150, 30);
		firid.setBounds(500, 250, 150, 30);
		assidate.setBounds(500, 300, 150, 30);
		status.setBounds(500, 350, 150, 30);
		
		co.add(offname);
		co.add(offid);
		co.add(firid);
		co.add(assidate);
		co.add(status);
		
		//Button
		search=new JButton("Search");
		assign=new JButton("Assign");
		
		search.setBounds(700, 250, 80, 30);
		assign.setBounds(450, 420, 80, 30);
		
		co.add(search);
		co.add(assign);
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj=e.getSource();
				if(obj==search) {
					
						String id=firid.getText();
						try {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMACHANDRAN","rc6601");
							String str="select filedate,status from fir2 where firid=?";
							PreparedStatement psmt=conn.prepareStatement(str);
							psmt.setString(1, id);
							ResultSet rs=psmt.executeQuery();
							if(rs.next()) {
								String date=rs.getString("filedate");
								String s=rs.getString("status");
								assidate.setText(date);
								status.setText(s);
							}
							else {
								JOptionPane.showMessageDialog(null, "FIR id not found");
							}
							conn.setAutoCommit(true);
							conn.close();
						} catch (Exception e1) {
							System.out.println(e1);
						}
					
				}
			}
		});
		assign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj=e.getSource();
				if(obj==assign){
					String ofname=offname.getText();
					String ofid=offid.getText();
					if(checkName(ofname) && checkId(ofid)) {
						try{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMACHANDRAN","ramachandran6601");
							String name=offname.getText();
							String id=offid.getText();
							String fir=firid.getText();
							String date=assidate.getText();
							String stat=status.getText();
							String ac="accepted";
							String pen="pending";
							if(stat.equals(ac) || stat.equals(pen)) {
								if(stat.equals(ac)) {
									String st="insert into caseassigned values(?,?,?,?,?)";
									PreparedStatement ps=conn.prepareStatement(st);
									
			//						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
			//						java.util.Date d=sdf.parse(date);
			//						java.sql.Date sqd=new java.sql.Date(d.getTime());
									
									ps.setString(1, name);
									ps.setString(2, id);
									ps.setString(3, fir);
									ps.setString(4, date);
									ps.setString(5, stat);
									ps.execute();
									
									JOptionPane.showMessageDialog(null, "data added successfully!!");
									conn.setAutoCommit(true);
									offname.setText("");
									offid.setText("");
									firid.setText("");
									assidate.setText("");
									status.setText("");
									conn.close();
								}
								else {
									JOptionPane.showMessageDialog(null, "Pending status should be changed or accepted");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Rejected Status cannot be assigned");
							}
						}
							catch(Exception ex) {
								System.out.println(ex);
							}
					}
					else {
						JOptionPane.showMessageDialog(null, "Enter Officer Name and Id Correctly");
					}
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
		setBounds(100, 100, 1000, 600);
		setVisible(true);
	}
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
	public boolean checkId(String id)
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
		if(id.charAt(3)!='L')
		{
			return false;
		}
		
		return true;
	}
	public static void main(String[] args) throws IOException {
		new assignCases();

	}

}
