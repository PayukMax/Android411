package com.example.prototypeapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsListAdaptor extends RecyclerView.Adapter<UsListAdaptor.MyViewHolder> {

    private List<UsersData> datList;
    private AdminAct activity;
    private DbHelper myDB;

    public UsListAdaptor( DbHelper myDB, AdminAct activity) {
        this.myDB = myDB;
        this.activity = activity;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final UsersData item = datList.get(position);
        String tmp = item.getId()+" - "+item.getName()+" - "+item.getPassw()+" - "+item.getRole();
        holder.user_line.setText(tmp); //
    }

    public Context getContext(){
        return activity;
    }

    public void setUser (List<UsersData> mList){
        this.datList = mList;
        notifyDataSetChanged();
    }

    public void deleteUser(int position){
        UsersData item = datList.get(position);
        myDB.deleteUser(item.getId());
        datList.remove(position);
        notifyItemRemoved(position);
    }

    public void editUser (int position){
        // код при редактировании записи юзера, аналог editItems
        UsersData item = datList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id", item.getId());
        bundle.putString("user", item.getName());
        bundle.putString("passw", item.getPassw());
        bundle.putInt("role", item.getRole());
        AddNewUser nUser = new AddNewUser();
        nUser.setArguments(bundle);
        nUser.show(activity.getSupportFragmentManager(), nUser.getTag());

    }



    @Override
    public int getItemCount() {
        return datList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView user_line;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            user_line = itemView.findViewById(R.id.user_line);
        }
    }
}
