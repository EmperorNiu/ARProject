package com.example.arproject.homeFragmet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arproject.network.Api
import com.example.arproject.network.Buildings
import com.example.arproject.network.Position
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _latitude: MutableLiveData<Double>
            by lazy { MutableLiveData<Double>().also { it.value = 5.23 }}
    val latitude: LiveData<Double>
        get() = _latitude

    private val _longitiude: MutableLiveData<Double>
            by lazy { MutableLiveData<Double>().also { it.value = 1.02 }}
    val longitiude: LiveData<Double>
        get() = _longitiude

    private val _buildingName: MutableLiveData<String>
            by lazy { MutableLiveData<String>().also { it.value = "建筑名称" }}
    val buildingName: LiveData<String>
        get() = _buildingName

    fun setLatitude(x:Double){
        _latitude.value = x
    }
    fun setLongitiude(x:Double){
        _longitiude.value = x
    }
    fun getBuildingInfo() {
        _latitude.value = _latitude.value?.plus(1.0) // 测试用
        var position = Position(2.0,2.0) //使用位置信息获取附近建筑
        Api.retrofitService.getBuildingId(position).enqueue(
            object: Callback<Buildings> {
                override fun onFailure(call: Call<Buildings>, t: Throwable) {
                }

                override fun onResponse(call: Call<Buildings>, response: Response<Buildings>) {
                    _buildingName.value = response.body()?.building_list?.get(0)?.Name
                }
            })
    }
}