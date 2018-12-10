package hotel.model.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import hotel.model.dto.ReserveDTO;

public class DBUtil
{
	static Properties p = new Properties();
	static
	{
		try
		{
			p.load(new FileInputStream("db.properties")); // ������Ƽ�� ���� �б�
			Class.forName(p.getProperty("jdbc.driver")); // jdbc ����̹��� ���� ��������
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException 
	{
		return DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.id"), p.getProperty("jdbc.pw"));
	}
	
	public static void close(Connection conn, Statement stmt)
	{
		try
		{
			if(stmt != null)
			{
				stmt.close();
				stmt = null;
			}
			
			if(conn != null) 
			{
				conn.close();
				conn = null;
			}
		} 
		catch (SQLException s) 
		{
			s.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rset)
	{
		try
		{
			if(rset != null)
			{
				rset.close();
				rset = null;
			}
			
			if(stmt != null)
			{
				stmt.close();
				stmt = null;
			}
			
			if(conn != null)
			{
				conn.close();
				conn = null;
			}
		}
		catch (SQLException s)
		{
			s.printStackTrace();
		}
	}
}
