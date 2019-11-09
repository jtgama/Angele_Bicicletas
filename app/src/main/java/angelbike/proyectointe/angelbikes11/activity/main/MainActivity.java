package angelbike.proyectointe.angelbikes11.activity.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import angelbike.proyectointe.angelbikes11.R;
import angelbike.proyectointe.angelbikes11.activity.editor.EditarActivity;
import angelbike.proyectointe.angelbikes11.model.ModeloUsuario;

public class MainActivity extends AppCompatActivity implements ManiView{

    private static final int INTENT_EDIT = 200;
    private static final int INTENT_ADD = 100;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipe;
    MainPresenter mainPresenter;
    MainAdapter adapta;
    MainAdapter.ItemClickListener itemClickListener;
    List<ModeloUsuario> modeloUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.listar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipe = findViewById(R.id.swipe_refresh);
         fab = findViewById(R.id.agregar);
        fab.setOnClickListener(view ->
                        startActivityForResult(new Intent(this, EditarActivity.class), INTENT_ADD)
                );
        mainPresenter = new MainPresenter(this);
        mainPresenter.getData();
        swipe.setOnRefreshListener(

                () -> mainPresenter.getData()
        );
        itemClickListener  = ((view, position) -> {
            int id = modeloUsuario.get(position).getId();
          String angeles = modeloUsuario.get(position).getAngel();
            String correo = modeloUsuario.get(position).getCorreo();
            String telefono = modeloUsuario.get(position).getTele();
           int color = modeloUsuario.get(position).getColor();
           Intent intent  = new Intent(this,EditarActivity.class);
           intent.putExtra("id_angel",id);
            intent.putExtra("nombre",angeles);
            intent.putExtra("correo",correo);
            intent.putExtra("telefono",telefono);
            intent.putExtra("color",color);
            startActivityForResult(intent,INTENT_EDIT);



        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INTENT_ADD && resultCode== RESULT_OK){
            mainPresenter.getData();
        }
        else
        if (requestCode == INTENT_EDIT && resultCode== RESULT_OK){
            mainPresenter.getData();
        }
    }

    @Override
    public void showLoading() {
      swipe.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipe.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<ModeloUsuario> modeloUsuarios) {
    adapta = new MainAdapter(this,modeloUsuarios,itemClickListener);
    adapta.notifyDataSetChanged();
    recyclerView.setAdapter(adapta);
    modeloUsuario = modeloUsuarios;
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
