package com.example.arproject.homeFragmet

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.baidu.location.BDAbstractLocationListener
import com.baidu.location.BDLocation
import com.baidu.location.LocationClient
import com.example.arproject.R
import com.example.arproject.databinding.HomeFragmentBinding


class Home : Fragment() {

    companion object {
        fun newInstance() = Home()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val binding:HomeFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.home_fragment,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val mLocationClient: LocationClient = LocationClient(context)
        val myListener: MyLocationListener = MyLocationListener()
        mLocationClient.registerLocationListener(myListener)
        mLocationClient.start()
        return binding.root
    }

    inner class MyLocationListener: BDAbstractLocationListener() {
        override fun onReceiveLocation(location: BDLocation) {
            var latitude = location.getLatitude()
            var longitude = location.getLongitude()
            viewModel.setLatitude(latitude)
            viewModel.setLongitiude(longitude)
        }
    }
}