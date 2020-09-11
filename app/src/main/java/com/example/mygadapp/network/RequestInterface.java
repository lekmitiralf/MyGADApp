package com.example.mygadapp.network;

import com.example.mygadapp.Models.Learner;
import com.example.mygadapp.Models.Skill;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("api/hours")
    Call<List<Learner>> getLearnerJson();

    @GET("api/skilliq")
    Call<List<Skill>> getSkillJson();

}
