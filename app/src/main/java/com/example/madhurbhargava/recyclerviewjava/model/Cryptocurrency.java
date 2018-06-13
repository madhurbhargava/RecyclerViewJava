package com.example.madhurbhargava.recyclerviewjava.model;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;


import com.google.gson.annotations.SerializedName;

public class Cryptocurrency {

    public static DiffUtil.ItemCallback<Cryptocurrency> DIFF_CALLBACK = new DiffUtil.ItemCallback<Cryptocurrency>() {
        @Override
        public boolean areItemsTheSame(@NonNull Cryptocurrency oldItem, @NonNull Cryptocurrency newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Cryptocurrency oldItem, @NonNull Cryptocurrency newItem) {
            return oldItem.equals(newItem);
        }
    };

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;


    @SerializedName("price_usd")
    Double price;

    @SerializedName("symbol")
    String symbol;

    @SerializedName("rank")
    Integer rank;

    public Cryptocurrency(String id, String name, Double price, String symbol) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
