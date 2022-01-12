package com.example.practiceproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practiceproject.di.RetroServiceInterface
import com.example.practiceproject.models.ListData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var mService: RetroServiceInterface

    lateinit var liveDataList: MutableLiveData<ListData>

    init {
        // here we need to init application class
        (application as MyApplication).getRetroComponent().inject(this)
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<ListData>{
        return liveDataList
    }

    fun makeApiCall(){

        val call: Call<ListData> = mService.getDataFromAPI("newyork")
        call.enqueue(object : Callback<ListData>{
            override fun onResponse(call: Call<ListData>, response: Response<ListData>) {
                if(response.isSuccessful){
                    liveDataList.postValue(response.body())
                }
                else{
                    liveDataList.postValue(null)
                }
            }

            override fun onFailure(call: Call<ListData>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })


    }
}