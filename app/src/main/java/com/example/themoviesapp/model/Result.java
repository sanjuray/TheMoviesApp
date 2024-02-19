package com.example.themoviesapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    //based on json format json : paste the json into a json simplifier types website and get to understand
    //the structure of it

    //to use json converter we need gson for which serialization and deserialization is needed
    @SerializedName("page")//map json property to appropriate class property particularly used when the names are different else not required
    @Expose//decides which fields are included or excluded for security reasons
    private Integer page;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("results")
    @Expose
    private List<Movie> results = null;

    public Result() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
