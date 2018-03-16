package com.alberto.bitcoinbrowser;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Alberto on 16/03/2018.
 */

public class BitcoinRecyclerViewAdapter extends RecyclerView.Adapter<BitcoinRecyclerViewHolder> {
    private static final String LOG_TAG = BitcoinRecyclerViewAdapter.class.getSimpleName();

    private List<Bitcoin> mBitcoinList;
    private Context mContext;

    public BitcoinRecyclerViewAdapter(Context context, List<Bitcoin> bitcoinList){
        mBitcoinList = bitcoinList;
        mContext = context;
    }

    @Override
    public BitcoinRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.browse, null, false);

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(lp);

        BitcoinRecyclerViewHolder bitcoinRecyclerViewHolder = new BitcoinRecyclerViewHolder(view);

        return bitcoinRecyclerViewHolder;
    }

    @Override
    public int getItemCount() {
        return (mBitcoinList != null ? mBitcoinList.size() : 0) ;
    }

    @Override
    public void onBindViewHolder(BitcoinRecyclerViewHolder holder, int position) {
        Bitcoin bitcoinItem = mBitcoinList.get(position);

        Log.d(LOG_TAG, "Processing: " + bitcoinItem.getmTitle() + "->" + Integer.toString(position));

        Picasso.with(mContext).load(bitcoinItem.getmImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.getmImageBrowse());

        holder.mTitle.setText(bitcoinItem.getmTitle());
    }

    public void loadNewData(List<Bitcoin> bitcoins){
        mBitcoinList = bitcoins;

        notifyDataSetChanged();
    }

    public Bitcoin getBitcoin(int position){
        return (mBitcoinList != null ? mBitcoinList.get(position) : null );
    }
}
