package com.example.picsart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picsart.R;

import java.util.ArrayList;
import java.util.List;

public class FrameAdapter extends RecyclerView.Adapter<FrameAdapter.FrameViewHolder> {

    Context context;
    List<Integer> frameList;
    FrameAdapterListener listener;
    int rowSelected = -1;

    public FrameAdapter(Context context, FrameAdapterListener listener) {
        this.context = context;
        this.frameList = getFrameList();
        this.listener = listener;
    }

    private List<Integer> getFrameList() {
        List<Integer> result = new ArrayList<>();
        result.add(R.drawable.card_1_resize);
        result.add(R.drawable.card_2_resize);
        result.add(R.drawable.card_3_resize);
        result.add(R.drawable.card_7_resize);
        result.add(R.drawable.card_1_resize);
        result.add(R.drawable.card_3_resize);
        return result;
    }

    @NonNull
    @Override
    public FrameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(context).inflate(R.layout.frame_item,parent,false);
        return new FrameViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull FrameViewHolder holder, int position) {

        if(rowSelected == position)
            holder.imgCheck.setVisibility(View.VISIBLE);
        else
            holder.imgCheck.setVisibility(View.INVISIBLE);

        holder.imgFrame.setImageResource(frameList.get(position));
    }

    @Override
    public int getItemCount() {
        return frameList.size();
    }

    public class FrameViewHolder  extends RecyclerView.ViewHolder{

        ImageView imgCheck,imgFrame;
        public FrameViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCheck = itemView.findViewById(R.id.img_check);
            imgFrame = itemView.findViewById(R.id.img_frame);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onFrameSelected(frameList.get(getAdapterPosition()));

                    rowSelected = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }

    public interface FrameAdapterListener{
        void onFrameSelected(int frame);

    }
}
