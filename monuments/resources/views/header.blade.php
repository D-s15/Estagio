<header class="header">
    <h1>Monumentos de Beja</h1>
</header>

<style>
.header {
    height: 100px;
    text-align: center;
    background-color: #068edf;
    padding-top: 20px;
    font-size: 24px;
    width: 100%;
}
</style>

<body>
    @section('header')
    <div>
        @if (Route::has('login'))
        <div class="hidden fixed top-0 right-0 px-6 py-4 sm:block flex items-center justify-between" id=>
            <a href="{{ url('/monument') }}" class="text-sm text-gray-700 underline ">Monumentos</a>
            <a href="{{ url('/point') }}" class="text-sm text-gray-700 underline ">Pontos de Interesse</a>
            @auth
            <a href="{{ url('/dashboard') }}" class="text-sm text-gray-700 underline">Dashboard</a>
            @else
            <a href="{{ route('login') }}" class="text-sm text-gray-700 underline">Log in</a>

            @if (Route::has('register'))
            <a href="{{ route('register') }}" class="ml-4 text-sm text-gray-700 underline">Register</a>
            @endif
            @endauth
        </div>
        @endif
        @show
    </div>
</body>