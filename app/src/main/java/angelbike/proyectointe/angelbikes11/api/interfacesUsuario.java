package angelbike.proyectointe.angelbikes11.api;

import java.util.List;

import angelbike.proyectointe.angelbikes11.model.ModeloUsuario;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface interfacesUsuario {

    @FormUrlEncoded
    @POST("AgregarServicio.php")
    Call<ModeloUsuario> guardarusu(
         @Field("nombre") String angel,
         @Field("correo") String correo,
         @Field("telefono") String tele,
         @Field("color") int color
    );
   @GET("Listarservicio.php")
   Call<List<ModeloUsuario>> getClientes();

    @FormUrlEncoded
    @POST("ActualizarServicio.php")
    Call<ModeloUsuario> actualiusu(
            @Field("id_angel") int id,
            @Field("nombre") String angel,
            @Field("correo") String correo,
            @Field("telefono") String tele,
            @Field("color") int color
    );
    @FormUrlEncoded
    @POST("EliminarServicio.php")
    Call<ModeloUsuario> eliminausu( @Field("id_angel") int id  );

    @FormUrlEncoded
    @POST("Registro.php")
    Call<ModeloUsuario> guardaregis(
            @Field("nombre") String angel,
            @Field("correo") String correo,
            @Field("password") String contra,
            @Field("telefono") String tele
    );
    @FormUrlEncoded
    @POST("login2.php")
    Call<ModeloUsuario> iniciarsession(

            @Field("correo") String correo,
            @Field("password") String contra

    );
}
