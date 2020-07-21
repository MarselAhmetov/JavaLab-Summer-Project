<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вакансия: ${vacancy.vacancyName}</title>
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
            <div class="card">
                <div class="card-header h3 text-center">
                    <p class="h3 card-title">Вакансия: ${vacancy.vacancyName}</p>
                </div>
                <div class="card-body">
                    <p class="card-text h4 text-center">Требования:</p>
                    <p class="card-text h5 ml-4">${vacancy.requirements}</p>
                    <p class="card-text h4 text-center">Описание:</p>
                    <p class="card-text h5 ml-4">${vacancy.description}</p>
                    <#if vacancy.competencies?? && vacancy.competencies?has_content>
                        <#list vacancy.competencies as competence>
                            <#if competence?is_first><span class="h5 ml-4">Список компетенций:</span></#if>
                            <p class="card-text btn btn-secondary h5">${competence.name}</p>
                        </#list>
                    <#else>
                        <span class="h5 ml-4">Список компетенций: Не указано</span>
                    </#if>
                    <p class="card-text h6 text-muted"> Создатель: ${vacancy.user.username} </p>
                    <p class="card-text h6 text-center"><a class="btn btn-secondary" href="/vacancies"><- Вернуться к списку
                            вакансий</a>
                    </p>
                </div>
                <div class="card-footer text-muted text-center">
                    Дата создания: ${vacancy.creationDate}
                </div>
            </div>
        </div>
        <div class="col-2"></div>
    </div>
</div>
</body>

</html>