<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="br.com.urna.controle.Controle"%>
<%@page import="br.com.urna.servlet.Urna"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
*{
  text-align: center;
  margin-top: 30px;
  

}
button{
 height: 100px;
font-size: 20px;
}

body {
  border-style: solid;
   height: 500px;
   
  }
  .informacao{
  
  border-style: solid;
  background-color: black;
  color: white;
    height: 400px;
    border-color: green;
    width: 700px;
  }
  p{
  font-size: 60px;
  }
  
  .resultado{
  margin-top: 100px;
  background-color : white;
   width:40px; 
   height: 40px;
   margin-left: 1200px;
  }
  
</style>
<meta charset="UTF-8">
<title>Votação</title>
</head>
<body>
 <div class="container">
  <div class="row">
  <div class="col">
	<div class="informacao">
  <p > <% if(Urna.controle.isBloquear()){ %> FIM <%} else{%> <% out.println(Urna.controle.getRank()); }%> </p>	
  
  
<p>  
<% if(Urna.candidato != null){ %> <%= Urna.candidato.getNome() %> <% } %>  
</p>

<p>  
<% if(Urna.controle.getNumero() != null){ %> <%= Urna.controle.getNumero() %> <% } %>  
</p>
</div>
 </div>
  <div class="col">
    <form action="Urna" method="POST">
   
   <div class="row">
  <button class="col-sm" name="numero" value="0" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>0</button>
  <button class="col-sm" name="numero" value="1" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>1</button>
  <button class="col-sm" name="numero" value="2" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>2</button>
  </div>
  
  <div class="row">
  <button class="col-sm" name="numero" value="3" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>3</button>
  <button class="col-sm" name="numero" value="4" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>4</button>
  <button class="col-sm" name="numero" value="5" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>5</button>
  </div>
  
  <div class="row">
  <button class="col-sm" name="numero" value="6" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>6</button>
  <button class="col-sm" name="numero" value="7" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>7</button>
  <button class="col-sm" name="numero" value="8" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>8</button>
  </div>
  
  <div class="row">
  <button class="col-sm" style="background-color : green" name="confirma"  value="confirma" >Confirma</button>
  <button class="col-sm" name="numero" value="9" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>9</button>
  <button class="col-sm" style="background-color : white" name="branco" value="branco" <% if(Urna.controle.isBloquear()){ %> disabled <%} %>>Branco</button>
  </div>
 </form>
  </div>
  </div>
   </div>
 <form action="Urna" method="POST">
   <button class="resultado" name="resultado" value="resultado"></button>
   </form>   
</body>
</html>