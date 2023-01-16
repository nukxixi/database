package studentsDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Select extends JFrame {
	JFrame f=new JFrame();
	MyPanel selectPanel=new MyPanel();
	JLabel label1=new JLabel("请选择要查询的学生学号/课号/系别名：");
	JButton btn1=new JButton("查询学生个人信息");
	JButton btn2=new JButton("查询学生成绩信息");
	JButton btn3=new JButton("查询系别下的所有学生");
	JButton btn4=new JButton("查询选择课程的学生成绩");
	JButton rtnbtn=new JButton("返回");
	Font font=new Font("楷体",Font.PLAIN, 30);
	static JTextField t=new JTextField();

	public Select(){
		
		this.setTitle("查询学生信息");
		t.setFont(new Font("楷体",Font.PLAIN, 20));
		selectPanel.setLayout(null);
		t.setBounds(450,20, 180, 40);
		label1.setBounds(20,20,450,40);
		//label2.setBounds(20,40,350,20);
		label1.setFont(new Font("楷体",Font.PLAIN, 24));
		//label2.setFont(new Font("楷体",Font.PLAIN,20));

		btn1.setBounds(130, 120,300, 50);
		btn2.setBounds(130, 220,300, 50);
		btn3.setBounds(130, 320,300, 50);
		btn4.setBounds(130, 420,300, 50);
		rtnbtn.setBounds(200,520,100,50);
		btn1.setFont(new Font("楷体",Font.PLAIN, 20));
		btn2.setFont(new Font("楷体",Font.PLAIN, 20));
		btn3.setFont(new Font("楷体",Font.PLAIN, 20));
		btn4.setFont(new Font("楷体",Font.PLAIN, 20));
		rtnbtn.setFont(new Font("楷体",Font.PLAIN, 20));

		selectPanel.add(t);
		selectPanel.add(label1);
		selectPanel.add(btn2);
		selectPanel.add(btn1);
		selectPanel.add(btn3);
		selectPanel.add(btn4);
		selectPanel.add(rtnbtn);
		
		this.add(selectPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(660,650);
		this.setVisible(true);	
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new SelectStudent(t.getText());
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new SelectStudentScore(t.getText());
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new SelectDept(t.getText());
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new SelectScore(t.getText());
			}
		});
		
		rtnbtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
			new ToolWin();
		}
		});	
	}
//	public static void main(String[] args) {
//		new Select();
//	}
}
