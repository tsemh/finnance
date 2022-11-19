<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String nome_usuario = "Leandro";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Finnance</title>
<link rel="stylesheet" href="./Resources/CSS/SidebarStyle.css">
<link rel="stylesheet" href="./Resources/CSS/TopBarStyle.css">


</head>
<body>
	<header>
		<div class="overlay">
			<nav class="nav">
				<span class="close_button">X</span>
				<ul>
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Investimentos</a></li>
					<li><a href="#">Metas</a></li>
					<li><a href="#">Movimentações</a></li>
					<li><a href="#">Sobre</a></li>
				</ul>	
			</nav>
		</div>
		<div class="menu_button">
			<img src="./Resources/Images/menu.svg" alt="menu" />
		</div>

		<div class="headertitle">

			<span>Olá,</span>
			<%
			out.println(nome_usuario);
			%>
			<span class="headerlabel">Home</span>
		</div>

		<div class="profile_button">
			<img src="./Resources/Images/user.svg" alt="user profile" />
		</div>
		<nav class="profile">
			<ul>
				<li class="active"><a href="#">Contas</a></li>
				<li><a href="#">Logout</a></li>
			</ul>
		</nav>
	</header>
	<main class="main"></main>
	
	<script>
		const menu_button= document.querySelector(".menu_button");
		const nav= document.querySelector(".nav");
		const close_button= document.querySelector(".close_button");
		const overlay= document.querySelector(".overlay");
		
		const profile_button= document.querySelector(".profile_button");
		const profile= document.querySelector(".profile")
		menu_button.addEventListener("click", () => {
			nav.classList.toggle("active")
			overlay.classList.toggle("active")
			}, false)			
		close_button.addEventListener("click", () => {
			nav.classList.remove("active")
			overlay.classList.remove("active")
			}, false)
			
		profile_button.addEventListener("click", () => {profile.classList.toggle("active")}, false)
		
	</script>
</body>
</html>