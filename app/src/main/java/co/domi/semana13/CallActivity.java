package co.domi.semana13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

public class CallActivity extends AppCompatActivity {

    private FirebaseDatabase db;
    private EditText nombreId, telefonoId;
    private Button agregarBtn;
    private ListView dinamicView;
    private ArrayList<Usuario> userData;
    private ArrayAdapter<Usuario> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        db = FirebaseDatabase.getInstance();

        nombreId = findViewById(R.id.nombreId);
        telefonoId = findViewById(R.id.telefonoId);
        agregarBtn = findViewById(R.id.agregarBtn);
        dinamicView = findViewById(R.id.dinamicView);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userData);
        userData = new ArrayList<>();

        agregarBtn.setOnClickListener(
                (v) -> {
                    String username = getIntent().getExtras().getString("username");
                    DatabaseReference reference = db.getReference().child("Usuario").child(username);
                    Contactos contactos = new Contactos(
                            nombreId.getText().toString(),
                            Integer.getInteger(telefonoId.getText().toString())
                    );
                    reference.setValue(contactos);
                }
        );

       // loadDataBase();
    }

    public void loadDataBase(){
        String username = db.getReference().child("Usuario").push().getKey();
        DatabaseReference ref = db.getReference().child("Usuario").child(username);
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data) {

                        userData.clear();
                        for(DataSnapshot child : data.getChildren()){
                            Usuario usuario = child.getValue(Usuario.class);
                            //Agregar el usuario
                            userData.add(usuario);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                }
        );
    }
}