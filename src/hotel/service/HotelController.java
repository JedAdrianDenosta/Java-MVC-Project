package hotel.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import hotel.exception.NotExistException;
import hotel.model.HotelDAO;
import hotel.model.HotelService;
import hotel.model.MemberDAO;
import hotel.model.ReserveDAO;
import hotel.model.RoomDAO;
import hotel.model.dto.HotelDTO;
import hotel.model.dto.MemberDTO;
import hotel.model.dto.ReserveDTO;
import hotel.model.dto.RoomDTO;
import hotel.view.FailView;
import hotel.view.SuccessView;

public class HotelController
{
	private static Scanner in;
	static HotelService instance = HotelService.getInstance();
	
	static ArrayList<ReserveDTO> getAllReserve = null;
	static ArrayList<RoomDTO> getAllRoom = null;
	static ArrayList<HotelDTO> getAllHotel = null;
	static ArrayList<MemberDTO> getAllMember = null;
	
	static boolean deleteMember = false;
	
	static Scanner scan = new Scanner(System.in);
	
	public static void selectHRPMenu()
	{
		// ���� ��� ����
		String hotelId;
		int memberId;
		int roomId;
		
		// ���� �߰� ����
		int reserveNo;
		//String hotelId;
		int peopleCount;
		String stayPeriod;
		String reserveCheck;
		String reserveCost;
		//int memberId;
		//int roomId;
		
		// ȸ�� �߰� ����
		//int memberId;
		String memberName;
		String memberMobile;
		
		// ���� ���� ����
		String roomPrice;
		String roomCheck;
		
		while(true)
		{
			System.out.println("\n");
			System.out.println("*****************************************************************************************************************************");
			System.out.println("[1. ���� ��ȸ | 2. ���� ��ȸ | 3. ȣ�� ��ȸ | 4. ȸ�� ��ȸ | 5. ���� �߰�  | 6. ȸ�� �߰� | 7. ���� ���� | 8. ���� ���� | 9. ȸ�� ���� | 10. ȸ�� ���� | 0. ���� �ϱ�]");
			System.out.println("*****************************************************************************************************************************");
			
			in = new Scanner(System.in);
			System.out.println("\n��ȣ�� �Է����ּ���.");
			
			int m1 = in.nextInt();
			System.out.println("�Է��Ͻ� ��ȣ : " + m1);
			
			switch(m1)
			{
				case 1:
					try // ���� ��ȸ
					{
						getAllReserve = ReserveDAO.getAllReserves();
						if(getAllReserve.size() != 0)
						{
							System.out.println("\n���� ����");
							SuccessView.allListView(getAllReserve);
						}
						/*else
						{
							FailView.showError("������������� ��� ���� �˻� ���� �߻�");
						}*/
					}
					catch (SQLException s)
					{
						s.printStackTrace();
						FailView.showError("��� ���� �˻� �� ���� �߻�");
				    }
					break;
				case 2: // ���� ��ȸ
					try
					{
						getAllRoom = RoomDAO.getAllRooms();
						if(getAllRoom.size() != 0)
						{
							System.out.println("\n���� ����");
							SuccessView.allListView(getAllRoom);
						}
						else
						{
							FailView.showError("������������� ��� ���� �˻� ���� �߻�");
						}
					}
					catch (SQLException s)
					{
						s.printStackTrace();
						FailView.showError("��� ���� �˻� �� ���� �߻�");
					}
					break;
				case 3: // ȣ�� ��ȸ
					try
					{
						getAllHotel = HotelDAO.getAllHotels();
						if(getAllHotel.size() != 0)
						{
							System.out.println("\nȣ�� ����");
							SuccessView.allListView(getAllHotel);
						}
						else
						{
							FailView.showError("������������� ��� ȣ�� �˻� ���� �߻�");
						}
					}
					catch (SQLException s)
					{
						s.printStackTrace();
						FailView.showError("��� ȣ�� �˻� �� ���� �߻�");
					}
					break;
				case 4: // ȸ�� ��ȸ
					try
					{
						getAllMember = MemberDAO.getAllMembers();
						if(getAllMember.size() != 0)
						{
							System.out.println("\nȸ�� ����");
							SuccessView.allListView(getAllMember);
						}
						else
						{
							FailView.showError("������������� ��� ȸ�� �˻� ���� �߻�");
						}
					}
					catch (SQLException s)
					{
						s.printStackTrace();
						FailView.showError("��� ȣ�� �˻� �� ���� �߻�");
					}
					break;
				case 5: // ���� �߰�
					System.out.println("\n�߰��� ���� ������ �Է��ϼ���.");
					
					System.out.println("\n���� ��ȣ�� �Է��ϼ���.");
					reserveNo = scan.nextInt();
					
					System.out.println("\n������ ���� �ο��� �Է��ϼ���.");
					peopleCount = scan.nextInt();
					
					System.out.println("\n������ ���� �Ⱓ�� �Է��ϼ���.");
					stayPeriod = scan.next();
					
					System.out.println("\n������ ���� ���θ� �Է��ϼ���.");
					reserveCheck = scan.next();
					
					System.out.println("\n���� ����� �Է��ϼ���.");
					reserveCost = scan.next();
					
					System.out.println("\nȣ�� ID�� �Է��ϼ���.");
					hotelId = scan.next();
					
					System.out.println("\nȸ�� ID�� �Է��ϼ���.");
					memberId = scan.nextInt();
					
					System.out.println("\n���� ID�� �Է��ϼ���.");
					roomId = scan.nextInt();					
					
					ReserveDTO rdto = new ReserveDTO(reserveNo, peopleCount, stayPeriod, reserveCheck, reserveCost, hotelId, memberId, roomId);
					
					try
					{
						HotelService.addReserve(rdto);
						System.out.println("���������� ���ο� ���� ������ �߰��Ǿ����ϴ�.");
					}
					catch(SQLException s)
					{
						s.printStackTrace();
						FailView.showError("���ο� ���� ���� �߰� ���� �߻�");
					}
					break;
				case 6: // ȸ�� �߰�
					//System.out.println("\n�߰��� ȸ�� ������ �Է��ϼ���.");
					
					System.out.println("\n�߰��� ȸ�� ID�� �Է��ϼ���");
					memberId = scan.nextInt();
					
					System.out.println("\n�߰��� ȸ���� �̸��� �Է��ϼ���");
					memberName = scan.next();
					
					System.out.println("\n�߰��� ȸ���� �޴���ȭ ��ȣ�� �Է��ϼ���");
					memberMobile = scan.next();
					
					MemberDTO mdto = new MemberDTO(memberId, memberName, memberMobile);
					
					try
					{
						HotelService.addMember(mdto);
						System.out.println("���������� ���ο� ȸ�� ������ �߰��Ǿ����ϴ�.");
					}
					catch(SQLException s)
					{
						s.printStackTrace();
						FailView.showError("���ο� ȸ�� ���� �߰� ���� �߻�");
					}
					break;
				case 7: // ���� ����
					//System.out.println("\n������ ���� ������ �Է��ϼ���.");
					System.out.println("\n�����ȣ�� �Է��ϼ���.");
					reserveNo = scan.nextInt();
					
					System.out.println("\n������ ���� �ο��� �Է��ϼ���.");
					peopleCount = scan.nextInt();
					
					System.out.println("\n������ ���� �Ⱓ�� �Է��ϼ���.");
					stayPeriod = scan.next();
					
					System.out.println("\n������ ���� �̿밡�� �Է��ϼ���.");
					reserveCost = scan.next();
					
					ReserveDTO urdto = new ReserveDTO(reserveNo, peopleCount, stayPeriod, reserveCost);
					
					try
					{
						HotelService.updateReserve(urdto);
						System.out.println("���������� ���� ������ �����Ǿ����ϴ�.");
					}
					catch(SQLException | NotExistException s)
					{
						s.printStackTrace();
						FailView.showError("���� ���� �۾� ���� �߻�");
					}
					break;
				case 8: // ���� ����
					//System.out.println("\n������ ���� ������ �Է��ϼ���.");
					
					System.out.println("\n������ ���� ID�� �Է��ϼ���.");
					roomId = scan.nextInt();
					
					System.out.println("\n������ ���� ������ �Է��ϼ���.");
					roomPrice = scan.next();
					
					System.out.println("\n������ ���� ���� ���θ� �Է��ϼ���.");
					roomCheck = scan.next();
					
					RoomDTO rodto = new RoomDTO(roomId, roomPrice, roomCheck);
					try
					{
						HotelService.updateReserve(rodto);
						System.out.println("���������� ���� ������ �����Ǿ����ϴ�.");
					}
					catch(SQLException | NotExistException s)
					{
						s.printStackTrace();
						FailView.showError("���� ���� �۾� ���� �߻�");
					}
					break;
				case 9: // ȸ�� ����
					//System.out.println("\n������ ȸ�� ������ �Է��ϼ���.");
					
					System.out.println("\n������ ȸ���� ID�� �Է��ϼ���.");
					memberId = scan.nextInt();
					
					System.out.println("\n������ ȸ���� �޴��� ��ȣ�� �Է��ϼ���.");
					memberMobile = scan.next();
					
					//MemberDTO mdto = new RoomDTO(roomId, roomPrice, roomCheck);
					MemberDTO umdto = new MemberDTO(memberId, memberMobile);
					try
					{
						HotelService.updateMemberMobile(umdto);
						System.out.println("���������� ȸ�� ������ �����Ǿ����ϴ�.");
					}
					catch(SQLException s)
					{
						s.printStackTrace();
						FailView.showError("���� ���� �۾� ���� �߻�");
					}
					break;
				case 10: // ȸ�� ����
					System.out.println("\n������ ȸ���� ID�� �Է��ϼ���.");
					memberId = scan.nextInt();
					try
					{
						deleteMember = HotelService.deleteMember(memberId);
						System.out.println("���������� ȸ�� ������ �����Ǿ����ϴ�.");
					}
					catch (SQLException | NotExistException s)
					{
						s.printStackTrace();
						FailView.showError("��� ���� �˻� �� ���� �߻�");
				    }
					break;
				case 0: // ���� �ϱ�
					System.out.println("�޴� �������� ���ư��ϴ�.");
					break;
				default:
					break;
			}
			if(m1 == 0)
			{
				break;
			}
		}
	}
}
