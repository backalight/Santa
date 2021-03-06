package fr.formation.convertisseur;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    EditText etEuro;
    EditText etFrf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEuro = findViewById(R.id.euroEcran);
        etFrf = findViewById(R.id.frfEcran);
    }

    public void convertir(View view) {


        if (etEuro.getText().length() > 0) {

            String inputUser = etEuro.getText().toString();
            Double valueToConvert = parseDouble(inputUser);
            Double convertValue = valueToConvert * 6.55957;
            String str = convertValue.toString();
            etFrf.setText(str);
        } else {
            Toast.makeText(this, "ENTREZ UNE VALEUR", Toast.LENGTH_LONG);
        }


    }
}

