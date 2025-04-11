<%@ page language="java" %>
<header class="header">
    <nav class="navbar white">
        <div class="nav-wrapper ">
            <a href="/" class="brand-logo grey-text">Grepp</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down grey-text">
                <c:choose>
                    <c:when test="${empty principal or principal eq Principal.ANONYMOUS}">
                        <li><a href="/member/login" class="grey-text">sign in</a></li>
                        <li><a href="/member/signup" class="grey-text">sign up</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/member/logout" class="grey-text">logout</a></li>
                    </c:otherwise>
                </c:choose>
                <li>
                    <a href="mobile.html">
                        <i class="material-icons grey-text sidenav-trigger" data-target="slide-out">more_vert</i>
                    </a>
                </li>
            </ul
        </div>
    </nav>
</header>
