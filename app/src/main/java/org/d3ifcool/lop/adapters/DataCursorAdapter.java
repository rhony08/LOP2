package org.d3ifcool.lop.adapters;

import android.content.Context;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.database.LopContract;
import org.d3ifcool.lop.databinding.ItemListBinding;
import org.d3ifcool.lop.models.Data;

/**
 * Created by CHEVALIER-11 on 25-Apr-18.
 */

public class DataCursorAdapter extends CursorAdapter {

    public DataCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_data, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String title = cursor.getString(cursor.getColumnIndex(LopContract.LopEntry.COLUMN_TITLE));
        String desc = cursor.getString(cursor.getColumnIndex(LopContract.LopEntry.COLUMN_DESC));
        int status = cursor.getInt(cursor.getColumnIndex(LopContract.LopEntry.COLUMN_STATUS));
        int id = cursor.getInt(cursor.getColumnIndex(LopContract.LopEntry._ID));

        Data data = new Data(id, title, desc, status);

        TextView nameTextView = view.findViewById(R.id.title);
        nameTextView.setText(data.getName());

        TextView breedTextView = view.findViewById(R.id.desc);
        breedTextView.setText(data.getDesc());

        ImageView imageView = view.findViewById(R.id.img);
        if (data.getImage() == -1) {
            imageView.setVisibility(View.GONE);
        }else imageView.setImageResource(data.getImage());
    }
}
