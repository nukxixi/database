package studentsDatabase;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Delete extends JFrame{
	JFrame  f=new JFrame();
	MyPanel deletePanel=new MyPanel();
	JLabel label=new JLabel("������Ҫɾ����ѧ����ѧ�ţ�");
	JLabel l1=new JLabel("ѧ��");
	JTextField t1=new JTextField();
	
	JButton btn=new JButton("ɾ��");
	JButton rtnbtn=new JButton("����");
	Font font=new Font("����",Font.PLAIN, 30);
	
	
	public Delete(){
		this.setTitle("ɾ��ѧ����Ϣ");

		l1.setFont(font);
		deletePanel.setLayout(null);
		label.setBounds(80,30,500,50);
		l1.setBounds(80, 100, 100, 50);
		t1.setBounds(200, 100, 250, 50);
		btn.setBounds(80,200,150,50);
		rtnbtn.setBounds(300,200,150,50);
		btn.setFont(new Font("����",Font.PLAIN, 20));
		rtnbtn.setFont(new Font("����",Font.PLAIN, 20));
		label.setFont(new Font("����",Font.PLAIN, 30));
		
		t1.setFont(font);

		deletePanel.add(label);
		deletePanel.add(l1);
		deletePanel.add(t1);
		deletePanel.add(btn);
		deletePanel.add(rtnbtn);
		
		this.add(deletePanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 300);
		this.setSize(550, 350);
		this.setVisible(true);	
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int result=JOptionPane.showConfirmDialog(null,"ȷ��ɾ����ѧ����","ȷ��ɾ��",JOptionPane.YES_NO_OPTION);
				if(result==0){
					try {
						Database.delete(Integer.parseInt(t1.getText()));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
				}
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
	
//public static void main(String[] args) {
//	new Delete();
//}
}
