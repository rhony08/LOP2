package org.d3ifcool.lop.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by CHEVALIER-11 on 12-Mar-18.
 */

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.BindingHolder>  {

    @Override
    public TipsAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TipsAdapter.BindingHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BindingHolder extends RecyclerView.ViewHolder {

        public BindingHolder(View itemView) {
            super(itemView);
        }
    }
}
