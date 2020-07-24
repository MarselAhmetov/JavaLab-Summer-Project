<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список резюме</title>
    <#include "common/head-common.ftlh">
    <link rel="stylesheet" type="text/css" href="css/common.css">
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
                            data-target="#exampleModal">Создать резюме
                    </button>
                </#if>
            <#else>
                <div class="input-group mb-4">
                    <input type="text" class="form-control" placeholder="Поиск..." aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" id="button-addon2">Найти</button>
                    </div>
                </div>
            </#if>
            <#list resumes as resume>
                <#if resume?is_first><div class="h3 text-center mb-4">Список резюме ${resume.user.username}: </div></#if>
                <div class="card text-center">
                    <div class="card-header h3">
                        ${resume.resumeName}
                    </div>
                    <div class="card-body">
                        <p class="card-text h4">Описание:</p>
                        <p class="card-text h5">${resume.aboutMe}</p>
                        <h5 class="card-text text-muted h6">Создатель: ${resume.user.username}</h5>
                        <a href="http://34.71.144.13:8888/javalab-summer-project-0.0.1/resume/${resume.id}" class="btn btn-primary">Посмотреть резюме</a>
                    </div>
                </div>
            </#list>
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
                        <h5 class="modal-title" id="exampleModalLabel">Создать резюме</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="resume/create" method="POST" class="form">
                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" name="resumeName" class="form-control"
                                       placeholder="Название резюме"/>
                            </div>
                            <div class="form-group">
                                <textarea type="text" name="aboutMe" class="form-control"
                                          placeholder="Обо мне"></textarea>
                            </div>
                            <div class="form-group">
                                <input type="number" name="desiredSalary" class="form-control"
                                       placeholder="Желаемая зарплата"/>
                            </div>
                            <div class="form-group">
                                <select class="form-control" name="portfolio">
                                    <option selected value="" disabled hidden class="form-control">Прикрепить портфолио:</option>
                                    <#if !portfolios?? && portfolios?has_content>
                                        <option value="-1">Нет портфолио</option>
                                    <#else>
                                        <#list portfolios as portfolio>
                                            <option class="form-control" value="${portfolio.id}">${portfolio.topic}</option>
                                        </#list>
                                    </#if>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" name="competences" class="form-control" placeholder="Компетенция"/>
                            </div>
                            <div class="form-group">
                                <input type="text" name="competences" class="form-control" placeholder="Компетенция"/>
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