package com.david.livetennis.ui.ranks;

import android.util.Log;

import com.david.livetennis.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class atpRankingAPI {

    public ArrayList<RankingATP> getAtpRankings() {

        String id = "";

        try {

            String url = "https://ultimate-tennis1.p.rapidapi.com/live_leaderboard/100?rapidapi-key=d2aaf1ccbamsh2793d6d9984e60bp178e04jsn43066642fa7f";
            String ranking = HttpUtils.get(url);

            JSONObject jsonRankings = new JSONObject(ranking);
            JSONArray resultsRanking = jsonRankings.getJSONArray("data");

            ArrayList<RankingATP> datosAtpRanking = new ArrayList<>();

            for (int k = 0; k < resultsRanking.length(); k++) {

                JSONObject rankingJson = resultsRanking.getJSONObject(k);

                RankingATP datosRankings = new RankingATP();

                datosRankings.setName(rankingJson.getString("Name"));
                datosRankings.setAge(rankingJson.getString("Age"));
                datosRankings.setRank(rankingJson.getInt("Rank"));
                datosRankings.setLivePoints(rankingJson.getString("Live Points"));
                datosRankings.setPointsDifference(rankingJson.getString("Points Difference"));
                datosRankings.setId(rankingJson.getString("id"));

                id = rankingJson.getString("id");


                datosAtpRanking.add(datosRankings);

            }

            Log.e("Rankings En Directo:", datosAtpRanking.toString());
            return datosAtpRanking;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*try {

            String url1 = "https://ultimate-tennis1.p.rapidapi.com/player_info/" + id + "?rapidapi-key=775279fd3bmsh00645d573144cffp1d657ajsnb80d6ecb9d87";
            String rankingData = HttpUtils.get(url1);

            JSONObject jsonRankingsData = new JSONObject(rankingData);
            JSONArray resultsRankingData = jsonRankingsData.getJSONArray("player_data");

            ArrayList<RankingATP> datosAtpRankingJugadores = new ArrayList<>();

            for (int i = 0; i < resultsRankingData.length(); i++) {

                JSONObject rankingJsonData = resultsRankingData.getJSONObject(i);

                RankingATP datosRankingsData = new RankingATP();

                datosRankingsData.setBirthPlace(rankingJsonData.getString("Birthplace"));
                datosRankingsData.setCoach(rankingJsonData.getString("Coach"));

                datosAtpRankingJugadores.add(datosRankingsData);

            }

            Log.e("Datos Jugador:", datosAtpRankingJugadores.toString());
            return datosAtpRankingJugadores;

            } catch(JSONException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }*/

            return null;


        }

    }
