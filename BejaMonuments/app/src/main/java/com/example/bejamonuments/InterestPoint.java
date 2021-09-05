package com.example.bejamonuments;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class InterestPoint {

    @PrimaryKey
    private long id;
    private long monumentId;
    private String name;
    private String description;
    private String image;
    private int rating;
    private boolean visited;

    public InterestPoint(long id, long monumentId, String name, String description, String image, int rating, boolean visited) {
        this.id = id;
        this.monumentId = monumentId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.rating = rating;
        this.visited = visited;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMonumentId() {
        return monumentId;
    }

    public void setMonumentId(long monumentId) {
        this.monumentId = monumentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
