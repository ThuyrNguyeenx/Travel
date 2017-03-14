package com.example.thuynguyen.test1.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.thuynguyen.test1.R;

/**
 * Created by ThuyNguyen on 10/03/2017.
 */
public class CustomSlideAdapter extends PagerAdapter {

    private int[] listImg = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};
    private Context context;
    private LayoutInflater inflater;

    public CustomSlideAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return listImg.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout, container, false);
        ImageView img = (ImageView) view.findViewById(R.id.img_slide);
        img.setImageResource(listImg[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
