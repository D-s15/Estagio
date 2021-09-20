@extends('point.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Ver Pontos de Interesse</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('point') }}"> Voltar</a>
        </div>
    </div>
    <table class="table table-bordered">
        <tr>
            <th>monument_id:</th>
            <td>{{ $point->monument_id }}</td>
        </tr>
        <tr>
            <th>nome:</th>
            <td>{{ $point->name }}</td>
        </tr>
        <tr>
            <th>descrição:</th>
            <td>{{ $point->description }}</td>
        </tr>
        <tr>
            <th>Imagem:</th>
            <td><img src="{{ $point->image }}" alt="Monument image" width="100"/></td>
        </tr>
    </table>
@endsection