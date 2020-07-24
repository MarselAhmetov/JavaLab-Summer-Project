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
                    <p class="card-text text-center h6"><a href="resumes/${resume.user.id}"
                                                           class="btn btn-secondary"><- К списку резюме студента</a>
                    </p>
                    <#if principal.user.role = "COMPANY">
                        <button type="button" class="btn btn-primary btn-lg btn-block mb-4" data-toggle="modal"
                                data-target="#exampleModal">Пригласить
                        </button>
                    </#if>
                </div>
                <div class="card-footer text-muted">
                    Дата создания: ${resume.creationTime}
                </div>
            </div>
        </div>
        <div class="col-1"></div>
    </div>
</div>
<#if principal??>
    <#if principal.user.role = "COMPANY">
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
                    <form action="invite/create" method="POST" class="form">
                        <input type="hidden" name="userId" class="form-control" value="${resume.user.id}"/>
                        <input type="hidden" name="resumeId" class="form-control" value="${resume.id}"/>
                        <div class="modal-body">
                            <div class="form-group">
                                <textarea type="text" name="text" class="form-control"
                                          placeholder="Текст приглашения"></textarea>
                            </div>
                            <#if vacancies??>
                                <div class="form-group">
                                    <select class="form-control" name="vacancyId">
                                        <#list vacancies as vacancy>
                                            <option class="form-control"
                                                    value="${vacancy.id}">${vacancy.vacancyName}</option>
                                        </#list>
                                    </select>
                                </div>
                            </#if>

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
</body>

</html>