package com.erika.welovelinux.connection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SendCommand {
	
	public boolean sendCommand(String msg) {
		

		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			Socket socket = null;
			ObjectOutputStream oos = null;
			
			try {
				socket = new Socket(address.getHostName(), 8888);
				oos = new ObjectOutputStream(socket.getOutputStream());
				System.out.println("I'm sendind command ");
				
		
					oos.writeObject(msg);
			
					oos.close();
					socket.close();
					
					
					return true;
					
					
			} catch (IOException e) {
				
				System.out.println(e + " send error connecting ");
				return false;
			}
			
			
		} catch (UnknownHostException e) {
			System.out.println(e + " send error ");
			return false;
		}
		
	}
}
