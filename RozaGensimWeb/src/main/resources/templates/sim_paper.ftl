<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<div class="list-group" style="width: 1000px; margin:auto; padding: 3% 0; font-size: 25px">
    <a class="list-group-item active" style="text-align: center">Поиск схожих статей:</a>
    <form action="/query_paper" method="post">
        <br>
        <span style="font-size: 14pt">Текст статьи:</span><textarea name="paper_text"
                                                                    style="font-size: 14pt; width: 1000px; height: 400px"
                                                                    title="Текст статьи"></textarea>
        <hr>
        <button type="submit" class="btn btn-primary">Найти</button>
    </form>
</div>
</body>