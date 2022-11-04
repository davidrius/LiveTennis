package com.david.livetennis.ui.directo;

import java.util.List;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.david.livetennis.R;

public class AdapterPersonalizadoPartidosATP extends ArrayAdapter<ATP> {
    public AdapterPersonalizadoPartidosATP(Context context, int resource, List<ATP> object) {
        super(context, resource, object);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Mirem a veure si la View s'està reutilitzant, si no es així "inflem" la View
        ATP elementosATP = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.matches_card, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView tvJugador1 = convertView.findViewById(R.id.txtJugador1);
        TextView tvJugador2 = convertView.findViewById(R.id.txtJugador2);
        TextView tvSet1Jugador1 = convertView.findViewById(R.id.resultadoSet1Jugador1);
        TextView tvSet1Jugador2 = convertView.findViewById(R.id.resultadoSet1Jugador2);
        TextView tvSet2Jugador1 = convertView.findViewById(R.id.resultadoSet2Jugador1);
        TextView tvSet2Jugador2 = convertView.findViewById(R.id.resultadoSet2Jugador2);
        TextView tvSet3Jugador1 = convertView.findViewById(R.id.resultadoSet3Jugador1);
        TextView tvSet3Jugador2 = convertView.findViewById(R.id.resultadoSet3Jugador2);
        TextView tvActualScoreP1 = convertView.findViewById(R.id.ScoreActualP1);
        TextView tvActualScoreP2 = convertView.findViewById(R.id.ScoreActualP2);
        TextView tvTorneo = convertView.findViewById(R.id.txtNombreTorneo);

        String colorScore = "#8c958c";
        String colorScoreAlto = "#e3e4e5";

        // Fiquem les dades dels objectes (provinents del JSON) en el layout

        tvJugador1.setText(elementosATP.getJugadorLocal());
        tvJugador2.setText(elementosATP.getJugadorVisitante());
        tvTorneo.setText(elementosATP.getTournament());

        Log.e("Partidos Directo:", elementosATP.getSet3P1());

        //Comprobaciones con los set actuales de cada jugador

        if (elementosATP.getSet1P1().equals("None")){

            tvSet1Jugador1.setVisibility(View.INVISIBLE);

        }else{

            tvSet1Jugador1.setText(elementosATP.getSet1P1());

        }
        if (elementosATP.getSet1P2().equals("None")){

            tvSet1Jugador2.setVisibility(View.INVISIBLE);

        }else{

            tvSet1Jugador2.setText(elementosATP.getSet1P2());

        }
        if (elementosATP.getSet2P1().equals("None")){

            tvSet2Jugador1.setVisibility(View.INVISIBLE);

        }else{

            tvSet2Jugador1.setText(elementosATP.getSet2P1());

        }
        if (elementosATP.getSet2P2().equals("None")){

            tvSet2Jugador2.setVisibility(View.INVISIBLE);

        }else{

            tvSet2Jugador2.setText(elementosATP.getSet2P2());

        }
        if (elementosATP.getSet3P1().equals("None")){

            tvSet3Jugador1.setVisibility(View.INVISIBLE);

        }else{

            tvSet3Jugador1.setText(elementosATP.getSet3P1());

        }
        if (elementosATP.getSet3P2().equals("None")){

            tvSet3Jugador2.setVisibility(View.INVISIBLE);

        }else{

            tvSet3Jugador2.setText(elementosATP.getSet3P2());

        }

        //Comprobaciones con el score actual de cada jugador

        if(elementosATP.getActualScoreP1().equals("None")){

            tvActualScoreP1.setText("0");

        }
        if(elementosATP.getActualScoreP2().equals("None")){

            tvActualScoreP2.setText("0");

        }


        if(tvActualScoreP1.getText().equals("0")){

            tvActualScoreP1.setTextColor(Color.parseColor(colorScore));

        }else{

            tvActualScoreP1.setText(elementosATP.getActualScoreP1());

        }

        if(tvActualScoreP2.getText().equals("0")){

            tvActualScoreP2.setTextColor(Color.parseColor(colorScore));

        }else{

            tvActualScoreP2.setText(elementosATP.getActualScoreP2());

        }

        String set1P1 = (String) elementosATP.getSet1P1();
        String set1P2 = (String) elementosATP.getSet1P2();
        String set2P1 = (String) elementosATP.getSet2P1();
        String set2P2 = (String) elementosATP.getSet2P2();
        String set3P1 = (String) elementosATP.getSet3P1();
        String set3P2 = (String) elementosATP.getSet3P2();

            //P1 mayor

            /*if((!elementosATP.getSet1P1().equals("None")) || (!elementosATP.getSet1P2().equals("None")) ||
                    (!elementosATP.getSet2P1().equals("None")) || (!elementosATP.getSet2P2().equals("None")) ||
                    (!elementosATP.getSet3P1().equals("None")) || (!elementosATP.getSet3P2().equals("None"))) {

                if (set1P1.compareTo(set1P2) < 0 || set2P1.compareTo(set2P2) < 0 || set3P1.compareTo(set3P2) < 0) {

                    tvSet1Jugador2.setText(set1P2);
                    tvSet1Jugador2.setTypeface(null, Typeface.BOLD);
                    tvSet2Jugador2.setText(set2P2);
                    tvSet2Jugador2.setTypeface(null, Typeface.BOLD);
                    tvSet3Jugador2.setText(set3P2);
                    tvSet3Jugador2.setTypeface(null, Typeface.BOLD);


                }else if(set1P1.compareTo(set1P2) > 0 || set2P1.compareTo(set2P2) > 0 || set3P1.compareTo(set3P2) > 0){

                    tvSet1Jugador1.setText(set1P1);
                    tvSet1Jugador1.setTypeface(null, Typeface.BOLD);
                    tvSet2Jugador1.setText(set2P1);
                    tvSet2Jugador1.setTypeface(null, Typeface.BOLD);
                    tvSet3Jugador1.setText(set3P1);
                    tvSet3Jugador1.setTypeface(null, Typeface.BOLD);

                }/*else {

                    tvSet1Jugador1.setText(set1P1);
                    tvSet1Jugador2.setText(set1P2);
                    tvSet2Jugador1.setText(set2P1);
                    tvSet2Jugador2.setText(set2P2);
                    tvSet3Jugador1.setText(set3P1);
                    tvSet3Jugador2.setText(set3P2);

                }
            }*/



        /*if(Integer.parseInt(elementosATP.getActualScoreP1()) > Integer.parseInt(elementosATP.getActualScoreP2())){

            tvActualScoreP1.setTextColor(Color.parseColor("#2c56a5"));

        }else{

            tvActualScoreP2.setTextColor(Color.parseColor("#2c56a5"));

        }*/

        /*if(Integer.parseInt(elementosATP.getActualScoreP1()) > Integer.parseInt(elementosATP.getActualScoreP2())){

            tvActualScoreP1.setTextColor(Color.parseColor(colorScoreAlto));
            tvActualScoreP1.setTypeface(null, Typeface.BOLD);

        }else{

            tvActualScoreP1.setTextColor(Color.parseColor(colorScoreAlto));
            tvActualScoreP2.setTextColor(Color.parseColor(colorScoreAlto));
            tvActualScoreP2.setTypeface(null, Typeface.BOLD);

        }*/

        // Retornem la View replena per a mostrar-la
        return convertView;

    }

}