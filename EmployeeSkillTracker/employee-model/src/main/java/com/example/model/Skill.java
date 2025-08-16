package com.example.model;

public class Skill {
    private String name;
    private String rating; // Beginner, Intermediate, Expert

    public Skill() {}

    public Skill(String name, String rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    @Override
    public String toString() {
        return name + " (" + rating + ")";
    }
}