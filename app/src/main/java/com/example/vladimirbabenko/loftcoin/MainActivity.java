package com.example.vladimirbabenko.loftcoin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private String TAG = this.getClass().getSimpleName();
  private RecyclerView recycler;
  private CoinsAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    adapter = new CoinsAdapter();

    recycler = (RecyclerView) findViewById(R.id.rvRecycler);
    recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    recycler.setAdapter(adapter);

    loadData();
  }

  private void loadData() {
    Api api = ((App) getApplication()).getApi();

    api.ticker().enqueue(new Callback<List<Coin>>() {
      @Override public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
        Log.d(TAG, "onResponse: ");
        List<Coin> coins = response.body();

        Collections.sort(coins, new Comparator<Coin>() {
          @Override public int compare(Coin o1, Coin o2) {
            return Double.compare(o2.priceUsd, o1.priceUsd);
          }
        });

        adapter.setCoins(coins);
      }

      @Override public void onFailure(Call<List<Coin>> call, Throwable t) {
        Log.d(TAG, "onFailure: ");
        Log.d(TAG, "onFailure: ", t);
      }
    });
  }
}
