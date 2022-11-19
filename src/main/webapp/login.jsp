<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

  <!DOCTYPE html>
  <html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Login</title>

    <link rel="stylesheet" href="./Resources/CSS/login.css">
    <link rel="stylesheet" href="./Resources/CSS/style.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Glegoo&display=swap" rel="stylesheet">

  </head>

  <body>
    
        <div class="blue-ball">
          <img src="./Resources/Images/background/circule.png " alt="background image">
          <h1>FINNANCE</h1>
        </div>    

      <main>
          <h2>Transforme sua vida Financeira!</h2>

        <form action="ServletLogin" method="post">
          <input class="input-field item-form grey" type="email" id="email" name="email" placeholder="E-mail" pattern="[^@\s]+@[^@\s]+\.[^@\s]+" maxLength={30}>

          <input class="input-field item-form grey" type="password" id="password" name="senha" placeholder="Senha" maxLength={30} >

          <div class="div-esqueceu-submit">
            <a href="#" class="item-form a-form grey">Esqueceu a senha?</a>
            <input class="input-submit item-form" type="submit" value="Login">
          </div>
        </form>
    
        <div class="box-alter-page">
          <h3 class="grey">Novo por aqui?</h3>
          <a class="button-alter-page" href="./NovaConta.jsp"> Nova Conta </a>
        </div>
      </main>

      <script src="https://accounts.google.com/gsi/client" async defer></script>
  </body>

  </html>