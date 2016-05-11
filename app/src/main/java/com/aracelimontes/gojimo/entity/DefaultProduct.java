
package com.aracelimontes.gojimo.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefaultProduct implements Parcelable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("ios_iap_id")
    @Expose
    public String iosIapId;
    @SerializedName("store_ids")
    @Expose
    public List<Object> storeIds = new ArrayList<Object>();
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("assets")
    @Expose
    public List<Asset> assets = new ArrayList<Asset>();
    @SerializedName("publisher")
    @Expose
    public Publisher publisher;
    @SerializedName("author")
    @Expose
    public String author;


    protected DefaultProduct(Parcel in) {
        id = in.readString();
        title = in.readString();
        link = in.readString();
        iosIapId = in.readString();
        if (in.readByte() == 0x01) {
            storeIds = new ArrayList<Object>();
            in.readList(storeIds, Object.class.getClassLoader());
        } else {
            storeIds = null;
        }
        type = in.readString();
        if (in.readByte() == 0x01) {
            assets = new ArrayList<Asset>();
            in.readList(assets, Asset.class.getClassLoader());
        } else {
            assets = null;
        }
        publisher = (Publisher) in.readValue(Publisher.class.getClassLoader());
        author = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(link);
        dest.writeString(iosIapId);
        if (storeIds == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(storeIds);
        }
        dest.writeString(type);
        if (assets == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(assets);
        }
        dest.writeValue(publisher);
        dest.writeString(author);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DefaultProduct> CREATOR = new Parcelable.Creator<DefaultProduct>() {
        @Override
        public DefaultProduct createFromParcel(Parcel in) {
            return new DefaultProduct(in);
        }

        @Override
        public DefaultProduct[] newArray(int size) {
            return new DefaultProduct[size];
        }
    };
}
