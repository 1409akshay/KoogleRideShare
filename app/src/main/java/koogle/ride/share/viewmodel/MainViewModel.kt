package koogle.ride.share.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import koogle.ride.share.data.Repository
import koogle.ride.share.model.HelpItemResponse
import koogle.ride.share.model.UserHelpList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(val repository: Repository) :ViewModel(){
    val mutableHelpList = MutableLiveData<Response<Response<UserHelpList>>>()
    val mutableHelpItem = MutableLiveData<Response<HelpItemResponse>>()
    val errorMsg = MutableLiveData<String>()

    fun getHelpUserList() {
        val response = repository.getUserHelpList()
        response.enqueue(object : Callback<Response<UserHelpList>> {
            override fun onResponse(
                call: Call<Response<UserHelpList>>,
                response: Response<Response<UserHelpList>>
            ) {
                mutableHelpList.postValue(response)
            }

            override fun onFailure(call: Call<Response<UserHelpList>>, t: Throwable) {
                errorMsg.postValue(t.message)
            }
        })
    }

    fun getUserHelpItem(id: Int) {
        val response = repository.getUserHelpItem(id)
        response.enqueue(object : Callback<Response<HelpItemResponse>> {
            override fun onResponse(
                call: Call<Response<HelpItemResponse>>,
                response: Response<Response<HelpItemResponse>>
            ) {
                mutableHelpItem.postValue(response.body())
            }

            override fun onFailure(call: Call<Response<HelpItemResponse>>, t: Throwable) {
                errorMsg.postValue(t.message)
            }
        })
    }
}