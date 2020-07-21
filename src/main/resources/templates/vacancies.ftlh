<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список вакансий</title>
    <#include "common/head-common.ftlh">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <script src="/js/script.js"></script>
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
                            data-target="#exampleModal">Создать вакансию
                    </button>
                    <div class="text-center">
                        <p class="card-text mb-4 h3 text-center">Список вакансий: </p>
                    </div>
                <#else>
                    <div class="text-center">
                        <p class="card-text mb-4 h3 text-center">Список вакансий компании: </p>
                    </div>
                </#if>
            <#else>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Поиск..." aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" id="button-addon2">Найти</button>
                    </div>
                </div>
            </#if>
            <#list vacancies as vacancy>
                <div class="card mb-4">
                    <div class="card-header h3 text-center">
                        <p class="h3 card-title">Вакансия: ${vacancy.vacancyName}</p>
                    </div>
                    <div class="card-body">
                        <p class="card-text h4 text-center">Описание:</p>
                        <p class="card-text h5 ml-4">${vacancy.description}</p>
                        <p class="card-text h6 text-muted"> Создатель: ${vacancy.user.username} </p>
                        <p class="card-text text-center"><a href="/vacancy/${vacancy.id}" class="btn btn-primary ">Посмотреть вакансию</a></p>
                    </div>
                    <div class="card-footer text-muted text-center">
                        Дата создания: ${vacancy.creationDate}
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
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="/vacancy/create" method="POST" class="form">
                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" name="vacancyName" class="form-control"
                                       placeholder="Название вакансии"/>
                            </div>
                            <div class="form-group">
                                <textarea type="text" name="requirements" class="form-control"
                                          placeholder="Требования"></textarea>
                            </div>
                            <div class="form-group">
                                <textarea type="text" name="description" class="form-control"
                                          placeholder="Описание"></textarea>
                            </div>
                            <div class="form-group">
                                <input type="number" name="minSalary" class="form-control"
                                       placeholder="Минимальная зарплата"/>
                            </div>
                            <div class="form-group">
                                <input type="number" name="maxSalary" class="form-control"
                                       placeholder="Максимальная зарплата"/>
                            </div>
                            <div class="form-group" id="competenciesFields">
                                <button type="button" class="btn btn-primary" id="competenciesButton" onclick="addField()">Add competence</button>
                                <datalist id="competencies">
                                    <#list competencies as competence>
                                        <option value="${competence.name}">${competence.name}</option>
                                    </#list>
                                </datalist>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <input type="submit" class="btn btn-primary" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </#if>
</#if>

</html>