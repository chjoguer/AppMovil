package co.quindio.sena.navigationdrawerejemplo.fragments;

import java.util.List;

import co.quindio.sena.navigationdrawerejemplo.clases.Mascota;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostMascotas {

    @POST("mascotas/")
    Call<List<Mascota>> createPost(@Body Mascota mascota);

    @FormUrlEncoded
    @POST("mascotas/")
    Call<List<Mascota>> createPost(@Field("id_mascota") String mascota,@Field("nombre") String nombre,@Field("raza") String raza,@Field("descripcion") String descripcion,@Field("en_adopcion") Boolean adopcion,@Field("esta_perdida") Boolean perdido,@Field("propietario") int id);
}
