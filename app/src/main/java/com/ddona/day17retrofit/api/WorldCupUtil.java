package com.ddona.day17retrofit.api;

public class WorldCupUtil {
    private static final String BASE_URL = "https://obscure-gorge-93598.herokuapp.com/";
    private static WorldCupService INSTANCE;
    
    public static WorldCupService getWorldCupService() {
        return WorldCupClient.getWorldCupClient(BASE_URL).create(WorldCupService.class);
    }
}
