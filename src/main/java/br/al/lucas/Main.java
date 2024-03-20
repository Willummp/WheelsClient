package br.al.lucas;

import br.al.lucas.models.Card;
import br.al.lucas.models.MTGResponse;
import br.al.lucas.services.CardsService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String baseUrl = "https://api.magicthegathering.io/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CardsService cardsService = retrofit.create(CardsService.class);

        try {
            Call<MTGResponse> call = cardsService.list();
            Response<MTGResponse> resp = call.execute();
            MTGResponse mtgResponse = resp.body();

            if (mtgResponse != null) {
                List<Card> cards = mtgResponse.cards;
                System.out.println(cards.size());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}