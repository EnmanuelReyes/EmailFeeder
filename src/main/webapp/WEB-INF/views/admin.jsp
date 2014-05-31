<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pimp
  Date: 23/05/2014
  Time: 05:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>ADMIN-PANEL :: EMAIL-APP</title>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/blog/blog.css" rel="stylesheet">

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
            <a class="blog-nav-item" href="/index.htm">Home</a>
            <a class="blog-nav-item active" href="/login.htm">Panel Administrativo</a>
            <a class="blog-nav-item" href="/suscriber.htm">Suscribirse</a>
            <c:if test="${not empty sessionScope.user}"><a class="blog-nav-item" href="/logout.htm">Cerrar Sesion</a></c:if>
        </nav>
    </div>
</div>

<div class="container">
    <h1>Agregar Post</h1>
    <br />
    <label>Agregue la informacion del post a continuacion</label>
    <br />
    <br />

    <form role="form" method="POST" name="postear" action="postear.htm">
        <label for="subject">Asunto</label>
        <input type="text" name="subject" class="form-control" placeholder="Introduzca el asunto" id="subject">
        <br />
        <label for="text">Texto</label>
        <textarea class="form-control" name="text" rows="5" id="text" placeholder="Introduzca el texto" ></textarea>
        <br />
        <button type="submit" class="btn btn-primary">Agregar Post</button>
    </form>
</div>
</body>
</html>