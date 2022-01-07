package com.pluralsight.smartnews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<RecyclerModel> mRecyclerModels;
    private Context mContext;

    public RecyclerAdapter(Context context, ArrayList<RecyclerModel> arrayListModel) {
        this.mContext = context;
        this.mRecyclerModels = arrayListModel;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        final RecyclerModel recyclerModel = mRecyclerModels.get(position);

        holder.textView.setText(recyclerModel.getText());
        Glide.with(mContext)
                .load(recyclerModel.getImage())
                .into(holder.imageView);

        holder.relativeLayout.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, NewsDescription.class);
            intent.putExtra("text", mRecyclerModels.get(position).getText());
            intent.putExtra("image", mRecyclerModels.get(position).getImage());

//            Toast.makeText(mContext, String.valueOf(mRecyclerModels.get(position).getImage()), Toast.LENGTH_SHORT).show();
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mRecyclerModels.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        RelativeLayout relativeLayout;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
            relativeLayout = itemView.findViewById(R.id.recycler);

        }
    }
}
