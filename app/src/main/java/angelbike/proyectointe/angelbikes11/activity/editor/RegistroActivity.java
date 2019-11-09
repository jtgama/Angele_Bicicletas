package angelbike.proyectointe.angelbikes11.activity.editor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import angelbike.proyectointe.angelbikes11.R;
import angelbike.proyectointe.angelbikes11.activity.editor.EditarPresenter;
import angelbike.proyectointe.angelbikes11.activity.editor.EditarView;
import angelbike.proyectointe.angelbikes11.api.ApiUsuario;
import angelbike.proyectointe.angelbikes11.api.interfacesUsuario;
import angelbike.proyectointe.angelbikes11.model.ModeloUsuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity  implements EditarView{

    private EditText nombre,correo,contra1,contra2,telefono;
    private Button btn_registrar;
    ProgressDialog progresar;
    EditarPresenter presentera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre = findViewById(R.id.nombre);
        correo = findViewById(R.id.correo);
        contra1 = findViewById(R.id.contra1);
        contra2 = findViewById(R.id.contra2);
        telefono = findViewById(R.id.telefo);
        btn_registrar = findViewById(R.id.Resgitrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Registrar();
            }
        });


    }

    private void  Registrar(){
        progresar = new ProgressDialog(this);
        progresar.setMessage("Cargando...");
        presentera = new EditarPresenter(this);

        final   String nomb= nombre.getText().toString().trim();
        final    String correov=  correo.getText().toString().trim();
        final   String contrase = contra1.getText().toString().trim();
        final   String contrase1 = contra2.getText().toString().trim();
        final    String tele  = telefono.getText().toString().trim();

        if (nomb.isEmpty()){
            nombre.setError("Por favor Ingrese Su Nombre");
        }else if (correov.isEmpty()){
            correo.setError("Por favor Ingrese Su Correo");
        }else if (contrase.isEmpty()){
            contra1.setError("Por favor Ingrese su Contraseña");
        }else if(contrase1.isEmpty()){
            contra2.setError("Por favor Ingrese Confirmacion de contraseña");
        }else{
            if(!TextUtils.isEmpty(contrase) && !TextUtils.isEmpty(contrase1)){
                if (contrase.equals(contrase1)){
                    presentera.guardar_registro(nomb,correov,contrase,tele);
                }
                else{
                    Toast.makeText(this, "La Contrraseña no Coinciden", Toast.LENGTH_SHORT).show();
                }

            }
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
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onRequestError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}


