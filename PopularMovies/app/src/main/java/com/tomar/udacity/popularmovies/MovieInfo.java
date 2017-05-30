package com.tomar.udacity.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieInfo implements Parcelable {
    String title, rating, year, descr, movieId;

    public MovieInfo(String title, String rating, String date, String descr, String movieId) {
        this.title = title;
        this.rating = rating;
        this.year = date.split("-")[0];
        this.descr = descr;
        this.movieId = movieId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.rating);
        dest.writeString(this.year);
        dest.writeString(this.descr);
        dest.writeString(this.movieId);
    }

    protected MovieInfo(Parcel in) {
        this.title = in.readString();
        this.rating = in.readString();
        this.year = in.readString();
        this.descr = in.readString();
        this.movieId = in.readString();
    }

    public static final Parcelable.Creator<MovieInfo> CREATOR = new Parcelable.Creator<MovieInfo>() {
        @Override
        public MovieInfo createFromParcel(Parcel source) {
            return new MovieInfo(source);
        }

        @Override
        public MovieInfo[] newArray(int size) {
            return new MovieInfo[size];
        }
    };
}
