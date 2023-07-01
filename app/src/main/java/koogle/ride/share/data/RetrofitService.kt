package koogle.ride.share.data

import koogle.ride.share.model.HelpItemResponse
import koogle.ride.share.model.UserHelpList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    //first endpoint
    @GET("userhelplist")
    fun getHelpList(): Call<Response<UserHelpList>>

    //api for getting specific item with refrence to userId
    @GET("userhelpdescription")
    fun getHelpListUserItem(@Query("user_help_id") id:Int):Call<Response<HelpItemResponse>>
}