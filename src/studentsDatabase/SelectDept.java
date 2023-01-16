package studentsDatabase;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class SelectDept extends JFrame{
	JFrame f=new JFrame();
	MyPanel p=new MyPanel();
	
	JLabel l=new JLabel("该系别的学生名单如下：");
	JButton rtnbtn=new JButton("返回");
	JScrollPane scrollPane=null;
	
	public SelectDept(String s) {
		try {
			Database.select_dept(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		p.setLayout(null);
		
//		scrollPane=new JScrollPane(Database.table2);
//		//scrollPane.setPreferredSize(new Dimension(600,600));
//		scrollPane.setVisible(true);
//		scrollPane.setBounds(new Rectangle(250, 50, 300, 150));
//		
		
		l.setFont(new Font("楷体",Font.PLAIN, 26));
		rtnbtn.setFont(new Font("楷体",Font.PLAIN, 20));
		
		l.setBounds(100,20, 300, 50);
		rtnbtn.setBounds(200, 600, 150, 50);
		p.add(Database.table2);
		//p.add(scrollPane);
		p.add(rtnbtn);
		p.add(l);
		this.add(p);
		this.setTitle("系别查询");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 200);
		this.setSize(550, 800);
		this.setVisible(true);	
		
		rtnbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				Database.rowInfo2.clear();
				Database.columnAtrs2.clear();
				Select.t.setText("");
				new Select();
			}
		});
	}
}
