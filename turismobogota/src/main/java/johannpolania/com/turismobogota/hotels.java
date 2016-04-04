package johannpolania.com.turismobogota;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class hotels extends AppCompatActivity {
private ImageButton tequendama,rosales,mercure;
private TextView detalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
        tequendama=(ImageButton)findViewById(R.id.teque);
        rosales=(ImageButton)findViewById(R.id.rosa);
        mercure=(ImageButton)findViewById(R.id.mercure);
        detalle=(TextView)findViewById(R.id.resul);

        tequendama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                        detalle.setText(getText(R.string.info_teque));

            }
        });
        rosales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detalle.setText(getText(R.string.info_rosales));

            }
        });

        mercure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detalle.setText(getText(R.string.info_mercure));

            }
        });



    }

    public void lanzarHome(View view)

    {
        finish();


    }

}
