<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Monument;
use App\http\Resources\Monument as MonumentResource;

class MonumentController extends Controller
{
        /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //// Get the posts
        // $p = Monument::paginate(5);
        $m = Monument::all();

        // Return collection of posts as a resource
        return MonumentResource::collection($m);
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
         $m = Monument::findOrFail($id);

        // Return a single post as a reso
        return new MonumentResource($m);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
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
