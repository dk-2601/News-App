package com.example.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    ArrayList<modelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewofhome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homefragment,null);

        recyclerViewofhome = view.findViewById(R.id.recyclerViewOfHome);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofhome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewofhome.setAdapter(adapter);

        findnews();


        return view;

    }

    private void findnews() {

        String api = "f7b3023a27364ade9a4fe819fe0f68bc";
        ApiUtilities.getApiInterface().getNews(country,20, api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                Log.i("Hello","display");
                if(response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

                
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

                Toast.makeText(getContext(),"uhuhu",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
