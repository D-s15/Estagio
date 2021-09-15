<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Monument;

class MonumentwebController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $monuments = Monument::all();
        return view('monument.list', compact('monuments'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
        return view('monument.create');
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
        return view('monument.view',compact('monument'));
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
        $request->validate([
            'name'=>'required',
            'description'=> 'required',
            'image' => 'required',
            'day_off' => 'required'
        ]);
 
        $monument = new Monument([
            'name' => $request->get('name'),
            'description' => $request->get('description'),
            'image' => $request->get('image'),
            'schedule_am' => $request->get('schedule_am'),
            'schedule_pm' => $request->get('schedule_pm'),
            'day_off' => $request->get('day_off'),
            'monument_rating' => $request->get('monument_rating'),
            'location' => $request->get('location')
        ]);

        $monument->save();
        return redirect('/monument')->with('success', 'Monument has been added');
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Monument  $monument
     * @return \Illuminate\Http\Response
     */
    public function edit(Monument $monument)
    {
        //
        return view('monument.edit',compact('monument'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Monument  $monument
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
        $request->validate([
            'name'=>'required',
            'description'=> 'required',
            'image' => 'required',
            'day_off' => 'required',
        ]);
 
        $monument = Monument::find($id);
        $monument->name = $request->get('name');
        $monument->description = $request->get('description');
        $monument->image = $request->get('image');
        $monument->schedule_am = $request->get('schedule_am');
        $monument->schedule_pm = $request->get('schedule_pm');
        $monument->day_off = $request->get('day_off');
        $monument->monument_rating = $request->get('monument_rating');
        $monument->location = $request->get('location');
 
        $monument->update();
 
        return redirect('/monument')->with('success', 'Monument updated successfully');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Monument  $monument
     * @return \Illuminate\Http\Response
     */
    public function destroy(Monument $monument)
    {
        //
        $monument->delete();
        return redirect('/monument')->with('success', 'Monument deleted successfully');
    }
}
