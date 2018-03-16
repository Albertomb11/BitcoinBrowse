package com.alberto.bitcoinbrowser;

import java.io.Serializable;

/**
 * Created by Alberto on 16/03/2018.
 */

public class Bitcoin implements Serializable {

    private static final long serialVersionUID = -7141431412425049771L;

    private String mImage;
    private String mTitle;
    private String mAuthor;
    private String mDescription;
    private String mUrl;
    private String mPublishedAt;

    public Bitcoin(String mImage, String mTitle, String mAuthor, String mDescription, String mUrl, String mPublishedAt) {
        this.mImage = mImage;
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mDescription = mDescription;
        this.mUrl = mUrl;
        this.mPublishedAt = mPublishedAt;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmPublishedAt() {
        return mPublishedAt;
    }

    public void setmPublishedAt(String mPublishedAt) {
        this.mPublishedAt = mPublishedAt;
    }

    @Override
    public String toString() {
        return "Bitcoin{" +
                "mImage='" + mImage + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mPublishedAt='" + mPublishedAt + '\'' +
                '}';
    }
}
