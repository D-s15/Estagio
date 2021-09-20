@extends('point.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Gestão de Pontos de Interesse</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-back" href="{{route('home') }}">voltar para a página inicial</a>
            <a class="btn btn-success" href="{{route('point.create') }}">Add</a>
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
        @foreach ($point as $point)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $point->name }}</td>
                <td><img src ="{{ $point->image }}" alt="Monument image" width="100"/></td>
                <td>
                    <form action="{{ route('point.destroy',$point->id) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('point.show',$point->id) }}">Mostrar</a>
                        <a class="btn btn-primary" href="{{ route('point.edit',$point->id) }}">Editar</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Apagar</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
@endsection