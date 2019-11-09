package angelbike.proyectointe.angelbikes11.activity.editor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import angelbike.proyectointe.angelbikes11.R;
import angelbike.proyectointe.angelbikes11.activity.main.PrincipalActivity;
import angelbike.proyectointe.angelbikes11.api.ApiUsuario;
import angelbike.proyectointe.angelbikes11.api.interfacesUsuario;
import angelbike.proyectointe.angelbikes11.model.ModeloUsuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements EditarView {
   private RelativeLayout rela1,relat2;
  private  ImageView image, image2;
    private EditText contra,correo;
    private TextView regis,olvido,iniciar;


  ProgressDialog progresar;
    EditarPresenter presentera;
   private Handler handler = new Handler();
   private Runnable  runnable = new Runnable() {
        @Override
        public void run() {
            rela1.setVisibility(View.VISIBLE);
            relat2.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
            image.setVisibility(View.GONE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rela1 = (RelativeLayout)findViewById(R.id.rela);
        relat2 = (RelativeLayout)findViewById(R.id.rela2);
        image = (ImageView)findViewById(R.id.logo);
        image2 = (ImageView)findViewById(R.id.ima_logo1);
        handler.postDelayed(runnable,  2000);
        contra = (EditText)findViewById(R.id.contrase);
        correo = (EditText)findViewById(R.id.correo1);
        regis = findViewById(R.id.regis);
        olvido = findViewById(R.id.olvid);
        iniciar = (Button)findViewById(R.id.aceptar);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             inicarses();

            }
        });
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
            }
        });
    }

    private void inicarses() {
        progresar = new ProgressDialog(this);
        progresar.setMessage("Cargando...");
        presentera =new EditarPresenter(this);

        final    String correov=  correo.getText().toString().trim();
        final   String contrase = contra.getText().toString().trim();

        if (correov.isEmpty()){
            correo.setError("Por favor Ingrese su Correo");
        }else if (contrase.isEmpty()){
            contra.setError("Por favor ingrese su Contraseña");
        }
        else{
            presentera.iniciarsesion(correov,contrase);
        }





    }


    @Override
    public void showProgress() {
        progresar.show();
    }

    @Override
    public void hideProgress() {
        progresar.hide();
    }

    @Override
    public void onRequestSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this,PrincipalActivity.class));

    }

    @Override
    public void onRequestError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
