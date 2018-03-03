package com.example.vladimirbabenko.loftcoin;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * interface for voids description
 */

public interface Api {
  /**
   * https://api.coinmarketcap.com/v1/ticker/
   */

  String baseUrl = "https://api.coinmarketcap.com/v1/";

  @GET("ticker") Call<List<Coin>> ticker();
}
