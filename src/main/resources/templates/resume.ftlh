<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${resume.resumeName}</title>
    <#include "common/head-common.ftlh">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
</head>

<body class="body">
<#include "header.ftlh">
<br>
<div class="container">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <div class="card text-center">
                <div class="card-header h3">
                    ${resume.resumeName}
                </div>
                <div class="card-body">
                    <p class="card-text h4">Описание:</p>
                    <p class="card-text h5">${resume.aboutMe}</p>
                    <#list resume.competences as competence>
                        <#if competence?is_first><span class="h5 ml-4">Список компетенций:</span></#if>
                        <p class="card-text btn btn-secondary h5">${competence.name}</p>
                    </#list>
                    <h5 class="card-text text-muted h6">Создатель: ${resume.user.username}</h5>
                    <p class="card-text text-center h6"><a href="/resumes/${principal.user.id}" class="btn btn-secondary"><- Вернуться к списку резюме</a></p>
                </div>
                <div class="card-footer text-muted">
                    Дата создания: ${resume.creationTime}
                </div>
            </div>
        </div>
        <div class="col-1"></div>
    </div>
</div>
</body>

</html>