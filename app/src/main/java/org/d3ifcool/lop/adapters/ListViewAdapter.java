package org.d3ifcool.lop.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.databinding.ItemListBinding;
import org.d3ifcool.lop.models.Data;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter {
    private LayoutInflater inflater;
    public ListViewAdapter(@NonNull Context context, @NonNull List<? extends Data> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        Data data = (Data) getItem(position);
        ItemListBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_list,
                parent, false);
        binding.setList(data);
        return binding.getRoot();
    }
}
