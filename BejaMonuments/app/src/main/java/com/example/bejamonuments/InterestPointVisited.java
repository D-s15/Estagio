package com.example.bejamonuments;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class InterestPointVisited {
    @PrimaryKey
    private long id;
    private boolean visited;

    public InterestPointVisited(long id, boolean visited) {
        this.id = id;
        this.visited = visited;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}