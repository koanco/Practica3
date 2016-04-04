package johannpolania.com.turismobogota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hotel = (Button) findViewById(R.id.hoteles);

    }
        public void lanzar(View view)
    {
        Intent i = new Intent(this, hotels.class );
        startActivity(i);


    }

    public void lanzarBar(View view)
    {
        Intent i = new Intent(this, bares.class );
        startActivity(i);


    }

    public void lanzarSitio(View view)

    {
        Intent i = new Intent(this, sitios.class );
        startActivity(i);



    }

    public void lanzarDemo(View view)

    {
        Intent i = new Intent(this, infoDemografica.class );
        startActivity(i);



    }

    public void lanzarAutor(View view)

    {
        Intent i = new Intent(this, Autor.class );
        startActivity(i);



    }


}
