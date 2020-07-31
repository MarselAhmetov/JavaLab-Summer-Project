<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Компания ${company.name}</title>
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
                <p class="card-text h4 mb-4">Информация о компании ${company.name} </p>
            </div>
            <form action="http://34.71.144.13:8888/javalab-summer-project-0.0.1/edit/company" class="mb-4">
                <div class="form-group">
                    <label class="ml-4 h4">Электронная почта</label>
                    <input type="email" name="email" class="form-control" <#if !principal?? || principal.user.id != company.user.id> disabled</#if> placeholder="Enter email" value="${company.user.email}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Юзернейм</label>
                    <input type="text" name="username" class="form-control" <#if !principal?? || principal.user.id != company.user.id> disabled</#if> placeholder="Text" value="${company.user.username}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Название компании</label>
                    <input type="text" name="name" class="form-control" <#if !principal?? || principal.user.id != company.user.id> disabled</#if> placeholder="Text" value="${company.name}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Физ. адрес</label>
                    <input type="text" name="address" class="form-control" <#if !principal?? || principal.user.id != company.user.id> disabled</#if> placeholder="Text" value="${company.address}">
                </div>
                <div class="form-group">
                    <label class="ml-4 h4">Описание</label>
                    <input type="text" name="description" class="form-control" <#if !principal?? || principal.user.id != company.user.id> disabled</#if> placeholder="Text" value="${company.description}">
                </div>
                <#if principal?? && principal.user.id == company.user.id>
                    <div class="text-center">
                        <input type="submit" class="btn btn-primary" placeholder="Submit">
                    </div>
                </#if>
            </form>
            <div class="text-center">
                <p class="h4 mb-4">Дополнительно: </p>
                <a class="btn btn-primary" href="http://34.71.144.13:8888/javalab-summer-project-0.0.1/vacancies/${company.user.id}">Вакансии компании</a>
            </div>
        </div>
        <div class="col-2"></div>
    </div>
</div>
</body>

</html>