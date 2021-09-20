@extends('monument.layouts.app')

@section('content')
<div class="row">
    <div class="col-lg-11">
        <h2>Atualizar Monumento</h2>
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
<form method="post" action="{{ route('monument.update',$monument->id) }}">
    @method('PATCH')
    @csrf
    <div class="form-group">
        <label for="name">Nome:</label>
        <input type="text" class="form-control" id="name" placeholder="nome" name="name"
            value="{{ $monument->name }}">
    </div>
    <div class="form-group">
        <label for="description">Descrição:</label>
        <input type="text" class="form-control" id="description" placeholder="descrição"
            name="description" value="{{ $monument->description }}">
    </div>
    <div class="form-group">
        <label for="image">Imagem:</label>
        <input type="url" class="form-control" id="image" placeholder="link da imagem" name="image"
            value="{{ $monument->image }}">
    </div>
    <div class="form-group">
        <label for="schedule_am">Horário da manhã:</label>
        <input type="text" class="form-control" id="schedule_am" placeholder="horário da manhã"
            name="schedule_am" value="{{ $monument->schedule_am }}">
    </div>
    <div class="form-group">
        <label for="schedule_pm">Horário da tarde:</label>
        <input type="text" class="form-control" id="schedule_pm" placeholder="horário da tarde"
            name="schedule_pm" value="{{ $monument->schedule_pm }}">
    </div>
    <div class="form-group">
        <label for="closing">dia de encerramento:</label>
        <input type="text" class="form-control" id="day_off" placeholder="dia de encerramento" name="day_off"
            value="{{ $monument->day_off }}">
    </div>
    <div class="form-group">
        <label for="monument_rating">Classificação:</label>
        <input type="number" name="monument_rating" placeholder="Classificação" id="monument_rating"
            value="{{$monument->monument_rating }}">
    </div>
    <div class="form-group">
        <label for="location">Localização:</label>
        <input type="text" name="location" placeholder="localização" id="location"
            value="{{$monument->location }}">
    </div>
    <button type="submit" class="btn btn-default">Submeter</button>
</form>
@endsection