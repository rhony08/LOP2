package org.d3ifcool.lop.adapters;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.d3ifcool.lop.models.Achievement;
import org.d3ifcool.lop.models.Data;

/**
 * Layout will use this adapter to binding
 */

public class DataBindingAdapter {
    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, Data data){
        if (data instanceof Achievement){
            Log.d("gambar",((Achievement) data).getImage() + "");
            imageView.setImageResource(((Achievement) data).getImage());
        }else{
            imageView.setImageResource(data.getImage());
        }
    }

    @BindingAdapter("android:visibility")
    public static void setVisibility(ImageView imageView, int status){
        if (status == -1) imageView.setVisibility(View.GONE);
        else imageView.setVisibility(View.VISIBLE);
    }
}
