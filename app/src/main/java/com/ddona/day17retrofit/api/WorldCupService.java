package com.ddona.day17retrofit.api;

import com.ddona.day17retrofit.model.Match;
import com.ddona.day17retrofit.model.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WorldCupService {

    @GET("lichthidau/all")
    Call<List<Match>> getAllMatches();

    @GET("cauthu/all")
    Call<List<Player>> getAllPlayer();
}
