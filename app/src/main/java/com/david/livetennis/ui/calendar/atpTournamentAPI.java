package com.david.livetennis.ui.calendar;

import android.util.Log;

import com.david.livetennis.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class atpTournamentAPI {

    public ArrayList<TorneosATP> getTorneos() {

        try {
            String url = "https://ultimate-tennis1.p.rapidapi.com/tournament_list/atp/2022/atpgs?rapidapi-key=d2aaf1ccbamsh2793d6d9984e60bp178e04jsn43066642fa7f";
            String torneos = HttpUtils.get(url);

            JSONObject jsonTorneos = new JSONObject(torneos);
            JSONArray resultsTorneos = jsonTorneos.getJSONArray("Tournaments");

            ArrayList<TorneosATP> datosAtp = new ArrayList<>();


            for(int i = 0; i < resultsTorneos.length(); i++) {

                JSONObject tournamentsJson = resultsTorneos.getJSONObject(i);

                TorneosATP datosTournaments = new TorneosATP();

                datosTournaments.setNameTournament(tournamentsJson.getString("Tournament Name"));
                datosTournaments.setLocation(tournamentsJson.getString("Location"));
                datosTournaments.setDate(tournamentsJson.getString("Timestamp"));
                datosTournaments.setPrizeMoney(tournamentsJson.getString("Total Prize Money"));

                datosAtp.add(datosTournaments);


            }

            //Log.e("Partidos Directo:", datosAtp.toString());
            Log.e("Torneos:", datosAtp.toString());
            return datosAtp;


        } catch(IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;


    }


}
