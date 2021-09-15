<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\InterestPoint;
use App\http\Resources\InterestPoint as InterestInterestPointResource;

class interestPointController extends Controller
{
        /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index($id)
    {
        // Get the posts
        // $p = Post::paginate(5);
        $p = InterestPoint
    ::all()->where('monument_id', '=', $id);

 // Return collection of posts as a resource
 return InterestPointResource::collection($p);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
        return view('InterestPoint
    .create');
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
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
        // Get a single post
         $p = InterestPoint
        ::findOrFail($id);

        // Return a single post as a reso
        return new InterestPointResource($p);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update()
    {
        //
        $p = InterestPoint
    ::all();

        return InterestPointResource::collection($p);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
