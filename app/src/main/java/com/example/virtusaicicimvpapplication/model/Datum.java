
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
public class Datum implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private Integer id;

    @ColumnInfo(name = "email")
    @SerializedName("email")
    @Expose
    private String email;

    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    @Expose
    private String firstName;

    @ColumnInfo(name = "last_name")
    @SerializedName("last_name")
    @Expose
    private String lastName;

    @ColumnInfo(name = "avatar")
    @SerializedName("avatar")
    @Expose
    private String avatar;
    private final static long serialVersionUID = -8079886501448747908L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
