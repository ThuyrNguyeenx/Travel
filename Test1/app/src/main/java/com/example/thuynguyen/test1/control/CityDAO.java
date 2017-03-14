package com.example.thuynguyen.test1.control;

import android.content.Context;
import android.database.Cursor;

import com.example.thuynguyen.test1.model.City;

import java.util.ArrayList;

/**
 * Created by ThuyNguyen on 12/03/2017.
 */
public class CityDAO extends SQLiteController {
    public CityDAO(Context con) {
        super(con);
    }
    public ArrayList<City> getListCity(){
        ArrayList<City> listCity = new ArrayList<>();
        try {
            openDataBase();
            Cursor cursor = database.rawQuery("Select * from City", null);
            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String overView = cursor.getString(2);
                String img = cursor.getString(3);
                City city = new City(id,name,overView, img);
                listCity.add(city);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return listCity;
    }
    public City getCityByName(String name){
        City city = new City();
        try {
            openDataBase();
            Cursor cursor = database.rawQuery("Select * from City where Name like '"+name+"'",null);
            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String nameC = cursor.getString(1);
                String overView = cursor.getString(2);
                String img = cursor.getString(3);
                city = new City(id,nameC,overView, img);

            }
        }
        catch (Exception e){
            System.out.println("error "+e.getMessage());
        }
        finally {
            close();
        }
        return city;
    }
}
