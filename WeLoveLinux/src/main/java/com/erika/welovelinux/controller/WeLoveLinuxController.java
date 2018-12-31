package com.erika.welovelinux.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erika.welovelinux.connection.ReceiveResponse;
import com.erika.welovelinux.connection.SendCommand;
import com.erika.welovelinux.model.Command;
import com.erika.welovelinux.model.CommandResult;
import com.erika.welovelinux.model.CommandResultService;
import com.erika.welovelinux.model.CommandService;


@Controller
public class WeLoveLinuxController {
	
	@Autowired
	CommandService commandService;
	@Autowired
	CommandResultService commandResultService;
	
	
	@GetMapping("/")
	public String execute() {
		return "index"; 
	}
	
	@GetMapping("newcommand{command}")
	public String execSendExecAndReturnResp(@RequestParam("command") String command, RedirectAttributes attributes, Model model) throws IOException, InterruptedException, ClassNotFoundException {
		
		Command cmd = new Command();
		cmd.setCmd(command);
		
		// save command
		boolean resSaveCommand = commandService.saveCommand(cmd);
		
		if(resSaveCommand) {
			
			// send command to linux
			SendCommand sc = new SendCommand();
			boolean resSendCmd = sc.sendCommand(cmd.getCmd());
			
			if((resSendCmd)&&(!command.equalsIgnoreCase("exit"))&&(!command.toLowerCase().contains("mkdir"))&&
					(!command.toLowerCase().contains("rm"))&&(!command.toLowerCase().contains("cp"))) {
				// get result from linux
				List<CommandResult> response = new ArrayList<>();
				ReceiveResponse rr = new ReceiveResponse();
				response = rr.receiveResp(cmd);
				
				// save command result 
				commandResultService.saveCommandResult(response);
				
				model.addAttribute("commandresult", response);
			}else {
				if(!resSendCmd) {
					attributes.addFlashAttribute("msg", "Linux not connected or wrong configuration.");
				}
				if(command.equalsIgnoreCase("exit")) {
					attributes.addFlashAttribute("msg", "Linux app closed.");
				}
				if(command.toLowerCase().contains("mkdir")) {
					attributes.addFlashAttribute("msg", "Ls -l to know if folder was created.");
				}
			}
			
			

		}else {
			attributes.addFlashAttribute("msg", "An error ocurred, please try again later.");
		}
		
		return "index";
	}
	
	@GetMapping("getAllCommandsSent")
	public String getFromBdAllCommands(Model model) {
		List<Command> cl = commandService.getListCommand();
		List<CommandResult> crl = commandResultService.getAllResults();
		model.addAttribute("commandl", cl);
		model.addAttribute("commandresultl", crl);
		return "list";
	}
	
}
