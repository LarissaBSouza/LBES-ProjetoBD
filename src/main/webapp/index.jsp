<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
<link rel="stylesheet" href="style.css">

<meta charset="ISO-8859-1">
<title>Projeto Final</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-success" >
    		<div class="container-fluid">
      			<a class="navbar-brand" href="#">Raia Drogasil</a>
      			<a class="nav-link" href="#">Usuário</a>
    		</div>
  		</nav>
	
	<div class="container">
	
	<div class="titulo text-center mt-5"><h1>Lista de usuários</h1></div>
	
	<div class="container col-12 mt-5">
		<div class="card">
			<button type="button" class="col-3 btn btn-warning">
			<a href="formulario.jsp">Adicionar usuário</a>
			</button>
			 <table class="table table-bordered border-dark table-secondary mt-3">
  				<thead>
    				<tr>
      					<th scope="col">ID</th>
      					<th scope="col">Nome</th>
      					<th scope="col">Email</th>
      					<th scope="col">País</th>
      					<th scope="col">Ações</th>
    				</tr>
  				</thead>
  				<c:forEach items="${user}" var="user" varStatus="i">
    				<tr>
      						<td>${user.id}</td>
      						<td>${user.nome}</td>
      						<td>${user.email}</td>
      						<td>${user.pais}</td>
      						<td><a href="?id=${i.index}&alterar=0">Alterar</a> <a href="?id=${i.index}&alterar=1">Remover</a></td>
    				</tr>
  				</c:forEach>
			</table>
		</div>
	</div>
	</div>

</body>
</html>