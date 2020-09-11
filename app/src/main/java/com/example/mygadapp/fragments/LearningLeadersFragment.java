package com.example.mygadapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mygadapp.Models.Learner;
import com.example.mygadapp.R;
import com.example.mygadapp.network.RequestInterface;
import com.example.mygadapp.network.Retro;
import com.example.mygadapp.ui.main.Learning_Leaders_Adapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mygadapp.R.id.learning_leaders_recycle_view;

public class LearningLeadersFragment extends Fragment{
    private RecyclerView recyclerView;
    private Learning_Leaders_Adapter learning_adapter;
    private RequestInterface retro_interface;
    private Context context;
    public LearningLeadersFragment() { }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_learning_leaders,container,false);
        recyclerView = v.findViewById(R.id.learning_leaders_recycle_view);

        retro_interface = Retro.Retrofit_instance().create(RequestInterface.class);
        Call<List<Learner>> call = retro_interface.getLearnerJson();
        call.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
                getLearnerList(response.body());

                Log.w("retromsg","sucess");
            }

            @Override
            public void onFailure(Call<List<Learner>> call, Throwable t) {
                Log.w("retromsg","failure");
            }
        });
        return v;
    }
    private void getLearnerList(List<Learner> learners){
        learning_adapter = new Learning_Leaders_Adapter(context, learners);
//        adapter = new BaseAdapter(context, Learner.class, learnerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(learning_adapter);
    }
}
