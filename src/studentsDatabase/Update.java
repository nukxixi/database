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
	JLabel label=new JLabel("��ѡ��Ҫ�޸ĵ����ݣ�");
	JButton btn1=new JButton("����ѧ��������Ϣ");
	JButton btn2=new JButton("�޸�ѧ���ɼ���Ϣ");
	JButton rtnbtn=new JButton("����");
	Font font=new Font("����",Font.PLAIN, 30);
	public Update(){
		
		this.setTitle("����ѧ����Ϣ");
		label.setFont(font);
		
		updatePanel.setLayout(null);
		
		label.setBounds(80,30,500,50);
		btn1.setBounds(80, 120,300, 50);
		btn2.setBounds(80, 220,300, 50);
		rtnbtn.setBounds(170,320,100,50);
		btn1.setFont(new Font("����",Font.PLAIN, 20));
		btn2.setFont(new Font("����",Font.PLAIN, 20));
		rtnbtn.setFont(new Font("����",Font.PLAIN, 20));
		label.setFont(new Font("����",Font.PLAIN, 30));

		
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
