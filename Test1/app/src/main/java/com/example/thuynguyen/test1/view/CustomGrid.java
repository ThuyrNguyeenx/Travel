package com.example.thuynguyen.test1.view;

import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thuynguyen.test1.R;

/**
 * Created by ThuyNguyen on 10/03/2017.
 */
public class CustomGrid extends BaseAdapter {

    private Context context;
    private String[] name;
    private int[] img;
    public  TextView txtName;

    public CustomGrid(Context c, String[] n, int[] i){
        context = c;
        this.name = n;
        this.img = i;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            grid = new View(context);
            grid = inflater.inflate(R.layout.grid_single, null);
            txtName = (TextView) grid.findViewById(R.id.txtName_grid);
            ImageView imgView = (ImageView) grid.findViewById(R.id.img_grid);
            txtName.setText(name[position]);
            imgView.setImageResource(img[position]);
        }else {
            grid = (View) convertView;
        }
        return grid;
    }

}
