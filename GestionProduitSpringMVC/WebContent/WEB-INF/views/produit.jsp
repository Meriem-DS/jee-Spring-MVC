
 <%@ page import="java.util.ArrayList"%>
 <%@ page import="Model.User"%>
  <%@ page import="Model.JDBC"%>
  <%@ page import="Model.Produits"%>
  <%@ page import="com.mysql.jdbc.Statement"%>
  <%@ page import="java.sql.ResultSet"%>
  <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.util.Scanner,javax.servlet.http.HttpSession" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
    div b { color: red; }
    td h5 {color:blue;}
  </style>
  
<title>HOME</title>
</head>
<body>
<br>

<%-- Title of My Home Page --%>
<div class="container">
<h3>SpringMVC: REALISE PAR MERIEM NABIL GROUPE B</h3>
</div>

<br><br>

<%-- Barre de recherche --%>	
<form>
<label for="site-search">Search</label><input type="search" id="site-search" placeholder="Doesn't work for now" name="q" aria-label="Search through site content">
<button>Submit</button>
</form>

<%--Supression d'un produit (Delete) --%>
<div ><b>${Suppessionmsg}</b></div>

<%-- Update d'un produit (EDIT) --%>
<div ><b>${Editmsg}</b></div>

<%--Bien inseree (AddProduct)--%>
<div><b>${msg}</b></div>
<%--Pour afficher message d'erreur si les donnes inserees sont incorrecte --%>
<div ><b>${msgError}</b></div>




<table border=1>
<tr>
      <td><h5>Id</h5></td> 
      <td><h5>NOM</h5></td> 
      <td><h5>PRIX</h5></td>
      <td><h5>FOURNISSEUR</h5></td>
</tr>
<tbody>
  <c:forEach var="info"  items="${list}"> 
	<tr>
	  <td><c:out value="${info.id}"/></td>
	  <td><c:out value="${info.nomProduit}"/></td>
	  <td><%--<c:out value="${info.Prix}"/> --%></td> 
      <td><%--<c:out value="${info.Fournisseur}"/> --%></td>
	  <td><a href="<c:url value ='http://localhost:8083/GestionProduitSpringMVC/actions/redirect/${info.id}/${info.nomProduit}' />"><img alt="edit" src="<%=request.getContextPath()%>/Images/1.PNG" ></a></td>
	  <td><a onclick="return confirm('Are You Sur?')" href="<c:url value='http://localhost:8083/GestionProduitSpringMVC/actions/DeleteProduct/${info.id}' />"><img alt="delete" src="<%=request.getContextPath()%>/Images/2.PNG" ></a></td>
	</tr>
</c:forEach>
</tbody>
</table>

<br><br><br>

<div class="container">
	<h3>Ajouter un produit à la base de donnée</h3>
	<form method=Get action="http://localhost:8083/GestionProduitSpringMVC/actions/AddProduct.do">
	<div class="form-group">
	  <label for="c1">Nom du Produit</label><br>
	  <input type="text" placeholder="Nom du Produit" id="c1" name="Product" required><BR>
	</div>
	<div class="form-group">
	 <label for="c2">Prix </label><br>
	 <input type="number" placeholder="Prix" id="c2" name="prix" required><BR>
	</div>
	<div class="form-group">
	 <label for="c3">Fournisseur </label><br>
	 <input type="text" placeholder="Fournisseur"  id="c3" name="fourn" required><BR>
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>



</body>
</html>