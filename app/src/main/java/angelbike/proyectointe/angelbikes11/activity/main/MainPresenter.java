package angelbike.proyectointe.angelbikes11.activity.main;

import androidx.annotation.NonNull;

import java.util.List;

import angelbike.proyectointe.angelbikes11.api.ApiUsuario;
import angelbike.proyectointe.angelbikes11.api.interfacesUsuario;
import angelbike.proyectointe.angelbikes11.model.ModeloUsuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private  ManiView view;

    public MainPresenter(ManiView view) {
        this.view = view;
    }

    void getData(){

        view.showLoading();
        interfacesUsuario interfacesUsuarios = ApiUsuario.getApiUsuario().create(interfacesUsuario.class);
        Call<List<ModeloUsuario>> Call = interfacesUsuarios.getClientes();

        Call.enqueue(new Callback<List<ModeloUsuario>>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<List<ModeloUsuario>> call, @NonNull Response<List<ModeloUsuario>> response) {
               view.hideLoading();
               if (response.isSuccessful()&& response.body() != null){
                   view.onGetResult(response.body());

               }
            }

            @Override
            public void onFailure(@NonNull retrofit2.Call<List<ModeloUsuario>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }
}
