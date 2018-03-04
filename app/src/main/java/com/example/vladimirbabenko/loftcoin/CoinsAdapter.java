package com.example.vladimirbabenko.loftcoin;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.CoinsViewHolder> {

  private List<Coin> coins = Collections.EMPTY_LIST;

  // Сщздаёт холдер
  @Override public CoinsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = null;
    //        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    //        view = inflater.inflate(R.layout.item_coin, parent);
    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coin, parent, false);
    return new CoinsViewHolder(view);
  }

  // Наполняет ViewHolder данными
  @Override public void onBindViewHolder(CoinsViewHolder holder, int position) {
    holder.bind(coins.get(position));
  }

  // Возвращаем количество монет.
  @Override public int getItemCount() {
    return coins.size();
  }

  public void setCoins(List<Coin> coins) {
    this.coins = coins;
    notifyDataSetChanged();
  }
  // Внутренний статический клас, которыйм наполняется

  static class CoinsViewHolder extends RecyclerView.ViewHolder {

    private TextView symbol;
    private TextView name;
    private TextView price;
    private TextView percentChange;
    private Random random = new Random();
    private static int[] colors =
        {0xFF9C27B0, 0xFF673Ab7, 0xFF2196F3, 0xFF009688, 0xFFFFC107, 0xFFFF9800 };
    private Context context;

    public CoinsViewHolder(View itemView) {
      super(itemView);
      context = itemView.getContext();
      symbol = (TextView) itemView.findViewById(R.id.tvSymbol);
      name = (TextView) itemView.findViewById(R.id.tvName);
      price = (TextView) itemView.findViewById(R.id.tvPrice);
      percentChange = (TextView) itemView.findViewById(R.id.tvChange);
    }

    public void bind(Coin coin) {
      symbol.setText(coin.symbol);
      Drawable background = symbol.getBackground();
      Drawable wrapper = DrawableCompat.wrap(background);
      DrawableCompat.setTint(wrapper, colors[random.nextInt(colors.length)]);

      name.setText(coin.name);

      price.setText(context.getString(R.string.price, coin.priceUsd));
      percentChange.setText(context.getString(R.string.percent_change, coin.percentChange));

      if (coin.percentChange >= 0)
        percentChange.setTextColor(context.getResources().getColor(R.color.percentChangePositive));
       else
        percentChange.setTextColor(context.getResources().getColor(R.color.percentChangeNegative));
    }
  }
}
