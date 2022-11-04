package com.david.livetennis.ui.directo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.david.livetennis.R;
import com.david.livetennis.databinding.FragmentResultadosBinding;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FragmentPartidos extends Fragment {

    private FragmentResultadosBinding binding;
    private AdapterPersonalizadoPartidosATP adapter2;
    private SwipeRefreshLayout swipeRefreshLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentResultadosBinding.inflate(inflater, container, false);
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

        ArrayList<ATP> items = new ArrayList<>();
        adapter2 = new AdapterPersonalizadoPartidosATP(
                getContext(),
                R.layout.matches_card,
                items
        );

        binding.lvDatosPartidos.setAdapter(adapter2);
        refresh();
    }

    public void refresh() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {

            atpAPI api = new atpAPI();
            ArrayList<ATP>  atp = api.getAtp();


            handler.post(() -> {
                adapter2.clear();
                adapter2.addAll(atp);
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