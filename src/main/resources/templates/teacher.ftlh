<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Преподаватель ${teacher.lastName}  ${teacher.firstName} ${teacher.middleName}</title>
    <#include "common/head-common.ftlh">
    <link rel="stylesheet" type="text/css" href="http://34.71.144.13:8888/javalab-summer-project-0.0.1/css/common.css">
</head>

<body class="body">
<#include "header.ftlh">
<br>
<div class="container">
    <div class="row">
        <div class="col-2"></div>
        <div class="col">
            <div class="text-center">
                <p class="card-text h4 mb-4">Информация о преподавателе ${teacher.lastName} ${teacher.firstName} ${teacher.middleName}</p>
            </div>
            <form action="http://34.71.144.13:8888/javalab-summer-project-0.0.1/edit/teacher">
                <div class="form-group">
                    <label class="ml-4 h4">Электронная почта</label>
                    <input type="email" name="email" class="form-control" <#if !principal?? || principal.user.id != teacher.user.id> disabled</#if> placeholder="Enter email" value="${teacher.user.email}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Юзернейм</label>
                    <input type="text" name="username" class="form-control" <#if !principal?? || principal.user.id != teacher.user.id> disabled</#if> placeholder="Text" value="${teacher.user.username}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Имя</label>
                    <input type="text" name="firstName" class="form-control" <#if !principal?? || principal.user.id != teacher.user.id> disabled</#if> placeholder="Text" value="${teacher.firstName}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Фамилия</label>
                    <input type="text" name="lastName" class="form-control" <#if !principal?? || principal.user.id != teacher.user.id> disabled</#if> placeholder="Text" value="${teacher.lastName}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Отчество</label>
                    <input type="text" name="middleName" class="form-control" <#if !principal?? || principal.user.id != teacher.user.id> disabled</#if> placeholder="Text" value="${teacher.middleName}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Преподаваемый предмет</label>
                    <input type="text" name="subject" class="form-control" <#if !principal?? || principal.user.id != teacher.user.id> disabled</#if> placeholder="Text" value="${teacher.subject}">
                </div>
                <#if principal?? && principal.user.id == teacher.user.id>
                    <input type="submit" class="btn btn-primary" value="Сохранить">
                </#if>
            </form>
        </div>
        <div class="col-2"></div>
    </div>
</div>
</body>

</html>