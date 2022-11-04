package com.david.livetennis.ui.calendar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.david.livetennis.R;
import com.david.livetennis.databinding.FragmentCalendarioBinding;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FragmentTorneos extends Fragment {

    private FragmentCalendarioBinding binding;
    private AdapterPersonalizadoTorneos adapter1;
    private SwipeRefreshLayout swipeRefreshLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCalendarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        swipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.swiperefreshlayout);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
                swipeRefreshLayout.setRefreshing(false);
                //swipeRefreshLayout.setEnabled(false);
            }
        });

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         ArrayList<TorneosATP> items = new ArrayList<>();

        adapter1 = new AdapterPersonalizadoTorneos(
                getContext(),
                R.layout.tournaments_card,
                items
        );

        binding.lvDatosTorneos.setAdapter(adapter1);
        refresh();


    }

    public void refresh() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {

            atpTournamentAPI apiTorneos = new atpTournamentAPI();
            ArrayList<TorneosATP> torneosATP = apiTorneos.getTorneos();

            handler.post(() -> {
                adapter1.clear();
                adapter1.addAll(torneosATP);
            });

        });

        FancyToast.makeText(getContext(),"Cargando...", FancyToast.LENGTH_LONG,FancyToast.CONFUSING,false).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}