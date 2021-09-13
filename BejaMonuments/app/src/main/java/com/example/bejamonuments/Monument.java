package com.example.bejamonuments;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Monument{

    @PrimaryKey
    private long id;
    private String name;
    private String schedule_AM;
    private String schedule_PM;
    @SerializedName("day_off")
    private String dayOff;

    private String description;
    private String image;
    private int monumentRating;
    private String location;

    public Monument(long id, String name, String schedule_AM, String schedule_PM, String dayOff, String description, String image, int monumentRating, String location) {
        this.id = id;
        this.name = name;
        this.schedule_AM = schedule_AM;
        this.schedule_PM = schedule_PM;
        this.dayOff = dayOff;
        this.description = description;
        this.image = image;
        this.monumentRating = monumentRating;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule_AM() {
        return schedule_AM;
    }

    public void setSchedule_AM(String schedule_AM) {
        this.schedule_AM = schedule_AM;
    }

    public String getSchedule_PM() {
        return schedule_PM;
    }

    public void setSchedule_PM(String schedule_PM) {
        this.schedule_PM = schedule_PM;
    }

    public String getDayOff() {
        return dayOff;
    }

    public void setDayOff(String dayOff) {
        this.dayOff = dayOff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMonumentRating() {
        return monumentRating;
    }

    public void setMonumentRating(int monumentRating) {
        this.monumentRating = monumentRating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
