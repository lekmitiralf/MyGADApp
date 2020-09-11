package com.example.mygadapp.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mygadapp.Models.Skill;
import com.example.mygadapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Skill_Iq_Adapter extends RecyclerView.Adapter<Skill_Iq_Adapter.ViewHolder> {
    Context context;
    private List<Skill> Skills ;
    public Skill_Iq_Adapter(Context context , List<Skill> Skills) {
        this.context = context;
        // this.imageView = imageView;
        this.Skills = Skills;


    }
    @NonNull
    @Override
    public Skill_Iq_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gads_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Skill_Iq_Adapter.ViewHolder holder, int position) {
        String imageUrl = Skills.get(position).getBadgeUrl();
        String studentDetails = Skills.get(position).getScore() +
                " Score ," +
                Skills.get(position).getCountry();
//        Log.e("ImageUrl", imageUrl);

        Glide.with(context)
                .load(imageUrl)
                .into(holder.badge);
        holder.name.setText(Skills.get(position).getName());

        holder.subtitle.setText(studentDetails);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView badge;
        TextView name, subtitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            badge = (ImageView) itemView.findViewById(R.id.badge);
            name =(TextView) itemView.findViewById(R.id.name);
            subtitle =(TextView) itemView.findViewById(R.id.subtitle);
        }
    }
}
