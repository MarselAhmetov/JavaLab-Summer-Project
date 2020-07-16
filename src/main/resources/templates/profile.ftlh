<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Личный кабинет</title>
</head>

<body>
    <#include "common/header.ftlh"/>
    <main>
        <#list user.roles as role>
            <#if (role.authority=="STUDENT" )>
                <div>Я студент!</div>
                <#elseif (role.authority=="EMPLOYER" ) />
                <div>Я работодатель!</div>
                <#elseif (role.authority=="TEACHER" ) />
                <div>Я преподаватель!</div>
            </#if>
        </#list>
    </main>
</body>

</html>