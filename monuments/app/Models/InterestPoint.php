<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class interestPoint extends Model
{
    use HasFactory;
    protected $fillable=[
        'monument_id',
        'name',
        'image',
        'description',
        'rating'
    ];
}