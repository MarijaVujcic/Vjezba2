package com.example.vjezba2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView listView = (RecyclerView)findViewById(R.id.GithubList);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(layoutManager);


        GitData one = new GitData("Marija","repo","3",R.drawable.angel_wings_flower_vector_102124_1600x1200);
        GitData two = new GitData("Marijana","repo2","10",R.drawable.angel_wings_flower_vector_102124_1600x1200);

        final ArrayList<GitData> gitDataArrayList = new ArrayList<GitData>();
        gitDataArrayList.add(one);
        gitDataArrayList.add(two);

        final RecyclerView.Adapter gitAdapter = new GitAdapter(gitDataArrayList);
        listView.setAdapter(gitAdapter);
        String url = "https://github.com/";
/*        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(DownloadManager.Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        MyData myData = gson.fromJson(String.valueOf(jsonObject), MyData.class);
                        myDataset.add(myData);


                    }
                    Log.d("jeee", "evo");
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("jeee", "lose");
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("jeee", error.getMessage());

            }
        }
        );


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);*/



    }
}