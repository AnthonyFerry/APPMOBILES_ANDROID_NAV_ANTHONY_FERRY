package com.example.anthonyferry.utilisateurs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Anthony FERRY on 08/03/2017.
 */

public class User implements Parcelable {

    private String Name;
    private String Password;
    private String Mail;

    public User(String name, String password, String mail) {
        Name = name;
        Password = password;
        Mail = mail;
    }

    public User (Parcel source)
    {
        Name = source.readString();
        Password = source.readString();
        Mail = source.readString();
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(Name);
        dest.writeString(Password);
        dest.writeString(Mail);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>(){
        @Override
        public User createFromParcel(Parcel source){ return new User(source); }

        @Override
        public User[] newArray(int size) { return new User[size]; }
    };

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getMail() {
        return Mail;
    }
}