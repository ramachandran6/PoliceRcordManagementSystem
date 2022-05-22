package PoliceRecordManagementSystem;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class login extends JFrame{
	JLabel un,pw;
	JTextField tun,tpw;
	JButton li;
	Container co;
	login(){
		co=getContentPane();
		co.setLayout(null);
		
		//Label
		un=new JLabel("Enter PoliceId");
		un.setBounds(100, 100, 150, 30);
		co.add(un);
		pw=new JLabel("Enter Password");
		pw.setBounds(100, 200, 150, 30);
		co.add(pw);
		
		//JTextField
		tun=new JTextField();
		tun.setBounds(250, 100, 100, 30);
		co.add(tun);
		tpw=new JTextField();
		tpw.setBounds(250, 200, 100, 30);
		co.add(tpw);
		
		//Button
		li=new JButton("Login");
		li.setBounds(230, 300, 80, 30);
		co.add(li);
		li.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMACHANDRAN","rc6601");
					String id=tun.getText();
					String pass=tpw.getText();
					String str="select * from login where id=?";
					PreparedStatement ps=conn.prepareStatement(str);
					ps.setString(1, id);
					ResultSet rs=ps.executeQuery();

					String str2="select * from login";
					Statement ps2=conn.createStatement();
					ResultSet rs2=ps2.executeQuery(str2);
					if(rs.next()) {
							if(rs2.getString("password")==pass) {
								System.out.println("success");
							}
							else {
								JOptionPane.showMessageDialog(null, "invalid password");
							}
					}
					else {
						JOptionPane.showMessageDialog(null, "id not found");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
			}
		});
		
		setBounds(100, 100, 500, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new login();

	}

}
