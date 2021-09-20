@extends('monument.layouts.app')

@section('content')
<div class="row">
    <div class="col-lg-11">
        <h2>Ver Monumentos</h2>
    </div>
    <div class="col-lg-1">
        <a class="btn btn-primary" href="{{ url('monument') }}"> Voltar</a>
    </div>
</div>
<table class="table table-bordered">
    <tr>
        <th>Nome:</th>
        <td>{{ $monument->name }}</td>
    </tr>
    <tr>
        <th>Descrição:</th>
        <td>{{ $monument->description }}</td>
    </tr>
    <tr>
        <th>Imagem:</th>
        <td><img src="{{ $monument->image }}" alt="Monument image" width="100" /></td>
    </tr>
    <tr>
        <th>Horário da Manhã:</th>
        <td>{{ $monument->schedule_am }}</td>
    </tr>
    <tr>
        <th>Horário da Tarde:</th>
        <td>{{ $monument->schedule_pm }}</td>
    </tr>
    <tr>
        <th>Dia de encerramento:</th>
        <td>{{ $monument->day_off }}</td>
    </tr>
    <tr>
        <th>Classificação:</th>
        <td>{{ $monument->monument_rating }}</td>
    </tr>
    <tr>
        <th>localização:</th>
        <td>{{ $monument->location }}</td>
    </tr>

</table>
@endsection