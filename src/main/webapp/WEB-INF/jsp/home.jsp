<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tianyouzhou
  Date: 2018/9/1
  Time: 下午11:14
  To change this template use File | Settings | File Templates.
--%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Checkout example for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value = "/resources/css/signin.css"/>" rel="stylesheet">
</head>

<body class="text-center">

    <div class="form-signin">
        <img class="mb-4" src="https://cdn2.iconfinder.com/data/icons/film-industry/78/Movie_icons-08-512.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

    <form:form action = "${pageContext.request.contextPath}/index" method = "post" modelAttribute="user" >


        <div class="form-group">
            <label for="content" class="sr-only">Your Name</label>
            <form:input path="username" id = "content" class="form-control" placeholder="Your Name" required="username"/>
        </div>


        <br>

        <input type="submit" value="Start" class="btn btn-lg btn-primary btn-block">

        <br>
        <a href="<c:url value="/admin/"/>">Admin</a>

    </form:form>

</div>
</body>
</html>

