package koogle.ride.share.data

import koogle.ride.share.data.RetrofitService

class Repository constructor(private val retrofitService: RetrofitService) {
    fun getUserHelpList() = retrofitService.getHelpList()
    fun getUserHelpItem(id:Int) = retrofitService.getHelpListUserItem(id)

}
