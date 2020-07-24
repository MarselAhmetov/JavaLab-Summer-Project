<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список студентов-соискателей</title>
    <#include "common/head-common.ftlh">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
</head>

<body>
<#include "header.ftlh">
<#if studentsMap?? && studentsMap?keys?has_content>
    <div class="container">
        <div class="row">
            <div class="col-2"></div>
            <div class="col">
                <div class="card-container">
                    <div class="h3 text-center mb-4 mt-4">Список студентов:</div>
                    <#list studentsMap as student, resumes>
                        <div class="card text-center mb-4">
                            <div class="card-header h3">
                                <h3>${student.lastName} ${student.firstName} ${student.middleName}</h3>
                            </div>
                            <div class="card-body">
                                <p class="card-text h5 mb-2">Описание: </p>
                                <p class="card-text mb-2">Меня
                                    зовут ${student.lastName} ${student.firstName} ${student.middleName}</p>
                                <p class="card-text h5 mb-2">Пол:</p>
                                <p class="card-text mb-2">
                                    <#if student.sex == "male">
                                        Мужской
                                    <#else>
                                        Женский
                                    </#if>
                                </p>
                                <p class="card-text mb-2 h5">Мои резюме: </p>
                                <#list resumes as resume>
                                    <p class="card-text mb-2"><a href="resume/${resume.id}" class="btn btn-secondary">${resume.resumeName}</a></p>
                                    <#if resumes?has_next>
                                        ,
                                    </#if>
                                </#list>
                                <p class="card-text text-muted h6">Создатель: ${student.user.username}</p>
                                <p class="card-text text-center h6"><a href="student/${student.user.id}"
                                                                       class="btn btn-primary">Подробнее о студенте...</a></p>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
            <div class="col-2"></div>
        </div>
    </div>
<#else>
    <div>Пока что студентов нет :(</div>
</#if>
</body>

</html>