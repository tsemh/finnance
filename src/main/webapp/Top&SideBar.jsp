
<header>
	<div class="overlay">
		<nav class="nav">
			<span class="close_button">X</span>
			<ul>
				<li class="active"><a href="#">Home</a></li>
				<li><a onclick="CallNaoDisponivel()">Investimentos</a></li>
				<li><a onclick="CallNaoDisponivel()">Metas</a></li>
				<li><a onclick="CallNaoDisponivel()">Movimentações</a></li>
				<li><a onclick="CallNaoDisponivel()">Sobre</a></li>
			</ul>	
		</nav>
	</div>
	<div class="menu_button">
		<img src="./Resources/Images/menu.svg" alt="menu" />
	</div>

	<div class="headertitle">

		<span>Olá,</span>
		${UserName}
		<span class="headerlabel">${CurrentPage}</span>
	
	</div>

	<div class="profile_button">
		<img src="./Resources/Images/user.svg" alt="user profile" />
	</div>
	<nav class="profile">
		<ul>
			<li class="active"><a onclick="CallNaoDisponivel()">Contas</a></li>
			<li><a href="logout">Logout</a></li>
		</ul>
	</nav>
</header>	
