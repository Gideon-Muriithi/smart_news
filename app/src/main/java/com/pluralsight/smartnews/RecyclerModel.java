package com.pluralsight.smartnews;

public class RecyclerModel {

    private int image;
    String text;

    public RecyclerModel(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }


}
