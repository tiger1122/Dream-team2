package p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class network01 {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;	//서버
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		serverSocket = new ServerSocket(80);

		try {
			System.out.println("start");
			clientSocket = serverSocket.accept();
			System.out.println("클라이언트 접속");
			//out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			while(true) {
				String inputLine = null;
				inputLine = in.readLine();
				System.out.println("클라이언트로부터 받은 문자 : " + inputLine);
				//out.println(inputLine);	//어플으로 다시 보내주는 부분

				if(inputLine.equals("exit"))
					break;
			}
			//out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
