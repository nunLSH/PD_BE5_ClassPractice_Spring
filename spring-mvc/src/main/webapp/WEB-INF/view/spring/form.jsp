<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>Grepp</title>
    <%@include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/sidenav.jsp" %>
<main class="container">
    <div class="row">
        <form class="col s12" action="/form" method="post">
            <div class="row">
                <div class="input-field col s7 ">
                    <i class="material-icons prefix">account_circle</i>
                    <input id="userId" name="userId" type="text" placeholder="userId"
                           class="validate"/>
                </div>
                <div class="input-field col s7 ">
                    <i class="material-icons prefix">account_circle</i>
                    <input id="password" name="password" type="password"
                           placeholder="password"
                           class="validate"/>
                </div>
                <div class="input-field col s7 ">
                    <i class="material-icons prefix">email</i>
                    <input id="email" name="email" type="email" placeholder="email"
                           class="validate"/>
                </div>
                <div class="input-field col s7 ">
                    <i class="material-icons prefix">phone</i>
                    <input id="tel" name="tel" type="tel" placeholder="tel"
                           class="validate"/>
                </div>
            </div>
            <button class="btn waves-effect waves-light offset-s1" type="submit" name="action">
                Submit
                <i class="material-icons right">send</i>
            </button>
        </form>
    </div>

</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>