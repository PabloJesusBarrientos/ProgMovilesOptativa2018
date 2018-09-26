package pablo.barrientos.utng.edu.mx.appcalcularfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etApePaterno, etApeMaterno, etNombre;
    private Spinner cmbDias, cmbMeses, cmbAnios;
    private TextView tvRfc;
    private Button btnCalcular, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etApePaterno = (EditText)findViewById(R.id.etApePaterno);
        etApeMaterno = (EditText)findViewById(R.id.etApeMaterno);
        etNombre = (EditText)findViewById(R.id.etNombre);

        tvRfc = (TextView) findViewById(R.id.tvResultado);

        cmbAnios = (Spinner)findViewById(R.id.cmb_anio);
        cmbMeses = (Spinner)findViewById(R.id.cmb_mes);
        cmbDias = (Spinner)findViewById(R.id.cmb_dia);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnClear=(Button)findViewById(R.id.btnClear);

        btnCalcular.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = thisYear; i >= 1900; i--) {
            years.add(Integer.toString(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
        cmbAnios.setAdapter(adapter);

        ArrayList<String> days = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapterDays = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        cmbDias.setAdapter(adapterDays);

    }

    public void clear(){

    }

    @Override
    public void onClick(View v) {
        try {
            String apPaterno = etApePaterno.getText().toString().trim();
            String apMaterno = etApeMaterno.getText().toString().trim();
            String nombre = etNombre.getText().toString().trim();
            String anio = String.valueOf(cmbAnios.getSelectedItem());
            String mes = String.valueOf(cmbMeses.getSelectedItemId()+1);
            String dia = String.valueOf(cmbDias.getSelectedItemId()+1);
            String rfc = "";

            switch (v.getId()){
                case R.id.btnCalcular:
                    apPaterno = apPaterno.substring(0, 2);
                    apMaterno = apMaterno.substring(0, 1);
                    nombre = nombre.substring(0,1);
                    anio = anio.substring(2,4);
                    System.out.println("MES: " + mes + " - DIA: " + dia);
                    mes = mes.length() > 1 ? mes : "0"+mes;
                    dia = dia.length() > 1 ? dia : "0"+dia;

                    rfc = apPaterno + apMaterno + nombre + anio + mes + dia;

                    tvRfc.setText("RFC: " + rfc);

                    break;
                case R.id.btnClear:
                    etApePaterno.setText("");
                    etApeMaterno.setText("");
                    etNombre.setText("");
                    tvRfc.setText("");
                    cmbAnios.setSelection(0);
                    cmbMeses.setSelection(0);
                    cmbDias.setSelection(0);
                    break;
            }
        }catch (Exception e){
            Toast.makeText(this, "Es necesario llenar todos los campos!", Toast.LENGTH_LONG).show();
        }
    }
}
