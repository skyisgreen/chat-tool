package Hospitallink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Link {

	public static Connection getConnection() {
		Connection connection = null;
		//���ݿ�����
		String driveName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//���ӵ����ݿ�
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=ҽԺ��������ϵͳ"; 
		String user = "root";
		String password ="";
				
		//����JDBC-MySQL���ݿ�����
		try {
			Class.forName(driveName);
			connection = (Connection) DriverManager.getConnection(url,user,password);
			System.out.println("���ݿ����ӳɹ�");
		}
		catch(Exception e) {
			System.out.println("���ݿ�����ʧ��:"+e.getMessage());
		}
		return connection;
	}
	

	public static void closeAll(ResultSet rs,PreparedStatement ps,Connection con){
		if(rs != null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		if(ps != null){
			try{
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		if(con != null){
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
}
