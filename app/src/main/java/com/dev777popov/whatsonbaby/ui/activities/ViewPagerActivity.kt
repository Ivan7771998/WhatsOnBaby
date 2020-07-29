package com.dev777popov.whatsonbaby.ui.activities

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.dev777popov.whatsonbaby.R
import com.dev777popov.whatsonbaby.adapters.PagerAdapter
import com.dev777popov.whatsonbaby.ui.fragments.pagersFr.PagerFragment1
import com.dev777popov.whatsonbaby.ui.fragments.pagersFr.PagerFragment2
import com.dev777popov.whatsonbaby.ui.fragments.pagersFr.PagerFragment3
import com.dev777popov.whatsonbaby.ui.fragments.pagersFr.PagerFragment4
import kotlinx.android.synthetic.main.activity_view_pager.*


class ViewPagerActivity : AppCompatActivity() {

    private val PERMISSION_REQUEST_CODE = 10
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        listOf(PagerFragment1(), PagerFragment2(), PagerFragment3(), PagerFragment4()).also {
            pagerAdapter = PagerAdapter(supportFragmentManager, it)
            viewPager.adapter = pagerAdapter
        }

        //viewPager.beginFakeDrag()

        testBtn.setOnClickListener {
            if (viewPager.currentItem != 3 && viewPager.currentItem != 1) {
                viewPager.currentItem++
            } else if (viewPager.currentItem == 1) {
                requestPermissions()
            }
        }
    }

    private fun requestPermissions() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            requestLocation()
        } else {
            requestLocationPermissions()
        }
    }

    private fun requestLocationPermissions() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                    arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ),
                    PERMISSION_REQUEST_CODE
                )
            }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                requestLocation()
            }
        }
    }

    // Запрашиваем координаты
    private fun requestLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) return
        viewPager.currentItem++
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val criteria = Criteria()
        criteria.accuracy = Criteria.ACCURACY_COARSE
        val provider = locationManager.getBestProvider(criteria, true)
        if (provider != null) {
            locationManager.requestLocationUpdates(provider, 20, 1f, object : LocationListener {
                override fun onLocationChanged(location: Location) {

                }

                override fun onStatusChanged(
                    provider: String,
                    status: Int,
                    extras: Bundle
                ) {
                }

                override fun onProviderEnabled(provider: String) {}
                override fun onProviderDisabled(provider: String) {}
            })
        }
    }

}