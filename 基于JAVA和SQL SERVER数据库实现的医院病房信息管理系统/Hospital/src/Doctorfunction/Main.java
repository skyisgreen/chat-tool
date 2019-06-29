package Doctorfunction;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Hospitaladmin.Insert_Patient;
import geng.model.Login;

public class Main implements ActionListener{

	Login login;
	JFrame frame = new JFrame();
	JButton b1 = new JButton("���������Ϣ");
	JButton b2 = new JButton("�Ǽǲ�����Ϣ");
	JButton b3 = new JButton("��ѯ������Ϣ");
	JButton b4 = new JButton("��ѯ��λ��Ϣ");
	JButton b5 = new JButton("��Ժ����");
	
	public Main(Login login) {
		this.login=login;
		// TODO Auto-generated constructor stub
		frame.setBounds(330,150,600,500);
		b1.setBounds(200, 60, 150, 40);
		b1.setFont(new Font("����",0,16));
		b1.addActionListener(this);
		
		b2.setBounds(200, 120,150, 40);
		b2.setFont(new Font("����",0,16));
		b2.addActionListener(this);
		
		b3.setBounds(200, 180, 150, 40);
		b3.setFont(new Font("����",0,16));
		b3.addActionListener(this);
		
		b4.setBounds(200, 240, 150, 40);
		b4.setFont(new Font("����",0,16));
		b4.addActionListener(this);
		
		b5.setBounds(200, 300, 150, 40);
		b5.setFont(new Font("����",0,16));
		b5.addActionListener(this);
		
		
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b1) {
			new Select_Doctor(login);
		}

		if(e.getSource() == b2) {
			new Insert_Patient();
		}
		
		if(e.getSource() == b3) {
			new Select_Patient();
		}
		
		if(e.getSource() == b4) {
			new Select_Bed();
		}
		
		if(e.getSource() == b5) {
			new leave_cost();
		}
	}

}
