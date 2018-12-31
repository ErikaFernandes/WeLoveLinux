<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  
  body {
    font: 400 15px Lato, sans-serif;
    line-height: 1.8;
  }
  h2 {
    font-size: 24px;
    text-transform: uppercase;
    color: #303030;
    font-weight: 600;
    margin-bottom: 30px;
  }
  h4 {
    font-size: 19px;
    line-height: 1.375em;
    color: #303030;
    font-weight: 400;
    margin-bottom: 30px;
  }  
  </style>
        <title>We Love Linux</title>
    </head>
    <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">We Love Linux</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/">Home</a>
      <li><a href="WeLoveLinux/getAllCommandsSent">List All Commands Sent</a></li>
    </ul>
  </div>
</nav>
    <div style="text-align: center; margin-top:8%">
        <h1>Welcome to We Love Linux Web App</h1>
       
       <h2>Send your command to Linux here</h2>
       
       <form method="GET" action="newcommand" >
		 	<center>
			 	<table>
			 		<thread>
			 			<th>Command Result</th>
			 		</thread>
			 		<tbody>
			 			<c:forEach items="${commandresult}" var="res">
			 				<tr>
			 					<td><c:out value="${res.line}" /></td>
			 				<tr>
			 			</c:forEach>
			 		</tbody>
			 	</table>
		 	</center>
		 	<br /><br />
		    <div class="input-group">
		      <input id="link" name="command" type="text"  class="form-control" size="50" placeholder="Your Command here"  autocomplete="off" required />
		      <div class="input-group-btn">
		        <button type="submit" class="btn btn-danger">Execute Command</button>
		      </div>
		    </div>
		    <c:out value="${msg}" />
		</form>
    </div>
    </body>
</html>
