<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>We Love Linux</title>
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
</head>
<body>
 <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
     <a class="navbar-brand" href="/">We Love Linux</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/">Home</a>
      <li><a href="getAllCommandsSent">List All Commands Sent</a></li>
    </ul>
  </div>
</nav>


<div align="center" style="margin-top:8%;">
<h1 >Command</h1>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Command</th>
      </tr>
    </thead>
    <tbody>
      
		<c:forEach items="${commandl}" var="cmd">
		<tr>
			<td><c:out value = "${cmd.id_cmd}"/></td>
			<td><c:out value = "${cmd.cmd}"/></td>
		</tr>
		</c:forEach>
		
     
    </tbody>
  </table>
  <h1 >Results</h1>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Line</th>
        <th>ID Command</th>
      </tr>
    </thead>
    <tbody>
      
		<c:forEach items="${commandresultl}" var="res">
		<tr>
			<td><c:out value = "${res.idCR}"/></td>
			<td><c:out value = "${res.line}"/></td>
			<td><c:out value = "${res.idfk.id_cmd}"/></td>
		</tr>
		</c:forEach>
		
     
    </tbody>
  </table>
 </div>

</body>
</html>