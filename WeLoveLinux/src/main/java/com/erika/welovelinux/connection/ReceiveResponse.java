package com.erika.welovelinux.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import com.erika.welovelinux.model.Command;
import com.erika.welovelinux.model.CommandResult;

public class ReceiveResponse {

	private static ServerSocket server;
	private static int port = 8890;
	
	
	@SuppressWarnings("unchecked")
	public List<CommandResult> receiveResp(Command command) throws IOException, ClassNotFoundException {
		
		CommandResult commandResult;
		List<CommandResult> commandResultList = new ArrayList<CommandResult>();
		
		server = new ServerSocket(port);
		List<String> message = null;
		
		while(true) {
			System.out.println("Waiting for response");
			Socket socket = server.accept();
			
			
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			message = (List<String>) ois.readObject(); 
			System.out.println("Response received " + message);
			
			ois.close();
			socket.close();
			
			if(message.size() > 0) {
				break;
			}
		}
		
		// build commandResultList
		for (String elem : message) {
			commandResult = new CommandResult();
			commandResult.setIdfk(command);
			commandResult.setLine(elem);
			commandResultList.add(commandResult);
		}
		
		System.out.println("Shutting down socket server ");
		server.close();
		
		return commandResultList;
	}
}
