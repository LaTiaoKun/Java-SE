package unit09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class Demo09T12client {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		URL url = new URL("https://www.bupt.edu.cn");
		var in = url.openStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		while((str = br.readLine())!=null)
		{
			System.out.println(str);
		}
		br.close();
		isr.close();
	
		in.close();

	}

}
