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
        <h2>Create new Trivia</h2>
        <p class="lead">Below is an example form built entirely with Bootstrap's form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>
    </div>

    <form:form action = "${pageContext.request.contextPath}/trivia/create" method = "post" modelAttribute="trivia" >

        <h3>Trivia</h3>

        <div class="form-group">
            <label for="content">Content</label>
            <form:input path="content" id = "content" class="form-control" />
        </div>

        <div class="form-group">
            <label for="answersA">Answer A</label>
            <form:input path="answersA" id = "answersA" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="answersB">Answer B</label>
            <form:input path="answersB" id = "answersB" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="answersC">Answer C</label>
            <form:input path="answersC" id = "answersC" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="answersD">Answer D</label>
            <form:input path="answersD" id = "answersD" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="correct">Correct Answer</label>
            <form:input type="number" path="correct" id = "correct" class="form-control" />
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

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>--%>
<%--<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>--%>
<%--<script src="../../assets/js/vendor/popper.min.js"></script>--%>
<%--<script src="../../dist/js/bootstrap.min.js"></script>--%>
<%--<script src="../../assets/js/vendor/holder.min.js"></script>--%>
<%--<script>--%>
    <%--// Example starter JavaScript for disabling form submissions if there are invalid fields--%>
    <%--(function() {--%>
        <%--'use strict';--%>

        <%--window.addEventListener('load', function() {--%>
            <%--// Fetch all the forms we want to apply custom Bootstrap validation styles to--%>
            <%--var forms = document.getElementsByClassName('needs-validation');--%>

            <%--// Loop over them and prevent submission--%>
            <%--var validation = Array.prototype.filter.call(forms, function(form) {--%>
                <%--form.addEventListener('submit', function(event) {--%>
                    <%--if (form.checkValidity() === false) {--%>
                        <%--event.preventDefault();--%>
                        <%--event.stopPropagation();--%>
                    <%--}--%>
                    <%--form.classList.add('was-validated');--%>
                <%--}, false);--%>
            <%--});--%>
        <%--}, false);--%>
    <%--})();--%>
<%--</script>--%>
</body>
</html>

