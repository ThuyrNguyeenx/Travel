package com.example.thuynguyen.test1.model;

import java.io.Serializable;

/**
 * Created by ThuyNguyen on 10/03/2017.
 */
public class City implements Serializable {
    private int iD;
    private String name, overView;
    private String img;

    public City(int iD, String name, String overView, String img) {
        this.iD = iD;
        this.name = name;
        this.overView = overView;
        this.img = img;
    }

    public City() {

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }
}
