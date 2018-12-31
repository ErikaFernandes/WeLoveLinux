# WeLoveLinux

  ## Web App 
   - Send command to Java Project (By Socket)
   - Save Command and Results
   - Show result (When the command is a list)
   - List Command and Result saved
   
   ## Java Project (Linux side)
   - Receive Command from Web App (By Socket)
   - Execute Command on terminal
   - Receive Result from terminal 
   - Send result to Web App 
   
   
   <br />
 
 # Built With
 - [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
 - [Bootstrap](https://getbootstrap.com/)
 - [MySQL](https://www.mysql.com/)
 - [Liberty](https://www.ibm.com/support/knowledgecenter/en/SSEQTP_liberty/com.ibm.websphere.wlp.doc/ae/cwlp_about.html) 
 - [Java](https://www.ibm.com/developerworks/java/jdk/)
 
 <br />
   
   
# If you Want to Try

- Alter the IP WebApp: WeLoveLinux/src/main/java/com/erika/welovelinux/connection/SendCommand.java (Alter from 127.0.0.1 to Linux IP)
- Alter the IP Java Project: WeLoveLinuxAPI/src/com/erika/welovelinuxapi/connection/SendResponse.java (Alter from 127.0.0.1 to Computer IP where the WebApp is hosted)

- If you are using VirtualBox: The Newtork configuration of your Virtual Machine needs to be as Bridged Adapter
   
   
