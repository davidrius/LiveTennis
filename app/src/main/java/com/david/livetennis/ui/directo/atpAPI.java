package com.david.livetennis.ui.directo;

import com.david.livetennis.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class atpAPI {

    public ArrayList<ATP> getAtp() {

        try {
            String url = "https://ultimate-tennis1.p.rapidapi.com/live_scores?rapidapi-key=d2aaf1ccbamsh2793d6d9984e60bp178e04jsn43066642fa7f";
            String matches = HttpUtils.get(url);

            JSONObject jsonMatches = new JSONObject(matches);
            JSONArray resultsMatches = jsonMatches.getJSONArray("matches");

            ArrayList<ATP> datosAtp = new ArrayList<>();


            for(int i = 0; i < resultsMatches.length(); i++) {

                JSONObject matchesJson = resultsMatches.getJSONObject(i);

                ATP datosMatches = new ATP();

                datosMatches.setJugadorVisitante(matchesJson.getString("Away Player"));
                datosMatches.setJugadorLocal(matchesJson.getString("Home Player"));
                datosMatches.setTournament(matchesJson.getString("Tournament"));
                datosMatches.setSurface(matchesJson.getString("Surface"));
                datosMatches.setRonda(matchesJson.getString("Round"));
                datosMatches.setSet1P1(matchesJson.getString("Set1 Player 1"));
                datosMatches.setSet1P2(matchesJson.getString("Set1 Player 2"));
                datosMatches.setSet2P1(matchesJson.getString("Set2 Player 1"));
                datosMatches.setSet2P2(matchesJson.getString("Set2 Player 2"));
                datosMatches.setSet3P1(matchesJson.getString("Set3 Player 1"));
                datosMatches.setSet3P2(matchesJson.getString("Set3 Player 2"));
                datosMatches.setActualScoreP1(matchesJson.getString("Player 1 Score"));
                datosMatches.setActualScoreP2(matchesJson.getString("Player 2 Score"));

                datosAtp.add(datosMatches);


            }

            //Log.e("Partidos Directo:", datosAtp.toString());
            return datosAtp;


        } catch(IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;


    }

}
