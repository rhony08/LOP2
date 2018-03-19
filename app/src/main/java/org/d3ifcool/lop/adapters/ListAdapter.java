package org.d3ifcool.lop.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.databinding.ItemListBinding;
import org.d3ifcool.lop.models.Data;

import java.util.List;

/**
 * Created by CHEVALIER-11 on 12-Mar-18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.BindingHolder> {
    private List<? extends Data> mList;

    public ListAdapter(List<? extends Data> mList) {
        this.mList = mList;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list,
                        parent, false);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.binding.setList(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    static class BindingHolder extends RecyclerView.ViewHolder {

        final ItemListBinding binding;

        public BindingHolder(ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
