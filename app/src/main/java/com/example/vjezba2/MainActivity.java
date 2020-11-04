package com.example.vjezba2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {
    public ArrayList<GitData> gitDataArrayList = new ArrayList<GitData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // https://github.com/search?q=stars%3A%3E100&s=stars&type=Repositories
        String gitHubUrl = "https://api.github.com/";
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(gitHubUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubDataCollector holder = retrofit.create(GitHubDataCollector.class);
        Call<GithubResponse> response = holder.getStarrepositories();

        response.enqueue(new Callback<GithubResponse>() {
            @Override
            public void onResponse(Call<GithubResponse> call, Response<GithubResponse> response) {
                int statusCode = response.code();
                final GithubResponse resultResponse = response.body();
                generateUsers(resultResponse.getItems());
            }

            @Override
            public void onFailure(Call<GithubResponse> call, Throwable t) {

            }
        });
    }

    private void generateUsers(List<GitHubUser> users)
    {
        final RecyclerView listView = (RecyclerView)findViewById(R.id.GithubList);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(layoutManager);
        try {
            for (int i = 0; i < users.size(); i++) {
                GitData one = new GitData(users.get(i).getOwner().getLogin(), users.get(i).getName(), users.get(i).getStargazersCount(),
                        R.drawable.angel_wings_flower_vector_102124_1600x1200);
                gitDataArrayList.add(one);

            }
            final RecyclerView.Adapter gitAdapter = new GitAdapter(gitDataArrayList);
            listView.setAdapter(gitAdapter);
            Log.d( null ,"Hello world Response : " + gitDataArrayList.size());

        }
        catch (Exception e)
        {

        }
    }
}