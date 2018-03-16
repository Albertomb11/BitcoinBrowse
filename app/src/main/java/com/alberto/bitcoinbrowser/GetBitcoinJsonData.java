package com.alberto.bitcoinbrowser;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alberto on 16/03/2018.
 */

public class GetBitcoinJsonData extends GetRawData {
    private static final String LOG_TAG = GetBitcoinJsonData.class.getSimpleName();

    private List<Bitcoin> mBitcoin;
    private Uri mDestinationUri;

    public GetBitcoinJsonData(String searchCriteria, boolean matchAll) {
        super(null);
        createAndUpdateUri(searchCriteria, matchAll);
        mBitcoin = new ArrayList<>();
    }

    public List<Bitcoin> getBitcoins() {
        return mBitcoin;
    }

    private boolean createAndUpdateUri(String searchCriteria, boolean matchAll) {
        final String BITCOIN_BASE_API_URL = "https://newsapi.org/v2/everything?q=bitcoin&sortBy=publishedAt&apiKey=d77f743c0e5744b69a87cfbf30108e4e";
        final String TAGS_PARAM = "tags";
        final String TAGMODE_PARAM = "tagmode";
        final String FORMAT_PARAM = "format";
        final String NO_JSON_CALLBACK_PARAM = "nojsoncallback";

        mDestinationUri = Uri.parse(BITCOIN_BASE_API_URL).buildUpon()
                .appendQueryParameter(TAGS_PARAM, searchCriteria)
                .appendQueryParameter(TAGMODE_PARAM, (matchAll?"all":"any"))
                .appendQueryParameter(FORMAT_PARAM, "json")
                .appendQueryParameter(NO_JSON_CALLBACK_PARAM, "1")
                .build();

        return mDestinationUri != null;
    }

    private void processResult() {
        final String BITCOIN_ARTICLES = "articles";
        final String BITCOIN_TITLE = "title";
        final String BITCOIN_PHOTO_URL = "urlToImage";
        final String BITCOIN_AUTHOR = "author";
        final String BITCOIN_DESCRIPTION = "description";
        final String BITCOIN_URL = "url";
        final String BITCOIN_PUBLISHEDAT = "publishedAt";

        if ( getDownloadStatus() != DownloadStatus.OK ) {
            Log.e(LOG_TAG, "No se ha descargado el JSON");
            return;
        }

        try {
            JSONObject jsonData = new JSONObject(getData());
            JSONArray itemsArray = jsonData.getJSONArray(BITCOIN_ARTICLES);

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject jsonBitcoin = itemsArray.getJSONObject(i);
                String image = jsonBitcoin.getString(BITCOIN_PHOTO_URL);
                String title = jsonBitcoin.getString(BITCOIN_TITLE);
                String author = jsonBitcoin.getString(BITCOIN_AUTHOR);
                String description = jsonBitcoin.getString(BITCOIN_DESCRIPTION);
                String url = jsonBitcoin.getString(BITCOIN_URL);
                String publishedAt = jsonBitcoin.getString(BITCOIN_PUBLISHEDAT);

                Bitcoin photo = new Bitcoin(image, title, author, description, url, publishedAt);
                mBitcoin.add(photo);
            }

            for(Bitcoin bitcoin: mBitcoin){
                Log.d(LOG_TAG, "Bitcoin: " + bitcoin.toString());
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "No se puede crear el objeto JSON");
            e.printStackTrace();
        }
    }

    public void execute() {
        DownloadJsonData downloadJsonData = new DownloadJsonData();
        Log.v(LOG_TAG, "Build Uri: " + mDestinationUri.toString());
        downloadJsonData.execute(mDestinationUri.toString());
    }

    public class DownloadJsonData extends DownloadRawData {

        @Override
        protected void onPostExecute(String webData) {
            super.onPostExecute(webData);
            processResult();
        }

        @Override
        protected String doInBackground(String... params) {
            String [] par = { mDestinationUri.toString() };

            return super.doInBackground(par);
        }
    }
}
