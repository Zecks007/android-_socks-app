package com.ger.stockwatch;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StockAdapter  extends RecyclerView.Adapter<StockAdapter.ViewHolder> {
    private ArrayList<Stock> stocksarray;
    private final MainActivity Main;

    public StockAdapter(ArrayList<Stock> stocksarray, MainActivity main) {
        this.stocksarray = stocksarray;
        Main = main;
    }

    @NonNull
    @Override
    public StockAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.stockitem,parent,false);
        view.setOnClickListener(Main);
            view.setOnLongClickListener(Main);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockAdapter.ViewHolder holder, int position) {
        Stock st=stocksarray.get(position);
        holder.symboL.setText(st.getSymbol());
        holder.companY.setText(st.getCompany());
        holder.pricE.setText(String.valueOf(st.getPrice()));

        if (st.getPriceChange()<0)
        {

            holder.pricechangE.setText("▼ "+ String.valueOf(st.getPriceChange())+"("+String.valueOf(st.getChangePercentage())+"%)");
            holder.symboL.setTextColor(Color.parseColor("#C60505"));   //red  color
            holder.companY.setTextColor(Color.parseColor("#C60505"));
            holder.pricE.setTextColor(Color.parseColor("#C60505"));
            holder.pricechangE.setTextColor(Color.parseColor("#C60505"));

        }
        else
        {
            //color #059C0B green
            holder.pricechangE.setText("▲ "+ String.valueOf(st.getPriceChange())+"("+String.valueOf(st.getChangePercentage())+"%)");

            holder.symboL.setTextColor(Color.parseColor("#059C0B"));
            holder.companY.setTextColor(Color.parseColor("#059C0B"));
            holder.pricE.setTextColor(Color.parseColor("#059C0B"));
            holder.pricechangE.setTextColor(Color.parseColor("#059C0B"));

        }


    }

    @Override
    public int getItemCount() {
        return stocksarray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView symboL;
        TextView companY;
        TextView pricE;
        TextView pricechangE;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            symboL=itemView.findViewById(R.id.stocksymbol);
            companY=itemView.findViewById(R.id.companyname);
            pricE=itemView.findViewById(R.id.stockprice);
            pricechangE=itemView.findViewById(R.id.stockchange);


        }
    }
}
