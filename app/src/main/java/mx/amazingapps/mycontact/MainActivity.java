package mx.amazingapps.mycontact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    contactos =new ArrayList<Contacto>();
     contactos.add(new Contacto("Juan Acosta","123456789","Ja@gmail.com"));
        contactos.add(new Contacto("Eymi ZApien","44445555","test@mail.com"));
        contactos.add(new Contacto("Elva Lorenza","9999999","x@xmail.com"));
        contactos.add(new Contacto("Pedro Hernandez","11111111","email@email.com"));

        ArrayList<String> nombreDeContacto= new ArrayList<>();
        for (Contacto contacto: contactos
             ) {
            nombreDeContacto.add(contacto.getNombre());
        }
        ListView lstCotactos = (ListView)findViewById(R.id.lstContactos);
        lstCotactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreDeContacto));

        lstCotactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this,DetailContact.class);
                intent.putExtra(getResources().getString(R.string.pNombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.pTelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pEmail),contactos.get(position).getEmail());
                startActivity(intent);
            }
        });



    }
}
