package studentsDatabase;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Insert extends JFrame{
	JFrame f=new JFrame();
	MyPanel panel=new MyPanel();
	JLabel label=new JLabel("��ѡ����Ҫ��ӵ���Ϣ��");
	JButton b1=new JButton("ѧ��������Ϣ");
	JButton b2=new JButton("ѧ���ɼ���Ϣ");

	JButton rtnbtn=new JButton("����");
	Font font1=new Font("����",Font.PLAIN, 30);
	Font font2=new Font("����",Font.PLAIN, 20);
	
	public Insert(){

		this.setTitle("���ѧ����Ϣ");

		label.setFont(font1);
		b1.setFont(font2);
		b2.setFont(font2);
		rtnbtn.setFont(font2);

		panel.setLayout(null);
		label.setBounds(80,30,500,50);
		b1.setBounds(150, 150, 200, 50);
		b2.setBounds(150, 250, 200, 50);
		rtnbtn.setBounds(200, 350, 100, 50);

		panel.add(label);
		panel.add(b1);
		panel.add(b2);
		panel.add(rtnbtn);

		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(550, 550);
		this.setVisible(true);	
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new InsertStudent();
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new InsertScore();
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
	
	class InsertPanel extends JPanel{
		public void paintComponent(Graphics g){  
	        super.paintComponent(g);  
	        //����һ�ű���ͼƬ  2.jpg��ͼƬ��·��  �Լ��趨Ϊ�Լ���Ҫ��ӵ�ͼƬ  
	        Image image = new ImageIcon("lib/image0.jpg").getImage();  
	        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
	    } 
	}

}
