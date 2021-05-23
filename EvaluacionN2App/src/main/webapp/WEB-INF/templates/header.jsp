<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="vendor/bulma/css/bulma.min.css" rel=stylesheet>
</head>
<body>
	<header>
		<nav class="navbar is-primary" role="navigation" aria-label="main navigation">
		  <div class="navbar-brand">
		
		    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		    </a>
		  </div>
		
		  <div id="navbarBasicExample" class="navbar-menu">
		    <div class="navbar-start">
		      <a class="navbar-item ml-4">Home</a>
		
		
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">Solicitudes</a>
		
		        <div class="navbar-dropdown">
		          <a class="navbar-item" href="AgregarClienteController.do">Agregar solicitud</a>
		          
		          <a class="navbar-item" href="VerClienteController.do">Atender solicitudes</a>
		          

		        </div>
		      </div>
		    </div>
		
		  </div>
		</nav>
	</header>