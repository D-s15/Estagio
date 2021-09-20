@extends('point.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Atualizar Ponto de Interesse</h2>
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
    <form method="post" action="{{ route('point.update',$point->id) }}" >
        @method('PATCH')
        @csrf
        <div class="form-group">
            <label for="monument_id">Id do Monumento Associado:</label>
            <input type="number" class="form-control" id="monument_id" placeholder="ID do monumento associado" name="monument_id" value="{{ $point->monument_id }}">
        </div>
        <div class="form-group">
            <label for="name">Nome do Ponto de Interesse:</label>
            <input type="text" class="form-control" id="name" placeholder="nome" name="name" value="{{ $point->name }}">
        </div>
        <div class="form-group">
            <label for="description">Descrição:</label>
            <input type="text" class="form-control" id="description" placeholder="descrição" name="description" value="{{ $point->description }}">
        </div>
        <div class="form-group">
            <label for="image">Imagem do Ponto de Interesse:</label>
            <input type="url" class="form-control" id="image" placeholder="link da imagem" name="image" value="{{ $point->image }}">
        </div>
        <div class="form-group">
            <label for="rating">Classificação do Ponto de Interesse:</label>
            <input type="number" name="rating" placeholder="classificação" id="rating" value="{{ $point->rating }}">
        </div>
        <button type="submit" class="btn btn-default">Submeter</button>
    </form>
@endsection