package chap15;

import java.io.*;
import java.util.ArrayList;

public class SerialEx2 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileInputStream     fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);

			ObjectInputStream in = new ObjectInputStream(bis);

			// ��ü�� ���� ���� ����� ������ ��ġ�ؾ��Ѵ�.
			// ���� ���� ��ü�� ����ȭ �� ������ �÷��ǿ� �־ �ش� �÷��Ǹ� ����ȭ �ϴ� ���� ����.
			//UserInfo u1 = (UserInfo)in.readObject();
			//UserInfo u2 = (UserInfo)in.readObject();
			ArrayList<UserInfo2> list = (ArrayList)in.readObject();

			//System.out.println(u1);
			//System.out.println(u2);
			//System.out.println(list);

			for( UserInfo2 curUserInfo : list )
			{
				System.out.println(curUserInfo);
			}
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // main
} // class
