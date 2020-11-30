package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var wifiScanReceiver: WifiScanReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        val wifiScanReceiver = WifiScanReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        registerReceiver(wifiScanReceiver, intentFilter)

        binding.buttonScanWifi.setOnClickListener {
            val wifiScanSuccess = wifiManager.startScan()
            if (wifiScanSuccess) {
                Toast
                    .makeText(this, "Scanning for WIFI, please wait.", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast
                    .makeText(this, "Failed to scan for WIFI.", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiScanReceiver)
    }

    inner class WifiScanReceiver: BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val wifiManager = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val listOfWifiNames = wifiManager.scanResults.map {
                it.SSID
            }
            if (listOfWifiNames.isNotEmpty()) {
                binding.textViewScanResult.text = listOfWifiNames.toString()
            }

            val pipedreamAPI = Retrofit.Builder()
                .baseUrl("https://en5vl1141xhb5q2.m.pipedream.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PipedreamAPI::class.java)
            Toast
                .makeText(context, "Sending WIFI scan result to Pipedream!", Toast.LENGTH_LONG)
                .show()
            GlobalScope.launch(Dispatchers.IO) {
                pipedreamAPI.postWifiScanResultToPipedream(listOfWifiNames).execute()
            }
        }
    }
}