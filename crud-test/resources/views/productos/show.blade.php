@extends('base')

@section('content')
    <div class="container">
        <h1>Detalles del Producto</h1>
        <div class="card">
            <div class="card-header">
                Producto #{{ $producto->id }}
            </div>
            <div class="card-body">
                <h5 class="card-title">{{ $producto->nombre }}</h5>
                <p class="card-text">{{ $producto->descripcion }}</p>
                <p class="card-text"><strong>Precio:</strong> {{ $producto->precio }}</p>
                <p class="card-text"><strong>Cantidad en Stock:</strong> {{ $producto->cantidad_en_stock }}</p>
                <a href="{{ route('productos.index') }}" class="btn btn-primary">Volver</a>
            </div>
        </div>
    </div>
@endsection
