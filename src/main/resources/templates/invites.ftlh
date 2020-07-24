<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
</head>

<body class="body">
<#include "header.ftlh">
<br>
<div class="container">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Search" aria-describedby="button-addon2">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>
                </div>
            </div>
            <#list invites as invite>
                <div class="card text-center">
                    <div class="card-header">
                        ${invite.company.name} send invite to ${invite.student.lastName} ${invite.student.firstName} ${invite.student.middleName}
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${invite.resume.resumeName}</h5>
                        <p class="card-text">${invite.text}</p>
                        <#if principal.user.role = "STUDENT">
                            <a href="company/${invite.company.user.id}" class="btn btn-primary">Go to company</a>
                        </#if>
                        <#if principal.user.role = "COMPANY">
                            <a href="student/${invite.student.user.id}" class="btn btn-primary">Go to student</a>
                        </#if>
                    </div>
                </div>
            </#list>
        </div>
        <div class="col-1"></div>
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
                                    <#list portfolios as portfolio>
                                        <option value="${portfolio.id}">${portfolio.topic}</option>
                                    </#list>
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