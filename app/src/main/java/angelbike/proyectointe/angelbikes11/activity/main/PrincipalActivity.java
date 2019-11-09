package angelbike.proyectointe.angelbikes11.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import angelbike.proyectointe.angelbikes11.R;

public class PrincipalActivity extends AppCompatActivity {

     private Button Btnagregar;
   private ProgressDialog progresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Btnagregar = (Button)findViewById(R.id.btnAgregar);

        progresar = new ProgressDialog(this);
        progresar.setMessage("Cargando...");
        Btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalActivity.this, MainActivity.class));
            }
        });
    }
}
