package com.example.themoviedatabaseapp;
//api link
//https://api.themoviedb.org/3/movie/popular?api_key=5d8d574f48b0c983c0b989084f2a187c

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;



public class JsonPOJO implements Parcelable {

    public JsonPOJO(){
    }


    private int page;
    private List<Result> results;
    private int total_pages;
    private int total_results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public void setTotalPages(int totalPages) {
        this.total_pages = totalPages;
    }

    public int getTotalResults() {
        return total_results;
    }

    public void setTotalResults(int totalResults) {
        this.total_results = totalResults;
    }



 static class Result {
    public Result() {

    }

    private Boolean adult;
    private String backdrop_path;
    private List<Integer> genre_ids;
    private Integer id;
    private String original_language;
    private String original_title;
    private String overview;
    private Double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private Boolean video;
    private Double vote_average;
    private Integer vote_count;

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdrop_path;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdrop_path = backdropPath;
    }

    public List<Integer> getGenreIds() {
        return genre_ids;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genre_ids = genreIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return original_language;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.original_language = originalLanguage;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.original_title = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return vote_average;
    }

    public void setVoteAverage(Double voteAverage) {
        this.vote_average= voteAverage;
    }

    public Integer getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(Integer voteCount) {
        this.vote_count = voteCount;
    }

}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.page);
        dest.writeList(this.results);
        dest.writeInt(this.total_pages);
        dest.writeInt(this.total_results);
    }

    public void readFromParcel(Parcel source) {
        this.page = source.readInt();
        this.results = new ArrayList<Result>();
        source.readList(this.results, Result.class.getClassLoader());
        this.total_pages = source.readInt();
        this.total_results = source.readInt();
    }

    protected JsonPOJO(Parcel in) {
        this.page = in.readInt();
        this.results = new ArrayList<Result>();
        in.readList(this.results, Result.class.getClassLoader());
        this.total_pages = in.readInt();
        this.total_results = in.readInt();
    }

    public static final Parcelable.Creator<JsonPOJO> CREATOR = new Parcelable.Creator<JsonPOJO>() {
        @Override
        public JsonPOJO createFromParcel(Parcel source) {
            return new JsonPOJO(source);
        }

        @Override
        public JsonPOJO[] newArray(int size) {
            return new JsonPOJO[size];
        }
    };
}
