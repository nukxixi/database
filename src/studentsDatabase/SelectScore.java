package studentsDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SelectScore extends JFrame{
	JFrame f=new JFrame();
	MyPanel p=new MyPanel();
	JLabel l=new JLabel("ѡ�ÿε�ѧ���ɼ����£�");
	JButton rtnbtn=new JButton("����");

	
	public SelectScore(String s) {
		try {
			Database.select_score(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		p.setLayout(null);
		
		l.setFont(new Font("����",Font.PLAIN, 26));
		rtnbtn.setFont(new Font("����",Font.PLAIN, 20));
		
		l.setBounds(100,80, 300, 50);
		rtnbtn.setBounds(150, 650, 150, 50);
		p.add(rtnbtn);
		p.add(Database.table3);
		p.add(l);
	
		this.add(p);
		this.setTitle("�γ̲�ѯ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 200);
		this.setSize(550, 800);
		this.setVisible(true);	
		
		rtnbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				Database.rowInfo3.clear();
				Database.columnAtrs3.clear();
				Select.t.setText("");
				new Select();
			}
		});
	}
//	public static void main(String[] args) {
//		new SelectScore();
//	}
}
