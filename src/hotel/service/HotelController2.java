package hotel.service;

import java.sql.SQLException;
import java.util.ArrayList;

import hotel.model.HotelDAO;
import hotel.model.HotelService;
import hotel.model.MemberDAO;
import hotel.model.ReserveDAO;
import hotel.model.RoomDAO;
import hotel.model.RoomTypeDAO;
import hotel.model.dto.HotelDTO;
import hotel.model.dto.MemberDTO;
import hotel.model.dto.ReserveDTO;
import hotel.model.dto.RoomDTO;
import hotel.model.dto.RoomTypeDTO;
import hotel.view.FailView;
import hotel.view.SuccessView;

public class HotelController2
{
	static HotelService instance = HotelService.getInstance();
	
	/*
	// ��� ���� �˻�
	public static ArrayList<ReserveDTO> getAllReserves()
	{
		ArrayList<ReserveDTO> allReserve = null;
		
		try
		{
			allReserve = ReserveDAO.getAllReserves();
			SuccessView.allListView(allReserve);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("��� ���� �˻� �� ���� �߻�");
		}
		return allReserve;
	}
	
	// ��� ȸ�� �˻�
	public static ArrayList<MemberDTO> getAllMembers()
	{
		ArrayList<MemberDTO> allMember = null;
		
		try
		{
			allMember = MemberDAO.getAllMembers();
			SuccessView.allListView(allMember);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("��� ���� �˻� �� ���� �߻�");
		}
		return allMember;
	}
	
	// ��� ���� �˻�
	public static ArrayList<RoomDTO> getAllRooms()
	{
		ArrayList<RoomDTO> allRoom = null;
		
		try
		{
			allRoom = RoomDAO.getAllRooms();
			SuccessView.allListView(allRoom);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("��� ���� �˻� �� ���� �߻�");
		}
		return allRoom;
	}
		
	// ���� �߰�
	public static boolean addReserve(int reserveNo, String hotelId, int peopleCount,String stayPeriod, String reserveCheck,String reserveCost , int memberId, int roomId)
	{
		boolean result = false;
		
		try
		{
			result =  ReserveDAO.addReserve(new ReserveDTO(reserveNo, hotelId, peopleCount, stayPeriod, reserveCheck, reserveCost, memberId, roomId));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("���� �߰� �� ���� �߻�");
		}
		return result;
	}
	
	// ���� ����
	public static int deleteReserve(int reserveNo)
	{
		int result = 0;
		
		try
		{
			result = ReserveDAO.deleteReserve(reserveNo);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("����� ���� ���� �߻�");
		}
		return result;
	}
	
	// ȸ�� ����
	public static boolean updateMember(int mid, String mobile)
	{
		boolean result = false;
		
		try
		{
			result = MemberDAO.updateMemberMobile(mid, mobile);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			FailView.showError("ȸ�� ������ ���� ���� �߻�");
		}
		return result;
	}
*/
	// ��� ���� �˻� ����
	public static ArrayList<ReserveDTO> getAllReserve()
	{
		ArrayList<ReserveDTO> getAllReserve = null;

		try
		{
			getAllReserve = ReserveDAO.getAllReserves();
			SuccessView.allListView(getAllReserve);
		}
		catch (SQLException s)
		{
			s.printStackTrace();
			FailView.showError("��� ������Ʈ �˻��� ���� �߻�");
	    }
	    return getAllReserve;
	}

   // ���ο� ���� ���
   /*public static boolean addReserve(int reserveNo, String hotelId, int peopleCount,String stayPeriod, String reserveCheck, String reserveCost , int memberId, int roomId )
   {
	   boolean addReserve = false;
	   
	   try
	   {
		   addReserve = ReserveDAO.addReserve(new ReserveDTO(reserveNo, hotelId, peopleCount, stayPeriod, reserveCheck, reserveCost, memberId, roomId));
      
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("�߰� ����� ���� �߻�");
	   }
	   return addReserve;
   }*/

   // ID �� ���� ����
   public static boolean updateReserve(int memberId, int peopleCount, String stayPeriod, String reserveCost)
   {
	   boolean updateReserve = false;
	   
	   try
	   {
		   updateReserve = ReserveDAO.updateReserve(memberId, peopleCount, stayPeriod, reserveCost);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("���� ���� ����");
	   }
	   return updateReserve;
   }

   // ���� id�� ����
   public static boolean deleteReserve(int reserveId) 
   {
	   boolean deleteReserve = false;

	   try
	   {
		   
		   deleteReserve = ReserveDAO.deleteReserve(reserveId);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("������Ʈ ������ ���� �߻�");
	   }
	   return deleteReserve;
   }

	   
   ////////////////////////////////////////////����
	   
