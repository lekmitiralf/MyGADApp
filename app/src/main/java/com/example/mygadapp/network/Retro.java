package com.example.mygadapp.network;

import android.util.Log;
import android.widget.Toast;

import com.example.mygadapp.MainActivity;
import com.example.mygadapp.Models.Learner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {
    private static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    private static final String FORM_IRL = "https://docs.google.com/forms/d/e/";

    static ArrayList<Learner> learners = new ArrayList<>();
    public static Retrofit  Retrofit_instance() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
    public static Retrofit Retro_form(){
            Retrofit retro_form = new Retrofit.Builder()
                    .baseUrl(FORM_IRL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retro_form;
        }




    // GitHubService service = retrofit.create(GitHubService.class);
}

