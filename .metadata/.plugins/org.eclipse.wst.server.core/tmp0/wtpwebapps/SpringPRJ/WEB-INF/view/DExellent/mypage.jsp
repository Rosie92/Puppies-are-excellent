<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
<!--         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" /> -->
    	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>강아지는 훌륭하다</title>
        <link rel="icon" type="image/x-icon" href="/assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/styles.css" rel="stylesheet" />
        <link href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css" rel="stylesheet" type="text/css">

		<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

    </head>
    <body id="page-top">

        <!-- Masthead2-->
      <header class="masthead2">
            <div class="container">
                <div class="masthead2-heading text-uppercase">&emsp;&emsp;&nbsp;Kakao<br>Member&emsp;&emsp;<br>Information </div>
                <div>
                    <div style="font-size: 20px; color:rgb(116, 116, 116); text-align: center; padding-bottom: 10px; margin-top: 40px;"><%=session.getAttribute("user_name") %></div>
                    <div style="font-size: 20px; color:rgb(116, 116, 116); text-align: center; padding-bottom: 10px;"><%=session.getAttribute("user_mail") %></div>
                    <div style="font-size: 20px; color:rgb(116, 116, 116); text-align: center; padding-bottom: 10px;"><%=session.getAttribute("user_range") %></div>
                    <img src="<%=session.getAttribute("user_profile_image") %>">
                    <img src="<%=session.getAttribute("user_thumbnail_image") %>">
                </div>
                <div>
                <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="https://accounts.kakao.com/weblogin/account/info">카&nbsp카&nbsp오&nbsp&nbsp계&nbsp정&nbsp&nbsp관&nbsp리</a>
                </div>
            </div>
        </header>
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="/assets/mail/jqBootstrapValidation.js"></script>
        <script src="/assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="/js/scripts.js"></script>
    </body>
</html>
