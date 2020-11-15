package co.domi.semana13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase db;
    private EditText usernameId;
    private Button ingresarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();

        usernameId = findViewById(R.id.usernameId);
        ingresarBtn = findViewById(R.id.ingresarBtn);

        ingresarBtn.setOnClickListener(
                (v) -> {
                    String id = UUID.randomUUID().toString();
                    DatabaseReference reference = db.getReference().child("Usuario").child(usernameId.getText().toString());

                    Usuario usuario = new Usuario(
                            usernameId.getText().toString(),
                            id
                    );
                    reference.setValue(usuario);
                    Intent a = new Intent(this,CallActivity.class);
                    a.putExtra("username", usernameId.getText().toString());
                    startActivity(a);

                }
        );

    }
}