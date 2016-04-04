package johannpolania.com.notasactividades;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText eProy,ePrac,eExpo,eNota;
private Button bCalcular,bLimpiar;
    private TextView tProyecto,tPractica,tExposicion;
private double pExpo,pPrac,pProy;
    double notaProyecto,notaExpo,notaPractica,notaFinal;

    @Override
    protected void onSaveInstanceState(Bundle outState) {


        super.onSaveInstanceState(outState);
        outState.putDouble("pProy", pProy);
        outState.putDouble("pPrac", pPrac);
        outState.putDouble("pExpo", pExpo);
        outState.putString("notaExpo",(eExpo.getText().toString()));
        outState.putString("notaPrac", (ePrac.getText().toString()));
        outState.putString("notaProy", (eProy.getText().toString()));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eProy = (EditText) findViewById(R.id.eProy);
        ePrac = (EditText) findViewById(R.id.ePrac);
        eExpo = (EditText) findViewById(R.id.eExpo);
        eNota = (EditText) findViewById(R.id.eNota);

        bCalcular = (Button) findViewById(R.id.bCalcular);
        bLimpiar = (Button) findViewById(R.id.bLimpiar);
        tProyecto = (TextView) findViewById(R.id.textProy);
        tExposicion = (TextView) findViewById(R.id.textExpo);
        tPractica = (TextView) findViewById(R.id.textPrac);

        if(savedInstanceState!=null)
        { pProy=savedInstanceState.getDouble("pProy");
            pPrac=savedInstanceState.getDouble("pPrac");
            pExpo=savedInstanceState.getDouble("pExpo");
            tPractica.setText("("+String.valueOf(pPrac)+"%)");
            tProyecto.setText("("+String.valueOf(pProy)+"%)");
            tExposicion.setText("("+String.valueOf(pExpo)+"%)");

           eProy.setText(String.valueOf(savedInstanceState.getString("notaProy")));
            ePrac.setText(String.valueOf(savedInstanceState.getString("notaPrac")));
            eExpo.setText(String.valueOf(savedInstanceState.getString("notaExpo")));



        }
else {


            pExpo = 10;
            pPrac = 40;
            pProy = 50;
        }
        bLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eProy.setText("");
                ePrac.setText("");
                eExpo.setText("");
                eNota.setText("");
            }
        });
        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(!eProy.getText().toString().equals("") && !ePrac.getText().toString().equals("") && !eExpo.getText().toString().equals("") )
              {
                  notaProyecto=Double.parseDouble(eProy.getText().toString());
                  notaExpo=Double.parseDouble(eExpo.getText().toString());
                  notaPractica=Double.parseDouble(ePrac.getText().toString());
                  if(notaProyecto>=0 && notaProyecto<=5)
                  {
                      if(notaExpo>=0 && notaExpo<=5)
                      {
                          if(notaPractica>=0 && notaPractica<=5)
                          {
                           notaFinal=(pExpo/100)*notaExpo+(pPrac/100)*notaPractica+notaProyecto*(pProy/100);
                              String s;

                           eNota.setText(String.valueOf(notaFinal).substring(0,3));
                           }
                          else
                          {
                              eNota.setText("Ingrese una nota de practica válida");

                          }

                      }
                      else
                      {
                          eNota.setText("Ingrese una nota de Exposición válida");

                      }


                  }
                  else
                  {
                      eNota.setText("Ingrese una nota de Proyecto válida");

                  }

              }
                else
              {

                  eNota.setText("Ingrese las notas por favor");

              }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuConfigurar) {
            Toast.makeText(this, "Presiono configurar", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,SettingsActivity.class);
            intent.putExtra("pExpo",pExpo);
            intent.putExtra("pPrac",pPrac);
            intent.putExtra("pProy", pProy);
            startActivityForResult(intent,1234);


        } else
        {
            Toast.makeText(this, "Presiono calcular", Toast.LENGTH_SHORT).show();


        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1234 && resultCode==RESULT_OK)
        {
            tPractica.setText("("+String.valueOf(data.getExtras().getString("pPrac"))+"%)");
            tExposicion.setText("("+String.valueOf(data.getExtras().getString("pExpo"))+"%)");
            tProyecto.setText("("+String.valueOf(data.getExtras().getString("pProy"))+"%)");
            pProy=Double.parseDouble(data.getExtras().getString("pProy"));
            pExpo=Double.parseDouble(data.getExtras().getString("pExpo"));
            pPrac=Double.parseDouble(data.getExtras().getString("pPrac"));

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
