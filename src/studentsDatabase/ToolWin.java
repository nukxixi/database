package studentsDatabase;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ToolWin extends JFrame{
	JButton b1=new JButton("��ѯѧ����Ϣ");
	JButton b2=new JButton("����ѧ����Ϣ");
	JButton b3=new JButton("ɾ��ѧ����Ϣ");
	JButton b4=new JButton("�޸�ѧ����Ϣ");
	JLabel label=new JLabel("��ѡ�������");
	MyPanel toolPanel=new MyPanel();
	Font font=new Font("����",Font.PLAIN, 20);
	
	public ToolWin(){
		this.setTitle("��������");
		
		label.setBounds(150,50,300,50);
		b1.setBounds(new Rectangle(150,150,200,50));
		b2.setBounds(new Rectangle(150,250,200,50));
		b3.setBounds(new Rectangle(150,350,200,50));
		b4.setBounds(new Rectangle(150,450,200,50));
		
		label.setFont(new Font("����",Font.PLAIN, 30));
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		
		toolPanel.setLayout(null);
		toolPanel.add(label);
		toolPanel.add(b1);
		toolPanel.add(b2);
		toolPanel.add(b3);
		toolPanel.add(b4);
		
		this.add(toolPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(550, 600);
		this.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Select();
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Insert();
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Delete();
			}
		});
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Update();
			}
		});
	}
	
//	public static void main(String[] args) {
//		new ToolWin();
//	}
	
}
