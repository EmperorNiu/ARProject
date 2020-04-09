package com.example.arproject.homeFragmet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.baidu.location.BDAbstractLocationListener
import com.baidu.location.BDLocation
import com.baidu.location.LocationClient
import com.example.arproject.R
import com.example.arproject.databinding.HomeFragmentBinding
import com.example.arproject.network.Api
import com.example.arproject.network.Building
import com.example.arproject.network.Buildings
import com.example.arproject.network.Position
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : Fragment() {

    companion object {
        fun newInstance() = Home()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val binding:HomeFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.home_fragment,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val mLocationClient: LocationClient = LocationClient(context)
        val myListener: MyLocationListener = MyLocationListener()
        mLocationClient.registerLocationListener(myListener)

        binding.button.setOnClickListener {
            mLocationClient.start()
            Log.d("try","get latitiude")
        }

//        binding.button.setOnClickListener{
////            val building:Building = Building()
//            var position = Position(2.0,2.0)
//            Api.retrofitService.getBuildingId(position).enqueue(
//                object : Callback<Buildings>{
//                    override fun onFailure(call: Call<Buildings>, t: Throwable) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    }
//                    override fun onResponse(call: Call<Buildings>, response: Response<Buildings>) {
//                        binding.titleTextView.text = response.body()?.building_list?.get(0)?.Name
//                        binding.introTextView.text = response.body()?.building_list?.get(0)?.description
//                    }
//                }
//            )
//        }
        return binding.root
    }

    inner class MyLocationListener: BDAbstractLocationListener() {
        override fun onReceiveLocation(location: BDLocation) {
            var latitude = location.getLatitude()
            var longitude = location.getLongitude()
            viewModel.setLatitude(latitude)
            viewModel.setLongitiude(longitude)
            Log.d("position","get latitiude" + latitude.toString())
        }
    }
}