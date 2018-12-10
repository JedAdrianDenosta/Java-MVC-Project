package hotel.model.dto;

public class ReserveDTO
{
	private int reserveNo;
	private int peopleCount;
	private String stayPeriod;
	private String reserveCheck;
	private String reserveCost;
	private String hotelId;
	private int memberId;
	private int roomId;
	
	public ReserveDTO() {}
	public ReserveDTO(int no, int cnt, String period, String check, String cost, String hid, int mid, int rid)
	{
		reserveNo = no;
		peopleCount = cnt;
		stayPeriod = period;
		reserveCheck = check;
		reserveCost = cost;
		hotelId = hid;
		memberId = mid;
		roomId = rid;
	}
	
	public ReserveDTO(int no, int cnt, String period, String cost)
	{
		reserveNo = no;
		peopleCount = cnt;
		stayPeriod = period;
		reserveCost = cost;
	}
	
	public int getReserveNo()
	{
		return reserveNo;
	}
	public void setReserveNo(int reserveNo)
	{
		this.reserveNo = reserveNo;
	}
	
	public int getPeopleCount()
	{
		return peopleCount;
	}
	public void setPeopleCount(int peopleCount)
	{
		this.peopleCount = peopleCount;
	}
	
	public String getStayPeriod()
	{
		return stayPeriod;
	}
	public void setStayPeriod(String stayPeriod)
	{
		this.stayPeriod = stayPeriod;
	}
	
	public String getReserveCheck()
	{
		return reserveCheck;
	}
	public void setReserveCheck(String reserveCheck)
	{
		this.reserveCheck = reserveCheck;
	}
	
	public String getReserveCost()
	{
		return reserveCost;
	}
	public void setReserveCost(String reserveCost)
	{
		this.reserveCost = reserveCost;
	}
	
	public String getHotelId()
	{
		return hotelId;
	}
	public void setHotelId(String hotelId)
	{
		this.hotelId = hotelId;
	}
	
	public int getMemberId()
	{
		return memberId;
	}
	public void setMemberId(int memberId)
	{
		this.memberId = memberId;
	}
	
	public int getRoomId()
	{
		return roomId;
	}
	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
	}
	
	@Override
	public String toString()
	{
		return "���� ���� [���� ��ȣ=" + reserveNo + ", ���� �ο� ��=" + peopleCount + ", ���� �Ⱓ =" + stayPeriod
				+ ", ���� ����=" + reserveCheck + ", ���� ���=" + reserveCost + ", ȣ�� ID=" + hotelId
				+ ", ȸ�� ID=" + memberId + ", ���� ID=" + roomId + "]"; 
	}
}
