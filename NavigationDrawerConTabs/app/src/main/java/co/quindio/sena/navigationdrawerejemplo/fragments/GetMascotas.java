package co.quindio.sena.navigationdrawerejemplo.fragments;

import java.util.List;

import co.quindio.sena.navigationdrawerejemplo.clases.Mascota;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetMascotas {
    @GET("mascotas")
    Call<List<Mascota>> getMascotas();

}
