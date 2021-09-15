<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class monument extends Model
{
    use HasFactory;
    protected $fillable=[
        'name',
        'image',
        'description',
        'schedule_am',
        'schedule_pm',
        'monument_rating',
        'day_off',
        'location'
    ];
}
