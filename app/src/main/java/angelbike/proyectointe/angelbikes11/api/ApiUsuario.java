package angelbike.proyectointe.angelbikes11.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUsuario {

    private static final String URL ="http://proyectop1.000webhostapp.com/";
    private static Retrofit retrofit;

    public static Retrofit getApiUsuario(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

    //public static Retrofit getClient(){

      //  Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
        //return new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create(gson))
          //      .build();
    //}
    //public static interfacesUsuario getServicio(){
       // return getClient().create(interfacesUsuario.class);
   // }

}
