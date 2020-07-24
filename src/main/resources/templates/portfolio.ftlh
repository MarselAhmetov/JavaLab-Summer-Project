<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${portfolio.topic}</title>
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
                    <h3>${portfolio.topic}</h3>
                </div>
                <div class="card-body">
                    <p class="card-text h5 mb-2">Описание: </p>
                    <p class="card-text mb-2">${portfolio.content}</p>
                    <p class="card-text text-muted h6">Создатель: ${portfolio.user.username}</p>
                    <p class="card-text text-center h6"><a href="http://34.71.144.13:8888/javalab-summer-project-0.0.1/portfolios/${portfolio.user.id}" class="btn btn-secondary"><- Вернуться к списку портфолио</a></p>
                </div>
                <div class="card-footer text-muted">
                    Confirmed?
                </div>
            </div>
        </div>
        <div class="col-1"></div>
    </div>
</div>
</body>

</html>