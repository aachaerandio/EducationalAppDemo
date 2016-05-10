
package com.aracelimontes.gojimo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Publisher {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("link")
    @Expose
    public String link;

}
