package koogle.ride.share.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkBuilder {
    private val BASE_URL = "https://staging.cabme.com.au/api/"
    var retrofitService: RetrofitService? = null
    fun getInstance(): RetrofitService {
        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitService = retrofit.create(RetrofitService::class.java)
        }
        return retrofitService!!
    }

}