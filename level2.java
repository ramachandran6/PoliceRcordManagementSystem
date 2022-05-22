package PoliceRecordManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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

public class level2 extends JFrame {
	JLabel tn;
	JButton file,view,search,va;
	Container co;
	level2() throws IOException{
		co=getContentPane();
		co.setLayout(new BorderLayout());
		//Label
//		tn=new JLabel("Tamil Nadu Department of Police");
//		tn.setFont(new Font("verdana",Font.BOLD,20));
//		tn.setBounds(150,50,400,30);
//		co.add(tn);
		//Buttons
		file=new JButton("File FIR");
		file.setBounds(370,150,200,30);
		co.add(file);
		file.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new createFIR();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		view=new JButton("View");
		view.setBounds(370,200,200,30);
		co.add(view);
		view.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new viewFIR();
				
			}
		});
		search=new JButton("Search");
		search.setBounds(370,250,200,30);
		co.add(search);
		search.addActionListener(new ActionListener() {
			
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
		va=new JButton("View Assigned cases");
		va.setBounds(370,300,200,30);
		co.add(va);
		va.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new viewCaseAssigned();
				
			}
		});
		JPanel panel = new JPanel();
//		BufferedImage bimg;
//		bimg = ImageIO.read(new File("C:\\Users\\19tuc\\eclipse-workspace\\DataStructure\\bin\\PoliceRecordManagementSystem\\images\\tnpolicebanner.jpg"));
//		JLabel ill=new JLabel(new ImageIcon(bimg));
//		panel.add(ill);
		co.add(panel);
		co.setBackground(Color.white);
		setBounds(100,100,1000,500);
		setVisible(true);
		setTitle("Tamil Nadu Police Department");
	}
	public static void main(String[] args) throws IOException {
		new level2();

	}

}
