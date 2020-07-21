<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Студент ${student.lastName}  ${student.firstName} ${student.middleName}</title>
    <#include "common/head-common.ftlh">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
</head>

<body class="body">
<#include "header.ftlh">
<br>
<div class="container">
    <div class="row">
        <div class="col-2"></div>
        <div class="col">
            <div class="text-center">
                <p class="card-text h4 mb-4">Информация о студенте ${student.lastName}  ${student.firstName} ${student.middleName}</p>
            </div>
            <form action="/edit/student">
                <div class="form-group">
                    <label class="ml-4 h4">Электронная почта</label>
                    <input type="email" name="email" class="form-control" <#if !principal?? || principal.user.id != student.user.id> disabled</#if> placeholder="Enter email" value="${student.user.email}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Юзернейм</label>
                    <input type="text" name="username" class="form-control" <#if !principal?? || principal.user.id != student.user.id> disabled</#if> placeholder="Text" value="${student.user.username}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Имя</label>
                    <input type="text" name="firstName" class="form-control" <#if !principal?? || principal.user.id != student.user.id> disabled</#if> placeholder="Text" value="${student.firstName}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Фамилия</label>
                    <input type="text" name="lastName" class="form-control" <#if !principal?? || principal.user.id != student.user.id> disabled</#if> placeholder="Text" value="${student.lastName}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Отчество</label>
                    <input type="text" name="middleName" class="form-control" <#if !principal?? || principal.user.id != student.user.id> disabled</#if> placeholder="Text" value="${student.middleName}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Дата рождения</label>
                    <input type="date" name="datOfBirth" class="form-control" <#if !principal?? || principal.user.id != student.user.id> disabled</#if> placeholder="Text" value="${student.dateOfBirth}">
                </div>
                <#if principal?? && principal.user.id == student.user.id>
                    <div class="text-center mb-4">
                        <input type="submit" class="btn btn-primary" placeholder="Сохранить">
                    </div>
                </#if>
                <div class="text-center">
                    <p class="h4 mb-4">Дополнительно: </p>
                    <a class="btn btn-primary mb-2" href="/resumes/${student.user.id}">Резюме студента</a>
                    <a class="btn btn-primary mb-2" href="/portfolios/${student.user.id}">Портфолио студента</a>
                </div>
            </form>
        </div>
        <div class="col-2"></div>
    </div>
</div>
</body>

</html>