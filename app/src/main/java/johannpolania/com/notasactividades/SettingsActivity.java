package johannpolania.com.notasactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private EditText eProy,ePrac,eExpo;
    private TextView tAviso;
    private Button bGuardar,bLimpiar;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("pProy", String.valueOf(eProy.getText().toString()));
        outState.putString("pPrac",String.valueOf(ePrac.getText().toString()));
        outState.putString("pExpo",String.valueOf(eExpo.getText().toString()));
    }

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        eProy=(EditText)findViewById(R.id.eeProy);
        ePrac=(EditText)findViewById(R.id.eePrac);
        eExpo=(EditText)findViewById(R.id.eeExpo);
        bGuardar=(Button)findViewById(R.id.bGuardar);
        bLimpiar=(Button)findViewById(R.id.bbLimpiar);
        tAviso=(TextView)findViewById(R.id.tAviso);
        Bundle extras=getIntent().getExtras();

       eProy.setText(String.valueOf(extras.getDouble("pProy")));
        ePrac.setText(String.valueOf(extras.getDouble("pPrac")));
        eExpo.setText(String.valueOf(extras.getDouble("pExpo")));

        if(savedInstanceState!=null) {
        eExpo.setText(savedInstanceState.getString("pExpo"));
        eProy.setText(savedInstanceState.getString("pProy"));
        ePrac.setText(savedInstanceState.getString("pPrac"));
        }


        bLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eProy.setText("");
                ePrac.setText("");
                eExpo.setText("");
                tAviso.setVisibility(View.INVISIBLE);
            }
        });

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalPorcentaje;
                totalPorcentaje = Double.parseDouble(eProy.getText().toString()) + Double.parseDouble(ePrac.getText().toString()) + Double.parseDouble(eExpo.getText().toString());
                if (totalPorcentaje == 100) {
                    tAviso.setVisibility(View.INVISIBLE);
                    Intent i = new Intent();
                    i.putExtra("pProy", eProy.getText().toString());
                    i.putExtra("pPrac", ePrac.getText().toString());
                    i.putExtra("pExpo", eExpo.getText().toString());
                    setResult(RESULT_OK, i);
                    finish();
                } else {
                    tAviso.setVisibility(View.VISIBLE);

                }

            }
        });
    }
}
