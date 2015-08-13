package com.example.hong611.mylistview.model;

import com.example.hong611.mylistview.R;

/**
 * Created by hong611 on 2015/8/12.
 */
public class ItemModel {
    private String titil;
    private String content;
    private int avatarResId;

    public String getTitil() {
        return titil;
    }

    public void setTitil(String titil) {
        this.titil = titil;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAvatar() {
        return avatarResId;
    }

    public void setAvatar(int avatar) {
        this.avatarResId = avatar;
    }

    public ItemModel(){
        titil="null";
        content="null";
        avatarResId= R.mipmap.ic_launcher;
    }

    public ItemModel(String titil,String content,int avatar){
        this.titil=titil;
        this.content=content;
        this.avatarResId=avatar;
    }
}
