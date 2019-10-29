package com.example.supot.listviewadvanec;

public class DataModel {
    private int image;
    private String name;
    private String subtitle;
    private boolean isSelected;

    public String getName() { return name;}
    public void setNamel(String name) {
        this.name =  name;
    }

    public String getSubtitle() {
        return subtitle;
    }
    public void setSubtitll(String subtitle) {
        this.subtitle =  subtitle;
    }

    public int getImg() {
        return image;
    }
    public void setImgl(int image) {
        this.image = image;
    }

    public boolean getSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
