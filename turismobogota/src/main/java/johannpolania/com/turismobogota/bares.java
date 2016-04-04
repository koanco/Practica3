package johannpolania.com.turismobogota;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class bares extends AppCompatActivity {
private ImageButton gaira,agua,carne;
private TextView rBares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bares);
        gaira=(ImageButton)findViewById(R.id.gaira);
        agua=(ImageButton)findViewById(R.id.aguapa);
        carne=(ImageButton)findViewById(R.id.andre);
        rBares=(TextView)findViewById(R.id.rBares);

        gaira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rBares.setText(getText(R.string.infoGaira));


            }


        });
      agua.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {



                      rBares.setText(getText(R.string.infoAguapanela));

                  }
              });




        carne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rBares.setText(getText(R.string.infoAndres));

            }
        });

   }

    public void lanzarHome(View view)

    {
        finish();


    }


}
