@extends('monument.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Adicionar Novo Monumento</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('monument') }}"> Voltar</a>
        </div>
    </div>
 
    @if ($errors->any())
        <div class="alert alert-danger">
        <strong>Oops!</strong> Houve problemas com o preenchimento de dados.<br><br>
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif
    <form action="{{ route('monument.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="name">Nome:</label>
            <input type="text" class="form-control" id="name" placeholder="Nome" name="name">
        </div>
        <div class="form-group">
            <label for="description">Descrição:</label>
            <input type="text" class="form-control" id="description" placeholder="descrição" name="description">
        </div>
        <div class="form-group">
            <label for="image">Imagem:</label>
            <input type="url" class="form-control" id="image" name="image" placeholder="link da imagem"></input>
        </div>
       <div class="form-group">
            <label for="schedule_am">Horário da manhã:</label>
            <input type="text" class="form-control" id="schedule_am" placeholder="Horário da manhã" name="schedule_am">
        </div> 
        <div class="form-group">
            <label for="schedule_pm">Horário da tarde:</label>
            <input type="text" class="form-control" id="schedule_pm" placeholder="Horário da Tarde" name="schedule_pm">
        </div>
        <div class="form-group">
            <label for="closing">Day de encerramento:</label>
            <input type="text" class="form-control" id="day_off" placeholder="dia de encerramento" name="day_off">
        </div>
        <div class="form-group">
            <label for="monument_rating">Classificação:</label>
            <input type="number" class="form-control" id="monument_rating" placeholder="Classificação" min="0" max="5" name="monument_rating">
        </div>
        <div class="form-group">
            <label for="location">Localização:</label>
            <input type="text" class="form-control" id="location" placeholder="localização" name="location">
        </div>
        <button type="submit" class="btn btn-default">Submeter</button>
    </form>
@endsection