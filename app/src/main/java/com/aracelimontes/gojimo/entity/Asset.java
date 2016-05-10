
package com.aracelimontes.gojimo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Asset {

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

}
