package PoliceRecordManagementSystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class viewCaseAssigned extends JFrame{
	JFrame jt;
	JLabel tn;
	JButton home;
	JTable table;
	String[] column= {"OfficerName","OfficerId","FirId","Date","Complaint Status"};
	Connection conn;
	viewCaseAssigned(){
		jt=new JFrame();
		jt.setLayout(null);
		home=new JButton("Home");
		home.setBounds(10,10,70,30);
		jt.add(home);
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
		tn=new JLabel("Tamil Nadu Department of Police");
		tn.setFont(new Font("verdana",Font.BOLD,25));
		tn.setBounds(400, 20, 600, 30);
		jt.add(tn);
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
		
		String offname="";
		String offid="";
        String date="";
		String firid="";
		String status="";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "RAMACHANDRAN","rc6601");
			String q="select * from caseassigned";
			Statement ps=conn.createStatement();
			JScrollPane scroll1 = new JScrollPane(table);

			ResultSet rs=ps.executeQuery(q);
			dm.addRow(column);
			while(rs.next()){
				offname=rs.getString("officername");
				offid=rs.getString("officerid");
				firid=rs.getString("firid");
				date=rs.getString("assigneddate");
				status=rs.getString("status");
				
				String tbData[] = {offname,offid,firid,date,status}; 
//				dm.addRow(new Object[] {date,station,firid,location,complaint,accused,place,applicant,phone,address,status});
				dm.addRow(tbData);
				conn.setAutoCommit(true);
			}
			
			jt.add(scroll1);
			jt.add(table);
			table.setBounds(100, 100, 1000, 400);
			jt.setBounds(100, 100, 1200, 600);
			jt.setVisible(true);
			conn.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public static void main(String[] args) {
		new viewCaseAssigned();

	}

}
