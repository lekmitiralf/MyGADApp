package com.example.mygadapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mygadapp.Models.Learner;
import com.example.mygadapp.Models.Skill;
import com.example.mygadapp.R;
import com.example.mygadapp.network.RequestInterface;
import com.example.mygadapp.network.Retro;
import com.example.mygadapp.ui.main.Learning_Leaders_Adapter;
import com.example.mygadapp.ui.main.Skill_Iq_Adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQLeadersFragment extends Fragment {
    private RecyclerView recyclerView;
    private Skill_Iq_Adapter Skill_adapter;
    private RequestInterface retro_interface;
    private Context context;
    public SkillIQLeadersFragment() { }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_iq_skill,container,false);
        recyclerView = v.findViewById(R.id.skill_iq_recycle_view);

        retro_interface = Retro.Retrofit_instance().create(RequestInterface.class);
        Call<List<Skill>> call = retro_interface.getSkillJson();
        call.enqueue(new Callback<List<Skill>>() {
            @Override
            public void onResponse(Call<List<Skill>> call, Response<List<Skill>> response) {
                getSkillsList(response.body());

                Log.w("retromsg","sucess");
            }

            @Override
            public void onFailure(Call<List<Skill>> call, Throwable t) {
                Log.w("retromsg","failure");
            }
        });
        return v;
    }
    private void getSkillsList(List<Skill> Skills){
        Skill_adapter = new Skill_Iq_Adapter(context, Skills);
//        adapter = new BaseAdapter(context, Learner.class, learnerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(Skill_adapter);
    }
}
