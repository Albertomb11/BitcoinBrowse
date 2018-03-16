package com.alberto.bitcoinbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Alberto on 16/03/2018.
 */

public class ViewBitcoinDetailsActivity extends BaseActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitcoin_details);

        activateToolbarWithBackEnabled();

        Intent intent = getIntent();
        Bitcoin bitcoin = (Bitcoin) intent.getSerializableExtra(BITCOIN_TRANSFER);

        TextView bitcoinTitle = findViewById(R.id.bitcoin_title);
        bitcoinTitle.setText( bitcoin.getmTitle());

        TextView bitcoinAuthor = findViewById(R.id.bitcoin_author);
        bitcoinAuthor.setText( bitcoin.getmAuthor());

        TextView bitcoinDescription = findViewById(R.id.bitcoin_description);
        bitcoinDescription.setText( bitcoin.getmDescription());

        TextView bitcoinUrl = findViewById(R.id.bitcoin_url);
        bitcoinUrl.setText( bitcoin.getmUrl());

        TextView bitcoinPublishedAt = findViewById(R.id.bitcoin_publishedAt);
        bitcoinPublishedAt.setText( bitcoin.getmPublishedAt());

        ImageView bitcoinImage = findViewById(R.id.bitcoin_image);
        Picasso.with(this).load(bitcoin.getmImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(bitcoinImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bitcoin_details, menu);

        return true;
    }
}
