package hotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotel.model.dto.ReserveDTO;
import hotel.model.util.DBUtil;

public class ReserveDAO
{
	// ��ü ���� �˻�
	public static ArrayList<ReserveDTO> getAllReserves() throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReserveDTO> list = null;
		
		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from reserve");
			
			rset = pstmt.executeQuery();			
			list = new ArrayList<ReserveDTO>();

			while(rset.next())
			{
				list.add(new ReserveDTO(rset.getInt(1), rset.getInt(2), rset.getString(3),
						rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7), rset.getInt(8)));
			}
		}
		finally
		{
			DBUtil.close(conn, pstmt, rset);
		}
		return list;
	}
	
	
	//id�� �ش� ������ ��� ���� ��ȯ
	public static ReserveDTO getReserve(int reserveNo) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ReserveDTO room = null;
		
		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from reserve where reserve_no = ?");
			pstmt.setInt(1, reserveNo);
			rset = pstmt.executeQuery();

			if(rset.next())
			{
				room = new ReserveDTO(rset.getInt(1), rset.getInt(2), rset.getString(3),
						rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7), rset.getInt(8));
			}			
		}
		finally
		{
			DBUtil.close(conn, pstmt, rset);
		}
		return room;
	}
	
	// �ű� ���� �߰� (���� �ڵ�)
	public static boolean addReserve(ReserveDTO newReserve) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into reserve values (?, ?, ?, ?, ?, ?, ?, ?)");
						
			pstmt.setInt(1, newReserve.getReserveNo());
			pstmt.setInt(2, newReserve.getPeopleCount());
			pstmt.setString(3, newReserve.getStayPeriod());
			pstmt.setString(4, newReserve.getReserveCheck());
			pstmt.setString(5, newReserve.getReserveCost());
			pstmt.setString(6, newReserve.getHotelId());
			pstmt.setInt(7, newReserve.getMemberId());
			pstmt.setInt(8, newReserve.getRoomId());	
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			{
				return true;
			}
		}
		finally
		{
			DBUtil.close(conn, pstmt);
		}		
		return false;
	}
	
	/*public static boolean addReserve(int reserveNo, String hotelId, int peopleCount, String stayPeriod, String reserveCheck, String reserveCost , int memberId, int roomId) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into reserve values (?, ?, ?, ?, ?, ?, ?, ?)");
						
			pstmt.setInt(1, reserveNo);
			pstmt.setString(2, hotelId);
			pstmt.setInt(3, peopleCount);
			pstmt.setString(4, stayPeriod);
			pstmt.setString(5, reserveCheck);
			pstmt.setString(6, reserveCost);
			pstmt.setInt(7, memberId);
			pstmt.setInt(8, roomId);	
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			{
				return true;
			}
		}
		finally
		{
			DBUtil.close(conn, pstmt);
		}		
		return false;
	}*/
	
	// Ư�� ���� ID�� �ش��ϴ� '�ο�, �Ⱓ, ���' ����
	//public static boolean updateReserve(int reserveNo, int peopleCount, String stayPeriod, String reserveCost) throws SQLException
	public static boolean updateReserve(ReserveDTO updateReserve) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = DBUtil.getConnection();			
			pstmt = conn.prepareStatement("update reserve set people_count = ?, stay_period = ?,  reserve_cost = ? where reserve_no = ?");
			
			/*pstmt.setInt(1, peopleCount);
			pstmt.setString(2, stayPeriod);
			pstmt.setString(3, reserveCost);
			pstmt.setInt(4, reserveNo);*/
			
			pstmt.setInt(1, updateReserve.getPeopleCount());
			pstmt.setString(2, updateReserve.getStayPeriod());
			pstmt.setString(3, updateReserve.getReserveCost());
			pstmt.setInt(4, updateReserve.getReserveNo());
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			{
				return true;
			}	
		}
		finally
		{
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	// Ư�� ���� id�� ���� ����� ����
	public static boolean deleteReserve(int reserveNo) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		//int result = 0;
		
		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("delete from reserve where reserve_no = ?");
			
			pstmt.setInt(1, reserveNo);			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
			{
				return true;
			}
		}
		finally
		{
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
}
