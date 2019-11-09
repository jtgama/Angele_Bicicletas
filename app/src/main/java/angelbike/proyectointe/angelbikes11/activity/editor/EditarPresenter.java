package angelbike.proyectointe.angelbikes11.activity.editor;

import androidx.annotation.NonNull;

import angelbike.proyectointe.angelbikes11.api.ApiUsuario;
import angelbike.proyectointe.angelbikes11.api.interfacesUsuario;
import angelbike.proyectointe.angelbikes11.model.ModeloUsuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarPresenter {

   private EditarView editarv;

    public EditarPresenter(EditarView editarv) {
        this.editarv = editarv;
    }

     void guardar_angel(final String nombre, final String correo, final String telefono, final int color) {
        editarv.showProgress();

        interfacesUsuario  interfa = ApiUsuario.getApiUsuario().create(interfacesUsuario.class);
        Call<ModeloUsuario> call  = interfa.guardarusu(nombre,correo,telefono,color);
        call.enqueue(new Callback<ModeloUsuario>() {
            @Override
            public void onResponse(@NonNull Call<ModeloUsuario> call, @NonNull Response<ModeloUsuario> response) {
               editarv.hideProgress();
                if (response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getAceptar();
                    if (success){
                        editarv.onRequestSuccess(response.body().getMensaje());

                    }
                    else{
                        editarv.onRequestError(response.body().getMensaje());

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ModeloUsuario> call, @NonNull Throwable t) {
               editarv.hideProgress();
                editarv.onRequestError(t.getLocalizedMessage());
            }
        });
    }
    void ActualizarCliente(int id, String angel,String correo,  String telefono, int color){
         editarv.showProgress();
         interfacesUsuario interfacesusuario = ApiUsuario.getApiUsuario().create(interfacesUsuario.class);
        Call<ModeloUsuario> call = interfacesusuario.actualiusu(id,angel,correo,telefono,color);
        call.enqueue(new Callback<ModeloUsuario>() {
            @Override
            public void onResponse(@NonNull Call<ModeloUsuario> call, @NonNull Response<ModeloUsuario> response) {
                editarv.hideProgress();
                if (response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getAceptar();
                    if (success){
                        editarv.onRequestSuccess(response.body().getMensaje());

                    }
                    else{
                        editarv.onRequestError(response.body().getMensaje());

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ModeloUsuario> call,@NonNull Throwable t) {
                editarv.hideProgress();
                editarv.onRequestError(t.getLocalizedMessage());
            }
        });

    }
    void  eliminarCliente(int id){

        editarv.showProgress();
        interfacesUsuario interfacesusuario = ApiUsuario.getApiUsuario().create(interfacesUsuario.class);
        Call<ModeloUsuario> call = interfacesusuario.eliminausu(id);
        call.enqueue(new Callback<ModeloUsuario>() {
            @Override
            public void onResponse(@NonNull Call<ModeloUsuario> call, @NonNull Response<ModeloUsuario> response) {
                editarv.hideProgress();
                if (response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getAceptar();
                    if (success){
                        editarv.onRequestSuccess(response.body().getMensaje());

                    }
                    else{
                        editarv.onRequestError(response.body().getMensaje());

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ModeloUsuario> call,@NonNull Throwable t) {
                editarv.hideProgress();
                editarv.onRequestError(t.getLocalizedMessage());
            }
        });

    }
    void guardar_registro(final String nombre, final String correo, final String contraseña,final String telefono) {
        editarv.showProgress();

        interfacesUsuario  interfa = ApiUsuario.getApiUsuario().create(interfacesUsuario.class);
        Call<ModeloUsuario> call  = interfa.guardaregis(nombre,correo,contraseña,telefono);
        call.enqueue(new Callback<ModeloUsuario>() {
            @Override
            public void onResponse(@NonNull Call<ModeloUsuario> call, @NonNull Response<ModeloUsuario> response) {
                editarv.hideProgress();
                if (response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getAceptar();
                    if (success){
                        editarv.onRequestSuccess(response.body().getMensaje());

                    }
                    else{
                        editarv.onRequestError(response.body().getMensaje());

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ModeloUsuario> call, @NonNull Throwable t) {
                editarv.hideProgress();
                editarv.onRequestError(t.getLocalizedMessage());
            }
        });
    }
    void iniciarsesion(final String correo, final String contraseña) {
        editarv.showProgress();

        interfacesUsuario  interfa = ApiUsuario.getApiUsuario().create(interfacesUsuario.class);
        Call<ModeloUsuario> call  = interfa.iniciarsession(correo,contraseña);
        call.enqueue(new Callback<ModeloUsuario>() {
            @Override
            public void onResponse(@NonNull Call<ModeloUsuario> call, @NonNull Response<ModeloUsuario> response) {
                editarv.hideProgress();
               if (response.isSuccessful()&& response.body()!= null){
                     Boolean  success = response.body().getAceptar();
                     if (success){

                         editarv.onRequestSuccess(response.body().getMensaje());
                     }
                     else{
                         editarv.onRequestError(response.body().getMensaje());
                     }
               }
            }

            @Override
            public void onFailure(@NonNull Call<ModeloUsuario> call, @NonNull Throwable t) {
                editarv.hideProgress();
                editarv.onRequestError(t.getLocalizedMessage());
            }
        });
    }
}
