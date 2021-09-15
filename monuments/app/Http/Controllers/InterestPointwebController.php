<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\InterestPoint;

class InterestPointwebController extends Controller
{
        /**
         * Display a listing of the resource.
         *
         * @return \Illuminate\Http\Response
         */
        public function index()
        {
            //
            $point = InterestPoint::all();
            return view('point.list', compact('point'));
        }
    
        /**
         * Show the form for creating a new resource.
         *
         * @return \Illuminate\Http\Response
         */
        public function create()
        {
            //
            return view('point.create');
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
                'monument_id'=> 'required',
                'description'=> 'required',
                'image' => 'required',
                'rating' => 'required'
            ]);
     
            $point = new InterestPoint([
                'name' => $request->get('name'),
                'monument_id' => $request->get('monument_id'),
                'description'=> $request->get('description'),
                'image'=> $request->get('image'),
                'rating' => $request->get('rating')
            ]);
     
            $point->save();
            return redirect('/point')->with('success', 'InterestPoint has been added');
        }
    
        /**
         * Display the specified resource.
         *
         * @param  \App\Models\InterestPoint  $point
         * @return \Illuminate\Http\Response
         */
        public function show(InterestPoint $point)
        {
            //
            return view('point.view',compact('point'));
        }
    
        /**
         * Show the form for editing the specified resource.
         *
         * @param  \App\Models\InterestPoint  $point
         * @return \Illuminate\Http\Response
         */
        public function edit(InterestPoint $point)
        {
            //
            return view('point.edit',compact('point'));
        }
    
        /**
         * Update the specified resource in storage.
         *
         * @param  \Illuminate\Http\Request  $request
         * @param  \App\Models\InterestPoint  $point
         * @return \Illuminate\Http\Response
         */
        public function update(Request $request, $id)
        {
            //
            $request->validate([
                'name'=>'required',
                'monument_id' => 'required',
                'description'=> 'required',
                'image' => 'required',
                'rating' => 'required'
            ]);
     
     
            $point = InterestPoint::find($id);
            $point->monument_id = $request->get('monument_id');
            $point->name = $request->get('name');
            $point->description = $request->get('description');
            $point->image = $request->get('image');
            $point->rating = $request->get('rating');
     
            $point->update();
     
            return redirect('/point')->with('success', 'InterestPoint updated successfully');
        }
    
        /**
         * Remove the specified resource from storage.
         *
         * @param  \App\Models\InterestPoint  $point
         * @return \Illuminate\Http\Response
         */
        public function destroy(InterestPoint $point)
        {
            //
            $point->delete();
            return redirect('/point')->with('success', 'InterestPoint deleted successfully');
        }
}
