
package com.example.virtusaicicimvpapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;

import javax.annotation.Generated;

import com.example.virtusaicicimvpapplication.roomDatabase.DataConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Generated("jsonschema2pojo")
public class DataRes extends Observable implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private Integer id;

    @ColumnInfo(name = "page")
    @SerializedName("page")
    @Expose
    private Integer page;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ColumnInfo(name = "per_page")
    @SerializedName("per_page")
    @Expose
    private Integer perPage;

    @ColumnInfo(name = "total")
    @SerializedName("total")
    @Expose
    private Integer total;

    @ColumnInfo(name = "total_pages")
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    @TypeConverters(DataConverter.class)
    @ColumnInfo(name = "data")
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    @Embedded
    @SerializedName("support")
    @Expose
    private Support support;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

}
