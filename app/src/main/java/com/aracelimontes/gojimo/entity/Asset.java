
package com.aracelimontes.gojimo.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Asset implements Parcelable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("copyright")
    @Expose
    public Object copyright;
    @SerializedName("meta")
    @Expose
    public String meta;
    @SerializedName("size")
    @Expose
    public Integer size;
    @SerializedName("content_type")
    @Expose
    public String contentType;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("path")
    @Expose
    public String path;
    @SerializedName("unzipped_base_url")
    @Expose
    public Object unzippedBaseUrl;
    @SerializedName("info")
    @Expose
    public List<Object> info = new ArrayList<Object>();
    @SerializedName("link")
    @Expose
    public String link;


    protected Asset(Parcel in) {
        id = in.readString();
        copyright = (Object) in.readValue(Object.class.getClassLoader());
        meta = in.readString();
        size = in.readByte() == 0x00 ? null : in.readInt();
        contentType = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        path = in.readString();
        unzippedBaseUrl = (Object) in.readValue(Object.class.getClassLoader());
        if (in.readByte() == 0x01) {
            info = new ArrayList<Object>();
            in.readList(info, Object.class.getClassLoader());
        } else {
            info = null;
        }
        link = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeValue(copyright);
        dest.writeString(meta);
        if (size == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(size);
        }
        dest.writeString(contentType);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(path);
        dest.writeValue(unzippedBaseUrl);
        if (info == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(info);
        }
        dest.writeString(link);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Asset> CREATOR = new Parcelable.Creator<Asset>() {
        @Override
        public Asset createFromParcel(Parcel in) {
            return new Asset(in);
        }

        @Override
        public Asset[] newArray(int size) {
            return new Asset[size];
        }
    };
}
