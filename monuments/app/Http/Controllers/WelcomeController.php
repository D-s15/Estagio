<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Monument;
use App\Models\InterestPoint;

class WelcomeController extends Controller
{
    //
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $monuments = Monument::all();
        return view('welcome', compact('monuments'));
    }


    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Monument  $monument
     * @return \Illuminate\Http\Response
     */
    public function show(Monument $monument)
    {
        //
        return view('welcome', compact('monument'));
    }

    public function showMon($id){
        $monument = Monument::find($id);
        $points = InterestPoint::query()->where('monument_id', '=', $id);
     
        return view('welcome2', compact('monument', 'points'));
    }

    public function showPoint($id){
        $point = InterestPoint::find($id);
        return view('welcome3', compact('point'));
    }

}
