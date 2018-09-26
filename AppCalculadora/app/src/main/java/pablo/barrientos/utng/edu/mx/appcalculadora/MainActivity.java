package pablo.barrientos.utng.edu.mx.appcalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUno, etDos;
    private TextView etRes;
    private Button btnSuma, btnResta, btnMultiplica, btnDivide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUno=(EditText)findViewById(R.id.etUno);
        etDos=(EditText)findViewById(R.id.etDos);
        etRes=(TextView)findViewById(R.id.tvResultado);

        btnSuma=(Button)findViewById(R.id.btnSumar);
        btnResta=(Button)findViewById(R.id.btnRestar);
        btnMultiplica=(Button)findViewById(R.id.btnMultiplicar);
        btnDivide=(Button)findViewById(R.id.btnDividir);

        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMultiplica.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    try {
        double datoUno = Double.parseDouble(etUno.getText().toString());
        double datoDos = Double.parseDouble(etDos.getText().toString());
        double resultado = 0;

        switch (v.getId()) {
            case R.id.btnSumar:
                resultado = datoUno + datoDos;
                break;
            case R.id.btnRestar:
                resultado = datoUno - datoDos;
                break;
            case R.id.btnMultiplicar:
                resultado = datoUno * datoDos;
                break;
            case R.id.btnDividir:
                resultado = datoUno / datoDos;
                break;
        }

        etRes.setText("Resultado: " +  resultado);
    }catch (Exception e){
        Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
    }



    }
}
