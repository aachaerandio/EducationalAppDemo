
package com.aracelimontes.gojimo.entity;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefaultProduct {

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

}
