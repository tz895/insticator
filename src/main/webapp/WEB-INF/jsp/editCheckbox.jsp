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
        <h1>Edit Checkbox</h1>
        <%--<p class="lead">Below is an example form built entirely with Bootstrap's form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>--%>
    </div>

    <form:form action = "${pageContext.request.contextPath}/checkbox/edit" method = "post" modelAttribute="checkbox" >

        <h3>Checkbox</h3>

        <form:hidden path="cId" value="${checkbox.cId}"/>

        <div class="form-group">
            <label for="content">Content</label>
            <form:input path="content" id = "content" class="form-control" value="${checkbox.content}"/>
        </div>

        <div class="form-group">
            <label for="option1">Option 1</label>
            <form:input path="option1" id = "option1" class="form-control" value="${checkbox.option1}"/>
        </div>

        <div class="form-group">
            <label for="option2">Option 2</label>
            <form:input path="option2" id = "option2" class="form-control" value="${checkbox.option2}"/>
        </div>

        <div class="form-group">
            <label for="option3">Option 3</label>
            <form:input path="option3" id = "option3" class="form-control" value="${checkbox.option3}"/>
        </div>

        <div class="form-group">
            <label for="option4">Option 4</label>
            <form:input path="option4" id = "option4" class="form-control" value="${checkbox.option4}"/>
        </div>

        <div class="form-group">
            <label for="option5">Option 5</label>
            <form:input path="option5" id = "option5" class="form-control" value="${checkbox.option5}"/>
        </div>

        <div class="form-group">
            <label for="option6">Option 6</label>
            <form:input path="option6" id = "option6" class="form-control" value="${checkbox.option6}"/>
        </div>

        <div class="form-group">
            <label for="option7">Option 7</label>
            <form:input path="option7" id = "option7" class="form-control" value="${checkbox.option7}"/>
        </div>

        <div class="form-group">
            <label for="option8">Option 8</label>
            <form:input path="option8" id = "option8" class="form-control" value="${checkbox.option8}"/>
        </div>

        <div class="form-group">
            <label for="option9">Option 9</label>
            <form:input path="option9" id = "option9" class="form-control" value="${checkbox.option9}"/>
        </div>

        <div class="form-group">
            <label for="option10">Option 10</label>
            <form:input path="option10" id = "option10" class="form-control" value="${checkbox.option10}"/>
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

