package angelbike.proyectointe.angelbikes11.activity.editor;

public interface EditarView {

    void showProgress();
    void hideProgress();
    void onRequestSuccess(String message);
    void onRequestError(String message);
}
