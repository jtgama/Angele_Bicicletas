package angelbike.proyectointe.angelbikes11.activity.main;

import java.util.List;

import angelbike.proyectointe.angelbikes11.model.ModeloUsuario;

public interface ManiView {

    void showLoading();
    void hideLoading();
    void  onGetResult(List<ModeloUsuario> modeloUsuarios);
    void  onErrorLoading(String message);
}
