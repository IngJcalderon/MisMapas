package mx.unam.mismapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ibLugar1;
    ImageView ibLugar2;
    ImageView ibLugar3;
    ImageView ibLugar4;
    String miLugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibLugar1 = (ImageView) findViewById(R.id.ibLugar1);
        ibLugar2 = (ImageView) findViewById(R.id.ibLugar2);
        ibLugar3 = (ImageView) findViewById(R.id.ibLugar3);
        ibLugar4 = (ImageView) findViewById(R.id.ibLugar4);

        ibLugar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                miLugar="miraflores";
                irMapa();
            }
        });

        ibLugar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                miLugar="lima";
                irMapa();
            }
        });

        ibLugar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                miLugar="callao";
                irMapa();
            }
        });

        ibLugar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                miLugar="chorrillos";
                irMapa();
            }
        });
    }

    public void irMapa(){
        //android:onClick="irMapa"
        Intent intent=new Intent(this,MapsActivity.class);
        intent.putExtra("lugar",miLugar);
        startActivity(intent);
    }
}
