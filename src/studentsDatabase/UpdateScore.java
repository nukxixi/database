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

public class UpdateScore extends JFrame{
	JFrame f=new JFrame();
	MyPanel p2=new MyPanel();
	JLabel label=new JLabel("������ѧ����Ϣ��");
	JLabel l1=new JLabel("ѧ�ţ�");
	JLabel l2=new JLabel("�κţ�");
	JLabel l3=new JLabel("�ɼ���");

	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	
	JButton btn=new JButton("ȷ�ϸ���");
	JButton rtnbtn=new JButton("����");
	Font font=new Font("����",Font.PLAIN, 30);
	
	public UpdateScore(){
		this.setTitle("����ѧ���ɼ�");
		label.setFont(font);
		p2.setLayout(null);
		
		label.setBounds(80,30,500,50);
		l1.setBounds(80,120,150,50);
		l2.setBounds(80,200,150,50);
		l3.setBounds(80,280,150,50);
		t1.setBounds(200, 120,200, 50);
		t2.setBounds(200, 200, 200, 50);
		t3.setBounds(200, 280, 200, 50);
		btn.setBounds(80, 360,180, 50);
		rtnbtn.setBounds(300,360,100,50);
		btn.setFont(new Font("����",Font.PLAIN, 20));
		rtnbtn.setFont(new Font("����",Font.PLAIN, 20));
		label.setFont(new Font("����",Font.PLAIN, 30));
		t1.setFont(new Font("����",Font.PLAIN, 30));
		t2.setFont(new Font("����",Font.PLAIN, 30));
		t3.setFont(new Font("����",Font.PLAIN, 30));
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		
		p2.add(label);
		p2.add(t1);
		p2.add(t2);
		p2.add(t3);
		p2.add(l1);
		p2.add(l2);
		p2.add(l3);
		p2.add(btn);
		p2.add(rtnbtn);
		
		this.add(p2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(500,500);
		this.setVisible(true);	
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Database.update_score(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()));
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
//		new UpdateScore();
//	}
}
