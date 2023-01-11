package com.example.tiktokclone.model;



public class MailBox {
    private String label;
    private String description;
    private String date;
    private String image;


    public MailBox(String label,String description,String image, String date) {
        this.label = label;
        this.description = description;
        this.image = image;
        this.date=date;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.label = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}


