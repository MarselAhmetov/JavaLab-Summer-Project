<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вакансии</title>
</head>

<body>
    <#include "common/header.ftlh"/>
    <main>
        <#if vacancies?? && (vacancies?has_content)>
            <#list vacancies as vacancy>
                <div>${vacancy}</div>
            </#list>
        <#else/>
            <div>Пока что вакансий нет :(<div>
        </#if>
    </main>
</body>

</html>