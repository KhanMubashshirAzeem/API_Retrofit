package com.example.api_retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.userHolder> {

    MainActivity mainActivity;
    List<UserModel> userModels;

    public Adapter(MainActivity mainActivity, List<UserModel> userModels) {
        this.mainActivity = mainActivity;
        this.userModels = userModels;
    }

    @NonNull
    @Override
    public Adapter.userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(mainActivity).inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.userHolder holder, int position) {
        holder.itemTxt.setText(userModels.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public static class userHolder extends RecyclerView.ViewHolder {
        TextView itemTxt;

        public userHolder(@NonNull View itemView) {
            super(itemView);
            itemTxt = itemView.findViewById(R.id.textView);
        }
    }
}
