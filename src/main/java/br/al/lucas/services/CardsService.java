package br.al.lucas.services;

import br.al.lucas.models.MTGResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CardsService {
    //  LISTAR
    @GET("/v1/cards")
    Call<MTGResponse>  list();


    //  LISTAR  COM FILTRO

    //  LER


}
