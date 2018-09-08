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
    <link href="<c:url value = "/resources/css/form-validation.css"/>" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container">
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h1>Create new Matric</h1>
        <%--<p class="lead">Below is an example form built entirely with Bootstrap's form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>--%>
    </div>

    <form:form action = "${pageContext.request.contextPath}/matric/edit" method = "post" modelAttribute="input" >

        <h3>Matric</h3>

        <form:hidden path="mid" value="${}"/>

        <div class="form-group">
            <label for="content">Content</label>
            <form:input path="content" id = "content" class="form-control" />
        </div>

        <div class="form-group">
            <label for="title">Title</label>
            <form:input path="title" id = "title" class="form-control"/>
        </div>

        <h4>Row Options</h4>

        <div class="form-group">
            <label for="rowOption1">Row Option1</label>
            <form:input path="rowOption1" id = "rowOption1" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="rowOption2">Row Option2</label>
            <form:input path="rowOption2" id = "rowOption2" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="rowOption3">Row Option3</label>
            <form:input path="rowOption3" id = "rowOption3" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="rowOption4">Row Option4</label>
            <form:input path="rowOption4" id = "rowOption4" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="rowOption5">Row Option5</label>
            <form:input path="rowOption5" id = "rowOption5" class="form-control"/>
        </div>


        <h4>Column Options</h4>

        <div class="form-group">
            <label for="colOption1">Column Option1</label>
            <form:input path="colOption1" id = "colOption1" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="colOption2">Column Option2</label>
            <form:input path="colOption2" id = "colOption2" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="colOption3">Column Option3</label>
            <form:input path="colOption3" id = "colOption3" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="colOption4">Column Option4</label>
            <form:input path="colOption4" id = "colOption4" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="colOption5">Column Option5</label>
            <form:input path="colOption5" id = "colOption5" class="form-control"/>
        </div>

        <br>

        <input type="submit" value="submit" class="btn btn-primary">
        <a href="<c:url value="/"/>" class="btn btn-light"> Cancel</a>

    </form:form>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017-2018 Company Name</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
</div>

</body>
</html>

