 <%@ page import="Model.JDBC"%>
 <%@ page import="com.mysql.jdbc.Statement"%>
 <%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Update Product</title>
</head>
<body>

<div class="container"> <br>
	<h3>UPDATE PRODUCT</h3>
	<form method=Get action="http://localhost:8083/GestionProduitSpringMVC/actions/EditProduct.do" >
	<div class="form-group">
	  <label for="c0">ID</label><br>
	  <input type="number" placeholder="id"  id="c0" name="id" value="${id}" required><BR>
	</div>
	<div class="form-group">
	  <label for="c1">Nom du Produit</label><br>
	  <input type="text" placeholder="Nom du Produit" id="c1" name="Product" value="${nomProduit}" required><BR>
	</div>
	<div class="form-group">
	 <label for="c2">Prix </label><br>
	 <input type="number" placeholder="Prix" id="c2" name="prix"  required><BR>
	</div>
	<div class="form-group">
	 <label for="c3">Fournisseur </label><br>
	 <input type="text" placeholder="Fournisseur"  id="c3" name="fourn"  required><BR>
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>



</body>
</html>