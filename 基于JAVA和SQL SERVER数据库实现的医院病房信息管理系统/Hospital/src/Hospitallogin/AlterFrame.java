package Hospitallogin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import linkdatabase.linkdatabase;

public class AlterFrame extends JFrame implements ActionListener {

	String sql;
	
	JLabel l1 = new JLabel("��    ��:");
	JLabel l2 = new JLabel("��    ��:");
	JLabel l3 = new JLabel("�� �� ��:");
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JButton b1 = new JButton("�޸�");
	JButton b2 = new JButton("ȡ��");
	
	public AlterFrame() {
		// TODO Auto-generated constructor stub
		super("�޸�����");
		setBounds(500,200,530,350);
		
		l1.setBounds(70, 70, 160, 30);
		l1.setFont(new Font("����",Font.PLAIN,25));
		l2.setBounds(70, 120, 160, 30);
		l2.setFont(new Font("����",Font.PLAIN,25));
		l3.setBounds(70, 170, 160, 30);
		l3.setFont(new Font("����",Font.PLAIN,25));
		
		t1.setBounds(230, 70, 200, 30);
		t1.setFont(new Font("����",0, 20));
		t2.setBounds(230, 120, 200, 30);
		t2.setFont(new Font("����",0, 20));
		t3.setBounds(230,170,200,30);
		t3.setFont(new Font("����",0, 20));
		
		b1.setBounds(115, 240, 115, 30);
		b1.setFont(new Font("����",0,15));
		b1.addActionListener(this);
		b2.setBounds(280, 240, 115, 30);
		b2.setFont(new Font("����",0,15));
		b2.addActionListener(this);
		
		super.add(l1);
		super.add(l2);
		super.add(l3);
		super.add(t1);
		super.add(t2);
		super.add(t3);
		super.add(b1);
		super.add(b2);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		if(source == b1) {
			String no = t1.getText().trim();
			String pass = t2.getText().trim();
			String newpass = t3.getText().trim();
			try {
				con = linkdatabase.getConnection();
				int a = JOptionPane.showConfirmDialog(null, "ȷ���޸����룿","ϵͳ��ʾ",JOptionPane.YES_NO_OPTION);//����ѡ��Ի���
				if(a == JOptionPane.YES_OPTION) {
					sql = "select Dno,Dpassword from Doctor where Dno=? and Dpassword=?";
					ps = con.prepareStatement(sql);
					ps.setObject(1, no);
					ps.setObject(2, pass);
				    rs = ps.executeQuery();
					if(rs.next()) {
						sql = "update Doctor set Dpassword=? where Dno=?";
						ps = con.prepareStatement(sql);
						ps.setObject(1, newpass);
						ps.setObject(2, no);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���","��ʾ��Ϣ",JOptionPane.PLAIN_MESSAGE);
						this.dispose();
					}else {
						JOptionPane.showMessageDialog(null,"�˺Ż�����������������룡","ϵͳ��ʾ",JOptionPane.ERROR_MESSAGE);
					}
				}
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				linkdatabase.closeAll(rs, ps, con);
			}
		}
		if(source == b2) {
			this.dispose();
		}
	}
}

