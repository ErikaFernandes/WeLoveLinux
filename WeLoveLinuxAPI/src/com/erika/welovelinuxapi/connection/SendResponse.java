package com.erika.welovelinuxapi.connection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class SendResponse {


	public void sendResp(List<String> msg) {

		try{
			InetAddress address = InetAddress.getByName("127.0.0.1");
			Socket socket = null;
			ObjectOutputStream oos = null;

			try{
				socket = new Socket(address.getHostName(), 8890);
				oos = new ObjectOutputStream(socket.getOutputStream());
				System.out.println("I'm sending the response " );
				oos.writeObject(msg);

				oos.close();
				socket.close();

			}catch(IOException e){
				System.out.println(e + " send error connecting .. ");
			}

		}catch(UnknownHostException e){
			System.out.println(e + " send error ");
		}
	}
}
