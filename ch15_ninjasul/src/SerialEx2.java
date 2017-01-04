import java.io.*;
import java.util.ArrayList;

public class SerialEx2 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileInputStream     fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);

			ObjectInputStream in = new ObjectInputStream(bis);

			// 객체를 읽을 때는 출력한 순서와 일치해야한다.
			// 여러 개의 객체를 직렬화 할 때에는 컬렉션에 넣어서 해당 컬렉션만 직렬화 하는 것이 좋다.
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
