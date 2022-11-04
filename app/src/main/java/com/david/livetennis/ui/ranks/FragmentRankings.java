package com.david.livetennis.ui.ranks;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.david.livetennis.R;
import com.david.livetennis.databinding.FragmentRankingsBinding;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FragmentRankings extends Fragment {

    private FragmentRankingsBinding binding;
    private AdapterPersonalizadoRankingATP adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ToggleButton toggleButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentRankingsBinding.inflate(inflater, container, false);
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

        ArrayList<RankingATP> items = new ArrayList<>();
        adapter = new AdapterPersonalizadoRankingATP(
                getContext(),
                R.layout.ranking_card,
                items
        );
        binding.lvDatos.setAdapter(adapter);
        refresh();
    }

    public void refresh() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {

            atpRankingAPI apiRanking = new atpRankingAPI();
            ArrayList<RankingATP> atpRankings = apiRanking.getAtpRankings();

            handler.post(() -> {
                adapter.clear();
                adapter.addAll(atpRankings);
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