@include('header')

<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="{{asset ('/css/app.css') }}">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <style>
    /* Make the image fully responsive */
    .carousel-inner img {
        width: 500px;
        height: 400px;
    }
    </style>

    <title>Monumentos de Beja</title>
</head>

<body>
    @section('header')

    <div style="float:left; width:50%;">
        <h1 style="font-size: 22px; padding-top:30px; padding-botom:30px; text-align:center">{{ $monument->name }}</h1>
        <p style="padding-bottom: 50px; padding-top: 30px">{{ $monument->day_off . "." . " Aberto de manhã das " . $monument->schedule_am . " e à tarde das " . $monument->schedule_pm }}
        </p>

        <p style="padding-bottom: 30px">{{ $monument->description }}</p>

        <a style="margin-auto: 0" href="{{ $monument->location}}">localização</a>
    </div>

    <div style="float:left; width:50%; padding:10px;">
        <img src="{{ $monument->image }}" alt="Monument Image">
    </div>

    <div style="clear: both; background-color: CornflowerBlue">

        <h1 style="text-align: center; font-size: 32; padding-bottom: 25px; padding-top: 25px; color:white">
            Pontos de Interesse</h1>
        <div id="point" class="carousel slide" data-ride="carousel">

            <ul class="carousel-indicators">
                @php
                $i = 0;
                @endphp
                @foreach ( $points as $point)

                @if ($i == 0)
                <li data-target="#point" data-slide-to="0" class="active"></li>
                @else
                <li data-target="#point" data-slide-to="{{$i}}"></li>
                @endif
                @php
                $i++;
                @endphp
                @endforeach
            </ul>

            <div class="carousel-inner">

                @php
                $i = 0;
                @endphp
                @foreach($points as $point)
                @if($i == 0)
                <div class="carousel-item active" style="margin:0 auto; width: 80%">
                    <img src="{{ $point->image }}" style="padding-left: 100px; margin:0 auto; width: 50%; float:left">
                    <div style="padding-top: 120px">
                        <h1 style="margin:0 auto; width: 50%; float:left; padding-left: 80px; padding-bottom: 30px; font-size: 24px">{{ $point->name }}</h1>
                        <a href="{{route('welcome.showPoint', $point->id) }}" style="padding-left: 80px">Ver Informação sobre este Ponto de
                            Interesse</a>
                    </div>
                </div>

                @elseif($i > 0)
                <div class="carousel-item" style="margin:0 auto; width: 80%">
                    <img src="{{$point->image }}" alt="point Image" style="padding-left: 100px; margin:0 auto; width: 50%; float:left">
                    <div style="padding-top: 120px">
                        <p style="margin:0 auto; width: 50%; float:left; padding-left:80px; padding-bottom: 30px; font-size: 24px">{{ $point->name }}</p>
                        <a href="{{route('welcome.showPoint', $point->id) }}" style="padding-left: 80px">Ver Informação sobre este Ponto de
                            Interesse</a>
                    </div>
                </div>

                @endif
                @php
                $i++;
                @endphp
                @endforeach
            </div>

            <a class="carousel-control-prev" href="#point" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#point" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>

        </div>
</body>

</html>