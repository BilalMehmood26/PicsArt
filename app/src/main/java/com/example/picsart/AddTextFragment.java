package com.example.picsart;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.picsart.Adapter.ColorAdapter;
import com.example.picsart.Interface.AddTextFragmentListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTextFragment extends BottomSheetDialogFragment implements ColorAdapter.ColorAdapterListener {

    int colorSelected = Color.parseColor("#000000");
    AddTextFragmentListener listener;

    EditText edt_add_text;
    RecyclerView recyclerView_color;
    Button btn_done;


    public void setListener(AddTextFragmentListener listener) {
        this.listener = listener;
    }

    static AddTextFragment instance;

    public static AddTextFragment getInstance(){
        if(instance == null)
            instance = new AddTextFragment();
        return instance;
    }

    public AddTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView =  inflater.inflate(R.layout.fragment_add_text, container, false);

        edt_add_text = itemView.findViewById(R.id.edt_add_text);
        recyclerView_color = itemView.findViewById(R.id.recycler_color);
        btn_done = itemView.findViewById(R.id.btn_done);

        recyclerView_color.setHasFixedSize(true);
        recyclerView_color.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        ColorAdapter colorAdapter = new ColorAdapter(getContext(),this);
        recyclerView_color.setAdapter(colorAdapter);

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAddTextButtonClick(edt_add_text.getText().toString(),colorSelected);
            }
        });

        return itemView;
    }

    @Override
    public void onColorSelected(int color) {
        colorSelected = color;

    }
}
