package com.example.vladimirbabenko.loftcoin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.CoinsViewHolder> {

    private List<Coin> coins = Collections.EMPTY_LIST;

    // Сщздаёт холдер
    @Override
    public CoinsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

//        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        view = inflater.inflate(R.layout.item_coin, parent);

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coin, parent, false);

        return new CoinsViewHolder(view);
    }

    // Наполняет ViewHolder данными
    @Override
    public void onBindViewHolder(CoinsViewHolder holder, int position) {
        holder.bind(coins.get(position));
    }


    // Возвращаем количество монет.
    @Override
    public int getItemCount() {
        return coins.size();
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
        notifyDataSetChanged();
    }

    static class CoinsViewHolder extends RecyclerView.ViewHolder {

        private TextView symbol;
        private TextView name;
        private TextView price;
        private TextView percentChange;


        public CoinsViewHolder(View itemView) {
            super(itemView);

            symbol = (TextView)itemView.findViewById(R.id.tvSymbol);
            name = (TextView)itemView.findViewById(R.id.tvName);
            price = (TextView)itemView.findViewById(R.id.tvPrice);
            percentChange = (TextView)itemView.findViewById(R.id.tvChange);
        }

        public void bind(Coin coin){

        }
    }
}
