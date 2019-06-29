package Hospitallogin;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Doctorfunction.Main;
import Hospitaladmin.admin_frame;
import Hospitalresponse.Alter;
import Hospitalresponse.Register;
import geng.handle.HandleLogin;
import geng.model.Login;
import linkdatabase.linkdatabase; 

public class LoginFrame extends JFrame implements ActionListener{

	String sql;
	Login login = new Login();
	HandleLogin handleLogin = new HandleLogin();
	JLabel l1 = new JLabel("��ӭ��½ҽԺ��������ϵͳ");
	JLabel l2 = new JLabel("�˺�:");
	JLabel l3 = new JLabel("����:");
	JLabel l4 = new JLabel("�˺Ų����ڣ�");
	JLabel l5 = new JLabel("<HTML><U>"+"ע���˺�"+"</U></HTML>");  
	JLabel l6 = new JLabel("<HTML><U>"+"�޸�����"+"</U></HTML>");
	
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	
	Button b1 = new Button("��½");
	Button b2 = new Button("ȡ��");
	
	public LoginFrame() {
		// TODO Auto-generated constructor stub
		//���ñ���
		super("��ӭ��½ҽԺ��������ϵͳ");//��������Ϊ��ӭ��½ҽԺ��������ϵͳ�Ĵ���
		setBounds(300,100,910,500);//���ô�������Ļ�ϵ�λ�ü���С
		String path = "lib/login.jpeg";
		ImageIcon backgroundimage=new ImageIcon(path);//ʹ��ǩ��ͼƬ���ô˴�������ͼƬ
		JLabel jLabel = new JLabel(backgroundimage);//��ǩΪ�û���ʾ��Ϣ
		jLabel.setBounds(0, 0, this.getWidth(), this.getHeight());//��ǩ�ڴ����ϵ�λ�ü���С
		JPanel jPanel1 = (JPanel) this.getContentPane();//��ʼ��һ��������壬�����ſ��԰�����������ó�͸����    jPanel1����������Ҫ��ӵ�ͼƬ�����������ǵ����
		jPanel1.setOpaque(false);//ʹ���������ʾ���е�ĳЩ���أ��������������������ֳ�����������͸��
		jPanel1.setLayout(null);
		this.getLayeredPane().add(jLabel,new Integer(Integer.MIN_VALUE));
		setVisible(true);
		
		// ��½��������
		l1.setBounds(450, 70, 450, 35);
		l1.setFont(new Font("����", Font.BOLD, 30)); 
		l2.setBounds(470, 140, 70, 25);
		l2.setFont(new Font("����",Font.BOLD,23));
		l3.setBounds(470, 200, 70, 25);
		l3.setFont(new Font("����",Font.BOLD,23));
		l4.setBounds(120, 200, 150, 20);
		l4.setFont(new Font("����",Font.BOLD,23));
		
		l5.setBounds(730,140,70,25);
		l5.setFont(new Font("΢���ź�",Font.BOLD,15));
		l5.setForeground(Color.blue);
		l5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l5.addMouseListener(new Register());
		
		l6.setBounds(730,200,70,25);
		l6.setFont(new Font("΢���ź�",Font.BOLD,15));
		l6.setForeground(Color.blue);
		l6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l6.addMouseListener(new Alter());
		
		t1.setBounds(540, 140, 160, 25);
		t1.setFont(new Font("����",0,18));
		t2.setBounds(540, 200, 160, 25);
		t2.setFont(new Font("����",0,18));
		
		b1.setBounds(540, 260, 70, 30);
		b1.setFont(new Font("����",0,15));
		b1.addActionListener(this);
		b2.setBounds(660, 260, 70, 30);
		b2.setFont(new Font("����",0,15));
		b2.addActionListener(this);
		
		super.add(l1);
		super.add(l2);
		super.add(l3);
		super.add(l5);
		super.add(l6);
		super.add(t1);
		super.add(t2);
		super.add(b1);
		super.add(b2);
		super.setLayout(null);
		super.setVisible(true);
		
		//�������������Ϸ��Ĺر�ͼ��ʱ,����������windowClosing����,����ڸ÷�����ʹ��System.exit(0)�˳����������
		super.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
			
		});
		super.setResizable(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginFrame();
	}

	@Override
	//�¼�Դ����ActionEvent�¼��󣬼��������ýӿ��еĴ˷����Է������¼���������
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();//��������¼������Ķ���
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		if(source == b1) {
			String name = t1.getText();
			String pass = t2.getText();
			Login login  = new Login();
			login.setDno(name);
			try {
				con = linkdatabase.getConnection();
				if("".equals(name.trim()) || "".equals(pass.trim())) {
					JOptionPane.showMessageDialog(null, "�����������ĵ�½��Ϣ��","ϵͳ��ʾ",JOptionPane.ERROR_MESSAGE);
				}else if(name.equals("admin") && pass.equals("123456")) {
					new admin_frame();
					super.dispose();
				}else {
					login.setDno(name);
					login.setDpassword(pass);
					login = handleLogin.queryVerify(login);
					if(login.getLoginSuccess() == true) {
						System.out.println("��¼�ɹ��ˣ�");
						new Main(login);
						super.dispose();
					}else {
						System.out.println("��¼ʧ���ˣ�");
						JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ������µ�¼","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);
					}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				linkdatabase.closeAll(rs, ps, con);
			}
		}
		if(source == b2) {
			System.exit(0);
		}
	}
}
