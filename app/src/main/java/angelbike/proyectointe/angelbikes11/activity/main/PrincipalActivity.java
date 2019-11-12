package angelbike.proyectointe.angelbikes11.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.database.DatabaseReference;

import angelbike.proyectointe.angelbikes11.R;
import angelbike.proyectointe.angelbikes11.activity.editor.AngelActivity;
import angelbike.proyectointe.angelbikes11.activity.editor.MapsActivity;

public class PrincipalActivity extends AppCompatActivity {

     private Button Btnagregar, Btncompartir,BtnUbica;
   private ProgressDialog progresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Btnagregar = (Button)findViewById(R.id.btnAgregar);
        Btncompartir = (Button)findViewById(R.id.btncompart);
        BtnUbica = (Button)findViewById(R.id.btnUbica);
        progresar = new ProgressDialog(this);
        progresar.setMessage("Cargando...");

        Btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalActivity.this, MainActivity.class));
            }
        });

        Btncompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, AngelActivity.class));
            }
        });

        BtnUbica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, MapsActivity.class));
            }
        });



    }
}
