package com.example.instagramclone.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.instagramclone.R;

import java.util.ArrayList;

public class GridImageAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private LayoutInflater mInflater;
    private int layoutResource;
    private ArrayList<String> imgUrls;

    public GridImageAdapter(Context mContext, int layoutResource, ArrayList<String> imgUrls) {
        super(mContext, layoutResource, imgUrls);
        this.mContext = mContext;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutResource = layoutResource;
        this.imgUrls = imgUrls;
    }

    private static class ViewHolder {
        SquareImageView mImage;
        ProgressBar mProgressBar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
        ViewHolder build pattern (Similar to recyclerView)
         */
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mProgressBar = convertView.findViewById(R.id.gridImageProgressBar);
            viewHolder.mImage = convertView.findViewById(R.id.gridImageView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String imgUrl = getItem(position);
        UniversalImageLoader.setImageWithGlide(imgUrl, viewHolder.mImage, mContext, viewHolder.mProgressBar);

        return convertView;
    }
}
