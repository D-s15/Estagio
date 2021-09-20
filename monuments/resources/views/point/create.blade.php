@extends('point.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Adicionar novo Ponto de Interesse</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('point') }}"> Voltar</a>
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
    <form action="{{ route('point.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="monument_id">id do Monumento associado:</label>
            <input type="number" class="form-control" id="monument_id" placeholder="ID do monumento associado" name="monument_id">
        </div>
        <div class="form-group">
            <label for="name">Nome:</label>
            <input type="text" class="form-control" id="name" placeholder="Nome do ponto de interesse" name="name">
        </div>
        <div class="form-group">
            <label for="description">Descrição:</label>
            <input type="text" class="form-control" id="description" name="description" placeholder="Enter Point Description">
        </div>
       <div class="form-group">
            <label for="image">Imagem do Ponto de Interesse:</label>
            <input type="URL" class="form-control" id="image" placeholder="link da imagem" name="image">
        </div>
        <div class="form-group">
            <label for="rating">Classificação do Ponto de Interesse:</label>
            <input type="number" class="form-control" id="rating" placeholder="Classificação" name="rating" min="0" max="5">
        </div>
        
        <button type="submit" class="btn btn-default">Submeter</button>
    </form>
@endsection