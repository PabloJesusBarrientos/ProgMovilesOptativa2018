package pablo.barrientos.utng.edu.mx.apppanfleto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContentActivity extends AppCompatActivity {

    Button btnRegresar;
    TextView tvContenido;
    ImageView ivContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        tvContenido = findViewById(R.id.tvContent);
        ivContenido = findViewById(R.id.ivContent);
        btnRegresar = findViewById(R.id.btnRegresar);

        ArrayList<String> content = new ArrayList<String>();
        content.add(getResources().getString(R.string.tema_content));
        content.add(getResources().getString(R.string.activs_didac));
        content.add(getResources().getString(R.string.eval_usuario));
        content.add(getResources().getString(R.string.progress_usuario));

        Intent intent = getIntent();
        int position = intent.getIntExtra("position" +
                "",0);
        tvContenido.setText(content.get(position));
        switch (position){
            case 0:
                ivContenido.setImageResource(R.drawable.kotlin);
                break;
            case 1:
                ivContenido.setImageResource(R.drawable.java);
                break;
            case 2:
                ivContenido.setImageResource(R.drawable.php);
                break;
            case 3:
                ivContenido.setImageResource(R.drawable.python);
                break;
        }

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
