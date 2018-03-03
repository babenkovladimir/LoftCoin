package com.example.vladimirbabenko.loftcoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private String TAG = this.getClass().getSimpleName();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Api api = ((App) getApplication()).getApi();
    api.ticker().enqueue(new Callback<List<Coin>>() {
      @Override public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
        Log.d(TAG, "onResponse: ");

        List<Coin> coins = response.body();
      }

      @Override public void onFailure(Call<List<Coin>> call, Throwable t) {
        Log.d(TAG, "onFailure: ");
        Log.d(TAG, "onFailure: ", t);

      }
    });
  }
}
