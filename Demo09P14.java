 package unit09;

import java.net.InetAddress;
import java.util.Scanner;

public class Demo09P14 {

	public static void main(String []args)
	{
		var scanner  =new Scanner(System.in);
		String answer,s;
		while(true)
		{
			System.out.println("是否输入域名或地址");
			s= scanner.next();
			if(s.equalsIgnoreCase("n"))break;
			System.out.println("Input IP/name");
			answer = scanner.next();
			try {
				InetAddress address = InetAddress.getByName(answer);
				System.out.println("Host"+address.getHostName());
				System.out.println("IP"+address.getHostAddress());
				System.out.println(address.isReachable(2000));
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
		}
	}
}
