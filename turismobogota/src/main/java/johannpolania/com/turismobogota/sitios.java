package johannpolania.com.turismobogota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class sitios extends AppCompatActivity {

    private ImageButton candelaria,tren,monserrate;
    private TextView rSitios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);
        candelaria=(ImageButton)findViewById(R.id.cande);
        tren=(ImageButton)findViewById(R.id.tren);
        monserrate=(ImageButton)findViewById(R.id.monse);
        rSitios=(TextView)findViewById(R.id.rSitios);

        candelaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rSitios.setText(getText(R.string.infoCandelaria));

            }
        });
        monserrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rSitios.setText(getText(R.string.infoMonserrate));

            }
        });

        tren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rSitios.setText(getText(R.string.infoTren));

            }        });

    }

    public void lanzarHome(View view)

    {
        finish();


    }
}
