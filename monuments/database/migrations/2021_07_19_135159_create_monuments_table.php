<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateMonumentsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('monuments', function (Blueprint $table) {
            $table->bigIncrements('id')->unsigned();
            $table->string('name', 70);
            $table->string('schedule_am', 15);
            $table->string('schedule_pm', 15);
            $table->string('day_off', 30);
            $table->text('description');
            $table->string('image', 300);
            $table->integer('monument_rating');
            $table->string('location');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('monuments');
    }
}
