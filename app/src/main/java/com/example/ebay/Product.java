package com.example.ebay;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    String name,imageurl,amount,id,description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.imageurl);
        dest.writeString(this.amount);
        dest.writeString(this.id);
        dest.writeString(this.description);
    }

    public Product() {
    }

    protected Product(Parcel in) {
        this.name = in.readString();
        this.imageurl = in.readString();
        this.amount = in.readString();
        this.id = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
