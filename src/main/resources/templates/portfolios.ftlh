<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список портфолио</title>
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
            <#if user?? && principal??>
                <#if user.id == principal.user.id>
                    <button type="button" class="btn btn-primary btn-lg btn-block mb-4" data-toggle="modal"
                            data-target="#exampleModal">Создать портфолио
                    </button>
                </#if>
            </#if>
            <div class="card-container">
                <div class="h3 text-center mb-4">Список портфолио: </div>
                <div class="d-flex flex-wrap" style="justify-content: space-around">
                    <#list portfolios as portfolio>
                        <div class="card text-center" style="width: 18rem; margin-bottom: 10px">
                            <div class="card-header h5">
                                <h3>${portfolio.topic}</h3>
                            </div>
                            <div class="card-body">

                                <p class="card-text mb-2">${portfolio.content}</p>
                                <p class="card-text"><a href="http://34.71.144.13:8888/javalab-summer-project-0.0.1/portfolio/${portfolio.id}" class="btn btn-primary">Посмотреть
                                        портфолио</a></p>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>
        <div class="col-2"></div>
    </div>
</div>
</body>

<#if user?? && principal??>
    <#if user.id == principal.user.id>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Создать портфолио</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="portfolio/create" method="POST" class="form">
                        <div class="modal-body">

                            <div class="form-group">
                                <input type="text" name="topic" class="form-control"
                                       placeholder="Название портфолио"/>
                            </div>
                            <div class="form-group">
                                <textarea type="text" name="content" class="form-control"
                                          placeholder="Информация"></textarea>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                            <input type="submit" class="btn btn-primary" value="Сохранить">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </#if>
</#if>

</html>