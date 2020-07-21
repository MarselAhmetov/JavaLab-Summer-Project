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
    <#if students?? && students?has_content>
        <#list students as student>
            <div>${student}</div>
        </#list>
    <#else>
        <div>Пока что студентов нет :(</div>    
    </#if>
</body>

</html>