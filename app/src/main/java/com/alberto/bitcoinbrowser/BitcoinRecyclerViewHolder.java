package com.alberto.bitcoinbrowser;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alberto on 16/03/2018.
 */

public class BitcoinRecyclerViewHolder extends RecyclerView.ViewHolder{
    private ImageView mImageBrowse;
    public TextView mTitle;

    public BitcoinRecyclerViewHolder(View itemView){
        super(itemView);
        mImageBrowse = itemView.findViewById(R.id.imageViewBrowse);
        mTitle = itemView.findViewById(R.id.textViewTitle);
    }

    public ImageView getmImageBrowse(){
        return mImageBrowse;
    }
}
