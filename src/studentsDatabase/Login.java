package studentsDatabase;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	MyPanel panel=new MyPanel();
	JLabel labelTitle=new JLabel("学生信息管理系统");
	JLabel labelId=new JLabel("用户名");
	JLabel labelPwd=new JLabel("密  码");
	JTextField textId=new JTextField();
	JPasswordField textPwd=new JPasswordField();
	JButton btnLogin=new JButton("登录");

	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost:3306/studentsmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	String userName = "root"; // 默认用户名
	String userPwd = "123456"; // 密码
	public Login(){
		Font font1=new Font("楷体",Font.PLAIN, 30);
		Font font2=new Font("楷体",Font.PLAIN,50);
		labelTitle.setFont(font2);
		labelId.setFont(font1);
		labelPwd.setFont(font1);
		panel.setLayout(null);
		labelTitle.setBounds(80, 30, 500, 200);
		labelId.setBounds(50,150,300,200);
		labelPwd.setBounds(50,230,300,200);
		textId.setBounds(200,220,300,50);
		textPwd.setBounds(200,300,300,50);
		btnLogin.setBounds(250,400,150,60);
		btnLogin.setFont(font1);
		
		textId.setFont(new Font("Times New Roman",Font.PLAIN, 30));
		textPwd.setFont(new Font("楷体",Font.PLAIN, 14));
		textPwd.setEchoChar('●');
		btnLogin.addActionListener(new loginSuccess());
		panel.add(labelTitle);
		panel.add(labelId);
		panel.add(labelPwd);
		panel.add(textId);
		panel.add(textPwd);
		panel.add(btnLogin);
		
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(650,580);
		f.setLocation(500, 300);
		f.setTitle("学生信息管理系统");
		f.getContentPane().add(panel);
		f.setVisible(true);	
	}
	
	class loginSuccess implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (textId.getText().equals("root") && textPwd.getText().equals("123456")) {
				dispose();
				new ToolWin();
				try {
					Class.forName(JDBC_DRIVER);
					Connection dbConn = DriverManager.getConnection(DB_URL, userName, userPwd);
					if(dbConn.isClosed())
						System.out.println("数据库已关闭！");
					else
						System.out.println("连接成功！"); 
				} catch (Exception ex) {
					System.out.println("连接失败！");
				}
			} else {
				if(!textId.getText().equals("root")){
					JOptionPane.showMessageDialog(null, "用户不存在！", "用户不存在", JOptionPane.INFORMATION_MESSAGE);
					textId.setText("");
					textPwd.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "密码错误", JOptionPane.INFORMATION_MESSAGE);
					textPwd.setText("");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
