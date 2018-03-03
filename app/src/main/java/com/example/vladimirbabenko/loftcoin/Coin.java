package com.example.vladimirbabenko.loftcoin;

import com.google.gson.annotations.SerializedName;

/**
 * Class for Gson
 */


//{
//    "id": "bitcoin",
//    "name": "Bitcoin",
//    "symbol": "BTC",
//    "rank": "1",
//    "price_usd": "10924.7",
//    "price_btc": "1.0",
//    "24h_volume_usd": "7599820000.0",
//    "market_cap_usd": "184582223591",
//    "available_supply": "16895862.0",
//    "total_supply": "16895862.0",
//    "max_supply": "21000000.0",
//    "percent_change_1h": "0.02",
//    "percent_change_24h": "0.47",
//    "percent_change_7d": "6.32",
//    "last_updated": "1520016267"

/*
* Если поля совпадают, тогда всё ок. Иначе необходимо подсказать при помощи аннотауии
* @SerializedName()
*
* */


public class Coin {
    public String id;
    public String name;
    public String symbol;
    @SerializedName("price_usd")
    public double priceUsd;
    @SerializedName("percent_change_24h")
    public double percentChange;
}
