package hotel.model.dto;

public class HotelDTO
{
	private String hotelId;
	private String hotelName;
	private int hotelGrade;
	private String hotelLocation;
	private String hotelPhone;
	
	public HotelDTO() {}
	public HotelDTO(String id, String name, int grade, String location, String phone)
	{
		hotelId = id;
		hotelName = name;
		hotelGrade = grade;
		hotelLocation = location;
		hotelPhone = phone;
	}
	
	public String getHotelId()
	{
		return hotelId;
	}
	public void setHotelId(String hotelId)
	{
		this.hotelId = hotelId;
	}
	
	public String getHotelName()
	{
		return hotelName;
	}
	public void setHotelName(String hotelName)
	{
		this.hotelName = hotelName;
	}
	
	public int getHotelGrade()
	{
		return hotelGrade;
	}
	public void setHotelGrade(int hotelGrade)
	{
		this.hotelGrade = hotelGrade;
	}
	
	public String getHotelLocation()
	{
		return hotelLocation;
	}
	public void setHotelLocation(String hotelLocation)
	{
		this.hotelLocation = hotelLocation;
	}
	
	public String getHotelPhone()
	{
		return hotelPhone;
	}
	public void setHotelPhone(String hotelPhone)
	{
		this.hotelPhone = hotelPhone;
	}
	
	@Override
	public String toString() 
	{
		return "ȣ�� ���� [ȣ�� ID=" + hotelId + ", ȣ�� ��=" + hotelName + ", ȣ�� ���=" + hotelGrade 
				+ ", ȣ�� ��ġ=" + hotelLocation + ", ȣ�� ��ȭ��ȣ=" + hotelPhone + "]";
	}
}
