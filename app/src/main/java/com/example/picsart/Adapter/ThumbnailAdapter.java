package com.example.picsart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picsart.Interface.FiltersListFragmentListener;
import com.example.picsart.R;
import com.zomato.photofilters.utils.ThumbnailItem;

import java.util.List;

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.MyViewHolder> {

    private List<ThumbnailItem> thumbnailItems;
    private FiltersListFragmentListener filterListener;
    private Context context;
    private int selectedIndex = 0;

    public ThumbnailAdapter(List<ThumbnailItem> thumbnailItems, FiltersListFragmentListener filterListener, Context context) {
        this.thumbnailItems = thumbnailItems;
        this.filterListener = filterListener;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.thumbnail_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        final ThumbnailItem thumbnailItem = thumbnailItems.get(position);

        holder.thumbnail.setImageBitmap(thumbnailItem.image);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterListener.onFilterSelected(thumbnailItem.filter);
                selectedIndex = position;
                notifyDataSetChanged();
            }
        });

        holder.filterName.setText(thumbnailItem.filterName);
        if(selectedIndex == position) {
            holder.filterName.setTextColor(ContextCompat.getColor(context, R.color.selected_filter));
        }else{
            holder.filterName.setTextColor(ContextCompat.getColor(context, R.color.normal_filter));
        }
    }

    @Override
    public int getItemCount() {
        return thumbnailItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView thumbnail;
        TextView filterName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            filterName = (TextView) itemView.findViewById(R.id.filter_name);


        }
    }
}
