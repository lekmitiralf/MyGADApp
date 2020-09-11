package com.example.mygadapp.network;

import com.example.mygadapp.Models.Learner;
import com.example.mygadapp.Models.Project;
import com.example.mygadapp.Models.Skill;

import java.util.List;

import androidx.annotation.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RequestInterface {
    @GET("api/hours")
    Call<List<Learner>> getLearnerJson();

    @GET("api/skilliq")
    Call<List<Skill>> getSkillJson();

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    @Nullable
    Call<Void> submitProject(
            @Field("entry.1877115667") @Nullable String firstName,
            @Field("entry.2006916086") @Nullable String lastName,
            @Field("entry.284483984") @Nullable String githubLink,
            @Field("entry.1824927963") @Nullable String emailAddress, Callback<Project> callback);

}
