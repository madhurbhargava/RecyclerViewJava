package com.example.madhurbhargava.recyclerviewjava.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.madhurbhargava.recyclerviewjava.R;
import com.example.madhurbhargava.recyclerviewjava.model.Cryptocurrency;

import java.util.List;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder> {

    private List<Cryptocurrency> mCurrencyList;

    public static class CryptoViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public CryptoViewHolder(TextView itemView) {
            super(itemView);
            mTextView = itemView;
        }
    }

    public CryptoAdapter(List<Cryptocurrency> currencies) {
        mCurrencyList = currencies;
    }

    @NonNull
    @Override
    public CryptoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.crypto_textview, parent, false);
        CryptoViewHolder viewHolder = new CryptoViewHolder(textView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoViewHolder holder, int position) {
        holder.mTextView.setText(mCurrencyList.get(position).getName()+":"+"$"+mCurrencyList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return mCurrencyList.size();
    }
}
