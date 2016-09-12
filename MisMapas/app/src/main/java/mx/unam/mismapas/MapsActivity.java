package mx.unam.mismapas;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    String lugar;
    String nombreMarker;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        lugar = getIntent().getStringExtra("lugar");
        mMap = googleMap;
        LatLng milugar=null;

        // Add a marker in Sydney and move the camera
       // LatLng sydney = new LatLng(-34, 151);
        if (lugar.compareToIgnoreCase("miraflores")==0){
             milugar = new LatLng(-12.11189833534688,-77.02947036770024);
            nombreMarker="Marcador en Miraflores";
        }if (lugar.compareToIgnoreCase("lima")==0){
            milugar = new LatLng(-12.047272074609824, -77.03753845241704);
            nombreMarker="Marcador in Lima";
        }if (lugar.compareToIgnoreCase("callao")==0){
            milugar = new LatLng(-11.999589738632805, -77.11684600856938);
            nombreMarker="Marcador en Callao";
        }if (lugar.compareToIgnoreCase("chorrillos")==0){
            milugar = new LatLng(-12.189596988656719, -77.00990097072759);
            nombreMarker="Marcador en Chorrillos";
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(milugar, 13));
        mMap.addMarker(new MarkerOptions().position(milugar).title(nombreMarker));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(milugar));
    }
}
