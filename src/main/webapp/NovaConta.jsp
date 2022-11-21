<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

  <!DOCTYPE html>
  <html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Nova Conta</title>

    <link rel="stylesheet" href="./Resources/CSS/NovaConta.css">
    <link rel="stylesheet" href="./Resources/CSS/style.css">
    <link rel="stylesheet" href="./Resources/CSS/limitacao.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Glegoo&display=swap" rel="stylesheet">

  </head>

  <body>
    
        <div class="blue-ball">
          <img src="./Resources/Images/background/circule.png " alt="background image">
          <h1>Nova Conta</h1>
        </div>    

      <main>
        <div class="white-box">
          <h2>Seja muito Bem Vindo(a)</h2>
          <form action="ServletCadastro" method="post">

            <input class="input-field item-form grey" type="text" id="nome" name="nome" placeholder="Nome" maxLength={30}>
  
            <input class="input-field item-form grey" type="email" id="email" name="email" placeholder="E-mail" pattern="[^@\s]+@[^@\s]+\.[^@\s]+" maxLength={30}>
  
            <input class="input-field item-form grey" type="password" id="password" name="senha" placeholder="Senha" maxLength={30} >
    
            <div class="div-esqueceu-submit">
              <input class="input-submit item-form" type="submit" value="Cadastre-se">
            </div>
          </form>

          <div class="box-alter-page">
            <h3 class="grey">Já possui conta?</h3>
            <a class="button-alter-page" href="./login.jsp"> Fazer Login </a>
          </div>
        </div>

    

      </main>

  </body>

  </html>