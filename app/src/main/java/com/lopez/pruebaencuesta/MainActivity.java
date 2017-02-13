package com.lopez.pruebaencuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    ArrayList<String> preguntas = new ArrayList<>();
    ArrayList<String> respuestas = new ArrayList<>();
    TextView preguntatext;
    RadioButton r;
    RadioGroup rg;
    int aumento;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preguntatext = (TextView) findViewById(R.id.text);

        rg=(RadioGroup)findViewById(R.id.rg) ;
        preguntas.add("Le gusto nuestro servicio?");
        preguntas.add("Volveria a nuestra tienda?");
        preguntas.add("Que fue lo que mas le gusto?");
        respuestas.add("Excelente");
        respuestas.add("Bueno");
        respuestas.add("Regular");
        respuestas.add("Malo");
        cambiar(i);

        final RadioButton[] rb = new RadioButton[respuestas.size()];
        for(int i=0; i<respuestas.size(); i++) {
            rb[i] = new RadioButton(this);
            rg.addView(rb[i]); //the RadioButtons are added to the radioGroup instead of the layout
            rb[i].setText(respuestas.get(i));
            rb[i].setId(i);
            
        }


      rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup radioGroup, int a) {
              switch (rg.getCheckedRadioButtonId()){

                  case 0:
                      i++;
                      cambiar(i);
                      break;
                  case 1:
                      i++;
                      cambiar(i);
                      break;
                  case 2:
                      i++;
                      cambiar(i);
                      break;
                  case 3:
                      i++;
                      cambiar(i);
                      break;
              }
          }
      });
    }
    public void cambiar(int i){
        if (i < preguntas.size()) {
            String pregunta;
            pregunta = preguntas.get(i);

            preguntatext.setText(pregunta);
            rg.clearCheck();

        }
        else {
            Toast.makeText(this, "terminaste", Toast.LENGTH_SHORT).show();
        }

    }

}
