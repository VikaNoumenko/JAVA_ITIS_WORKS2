<#import "spring.ftl" as spring />
<@spring.bind "model" />
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<div class="list-group" style="width: 1000px; margin:auto; padding: 3% 0; font-size: 25px">
    <a class="list-group-item active" style="text-align: center">${model.paper}</a>
    ${model.text}
</div>
</body>