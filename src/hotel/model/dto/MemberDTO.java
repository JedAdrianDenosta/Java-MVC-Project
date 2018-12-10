package hotel.model.dto;

public class MemberDTO
{
	private int memberId;
	private String memberName;
	private String memberMobile;
	
	public MemberDTO() {}
	public MemberDTO(int id, String name, String mobile)
	{
		memberId = id;
		memberName = name;
		memberMobile = mobile;
	}
	
	public MemberDTO(int id, String mobile)
	{
		memberId = id;
		memberMobile = mobile;
	}

	public MemberDTO(int id)
	{
		memberId = id;
	}
	
	public int getMemberId()
	{
		return memberId;
	}
	public void setMemberId(int memberId)
	{
		this.memberId = memberId;
	}
	
	public String getMemberName()
	{
		return memberName;
	}
	public void setMemberName(String memberName)
	{
		this.memberName = memberName;
	}
	
	public String getMemberMobile()
	{
		return memberMobile;
	}
	public void setMemberMobile(String memberMobile)
	{
		this.memberMobile = memberMobile;
	}
	
	@Override
	public String toString()
	{
		return "ȸ�� ���� [ȸ�� ID=" + memberId + ", ȸ�� �̸�=" + memberName + ", ȸ�� �޴��� ��ȣ=" + memberMobile + "]";
	}
	
	
}
