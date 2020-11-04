package com.example.vjezba2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GitAdapter extends RecyclerView.Adapter<GitAdapter.GitViewHolder> {
    private ArrayList<GitData> mDataset;
    @NonNull
    @Override
    public GitAdapter.GitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCell = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.git_main,parent,false);
        //viewCell.setBackgroundColor(0xff888888);
        GitViewHolder viewHolder = new GitViewHolder(viewCell);
        return viewHolder;
    }

    public static class GitViewHolder extends  RecyclerView.ViewHolder {

        public TextView repoName;
        public TextView ownerName;
        public TextView starsOfRepo;
        public ImageView avatar;
        public GitViewHolder(View v){
            super(v);
            repoName = v.findViewById(R.id.repositoryName);
            ownerName = v.findViewById(R.id.ownerName);
            starsOfRepo = v.findViewById(R.id.starCount);
            avatar = v.findViewById(R.id.avatarImage);

        };

    }
    public GitAdapter(ArrayList<GitData> myDataset){
        this.mDataset = myDataset;

    }

    @Override
    public void onBindViewHolder(@NonNull GitViewHolder holder, int position) {
        holder.ownerName.setText(mDataset.get(position).nameOfOwner);
        holder.repoName.setText(mDataset.get(position).nameOfRepository);
        holder.starsOfRepo.setText(mDataset.get(position).starsOfRepository.toString());
        holder.avatar.setImageResource(mDataset.get(position).avatar);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
