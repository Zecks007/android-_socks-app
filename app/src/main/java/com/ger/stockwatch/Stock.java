package com.ger.stockwatch;

import android.os.Parcel;
import android.os.Parcelable;
//Modal class for Stocks
public class Stock implements Parcelable {
    private  String symbol;
    private  String company;
    private  double price;
    private  double priceChange;
    private  double changePercentage;

    public Stock(String symbol, String company, double price, double priceChange, double changePercentage) {
        this.symbol = symbol;
        this.company = company;
        this.price = price;
        this.priceChange = priceChange;
        this.changePercentage = changePercentage;
    }

    protected Stock(Parcel in) {
        symbol = in.readString();
        company = in.readString();
        price = in.readDouble();
        priceChange = in.readDouble();
        changePercentage = in.readDouble();
    }

    public static final Creator<Stock> CREATOR = new Creator<Stock>() {
        @Override
        public Stock createFromParcel(Parcel in) {
            return new Stock(in);
        }

        @Override
        public Stock[] newArray(int size) {
            return new Stock[size];
        }
    };

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(double priceChange) {
        this.priceChange = priceChange;
    }

    public double getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(double changePercentage) {
        this.changePercentage = changePercentage;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(symbol);
        parcel.writeString(company);

        parcel.writeDouble(price);
        parcel.writeDouble(priceChange);
        parcel.writeDouble(changePercentage);


    }
}
