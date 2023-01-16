package studentsDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update extends JFrame{
	JFrame f=new JFrame();
	MyPanel updatePanel=new MyPanel();
	JLabel label=new JLabel("请选择要修改的内容：");
	JButton btn1=new JButton("更新学生个人信息");
	JButton btn2=new JButton("修改学生成绩信息");
	JButton rtnbtn=new JButton("返回");
	Font font=new Font("楷体",Font.PLAIN, 30);
	public Update(){
		
		this.setTitle("更新学生信息");
		label.setFont(font);
		
		updatePanel.setLayout(null);
		
		label.setBounds(80,30,500,50);
		btn1.setBounds(80, 120,300, 50);
		btn2.setBounds(80, 220,300, 50);
		rtnbtn.setBounds(170,320,100,50);
		btn1.setFont(new Font("楷体",Font.PLAIN, 20));
		btn2.setFont(new Font("楷体",Font.PLAIN, 20));
		rtnbtn.setFont(new Font("楷体",Font.PLAIN, 20));
		label.setFont(new Font("楷体",Font.PLAIN, 30));

		
		updatePanel.add(label);
		updatePanel.add(btn2);
		updatePanel.add(btn1);
		updatePanel.add(rtnbtn);
		
		this.add(updatePanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(500,500);
		this.setVisible(true);	
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new UpdateStudent();
			}
		});
	btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new UpdateScore();
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
//		new Update();
//	}
}
