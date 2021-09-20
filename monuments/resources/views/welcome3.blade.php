@include('header')

<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="{{asset ('/css/app.css') }}">

    <title>Monumentos de Beja</title>
</head>

<body>
    @section('header')

    <div style="margin:0 auto; width:50%; float: left">
        <h1 style="text-align: center; font-size: 28px; padding-top: 30px; padding-bottom: 30px">{{ $point->name}}</h1>
        <p>{{ $point->description }}</p>
        <a href="{{url()->previous() }}">voltar para trás</a>
    </div>
    <div>
        <img src="{{ $point->image }}" alt="Point Image" style="margin:0 auto; width:50%; float: left">
    </div>

</body>

</html>