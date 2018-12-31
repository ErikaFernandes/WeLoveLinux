package com.erika.welovelinuxapi.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExecCommand {

	public List<String> executeCommand(String command) throws IOException {
		List<String> result = new ArrayList<String>();

		String line;

		  ProcessBuilder builder = new ProcessBuilder(
		            "/bin/bash", "-c", command);
		        builder.redirectErrorStream(true);
		        Process p = null;
				try {
					p = builder.start();
				} catch (IOException e) {

					System.out.println("er " + e);
				}
		        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

		        while (true) {

				    line = r.readLine();

		            if (line == null) {
		            	break;
		            	}else{
		            		result.add(line);
		            		}
		            System.out.println(line);

		        }
		        return result;
	    }

}


