package pablo.barrientos.utng.edu.mx.apppanfleto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list;
        ArrayAdapter<String> adapter;

        list = (ListView)findViewById(R.id.list_main);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        adapter.add(getResources().getString(R.string.temas));
        adapter.add(getResources().getString(R.string.activs));
        adapter.add(getResources().getString(R.string.eval));
        adapter.add(getResources().getString(R.string.progress));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int  option = position;
                Toast.makeText(getApplicationContext(), "Opción... " + option, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                int pos=0;
                switch (option){
                    case 0:
                        pos = 0;
                        break;
                    case 1:
                        pos = 1;
                        break;
                    case 2:
                        pos = 2;
                        break;
                    case 3:
                        pos = 3;
                        break;
                }
                intent.putExtra("position", pos);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Asociar e¿con el menu xml
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, ContentActivity.class);
        int position;
        switch (item.getItemId()){
            case R.id.itmTemas:
                Toast.makeText(this, "Temas del lenguaje", Toast.LENGTH_LONG).show();
                position = 0;
                break;
            case R.id.itmActivs:
                Toast.makeText(this, "Actividades Aprendizaje", Toast.LENGTH_LONG).show();
                position = 1;
                break;
            case R.id.itmEval:
                Toast.makeText(this, "Evaluaciones", Toast.LENGTH_LONG).show();
                position = 2;
                break;
            case R.id.itmProgress:
                Toast.makeText(this, "Progreso del usuario", Toast.LENGTH_LONG).show();
                position = 3;
                break;
                default:
                    return super.onOptionsItemSelected(item);
        }

        intent.putExtra("position", position);
        startActivity(intent);
        finish();
        return true;
    }

}
