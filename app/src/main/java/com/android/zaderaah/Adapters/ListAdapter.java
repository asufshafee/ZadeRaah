package com.android.zaderaah.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.android.zaderaah.Database.DBManager;
import com.android.zaderaah.Details;
import com.android.zaderaah.Objects.DuaObj;
import com.android.zaderaah.R;
import com.android.zaderaah.Session.MyApplication;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private List<DuaObj> mDataset;
    MyApplication myApplication;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Name;
        public ImageView Image;
        MaterialFavoriteButton Fav;


        public MyViewHolder(View v) {
            super(v);
            Fav = v.findViewById(R.id.Favourite);
            Name = v.findViewById(R.id.Name);

        }
    }

    Activity activity;
    DBManager dbManager;

    public ListAdapter(List<DuaObj> myDataset, Activity activity, DBManager dbManager) {
        mDataset = myDataset;
        this.activity = activity;
        this.dbManager = dbManager;
        myApplication = (MyApplication) activity.getApplicationContext();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if (myApplication.getLanguage().equals("Eng"))
            holder.Name.setText(mDataset.get(position).getEngTittle());
        else holder.Name.setText(mDataset.get(position).getUrduTittle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myApplication.setCurrent(mDataset.get(position));
                activity.startActivity(new Intent(activity.getApplicationContext(), Details.class));

            }
        });

        if (mDataset.get(position).getFav().equals("true")) {
            holder.Fav.setFavorite(true);
        } else {
            holder.Fav.setFavorite(false);
        }


        holder.Fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mDataset.get(position).getFav().equals("true")) {
                    holder.Fav.setFavorite(true);
                    dbManager.update(Long.valueOf(mDataset.get(position).getID()), true);
                    mDataset.get(position).setFav(String.valueOf(true));

                } else {
                    holder.Fav.setFavorite(false);
                    dbManager.update(Long.valueOf(mDataset.get(position).getID()), false);
                    mDataset.get(position).setFav(String.valueOf(false));

                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}