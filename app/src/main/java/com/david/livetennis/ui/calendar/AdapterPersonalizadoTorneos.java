package com.david.livetennis.ui.calendar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.david.livetennis.R;

import java.util.List;

    public class AdapterPersonalizadoTorneos extends ArrayAdapter<TorneosATP> {

        public AdapterPersonalizadoTorneos(Context context, int resource, List<TorneosATP> object) {
        super(context, resource, object);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Mirem a veure si la View s'està reutilitzant, si no es així "inflem" la View
        TorneosATP torneosATP = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tournaments_card, parent, false);
        }

        // Unim el codi en les Views del Layout

        TextView tvNombreTorneo = convertView.findViewById(R.id.txtNombreTorneo);
        TextView tvCiudadTorneo = convertView.findViewById(R.id.txtCiudadTorneo);
        TextView tvPrizeMoney = convertView.findViewById(R.id.txtPrizeMoney);
        TextView tvDate = convertView.findViewById(R.id.txtDate);


        // Fiquem les dades dels objectes (provinents del JSON) en el layout

        tvNombreTorneo.setText(torneosATP.getNameTournament());
        tvCiudadTorneo.setText(torneosATP.getLocation());
        tvPrizeMoney.setText(torneosATP.getPrizeMoney());
        tvDate.setText(torneosATP.getDate());

        Log.e("Ranking:", torneosATP.getNameTournament() + torneosATP.getLocation() +
                torneosATP.getPrizeMoney() + torneosATP.getDate());

        // Retornem la View replena per a mostrar-la
        return convertView;

    }



}
