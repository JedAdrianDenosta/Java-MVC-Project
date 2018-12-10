package hotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotel.model.dto.HotelDTO;
import hotel.model.util.DBUtil;

public class HotelDAO
{
	// Ư�� ȣ�� ID�� �ش��ϴ� 'ȣ�� ���' ����
	public static boolean updateHotelGrade(String hotelId, int hotelGrade) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement("update hotel set hotel_grade = ? where hotel_id = ?");
			pstmt.setInt(1, hotelGrade);
			pstmt.setString(2, hotelId);
			
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
	
	// id�� �ش� ȣ���� ��� ���� ��ȯ
	public static HotelDTO getHotel(String hotelId) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HotelDTO hotel = null;
		
		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from hotel where hotel_id = ?");
			pstmt.setString(1, hotelId);
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				hotel = new HotelDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5));
			}			
		}
		finally
		{
			DBUtil.close(conn, pstmt, rset);
		}
		return hotel;
	}
	
	// ��� ȣ�� �˻��ؼ� ��ȯ
	public static ArrayList<HotelDTO> getAllHotels() throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HotelDTO> list = null;
		
		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from hotel");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<HotelDTO>();
			
			while(rset.next())
			{
				list.add(new HotelDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5)));
			}
		}
		finally
		{
			DBUtil.close(conn, pstmt, rset);
		}
		return list;
	}
}
