package studentsDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertScore extends JFrame{

	JFrame  f=new JFrame();
	MyPanel p=new MyPanel();
	JLabel label=new JLabel("请输入要添加的学生成绩：");
	JLabel l1=new JLabel("学号");
	JLabel l2=new JLabel("课号");
	JLabel l3=new JLabel("成绩");
	
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	
	JButton btn=new JButton("确定添加");
	JButton rtnbtn=new JButton("返回");
	Font font=new Font("楷体",Font.PLAIN, 30);
	
	public InsertScore(){
		this.setTitle("添加成绩信息");
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		p.setLayout(null);
		
		label.setBounds(80,30,500,50);
		l1.setBounds(80, 150, 100, 50);
		l2.setBounds(80, 250, 100, 50);
		l3.setBounds(80, 350, 100, 50);
		t1.setBounds(200, 150, 250, 50);
		t2.setBounds(200, 250, 250, 50);
		t3.setBounds(200, 350, 250, 50);
		btn.setBounds(80,500,150,50);
		rtnbtn.setBounds(300,500,150,50);
		btn.setFont(new Font("楷体",Font.PLAIN, 20));
		rtnbtn.setFont(new Font("楷体",Font.PLAIN, 20));
		label.setFont(new Font("楷体",Font.PLAIN, 30));
		
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		
		p.add(label);
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(t1);
		p.add(t2);
		p.add(t3);
		p.add(btn);
		p.add(rtnbtn);
		
		this.add(p);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(550, 650);
		this.setVisible(true);	
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Database.insert_score(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()));
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
	
//	public static void main(String[] args) {
//		new InsertScore();
//	}
}
