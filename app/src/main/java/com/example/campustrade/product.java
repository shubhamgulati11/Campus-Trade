package com.example.campustrade;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class product implements Parcelable {
    String name;
    String mobno;
    String spec;
    String image;

    public product() {
    }

    public product(String name, String mobno, String spec, String image) {
        this.name = name;
        this.mobno = mobno;
        this.spec = spec;
        this.image = image;
    }

    protected product(Parcel in) {
        name = in.readString();
        mobno = in.readString();
        spec = in.readString();
        image = in.readString();
    }

    public static final Creator<product> CREATOR = new Creator<product>() {
        @Override
        public product createFromParcel(Parcel in) {
            return new product(in);
        }

        @Override
        public product[] newArray(int size) {
            return new product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(mobno);
        parcel.writeString(spec);
        parcel.writeString(image);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
