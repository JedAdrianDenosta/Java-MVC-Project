package hotel.view;

import java.util.ArrayList;

public class SuccessView
{
	// ��� (���� or ȸ��) ���
	public static void allListView(ArrayList allLists)
	{
		for(int index = 0; index < allLists.size(); index++)
		{			
			System.out.println("�˻����� : " + (index + 1) + " - " + allLists.get(index));
		}
	}	
}
