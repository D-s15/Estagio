<?php

use Illuminate\Support\Facades\Route;
use App\http\Controllers\MonumentwebController;
use App\http\Controllers\InterestPointwebController;
use App\http\Controllers\WelcomeController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', [WelcomeController::class, 'index'])->name('home');

Route::get('/welcome/{id}', [WelcomeController::class, 'showMonPoints'])->name('welcome.showMonPoints');

Route::get('/welcome/point/{id}', [WelcomeController::class, 'showPoint'])->name('welcome.showPoint');

Route::middleware(['auth:sanctum', 'verified'])->group(function () {
    Route::resource('monument', MonumentwebController::class);

    Route::resource('point', InterestPointwebController::class);

    Route::get('/dashboard', function () {
        return view('dashboard');
    })->name('dashboard');
});