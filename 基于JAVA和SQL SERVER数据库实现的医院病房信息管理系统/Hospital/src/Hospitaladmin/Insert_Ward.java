package Hospitaladmin;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import linkdatabase.linkdatabase;

public class Insert_Ward implements ActionListener {

	private JFrame frame;
	private JTextField text_Wno;
	private JTextField text_Dname;
	private JTextField text_Wcharge;
	private JButton button1 = new JButton("����");
	private JButton button2 = new JButton("ȡ��");
	private String sql;
	
	public Insert_Ward() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("���벡����Ϣ");
		frame.setBounds(380,100,600,600);
		frame.getContentPane().setLayout(null);
		
		JLabel label_Wno = new JLabel("�� �� ��");
		label_Wno.setFont(new Font("����", Font.PLAIN, 25));
		label_Wno.setBounds(120,120,120,30);
		frame.getContentPane().add(label_Wno);
		text_Wno = new JTextField();
		text_Wno.setFont(new Font("����", Font.PLAIN, 20));
		text_Wno.setBounds(240,120,130,30);
		text_Wno.setColumns(10);
		frame.getContentPane().add(text_Wno);
		
		JLabel label_Dname = new JLabel("��������");
		label_Dname.setFont(new Font("����", Font.PLAIN, 25));
		label_Dname.setBounds(120,220,120,30);
		frame.getContentPane().add(label_Dname);
		text_Dname = new JTextField();
		text_Dname.setFont(new Font("����", Font.PLAIN, 20));
		text_Dname.setBounds(240,220,130,30);
		text_Dname.setColumns(10);
		frame.getContentPane().add(text_Dname);
		
		JLabel label_Wcharge = new JLabel("�շѱ�׼");
		label_Wcharge.setFont(new Font("����", Font.PLAIN, 25));
		label_Wcharge.setBounds(120,320,120,30);
		frame.getContentPane().add(label_Wcharge);
		text_Wcharge = new JTextField();
		text_Wcharge.setFont(new Font("����", Font.PLAIN, 20));
		text_Wcharge.setBounds(240,320,130,30);
		text_Wcharge.setColumns(10);
		frame.getContentPane().add(text_Wcharge);
		
		button1.setBounds(90, 470, 120, 40);
		frame.getContentPane().add(button1);
		button1.addActionListener(this);
		
		button2.setBounds(280, 470, 120, 40);
		frame.getContentPane().add(button2);
		button2.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == button1) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String Wno = text_Wno.getText().trim();
			String Deptname = text_Dname.getText().trim();
			String Wcharge =text_Wcharge.getText().trim();
		
			try {
				if("".equals(Wno) || "".equals(Deptname) || "".equals(Wcharge)) {
					JOptionPane.showMessageDialog(null, "������������Ϣ��","ϵͳ��ʾ",JOptionPane.ERROR_MESSAGE);
				}else {
					con =linkdatabase.getConnection();
					sql = "select Wno from Ward where Wno=?";
					try {
						ps = con.prepareStatement(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						ps.setObject(1, Wno);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						rs=ps.executeQuery();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						if(!rs.next()) {
							int a =JOptionPane.showConfirmDialog(null, "ȷ�ϲ��벡����Ϣ��","ϵͳ��ʾ",JOptionPane.YES_NO_OPTION);
							if(a == JOptionPane.YES_OPTION) {
								sql="INSERT INTO Ward(Wno,Deptname,Wcharge) VALUES(?,?,?)";
								ps = con.prepareStatement(sql);
								ps.setObject(1, Wno);
								ps.setObject(2, Deptname);
								ps.setObject(3, Wcharge);
								ps.executeUpdate();
								JOptionPane.showMessageDialog(null, "����ɹ���", "ϵͳ��ʾ",JOptionPane.PLAIN_MESSAGE); 
								frame.dispose();		 
							}
						}else {
							JOptionPane.showMessageDialog(null, "�ò����Ѿ����ڣ��޷�����!","ϵͳ��ʾ",JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "������������Ϣ!","ϵͳ��ʾ",JOptionPane.ERROR_MESSAGE);
			} finally {
				linkdatabase.closeAll(rs, ps, con);
			}
		}
		if(source == button2) {
			frame.dispose();
		}
	}

}
