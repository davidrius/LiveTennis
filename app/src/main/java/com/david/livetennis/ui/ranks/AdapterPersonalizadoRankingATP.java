package com.david.livetennis.ui.ranks;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.david.livetennis.R;

import java.util.List;

public class AdapterPersonalizadoRankingATP extends ArrayAdapter<RankingATP> {

    public AdapterPersonalizadoRankingATP(Context context, int resource, List<RankingATP> object) {
        super(context, resource, object);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Mirem a veure si la View s'està reutilitzant, si no es així "inflem" la View
        RankingATP rankingATP = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.ranking_card, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView tvNumeroRanking = convertView.findViewById(R.id.txtNumeroRanking);
        TextView tvNombreJugador = convertView.findViewById(R.id.txtNombreJugador);
        TextView tvNumeroPuntos = convertView.findViewById(R.id.txtPuntos);
        TextView tvDiferenciaPuntos = convertView.findViewById(R.id.txtDiferenciaPuntos);


        // Fiquem les dades dels objectes (provinents del JSON) en el layout

        tvNumeroRanking.setText(Integer.toString(rankingATP.getRank())+".");
        tvNombreJugador.setText(rankingATP.getName());
        tvNumeroPuntos.setText(rankingATP.getLivePoints());
        tvDiferenciaPuntos.setText(rankingATP.getPointsDifference());

        //tvActualScoreP1.setTextColor(Color.parseColor(colorScore));

        String diferencia = tvDiferenciaPuntos.getText().toString();
        String caracterBuscado = "-";

        for(int i = 0; i < diferencia.length(); i++){

            if(diferencia.contains(caracterBuscado) == true){

                tvDiferenciaPuntos.setTextColor(Color.parseColor("#e71837"));

            }else{

                tvDiferenciaPuntos.setTextColor(Color.parseColor("#49b675"));

            }

        }


        // Retornem la View replena per a mostrar-la
        return convertView;

    }


}
