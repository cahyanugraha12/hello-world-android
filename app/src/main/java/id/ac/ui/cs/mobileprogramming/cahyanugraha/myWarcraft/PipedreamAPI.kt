package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PipedreamAPI {
    @POST("/")
    fun postWifiScanResultToPipedream(@Body wifiScanResult: List<String>): Call<Void>
}