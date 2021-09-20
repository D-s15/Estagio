@extends('monument.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Gestão de Monumentos</h2>
        </div>
        <div class="col-lg-1">
            <a href="{{route('home') }}" class="btn btn-back">voltar para a página inicial</a>
            <a class="btn btn-success" href="{{route('monument.create') }}">Adicionar</a>
        </div>
    </div>
 
    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif
 
    <table class="table table-bordered">
        <tr>
            <th>Position</th>
            <th>name</th>
            <th>image</th>
            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($monuments as $monument)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $monument->name }}</td>
                <td><img src ="{{ $monument->image }}" alt="Monument image" width="100"/></td>
                <td>
                    <form action="{{ route('monument.destroy',$monument->id) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('monument.show',$monument->id) }}">Mostrar</a>
                        <a class="btn btn-primary" href="{{ route('monument.edit',$monument->id) }}">Editar</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Apagar</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
@endsection