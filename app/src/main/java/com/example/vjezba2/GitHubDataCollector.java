package com.example.vjezba2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubDataCollector {
    @GET("search/repositories?q=stars:>100000")
    Call<GithubResponse> getStarrepositories();
}
