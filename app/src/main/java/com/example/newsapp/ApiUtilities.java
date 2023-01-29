package com.example.newsapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiUtilities {

    private static Retrofit retrofit;

    //https://futurestud.io/tutorials/retrofit-getting-started-and-android-client#:~:text=Define%20Dependencies%3A%20Gradle%20or%20Maven&text=gradle%20or%20pom.,the%20library%20for%20your%20project.

    //refer the above link
    //Retrofit REST Client



    public static ApiInterface getApiInterface()
    {

        /*Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if(retrofit == null)
        {
            retrofit =   new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(ApiInterface.class);*/

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(ApiInterface.class);
    }
    
}
