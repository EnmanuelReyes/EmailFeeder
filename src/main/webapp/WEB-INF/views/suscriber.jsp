<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pimp
  Date: 15/05/2014
  Time: 09:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>SUSCRIPCION :: EMAIL-APP</title>
    <!-- Se incluyen las hojas de estilo de bootstrap -->

    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script src="https://dl.dropboxusercontent.com/u/11028287/functions.js" ></script>

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
            <a class="blog-nav-item" href="/login.htm">Panel Administrativo</a>
            <a class="blog-nav-item active" href="/suscriber.htm">Suscribirse</a>
            <c:if test="${not empty sessionScope.user}"><a class="blog-nav-item" href="/logout.htm">Cerrar Sesion</a></c:if>
        </nav>
    </div>
</div>
<div class="container">
    <h1>Suscripcion</h1>
    <label>Inserte sus datos a continuación:</label>

    <form:form method="post" commandName="suscriber" onsubmit="return validateEmail()">
        <div class="input-group">
            <span class="input-group-addon">Nombre</span>
            <input type="text" name="name" class="form-control" placeholder="Introduzca el nombre">
        </div><br />

        <div class="input-group">
            <span class="input-group-addon">Email</span>
            <input type="text" name="email" class="form-control" placeholder="Introduzca el email">
        </div><br />

        <button type="submit" class="btn btn-success">Suscribeme!</button>
    </form:form>
</body>

</html>

