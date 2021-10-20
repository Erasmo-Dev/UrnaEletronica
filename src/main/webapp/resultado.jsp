<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="br.com.urna.controle.Controle"%>
<%@page import="br.com.urna.servlet.Urna"%>
<%@page import="br.com.urna.entidades.Candidato"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>

.alinhar{
   border-style: solid;
  
 
}

*{
 text-align: center;
font-size: 15px;
 margin:auto;
}


</style>
<meta charset="UTF-8">
<title>Resultado</title>
</head>
<body>

<div class="container">
  <div class="row">
  <div class="col">
  <div class="alinhar">
<p> <b> Prefeitos</b></p>
<table>
<% 
for (Candidato candidato : Urna.controle.getCandidatos()) {
	if(candidato.getTipo().equals("P")){
   out.println("<tr>");
   
out.println("<th>"+candidato.getNome()+"</th>");
    
out.println("<th>  ("+candidato.getPartido()+")</th>");

out.println("<th>Votos "+candidato.getVotos()+"</th>");

    out.println("</tr>");
   }
}
 %>
</table>

<p><b> Brancos <%= Urna.controle.getBrancoP() %></b> </p>
</div>
</div>

<div class="col">
  <div class="alinhar">
<p> <b>Vereadores</b></p>
<table>
<% 
for (Candidato candidato : Urna.controle.getCandidatos()) {
	
	if(candidato.getTipo().equals("V")){
	
   out.println("<tr>");

out.println("<th>"+candidato.getNome()+"</th>");
    
out.println("<th>  ("+candidato.getPartido()+")</th>");

out.println("<th>Votos "+candidato.getVotos()+" </th>");

    out.println("</tr>");
	}
}
 %>
</table>
<p> <b>Brancos <%= Urna.controle.getBrancoV() %></b> </p>
</div>
</div>

<div class="col">
  <div class="alinhar">
<p><b>Votos por partidos</b></p>
<table>
<tr>
<th>
Partido comunista comuna (PCC)
<%= Urna.controle.getPCC() %>
</th>
</tr>
<tr>
<th>
Partido facção yeger (PFY)
<%= Urna.controle.getPFY() %>
</th>
</tr>
<tr>
<th>
Partido nacional comunal (PNC)
<%= Urna.controle.getPNC() %>
</th>
</tr>
</table>
</div>
</div>
</div>
</div>
<div class="container">
  <div class="row">
  <div class="col">
  <form action="Urna" method="GET">
  <button name="voltar" value="voltar">Voltar</button>
  </form>
  </div>
</div>
</div>
</body>
</html>