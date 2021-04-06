package com.example.picsart;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.picsart.Interface.EditImageFragmentListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditImageFragment extends BottomSheetDialogFragment implements SeekBar.OnSeekBarChangeListener {

    private EditImageFragmentListener listener;
    SeekBar seekbarBrightness, seekbarConstrant, seekbarSaturation;

    public void setListener(EditImageFragmentListener listener) {
        this.listener = listener;
    }

    static EditImageFragment instance;

    public static EditImageFragment getInstance(){
        if(instance == null)
            instance = new EditImageFragment();
        return instance;
    }

    public EditImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_edit_image, container, false);
        seekbarBrightness = itemView.findViewById(R.id.brightness_seekbar);
        seekbarConstrant = itemView.findViewById(R.id.constraint_seekbar);
        seekbarSaturation = itemView.findViewById(R.id.saturation_seekbar);


        seekbarBrightness.setMax(200);
        seekbarBrightness.setProgress(100);

        seekbarConstrant.setMax(20);
        seekbarConstrant.setProgress(0);

        seekbarSaturation.setMax(30);
        seekbarSaturation.setProgress(10);

        seekbarSaturation.setOnSeekBarChangeListener(this);
        seekbarConstrant.setOnSeekBarChangeListener(this);
        seekbarBrightness.setOnSeekBarChangeListener(this);

        return itemView;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if(listener != null)
        {
            if(seekBar.getId() == R.id.brightness_seekbar)
            {
                listener.onBrightnessChanged(progress-100);

            }else if(seekBar.getId() == R.id.constraint_seekbar)
            {
                progress+=10;
                float value  = .10f*progress;
                listener.onConstrantChanged(value);

            }else if(seekBar.getId() == R.id.saturation_seekbar)
            {
                float value = .10f*progress;
                listener.onSaturationChanged(value);
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        if(listener != null){
            listener.onEditStarted();
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        if(listener != null){
            listener.onEditComplete();
        }
    }

    public void resetControls(){
        seekbarBrightness.setProgress(100);
        seekbarConstrant.setProgress(0);
        seekbarSaturation.setProgress(10);

    }
}
