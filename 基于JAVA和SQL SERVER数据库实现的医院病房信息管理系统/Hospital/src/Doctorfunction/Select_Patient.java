package Doctorfunction;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import linkdatabase.linkdatabase;

public class Select_Patient extends JTable implements ActionListener{

	private JFrame frame;
	private JLabel label;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton button1 = new JButton("��ѯ");
	private JButton button2 = new JButton("ȡ��");
	private JTable table = new JTable();
	private DefaultTableModel dm = null;
	private JScrollPane scrollPane;//���������ʹ����Ҫ����ʾ��������ʾ
	private JPopupMenu popupMenu;//����ʽ�˵�
	
	public Select_Patient() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("��ѯ������Ϣ");
		frame.setBounds(100, 100, 1050, 550);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("ѡ���ѯ����");
		label.setFont(new Font("����", Font.PLAIN, 30));
		label.setBounds(15,90,210,40);
		frame.getContentPane().add(label);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("����",Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"������", "����","�Ա�","���","������","������","����ҽ������֤��","��ϵ�绰","��Ժ����","��Ժ����","ȫ��"}));
		comboBox.setBounds(15,150,210,40);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("����",Font.PLAIN, 20));
		textField.setBounds(15,220,210,40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		button1.setBounds(15,290,85,30);
		frame.getContentPane().add(button1);
		button1.addActionListener(this);
		
		button2.setBounds(140,290,85,30);
		frame.getContentPane().add(button2);
		button2.addActionListener(this);
		
		String[] columnNames={"������", "����","�Ա�","���","������","������","��ҽ֤��","��ϵ�绰","��Ժ����","��Ժ����"};
		dm = new DefaultTableModel(columnNames, 0);
		table.setModel(dm);
		scrollPane = new JScrollPane(table);
		table.setBounds(250, 15, 765, 475);
		scrollPane.setBounds(250, 15, 765, 475);
		frame.getContentPane().add(scrollPane);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String select = (String) comboBox.getSelectedItem();
		String text = textField.getText().trim();
		
		try {
			if(source == button1) {
				con = linkdatabase.getConnection();
				if(select.equals("������")) {
					String sql = "SELECT Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate from Patient where Pno=?";
					ps = con.prepareStatement(sql);
					ps.setObject(1, text);
					rs=ps.executeQuery();
					if(!rs.next()){
						JOptionPane.showMessageDialog(null, "�����Ϣ�����ڣ�����������!","ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
					}
					ps.close();
					rs.close();
					
					ps = con.prepareStatement(sql);
					ps.setObject(1, text);
					rs = ps.executeQuery();
					while(rs.next()){
						String Pno = rs.getString(1);
						String Pname = rs.getString(2);
						String Psex = rs.getString(3);
						String Pdiagnose = rs.getString(4);
						String Wno = rs.getString(5);
						String Bno = rs.getString(6);
						String Dno = rs.getString(7);
						String Ptel = rs.getString(8);
						String Pindate = rs.getString(9);
						String Poutdate = rs.getString(10);
						dm.addRow(new Object[]{Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate});							
					}
				}
			}
			if(select.equals("����")) {
				String sql = "SELECT Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate from Patient where Pname=?";
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs=ps.executeQuery();
				if(!rs.next()){
					JOptionPane.showMessageDialog(null, "�����Ϣ�����ڣ�����������!","ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				ps.close();
				rs.close();
				
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs = ps.executeQuery();
				while(rs.next()){
					String Pno = rs.getString(1);
					String Pname = rs.getString(2);
					String Psex = rs.getString(3);
					String Pdiagnose = rs.getString(4);
					String Wno = rs.getString(5);
					String Bno = rs.getString(6);
					String Dno = rs.getString(7);
					String Ptel = rs.getString(8);
					String Pindate = rs.getString(9);
					String Poutdate = rs.getString(10);
					dm.addRow(new Object[]{Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate});							
				}
			}
			if(select.equals("�Ա�")) {
				String sql = "SELECT Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate from Patient where Psex=?";
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs=ps.executeQuery();
				if(!rs.next()){
					JOptionPane.showMessageDialog(null, "�����Ϣ�����ڣ�����������!","ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				ps.close();
				rs.close();
				
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs = ps.executeQuery();
				while(rs.next()){
					String Pno = rs.getString(1);
					String Pname = rs.getString(2);
					String Psex = rs.getString(3);
					String Pdiagnose = rs.getString(4);
					String Wno = rs.getString(5);
					String Bno = rs.getString(6);
					String Dno = rs.getString(7);
					String Ptel = rs.getString(8);
					String Pindate = rs.getString(9);
					String Poutdate = rs.getString(10);
					dm.addRow(new Object[]{Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate});							
				}
			}
			if(select.equals("��Ͻ��")) {
				String sql = "SELECT Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate from Patient where Pdiagnose=?";
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs=ps.executeQuery();
				if(!rs.next()){
					JOptionPane.showMessageDialog(null, "�����Ϣ�����ڣ�����������!","ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				ps.close();
				rs.close();
				
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs = ps.executeQuery();
				while(rs.next()){
					String Pno = rs.getString(1);
					String Pname = rs.getString(2);
					String Psex = rs.getString(3);
					String Pdiagnose = rs.getString(4);
					String Wno = rs.getString(5);
					String Bno = rs.getString(6);
					String Dno = rs.getString(7);
					String Ptel = rs.getString(8);
					String Pindate = rs.getString(9);
					String Poutdate = rs.getString(10);
					dm.addRow(new Object[]{Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate});							
				}
			}
			if(select.equals("������")) {
				String sql = "SELECT Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate from Patient where Wno=?";
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs=ps.executeQuery();
				if(!rs.next()){
					JOptionPane.showMessageDialog(null, "�����Ϣ�����ڣ�����������!","ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				ps.close();
				rs.close();
				
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs = ps.executeQuery();
				while(rs.next()){
					String Pno = rs.getString(1);
					String Pname = rs.getString(2);
					String Psex = rs.getString(3);
					String Pdiagnose = rs.getString(4);
					String Wno = rs.getString(5);
					String Bno = rs.getString(6);
					String Dno = rs.getString(7);
					String Ptel = rs.getString(8);
					String Pindate = rs.getString(9);
					String Poutdate = rs.getString(10);
					dm.addRow(new Object[]{Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate});							
				}
			}
			if(select.equals("������")) {
				String sql = "SELECT Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate from Patient where Bno=?";
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs=ps.executeQuery();
				if(!rs.next()){
					JOptionPane.showMessageDialog(null, "�����Ϣ�����ڣ�����������!","ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				ps.close();
				rs.close();
				
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs = ps.executeQuery();
				while(rs.next()){
					String Pno = rs.getString(1);
					String Pname = rs.getString(2);
					String Psex = rs.getString(3);
					String Pdiagnose = rs.getString(4);
					String Wno = rs.getString(5);
					String Bno = rs.getString(6);
					String Dno = rs.getString(7);
					String Ptel = rs.getString(8);
					String Pindate = rs.getString(9);
					String Poutdate = rs.getString(10);
					dm.addRow(new Object[]{Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate});							
				}
			}
			if(select.equals("����ҽ������֤��")) {
				String sql = "SELECT Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate from Patient where Dno=?";
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs=ps.executeQuery();
				if(!rs.next()){
					JOptionPane.showMessageDialog(null, "�����Ϣ�����ڣ�����������!","ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				ps.close();
				rs.close();
				
				ps = con.prepareStatement(sql);
				ps.setObject(1, text);
				rs = ps.executeQuery();
				while(rs.next()){
					String Pno = rs.getString(1);
					String Pname = rs.getString(2);
					String Psex = rs.getString(3);
					String Pdiagnose = rs.getString(4);
					String Wno = rs.getString(5);
					String Bno = rs.getString(6);
					String Dno = rs.getString(7);
					String Ptel = rs.getString(8);
					String Pindate = rs.getString(9);
					String Poutdate = rs.getString(10);
					dm.addRow(new Object[]{Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate});							
				}
			}
			if(select.equals("ȫ��")) {
				String sql = "SELECT Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate from Patient";
				ps = con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()){
					String Pno = rs.getString(1);
					String Pname = rs.getString(2);
					String Psex = rs.getString(3);
					String Pdiagnose = rs.getString(4);
					String Wno = rs.getString(5);
					String Bno = rs.getString(6);
					String Dno = rs.getString(7);
					String Ptel = rs.getString(8);
					String Pindate = rs.getString(9);
					String Poutdate = rs.getString(10);
					dm.addRow(new Object[]{Pno,Pname,Psex,Pdiagnose,Wno,Bno,Dno,Ptel,Pindate,Poutdate});								
				}
			}
			/*
			JTable table=new JTable(dm);
			table.setBounds(250, 15, 765, 475);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(250, 15, 765, 475);
			frame.getContentPane().add(scrollPane);
			*/
			table = new JTable(dm);
			table.setBounds(250, 15, 765, 475);
			frame.getContentPane().add(scrollPane);
		}catch(SQLException e1){
			e1.printStackTrace();
		}finally {
			linkdatabase.closeAll(rs, ps, con);
		}
		if(source == button2) {
			frame.dispose();
		}
	}

}
