
package com.example.virtusaicicimvpapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Generated("jsonschema2pojo")
public class Support implements Serializable
{

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private Integer idSupport;

    @ColumnInfo(name = "url")
    @SerializedName("url")
    @Expose
    private String url;

    @ColumnInfo(name = "text")
    @SerializedName("text")
    @Expose
    private String text;

    public Integer getIdSupport() {
        return idSupport;
    }

    public void setIdSupport(Integer idSupport) {
        this.idSupport = idSupport;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
