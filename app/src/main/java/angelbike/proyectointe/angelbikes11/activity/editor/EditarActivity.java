package angelbike.proyectointe.angelbikes11.activity.editor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.thebluealliance.spectrum.SpectrumPalette;

import angelbike.proyectointe.angelbikes11.R;
import angelbike.proyectointe.angelbikes11.api.ApiUsuario;
import angelbike.proyectointe.angelbikes11.api.interfacesUsuario;
import angelbike.proyectointe.angelbikes11.model.ModeloUsuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarActivity extends AppCompatActivity implements EditarView {

    EditText angel,correo,telefono;
    ProgressDialog progresar;
    interfacesUsuario interfa;
    SpectrumPalette vector;
    EditarPresenter presentera;
    int colores,id;
    String nombre,corre,telefo;
    Menu menuA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        angel = findViewById(R.id.nombreAg);
        correo = findViewById(R.id.correo);
        telefono = findViewById(R.id.telefono);
        vector = findViewById(R.id.paletadecolores);
        vector.setOnColorSelectedListener(
                clr -> colores =clr
        );


        progresar = new ProgressDialog(this);
        progresar.setMessage("Cargando...");
        presentera = new EditarPresenter(this);

        Intent intent = getIntent();
        id = intent.getIntExtra("id_angel",0);
        nombre = intent.getStringExtra("nombre");
        corre = intent.getStringExtra("correo");
       telefo = intent.getStringExtra("telefono");
        colores = intent.getIntExtra("color",0);

        setDataFromIntenExtra();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor, menu);
        menuA = menu;
        if (id !=0){

            menuA.findItem(R.id.editar).setVisible(true);
            menuA.findItem(R.id.eliminar).setVisible(true);
            menuA.findItem(R.id.guarda).setVisible(false);
            menuA.findItem(R.id.actuli).setVisible(false);
        }
        else{
            menuA.findItem(R.id.editar).setVisible(false);
            menuA.findItem(R.id.eliminar).setVisible(false);
            menuA.findItem(R.id.guarda).setVisible(true);
            menuA.findItem(R.id.actuli).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String nombre = angel.getText().toString();
        String corre = correo.getText().toString();
        String tele = telefono.getText().toString();
        int color = this.colores;


        switch(item.getItemId()){
            case R.id.guarda:

                   if (nombre.isEmpty()){
                       angel.setError("Por favor ingrese su angel");
                   }else if (corre.isEmpty()){
                       correo.setError("Por favor Ingrese su Correo");
                   }else if (tele.isEmpty()){
                       telefono.setError("Por favor Ingrese su Telefono");
                   }
                   else{

                      presentera.guardar_angel(nombre,corre,tele,color);
                   }


                return true;
            case R.id.editar:
                editMode();
                menuA.findItem(R.id.editar).setVisible(false);
                menuA.findItem(R.id.eliminar).setVisible(false);
                menuA.findItem(R.id.guarda).setVisible(false);
                menuA.findItem(R.id.actuli).setVisible(true);
                return true;
            case R.id.actuli:
                if (nombre.isEmpty()){
                    angel.setError("Por favor ingrese su angel");
                }else if (corre.isEmpty()){
                    correo.setError("Por favor Ingrese su Correo");
                }else if (tele.isEmpty()){
                    telefono.setError("Por favor Ingrese su Telefono");
                }
                else{

                    presentera.ActualizarCliente(id,nombre,corre,tele,color);
                }
                return true;

                case R.id.eliminar:

              AlertDialog.Builder  alertDialog = new AlertDialog.Builder(this);

              alertDialog.setTitle("Confirmar!");
              alertDialog.setMessage("Desea Elimina este Angel?");
              alertDialog.setNegativeButton("Si", (dialogInterface, i) -> {dialogInterface.dismiss();
              presentera.eliminarCliente(id);
              });
              alertDialog.setPositiveButton("Cancelar",
                      (dialogInterface, i) -> dialogInterface.dismiss());


              alertDialog.show();

                    return true;

                default:
                    return super.onOptionsItemSelected(item);

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
        Toast.makeText(EditarActivity.this, message,
                 Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
             finish();
    }

    @Override
    public void onRequestError(String message) {
        Toast.makeText(EditarActivity.this, message,
                Toast.LENGTH_SHORT).show();

    }
    private void setDataFromIntenExtra() {
     if (id != 0){
         angel.setText(nombre);
         correo.setText(corre);
         telefono.setText(telefo);
         vector.setSelectedColor(colores);
         getSupportActionBar().setTitle("Actualizar Angel");
         readMode();
     }
     else
     {
         vector.setSelectedColor(getResources().getColor(R.color.blanco));
         colores=getResources().getColor(R.color.blanco);
         editMode();
     }
    }

    private void editMode() {
        angel.setFocusableInTouchMode(true);
        correo.setFocusableInTouchMode(true);
        telefono.setFocusableInTouchMode(true);
        vector.setEnabled(true);
    }

    private void readMode() {
        angel.setFocusableInTouchMode(false);
        correo.setFocusableInTouchMode(false);
        telefono.setFocusableInTouchMode(false);
        angel.setFocusable(false);
        correo.setFocusable(false);
        telefono.setFocusable(false);
        vector.setEnabled(false);
    }
}
