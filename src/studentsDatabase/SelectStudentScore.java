package studentsDatabase;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.crypto.Data;

public class SelectStudentScore extends JFrame{
	JFrame f=new JFrame();
	MyPanel p=new MyPanel();
	
	JLabel l=new JLabel("该学生成绩如下：");
	JButton rtnbtn=new JButton("返回");
	
	public SelectStudentScore(String s) {
		try {
			Database.select_student_score(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setLayout(null);
		l.setFont(new Font("楷体",Font.PLAIN, 30));
		rtnbtn.setFont(new Font("楷体",Font.PLAIN, 20));
		
		l.setBounds(100,50, 300, 50);
		rtnbtn.setBounds(200, 500, 150, 50);
		p.add(Database.table1);
		p.add(rtnbtn);
		p.add(l);
		this.add(p);
		this.setTitle("学生成绩");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(550, 650);
		this.setVisible(true);	
		
		rtnbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				Database.rowInfo1.clear();
				Database.columnAtrs1.clear();
				Select.t.setText("");
				new Select();
			}
		});
	}
	
//	public static void main(String[] args) {
//		new SelectScore();
//	}
}
