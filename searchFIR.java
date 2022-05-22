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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class searchFIR extends JFrame{
	JLabel search,tn;
	JButton home,loc,name,complaint,status,station,date;
	Container co;
	searchFIR() throws IOException{
		co=getContentPane();
		co.setLayout(new BorderLayout());
		
		//label
//		tn=new JLabel("Tamil Nadu Department of Police");
//		tn.setBounds(370, 20, 600, 30);
//		tn.setFont(new Font("verdana",Font.BOLD,25));
//		co.add(tn);
		search=new JLabel("Search FIR");
		search.setBounds(385, 100,150, 30);
		search.setFont(new Font("verdana",Font.BOLD,20));
		co.add(search);
		
		//Button
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
		loc=new JButton("Location");
		loc.setBounds(370, 150,150, 30);
		co.add(loc);
		loc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new searchLocation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		name=new JButton("Accused Name");
		name.setBounds(370, 200,150, 30);
		co.add(name);
		name.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new searchAccused();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		complaint=new JButton("Complaint");
		complaint.setBounds(370, 250,150, 30);
		co.add(complaint);
		complaint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new searchComplaint();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		status=new JButton("Status");
		status.setBounds(370, 300,150, 30);
		co.add(status);
		status.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new searchStatus();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		station=new JButton("Station Name");
		station.setBounds(370, 350,150, 30);
		co.add(station);
		station.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new searchStation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		date=new JButton("date");
		date.setBounds(370, 400,150, 30);
		co.add(date);
		date.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new searchDate();
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
		setBounds(100, 100, 1000, 500);
		setVisible(true);
		setTitle("Tamil Nadu Police Department-Search Fir");
	}
	public static void main(String[] args) throws IOException {
		new searchFIR();
	}

}
