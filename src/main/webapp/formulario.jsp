<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Maven -->
<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
<link rel="stylesheet" href="style.css"/>

<meta charset="ISO-8859-1">
<title>Formulário</title>
</head>
<body>

  		<nav class="navbar navbar-expand-lg navbar-light bg-success">
    		<div class="container-fluid">
      			<a class="navbar-brand" href="#">Raia Drogasil</a>
      			<a class="nav-link disabled" href="#">Usuário</a>
    		</div>
  		</nav>
	
	<form method="post" action="ProjetoFinal">
	<div class="container mt-5">
		<div class="card">
			<div class="titulo text-center mt-2"><h1>Adicionar Usuário</h1></div>
			<input type="hidden" name="id" value="${id}">
			<div class="mb-3 margin-left-3 margin-right-3">
  				<label for="exampleFormControlInput1" class="form-label">Nome</label>
  				<input type="text" class="form-control" id="exampleFormControlInput1" value="${nome}" name="nome">
			</div>
			<div class="mb-3 margin-left-3 margin-right-3">
  				<label for="exampleFormControlInput1" class="form-label">Email</label>
  				<input type="email" class="form-control" id="exampleFormControlInput1" value="${email}" name="email">
			</div>
			<div class="mb-3 margin-left-3 margin-right-3">
  				<label for="exampleFormControlInput1" class="form-label">País</label>
  				<input type="text" class="form-control" id="exampleFormControlInput1" value="${pais}" name="pais">
			</div>
			<a href="index.jsp"><button type="submit" class="col-3 btn btn-warning">Salvar</button></a>
		</div>
	</div>
	</form>
</body>
</html>