package studentsDatabase;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertStudent extends JFrame {
	
	JFrame  f=new JFrame();
	MyPanel insertPanel=new MyPanel();
	JLabel label=new JLabel("请输入要添加的学生信息：");
	JLabel l1=new JLabel("学号");
	JLabel l2=new JLabel("姓名");
	JLabel l3=new JLabel("性别");
	JLabel l4=new JLabel("系别");
	
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	
	JButton btn=new JButton("确定添加");
	JButton rtnbtn=new JButton("返回");
	Font font=new Font("楷体",Font.PLAIN, 30);
	
	public InsertStudent(){

		this.setTitle("添加学生信息");

		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);

		insertPanel.setLayout(null);
		label.setBounds(80,30,500,50);
		l1.setBounds(80, 100, 100, 50);
		l2.setBounds(80, 200, 100, 50);
		l3.setBounds(80, 300, 100, 50);
		l4.setBounds(80, 400, 100, 50);
		t1.setBounds(200, 100, 250, 50);
		t2.setBounds(200, 200, 250, 50);
		t3.setBounds(200, 300, 250, 50);
		t4.setBounds(200, 400, 250, 50);
		btn.setBounds(80,500,150,50);
		rtnbtn.setBounds(300,500,150,50);
		btn.setFont(new Font("楷体",Font.PLAIN, 20));
		rtnbtn.setFont(new Font("楷体",Font.PLAIN, 20));
		label.setFont(new Font("楷体",Font.PLAIN, 30));
		
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		
		insertPanel.add(label);
		insertPanel.add(l1);
		insertPanel.add(l2);
		insertPanel.add(l3);
		insertPanel.add(l4);
		insertPanel.add(t1);
		insertPanel.add(t2);
		insertPanel.add(t3);
		insertPanel.add(t4);
		insertPanel.add(btn);
		insertPanel.add(rtnbtn);
		
		this.add(insertPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(550, 650);
		this.setVisible(true);	
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Database.insert_student(t1.getText(), t2.getText(),t3.getText(), t4.getText());
			}
		});
		
		rtnbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new Insert();
			}
		});
	}
//	
//	public static void main(String[] args) {
//		new InsertStudent();
//	}

}
