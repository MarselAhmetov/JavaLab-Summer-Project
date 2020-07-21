<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Личный кабинет</title>
    <#include "common/head-common.ftlh">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
</head>

<body>
    <#include "header.ftlh"/>
    <main>
        <#if user??>
            <#if (user.role =="STUDENT" )>
                <div>Я студент!</div>
            <#elseif (user.role =="EMPLOYER" )>
                <div>Я работодатель!</div>
            <#elseif user.role ="TEACHER">
                <div>Я преподаватель!</div>
            </#if>
        <#else>
            <div>User кончался</div>
        </#if>
        <#if resumes?? && resumes?has_content>
            <#list resumes as resume>
                <div>${resume}</div>
            </#list>
        <#else>
            <div>Ваши резюме отстутствуют</div>
        </#if>
    </main>
</body>

</html>