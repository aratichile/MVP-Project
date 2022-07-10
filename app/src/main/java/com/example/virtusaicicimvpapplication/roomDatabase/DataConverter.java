package com.example.virtusaicicimvpapplication.roomDatabase;

import androidx.room.TypeConverter;

import com.example.virtusaicicimvpapplication.model.Datum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class DataConverter implements Serializable {

    @TypeConverter
    public String fromDataList(List<Datum> datum) {
        if (datum == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Datum>>() {
        }.getType();
        String json = gson.toJson(datum, type);
        return json;
    }

    @TypeConverter
    public List<Datum> toDataList(String datumString) {
        if (datumString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Datum>>() {
        }.getType();
        List<Datum> datumList = gson.fromJson(datumString, type);
        return datumList;
    }
}
