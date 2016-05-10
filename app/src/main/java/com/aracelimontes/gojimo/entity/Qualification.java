
package com.aracelimontes.gojimo.entity;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Qualification {

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

}
