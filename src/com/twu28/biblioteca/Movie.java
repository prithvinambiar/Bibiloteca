package com.twu28.biblioteca;

public class Movie {
    private String movieName;
    private String directorName;
    private int rating;

    public Movie(String movieName, String directorName) {
        this.movieName = movieName;
        this.directorName = directorName;
    }

    public Movie(String movieName, String directorName, int rating) {
        this(movieName, directorName);
        setRating(rating);
    }

    public int getRating() {
        return rating;
    }

    private void setRating(int rating) {
        if (rating >= 1 && rating <= 10)
            this.rating = rating;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public String getDirectorName() {
        return this.directorName;
    }
}
