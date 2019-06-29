package linkdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class linkdatabase {

    static Connection connection;

    public linkdatabase(){
    	//���ݿ�����
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //���ӵ����ݿ�
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=HWMS";
        String user="sa";
        String password="yyl13593519418";

        //����JDBC-MySQL���ݿ�����
        try {
			Class.forName(driverName);
			connection = (Connection) DriverManager.getConnection(url,user,password);
			System.out.println("���ݿ����ӳɹ�");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��:"+e.getMessage());
		}
    }

    public static Connection getConnection(){
    	new linkdatabase();
        return connection;
    }

    public void setConnection(Connection connection){
        this.connection = connection;
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
