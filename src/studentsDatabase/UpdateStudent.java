package studentsDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateStudent extends JFrame {
	JFrame f=new JFrame();
	MyPanel p1=new MyPanel();
	JLabel label=new JLabel("请输入学生信息：");
	JLabel l1=new JLabel("学  号：");
	JLabel l2=new JLabel("新系别：");

	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	
	JButton btn=new JButton("确认更新");
	JButton rtnbtn=new JButton("返回");
	Font font=new Font("楷体",Font.PLAIN, 30);
	
	
	public UpdateStudent(){
		this.setTitle("更新学生信息");
		label.setFont(font);
		p1.setLayout(null);
		
		label.setBounds(80,30,500,50);
		l1.setBounds(80,120,150,50);
		l2.setBounds(80,200,150,50);
		t1.setBounds(200, 120,200, 50);
		t2.setBounds(200, 200, 200, 50);
		btn.setBounds(80, 300,180, 50);
		rtnbtn.setBounds(300,300,100,50);
		btn.setFont(new Font("楷体",Font.PLAIN, 20));
		rtnbtn.setFont(new Font("楷体",Font.PLAIN, 20));
		label.setFont(new Font("楷体",Font.PLAIN, 30));
		t1.setFont(new Font("楷体",Font.PLAIN, 30));
		t2.setFont(new Font("楷体",Font.PLAIN, 30));
		l1.setFont(font);
		l2.setFont(font);
		
		p1.add(label);
		p1.add(t1);
		p1.add(t2);
		p1.add(l1);
		p1.add(l2);
		p1.add(btn);
		p1.add(rtnbtn);
		
		this.add(p1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(500,500);
		this.setVisible(true);	
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Database.update_student(Integer.parseInt(t1.getText()), t2.getText());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		rtnbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new Update();
			}
		});
	}
	
//	public static void main(String[] args) {
//		new UpdateStudent();
//	}
}
