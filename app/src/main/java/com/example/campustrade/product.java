package com.example.campustrade;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class product implements Parcelable {
    String name;
    int mobno;
    String spec;
    Bitmap bm;

    public product(String name, int mobno, String spec, Bitmap bm) {
        this.name = name;
        this.mobno = mobno;
        this.spec = spec;
        this.bm = bm;
    }

    protected product(Parcel in) {
        name = in.readString();
        mobno = in.readInt();
        spec = in.readString();
        bm = in.readParcelable(Bitmap.class.getClassLoader());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobno() {
        return mobno;
    }

    public void setMobno(int mobno) {
        this.mobno = mobno;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Bitmap getBm() {
        return bm;
    }

    public void setBm(Bitmap bm) {
        this.bm = bm;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(mobno);
        dest.writeString(spec);
        dest.writeParcelable(bm, flags);
    }
}
