
package com.aracelimontes.gojimo.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Qualification implements Parcelable{

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("country")
    @Expose
    public Country country;
    @SerializedName("subjects")
    @Expose
    public List<Subject> subjects = new ArrayList<>();
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("default_products")
    @Expose
    public List<DefaultProduct> defaultProducts = new ArrayList<>();

    protected Qualification(Parcel in) {
        id = in.readString();
        name = in.readString();
        country = (Country) in.readValue(Country.class.getClassLoader());
        if (in.readByte() == 0x01) {
            subjects = new ArrayList<>();
            in.readList(subjects, Subject.class.getClassLoader());
        } else {
            subjects = null;
        }
        link = in.readString();
        if (in.readByte() == 0x01) {
            defaultProducts = new ArrayList<>();
            in.readList(defaultProducts, DefaultProduct.class.getClassLoader());
        } else {
            defaultProducts = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeValue(country);
        if (subjects == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(subjects);
        }
        dest.writeString(link);
        if (defaultProducts == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(defaultProducts);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Qualification> CREATOR = new Parcelable.Creator<Qualification>() {
        @Override
        public Qualification createFromParcel(Parcel in) {
            return new Qualification(in);
        }

        @Override
        public Qualification[] newArray(int size) {
            return new Qualification[size];
        }
    };

}
