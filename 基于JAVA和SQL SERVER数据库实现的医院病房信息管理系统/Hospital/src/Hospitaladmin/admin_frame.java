package Hospitaladmin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import Jtable.Jtable;

public class admin_frame extends Jtable{

	JFrame frame;
	JMenuBar menuBar = new JMenuBar();//�˵������
	JLabel l1 = new JLabel("��ӭ����");
	JLabel l2 = new JLabel("ҽԺ��������ϵͳ");
	JMenu menu1 = new JMenu("������Ϣ����");
	JMenu menu2 = new JMenu("ҽ����Ϣ����");
	JMenu menu3 = new JMenu("������Ϣ����");
	JMenu menu4 = new JMenu("��λ��Ϣ����");
	JMenu menu5 = new JMenu("������Ϣ����");
	JMenuItem insert_department,manage_department;
	JMenuItem insert_doctor,manage_doctor;
	JMenuItem insert_ward,manage_ward;
	JMenuItem insert_bed,manage_bed;
	JMenuItem insert_patient,manage_patient;
	
	JToolBar jToolBar;//���������
	JButton jButton1,jButton2,jButton3,jButton4,jButton5,jButton6,jButton7;
	
	private Jtable table = new Jtable(){
		   public boolean isCellEditable(int row, int column){
		       return false;
		   }
		};
	private DefaultTableModel dm = null;
	
	public admin_frame() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("ҽԺ�ڲ���Ϣ����");
		frame.setBounds(330,200,688,431);
		String path="lib/Main.jpeg";
		ImageIcon backgroundimage=new ImageIcon(path);//ʹ��ǩ��ͼƬ���ô˴�������ͼƬ
		JLabel jLabel = new JLabel(backgroundimage);//��ǩΪ�û���ʾ��Ϣ
		jLabel.setBounds(0, 0,frame.getWidth(), frame.getHeight());//��ǩ�ڴ����ϵ�λ�ü���С
		JPanel jPanel1 = (JPanel) frame.getContentPane();//��ʼ��һ��������壬�����ſ��԰�����������ó�͸����    jPanel1����������Ҫ��ӵ�ͼƬ�����������ǵ����
		jPanel1.setOpaque(false);//ʹ���������ʾ���е�ĳЩ���أ��������������������ֳ�����������͸��
		jPanel1.setLayout(null);
		frame.getLayeredPane().add(jLabel,new Integer(Integer.MIN_VALUE));
		frame.setVisible(true);
		
		l1.setBounds(80,70,450,40);
		l1.setFont(new Font("΢���ź�",Font.BOLD,40));
		l2.setBounds(190,120,450,40);
		l2.setFont(new Font("΢���ź�",Font.BOLD,40));
		
		insert_department = new JMenuItem("�������");
		manage_department = new JMenuItem("�������");
		
		insert_doctor = new JMenuItem("����ҽ��");
		manage_doctor = new JMenuItem("����ҽ��");
		
		insert_ward = new JMenuItem("���벡��");
		manage_ward = new JMenuItem("������");
	
		
		insert_bed = new JMenuItem("���봲λ");
		manage_bed = new JMenuItem("����λ");
		
		insert_patient = new JMenuItem("���벡��");
		manage_patient = new JMenuItem("������");
		
		menu1.add(insert_department);
		menu1.add(manage_department);
		
		menu2.add(insert_doctor);
		menu2.add(manage_doctor);
		
		menu3.add(insert_ward);
		menu3.add(manage_ward);
		
		menu4.add(insert_bed);
		menu4.add(manage_bed);
		
		menu5.add(insert_patient);
		menu5.add(manage_patient);
		
		//���˵�����˵���
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		menuBar.add(menu5);
		
		frame.setJMenuBar(menuBar);
		frame.add(l1);
		frame.add(l2);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		insert_department.addActionListener(listen);
		manage_department.addActionListener(listen);
		
		insert_doctor.addActionListener(listen);
		manage_doctor.addActionListener(listen);
		
		insert_ward.addActionListener(listen);
		manage_ward.addActionListener(listen);
		
		insert_bed.addActionListener(listen);
		manage_bed.addActionListener(listen);
		
		insert_patient.addActionListener(listen);
		manage_patient.addActionListener(listen);
		
		String[]names={"����֤��","����","�Ա�","����","��������","ְ��","�绰","��������"};
		DefaultTableModel dm = new DefaultTableModel(names, 0);
		
	}

	public static void main(String[] args) {
		new admin_frame();
	}
	
	ActionListener listen = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==insert_department) {
				new Insert_Department();
			}
			
			if(e.getSource()==manage_department) {
				new Manage_Department();
			}
			
			if(e.getSource()==insert_doctor) {
				new Insert_Doctor();
			}
			
			if(e.getSource()==manage_doctor) {
				new Manage_Doctor();
			}
			
			if(e.getSource()==insert_ward) {
				new Insert_Ward();
			}
			
			if(e.getSource()==manage_ward) {
				new Manage_Ward();
			}
			
			if(e.getSource()==insert_bed) {
				new Insert_Bed();
			}
			
			if(e.getSource()==manage_bed) {
				new Manage_Bed();
			}
			
			if(e.getSource()==insert_patient) {
				new Insert_Patient();
			}
			
			if(e.getSource()==manage_patient) {
				new Manage_Patient();
			}
		}
	};
}

