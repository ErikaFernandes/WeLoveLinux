package com.erika.welovelinuxapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.erika.welovelinuxapi.command.ExecCommand;
import com.erika.welovelinuxapi.connection.ReceiveCommand;
import com.erika.welovelinuxapi.connection.SendResponse;

public class WeLoveLinuxAPIMain {

	public static void main(String[]args) throws IOException, InterruptedException, ClassNotFoundException {

		while(true){

		// receive command
		String newCommand = null;
		ReceiveCommand rc = new ReceiveCommand();
		newCommand = rc.receiveCmd();

		if(newCommand.equalsIgnoreCase("exit")) {
			break;
		}

		// execute command
		List<String> response = new ArrayList<String>();
		ExecCommand ec = new ExecCommand();
		response = ec.executeCommand(newCommand);

		// return response
		SendResponse sr = new SendResponse();
	    sr.sendResp(response);


		}

	}
}
