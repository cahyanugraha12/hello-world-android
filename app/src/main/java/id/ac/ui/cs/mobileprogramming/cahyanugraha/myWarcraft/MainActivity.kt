package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {
    private lateinit var showLocationButton: Button
    lateinit var locationTextView: TextView
    lateinit var fusedLocationClient: FusedLocationProviderClient
    private val ACCESS_LOCATION_REQUEST_CODE: Int = 1204

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        this.showLocationButton = findViewById(R.id.showLocationButton)
        this.locationTextView = findViewById(R.id.locationTextView)

        this.showLocationButton.setOnClickListener {
            getLocation()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            ACCESS_LOCATION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty()
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED
                ) {
                    getLocation()
                } else {
                    Toast
                        .makeText(this, "Permissions to check location are not granted!", Toast.LENGTH_SHORT)
                        .show()
                }
                return
            }
        }
    }

    private fun getLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                Array<String>(2) {
                    Manifest.permission.ACCESS_FINE_LOCATION
                    Manifest.permission.ACCESS_COARSE_LOCATION
                },
                ACCESS_LOCATION_REQUEST_CODE)
        } else {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    if (location != null) {
                        val loc = "Latitude: "
                            .plus(location.latitude.toString())
                            .plus(" | Longitude: ")
                            .plus(location.longitude.toString())
                        locationTextView.text = loc
                    } else {
                        Toast
                            .makeText(this, "Cannot get last location coordinates.", Toast.LENGTH_SHORT)
                            .show()
                        locationTextView.text = "Unknown"
                    }
                }
        }
    }
}