   //��� ����Ÿ�� �˻�
   public static ArrayList<RoomTypeDTO> getAllRoomType()
   {

      ArrayList<RoomTypeDTO> getAllRoomType = null;

      try
      {
    	  getAllRoomType = RoomTypeDAO.getAllRoomTypes();
         SuccessView.allListView(getAllRoomType);
      }
      catch (SQLException s)
      {
    	  s.printStackTrace();
    	  FailView.showError("��� ���� ���� �˻��� ���� �߻�");
      }
      return getAllRoomType;
   }

   //���İ��� üũ�� ����
   public static boolean updateRoomPriceCheck(int roomId, String roomPrice, String roomCheck )
   {
	   boolean getAllRoomType = false;

	   try
	   {
		   getAllRoomType = RoomDAO.updateRoomPriceCheck(roomId, roomPrice, roomCheck );
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("���İ��� üũ�� ���� ����");
	   }
	   return getAllRoomType;
   }

   //���� id�� �˻�
   public static RoomDTO getRoom(int roomId)
   {
	   RoomDTO getRoom = null;
	   try
	   {
		   getRoom = RoomDAO.getRoom(roomId);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("�˻� ���� �߻�");
	   }
	   return getRoom;
   }
	   
   //��� ���� �˻�
   public static ArrayList<RoomDTO> getAllRoom()
   {
	   ArrayList<RoomDTO> getAllRoom = null;

	   try
	   {
		   getAllRoom = RoomDAO.getAllRooms();
		   SuccessView.allListView(getAllRoom);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("��� ���� �˻��� ���� �߻�");
	   }
	   return getAllRoom;
   }


   ////////////////////////////////////////////ȸ��
   //ȸ�����
   public static boolean addMember(int memberId, String memberName,String memberMobile)
   {
	   boolean addMember = false;
	   
	   try
	   {
		   addMember = MemberDAO.addMember(new MemberDTO(memberId,memberName,memberMobile));
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("�߰� ȸ�� ��Ͻ� ���� �߻�");
	   }
	   return addMember;
   }

   //ȸ�� ����ȣ ����
   public static boolean updateMemberMoblie(int memberId, String memberMoblie)
   {
	   boolean updateMemberMoblie = false;

	   try
	   {
		   updateMemberMoblie = MemberDAO.updateMemberMobile(memberId, memberMoblie);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("ȸ�� ����ȣ ���� ����");
	   }
	   return updateMemberMoblie;
   }

   //ȸ�� ����
   public static boolean deleteMember(int memberId)
   {
	   boolean deleteMember = false;
	   
	   try
	   {
		   deleteMember = MemberDAO.deleteMember(memberId);
	   }
	   catch (SQLException s)
	   {
		   s.printStackTrace();
		   FailView.showError("ȸ�� ������ ���� �߻�");
	   }
	   return deleteMember;
   }

   //ȸ�� ��� �˻�
   public static ArrayList<MemberDTO> getAllMember()
   {
      ArrayList<MemberDTO> getAllMember = null;

      try
      {
         getAllMember = MemberDAO.getAllMembers();
         SuccessView.allListView(getAllMember);
      }
      catch (SQLException s)
      {
    	  s.printStackTrace();
    	  FailView.showError("��� ȸ�� �˻��� ���� �߻�");
      }
      return getAllMember;
   }
	   
   //ȸ�� id�� �˻�
   public static ReserveDTO getReserve(int memberId)
   {
      ReserveDTO getReserve = null;

      try
      {
    	  getReserve = ReserveDAO.getReserve(memberId);
      }
      catch (SQLException s)
      {
    	  s.printStackTrace();
    	  FailView.showError("�˻� ���� �߻�");
      }
      return getReserve;
   }
   
   //////////////////////////////////////////// ȣ��
	   
   //ȣ�� ��� ����
   public static boolean updateHotelGrade(String hotelId, int hotelGrade)
   {
	   boolean updateHotelGrade = false;

	   try 
	   {
         updateHotelGrade = HotelDAO.updateHotelGrade(hotelId, hotelGrade);
	   } 
	   catch (SQLException s) 
	   {
		   s.printStackTrace();
		   FailView.showError("ȸ�� ����ȣ ���� ����");
	   }
	   return updateHotelGrade;
   }

   //id�� ȣ�� �˻�
   public static HotelDTO getHotel(String hotelId)
   {
	   HotelDTO getHotel = null;

	   try 
	   {
		   getHotel = HotelDAO.getHotel(hotelId);
	   }
	   catch (SQLException s) 
	   {
		   s.printStackTrace();
		   FailView.showError("�˻� ���� �߻�");
	   }
	   return getHotel;
   }

   //��� ȣ�� �˻�
   public static ArrayList<HotelDTO> getAllHotel() 
   {
      ArrayList<HotelDTO> getAllHotel = null;

      try 
      {
         getAllHotel = HotelDAO.getAllHotels();
         SuccessView.allListView(getAllHotel);
      } 
      catch (SQLException s) 
      {
    	  s.printStackTrace();
    	  FailView.showError("��� ȣ�� �˻��� ���� �߻�");
      }
      return getAllHotel;
   }
}
