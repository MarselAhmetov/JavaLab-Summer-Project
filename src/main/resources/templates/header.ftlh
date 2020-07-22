<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/students">STC Work</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if principal??>
                <#switch principal.user.role>
                    <#case "STUDENT">
                        <li class="nav-item">
                            <a class="nav-link" href="/vacancies">Список вакансий</a>
                        </li>
                        <#break>
                    <#case "TEACHER">
                        <li class="nav-item">
                            <a class="nav-link" href="/students">Список студентов</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/vacancies">Список вакансий</a>
                        </li>
                        <#break>
                    <#case "COMPANY">
                        <li class="nav-item">
                            <a class="nav-link" href="/students">Список студентов</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/resumes">Список резюме</a>
                        </li>
                        <#break>
                </#switch>
            </#if>
<#--            <li class="nav-item dropdown">-->
<#--                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"-->
<#--                   aria-haspopup="true" aria-expanded="false">-->
<#--                    Dropdown-->
<#--                </a>-->
<#--                <div class="dropdown-menu" aria-labelledby="navbarDropdown">-->
<#--                    <a class="dropdown-item" href="#">Action</a>-->
<#--                    <a class="dropdown-item" href="#">Another action</a>-->
<#--                    <div class="dropdown-divider"></div>-->
<#--                    <a class="dropdown-item" href="#">Something else here</a>-->
<#--                </div>-->
<#--            </li>-->
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <#if principal??>
                <div class="btn-group dropleft">
                    <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        ${principal.user.username}
                    </button>
                    <div class="dropdown-menu">


                        <#switch principal.user.role>
                            <#case "STUDENT">
                                <a class="dropdown-item" href="/resumes/${principal.user.id}">Мои резюме</a>
                                <a class="dropdown-item" href="/portfolios/${principal.user.id}">Мои портфолио</a>
                                <a class="dropdown-item" href="/responses">My responses</a>
                                <a class="dropdown-item" href="/invites">Invites</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/student/${principal.user.id}">Мой Профиль</a>
                                <#break>
                            <#case "TEACHER">
                                <a class="dropdown-item" href="/teacher/${principal.user.id}">Мой Профиль</a>
                                <#break>
                            <#case "COMPANY">
                                <a class="dropdown-item" href="/vacancies/${principal.user.id}">Мои вакансии</a>
                                <a class="dropdown-item" href="/invites">My invites</a>
                                <a class="dropdown-item" href="/responses">Responses</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/company/${principal.user.id}">Мой Профиль</a>
                                <#break>
                        </#switch>
                        <a class="dropdown-item" href="/logout">Logout</a>
                    </div>
                </div>
            <#else>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="btn btn-primary nav-link" href="/signIn">Войти в аккаунт</a>
                </li>
            </ul>
            </#if>
        </form>
    </div>
</nav>