package hotel.view;

import java.util.Scanner;

import hotel.service.HotelController;

public class StartView
{
	private static Scanner in;
	static int i = 0;
	
	public static void main(String[] args)
	{
		 while (true)
		 {	 
			 System.out.println("***************************************");
	         System.out.println("******** Hotel Reserve Program ********");
	         System.out.println("***************************************");
	         System.out.println("\n 1. ���α׷� ����ϱ� | 2. �����ϱ�");
	
	         in = new Scanner(System.in);
	         System.out.println("\n��ȣ�� �Է����ּ���.");
	         
	         int m1 = in.nextInt();
	         System.out.println("�Է��Ͻ� ��ȣ : " + m1);
	         
	         switch (m1)
	         {
		         case 1:
		        	i = 1;
		            break;
		         case 2:
		        	i = 2;
		        	break;
		         default:
		        	 System.out.println("\n��ȣ�� �� �� �Է��ϼ̽��ϴ�.");
		        	 break;
	         }
	         
	         while (true)
	         {
	        	 if (i == 1)
	        	 {
	        		System.out.println("\n");
	        		System.out.println("********************************************");
		   	        System.out.println("******** Hotel Reserve Program Menu ********");
		   	        System.out.println("********************************************");
	                System.out.println("\n 1. ���� ��ȸ �ϱ� | 2. ���� �ϱ�");
	        	 }
	        	 else if (i == 2)
	        	 {
	        		 break;
	        	 }
	        	 
	        	 System.out.println("\n��ȣ�� �Է����ּ���.");  
	             int m2 = in.nextInt();
	             System.out.println("�Է��Ͻ� ��ȣ : " + m2);
	             
	             switch (m2)
	             {
	             	case 1:
	             		HotelController.selectHRPMenu();
	             		break;
	             		
	             	case 2:
	             		break;
	             	
	             	default:
	             		System.out.println("\n��ȣ�� �� �� �Է��ϼ̽��ϴ�.");
	             		break;
	             }
	             
	             if(m2 == 2)
	             {
	            	 break;
	             }
	         }
	         
	         if(m1 == 2)
	         {
	        	 System.out.println("\nHotel Reserve Program�� �����մϴ�.");
	        	 break;
	         }
		 }
	}
}
