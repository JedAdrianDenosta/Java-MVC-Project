package hotel.model;

import java.sql.SQLException;
import java.util.ArrayList;

import hotel.exception.NotExistException;
import hotel.model.dto.MemberDTO;
import hotel.model.dto.RoomDTO;
import hotel.model.dto.RoomTypeDTO;
import hotel.model.dto.HotelDTO;
import hotel.model.dto.ReserveDTO;

public class HotelService
{
	private static HotelService instance = new HotelService();
	
	private HotelService(){}	
	public static HotelService getInstance()
	{
		return instance;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// ����(Reserve) - CRUD
	public static void notExistReserve(int reserveId) throws NotExistException, SQLException
	{
		ReserveDTO reserve = ReserveDAO.getReserve(reserveId);
		if(reserve == null)
		{
			throw new NotExistException("�˻��Ͻ� ���� ��ȣ�� �����ϴ�.");
		}
	}
	
	// ��� ���� ���� ��ȯ
	public static ArrayList<ReserveDTO> getAllReserves() throws SQLException
	{
		return ReserveDAO.getAllReserves();
	}
		
	// ���� Ư�� id�� ���� �˻�
	public static ReserveDTO getReserve(int reserveNo) throws NotExistException, SQLException
	{
		ReserveDTO reserve = ReserveDAO.getReserve(reserveNo);
		if(reserve == null)
		{
			throw new NotExistException("�˻��Ͻ� �����ȣ ������ �����ϴ�.");
		}
		return reserve;
	}
	
	//���ο� ���� ���� (���� �ڵ�)
	public static boolean addReserve(ReserveDTO reserve) throws SQLException // ���� ���� �ڵ�
	{
		return ReserveDAO.addReserve(reserve);
	}
	
	/*public static void addReserve(int reserveNo, String hotelId, int peopleCount,String stayPeriod, String reserveCheck, String reserveCost , int memberId, int roomId) throws SQLException
	{
		try
		{
			ReserveDAO.addReserve(reserveNo, hotelId, peopleCount, stayPeriod, reserveCheck, reserveCost, memberId, roomId);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}*/
	
	// ���� ���࿡�� Ư�� ���� ID�� �ش��ϴ� '�ο�, �Ⱓ, ���' ����
	//public static boolean updateReserve(int reserveNo, int peopleCount, String stayPeriod, String reserveCost) throws SQLException, NotExistException ����
	public static boolean updateReserve(ReserveDTO reserve) throws SQLException, NotExistException
	{
		//notExistReserve(reserveNo);
		//return ReserveDAO.updateReserve(reserveNo, peopleCount, stayPeriod, reserveCost);
		return ReserveDAO.updateReserve(reserve);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// ����(Room) - CRUD
	public static void notExistRoom(int roomId) throws NotExistException, SQLException
	{
		RoomDTO room = RoomDAO.getRoom(roomId);
		if(room == null)
		{
			throw new NotExistException("�˻��ϴ� ���� ID��ȣ�� �������մϴ�.");
		}
	}
	
	// ��� ���� ���� ��ȯ
	public static ArrayList<RoomDTO> getAllRooms() throws SQLException
	{
		return RoomDAO.getAllRooms();
	}
	
	// ���� Ư�� id�� ���� �˻�
	public static RoomDTO getRoom(int roomId) throws NotExistException, SQLException
	{
		RoomDTO room = RoomDAO.getRoom(roomId);
		if(room == null)
		{
			throw new NotExistException("�˻��Ͻ� ���� ID ������ �����ϴ�.");
		}
		return room;
	}
	
	// Ư�� ���� ID�� �ش��ϴ� '������ ����', '���� ����' ����
	//public static boolean updateRoom(int roomId, String roomPrice, String roomCheck) throws SQLException, NotExistException
	public static boolean updateReserve(RoomDTO room) throws SQLException, NotExistException
	{
		//notExistRoom(roomId);
		//return RoomDAO.updateRoomPriceCheck(roomId, roomPrice, roomCheck);
		return RoomDAO.updateRoomPriceCheck(room);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// ȣ��(Hotel) - CRUD
	public static void notExistHotel(String hotelId) throws NotExistException, SQLException
	{
		HotelDTO hotel = HotelDAO.getHotel(hotelId);
		if(hotel == null)
		{
			throw new NotExistException("�˻��ϴ� ȣ�� ID�� �������մϴ�.");
		}
	}
	
	// ��� ȣ�� ���� ��ȯ
	public static ArrayList<HotelDTO> getAllHotels() throws SQLException
	{
		return HotelDAO.getAllHotels();
	}
	
	// ȣ�� Ư�� id�� ȣ�� �˻�
	public static HotelDTO getHotel(String hotelId) throws NotExistException, SQLException
	{
		HotelDTO hotel =  HotelDAO.getHotel(hotelId);
		if(hotel == null)
		{
			throw new NotExistException("�˻��Ͻ� ȣ�� ID ������ �����ϴ�.");
		}
		return hotel;
	}

	// Ư�� ȣ�� id�� �ش��ϴ� 'ȣ�� ���' ����
	public static boolean updateHotelGrade(String hotelId, int hotelGrade) throws SQLException, NotExistException
	{
		notExistHotel(hotelId);
		return HotelDAO.updateHotelGrade(hotelId, hotelGrade);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// ȸ��(Member) - CRUD
	public static void notExistMember(int memberId) throws NotExistException, SQLException
	{
		MemberDTO member = MemberDAO.getMember(memberId);
		if(member == null)
		{
			throw new NotExistException("�˻��ϴ� ȸ�� ID�� �������մϴ�.");
		}
	}
	
	// ��� ȸ�� ���� ��ȯ
	public static ArrayList<MemberDTO> getAllMembers() throws SQLException
	{
		return MemberDAO.getAllMembers();
	}
	
	// ȸ�� Ư�� id�� ȸ�� �˻�
	public static MemberDTO getMember(int memberId) throws SQLException, NotExistException
	{
		MemberDTO member = MemberDAO.getMember(memberId);
		if(member == null)
		{
			throw new NotExistException("�˻��Ͻ� ȸ�� ID ������ �����ϴ�.");
		}
		return member;
	}
	
	// �ű� ȸ�� �߰�
	public static boolean addMember(MemberDTO member) throws SQLException
	{
		return MemberDAO.addMember(member);
	}
	
	// Ư�� ȸ�� id�� �ش��ϴ� '��ȭ��ȣ' ����
	//public static boolean updateMemberMobile(int memberId, String memberMobile) throws SQLException, NotExistException
	public static boolean updateMemberMobile(MemberDTO updateMember) throws SQLException
	{
		//notExistMember(memberId);
		//return MemberDAO.updateMemberMobile(memberId, memberMobile);
		return MemberDAO.updateMemberMobile(updateMember);
	}
	
	// ȸ�� ����
	public static boolean deleteMember(int memberId) throws SQLException, NotExistException
	//public static boolean deleteMember(MemberDTO deletemember) throws SQLException, NotExistException
	{
		notExistMember(memberId);
		return MemberDAO.deleteMember(memberId);
		//return MemberDAO.deleteMember(deletemember);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//��� ���� ���� ���� �˻�
	public static ArrayList<RoomTypeDTO> getAllRoomType() throws SQLException
	{
		return RoomTypeDAO.getAllRoomTypes();
	}

}