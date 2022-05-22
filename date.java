package PoliceRecordManagementSystem;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class date extends JFrame{
	JLabel d;
	JDateChooser date;
	JComboBox show;
	JButton g;
	Container co;
	date(){
		co=getContentPane();
		co.setLayout(null);
		
		d=new JLabel("Enter date");
		d.setBounds(100, 100, 150, 30);
		co.add(d);
		
		date=new JDateChooser();
		date.setBounds(300, 100, 100, 30);
		co.add(date);
		show=new JComboBox();
		show.setBounds(500, 100, 100, 30);
		co.add(show);
		
		g=new JButton("Add Date");
		g.setBounds(100, 200, 150, 30);
		co.add(g);
		g.addActionListener(new ActionListener() {
			
			@Override
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				Object obj=e.getSource();
				if(obj==g) {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMACHANDRAN","rc6601");
						String dat=((JDateChooser) date).getDateFormatString();
						String sql="insert into datealoe values(?)";
						
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						String sqd=sdf.format(date.getDate());
						PreparedStatement psmt=conn.prepareStatement(sql);
						psmt.setString(1,sqd);
						psmt.execute();
						
						conn.setAutoCommit(true);
						conn.close();
						JOptionPane.showMessageDialog(null, "date added successfully");
					}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
				
			}
		});
		setBounds(100, 100, 700, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new date();
	}

}
