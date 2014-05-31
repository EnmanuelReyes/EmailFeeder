<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pimp
  Date: 23/05/2014
  Time: 08:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="http://getbootstrap.com/assets/ico/favicon.ico">

    <title>Enmanuel's Blog</title>

    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/blog/blog.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="http://getbootstrap.com/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item active" href="/index.htm">Home</a>
            <a class="blog-nav-item" href="/login.htm">Panel Administrativo</a>
            <a class="blog-nav-item" href="/suscriber.htm">Suscribirse</a>
            <c:if test="${not empty sessionScope.user}"><a class="blog-nav-item" href="/logout.htm">Cerrar Sesion</a></c:if>
        </nav>
    </div>
</div>
<div class="container">

    <div class="blog-header">
        <h1 class="blog-title">Enmanuel's Blog</h1>
        <p class="lead blog-description">Este es un blog como una tarea para Luis Soto!</p>
    </div>

    <div class="row">

        <div class="col-sm-8 blog-main">

            <div class="blog-post">
                <h2 class="blog-post-title"><c:out value="${post.subject}"/></h2>
                <p class="blog-post-meta"><c:out value="${post.creationDate}"/> <a href="#"><c:out value="${post.creator.user}"/></a></p>

                <p>${post.text}</p>
            </div><!-- /.blog-post  -->
        </div>
        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <div class="sidebar-module sidebar-module-inset">
                <h4>Acerca de</h4>
                <p>Esto es un blog sencillo creado por Enmanuel Reyes para Luis Soto.</p>
            </div>
        </div>
    </div>
</div>


            <!-- Bootstrap core JavaScript
  ================================================== -->
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
            <script src="../../dist/js/bootstrap.min.js"></script>
            <script src="../../assets/js/docs.min.js"></script>
</body>

</html>
