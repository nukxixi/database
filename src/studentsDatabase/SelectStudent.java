package studentsDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectStudent extends JFrame{
	
	MyPanel p=new MyPanel();
	JLabel label=new JLabel("该学生的信息如下：");
	JLabel l11=new JLabel("学号：");
	JLabel l12=new JLabel();
	JLabel l21=new JLabel("姓名：");
	JLabel l22=new JLabel();
	JLabel l31=new JLabel("性别：");
	JLabel l32=new JLabel();
	JLabel l41=new JLabel("系别：");
	JLabel l42=new JLabel();
	Font font=new Font("楷体",Font.PLAIN, 30);
	JButton rtnbtn=new JButton("返回");
	
	public SelectStudent(String s){
		
		label.setFont(new Font("楷体",Font.PLAIN, 30));
		l11.setFont(font);
		l12.setFont(font);
		l21.setFont(font);
		l22.setFont(font);
		l31.setFont(font);
		l32.setFont(font);
		l41.setFont(font);
		l42.setFont(font);
		rtnbtn.setFont(font);
			
		
		label.setBounds(80,50, 300, 40);
		l11.setBounds(80, 150, 150, 40);
		l12.setBounds(200, 150, 200, 40);
		l21.setBounds(80, 230, 150, 40);
		l22.setBounds(200, 230, 150, 40);
		l31.setBounds(80, 310, 150, 40);
		l32.setBounds(200, 310, 150, 40);
		l41.setBounds(80, 390, 150, 40);
		l42.setBounds(200, 390, 150, 40);
		rtnbtn.setBounds(180,480,150,50);
		
		try {
			Database.select_student(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		l12.setText(""+ Database.data.get(0));
		l22.setText((String) Database.data.get(1));
		l32.setText((String) Database.data.get(2));
		l42.setText((String) Database.data.get(3));
				
		p.setLayout(null);
		p.add(label);
		p.add(l11);
		p.add(l12);
		p.add(l21);
		p.add(l22);
		p.add(l31);
		p.add(l32);
		p.add(l41);
		p.add(l42);
		p.add(rtnbtn);
		
		this.setTitle("学生信息");
		this.add(p);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(550, 650);
		this.setVisible(true);	
		
		rtnbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				//Database.table.updateUI();
				Database.data.clear();
				Select.t.setText("");

				new Select();
			}
		});
	}	
	
//	public static void main(String[] args) {
//		new SelectStudent();
//	}
}
