package com.example.picsart.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.picsart.R;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewholder> {

    Context context;
    List<Integer> colorList;

    public ColorAdapter(Context context, ColorAdapterListener listener) {
        this.context = context;
        this.colorList = genColorList();
        this.listener = listener;
    }

    ColorAdapterListener listener;

    @NonNull
    @Override
    public ColorViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.color_item,parent,false);
        return new ColorViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewholder holder, int position) {
        holder.color_section.setCardBackgroundColor(colorList.get(position));

    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ColorViewholder extends RecyclerView.ViewHolder{

        public CardView color_section;
        public ColorViewholder(@NonNull View itemView) {
            super(itemView);
            color_section = itemView.findViewById(R.id.color_section);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onColorSelected(colorList.get(getAdapterPosition()));
                }
            });
        }
    }

    private List<Integer> genColorList(){
        List<Integer> colorList = new ArrayList<>();
        colorList.add(Color.parseColor("#2f2013"));
        colorList.add(Color.parseColor("#4f0b27"));
        colorList.add(Color.parseColor("#465442"));
        colorList.add(Color.parseColor("#1a1410"));
        colorList.add(Color.parseColor("#3a2c23"));
        colorList.add(Color.parseColor("#ea1313"));
        colorList.add(Color.parseColor("#40e0d0"));

        colorList.add(Color.parseColor("#4224ff"));
        colorList.add(Color.parseColor("#ffd700"));
        colorList.add(Color.parseColor("#40e0d0"));
        colorList.add(Color.parseColor("#008080"));
        colorList.add(Color.parseColor("#000080"));
        colorList.add(Color.parseColor("#00ffff"));
        colorList.add(Color.parseColor("#fb9214"));

        colorList.add(Color.parseColor("#fff0f5"));
        colorList.add(Color.parseColor("#3a2c23"));
        colorList.add(Color.parseColor("#ddb897"));
        colorList.add(Color.parseColor("#ffefd5"));
        colorList.add(Color.parseColor("#1a1410"));
        colorList.add(Color.parseColor("#cd853f"));
        colorList.add(Color.parseColor("#ffe4e1"));



        return colorList;
    }

    public interface ColorAdapterListener{
        void onColorSelected(int color);
    }
}
