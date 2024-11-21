package com.erns.canvaspre.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.erns.canvaspre.R;
import com.erns.canvaspre.adapters.PictureAdapter;
import com.erns.canvaspre.model.database.AppDatabase;
import com.erns.canvaspre.model.database.GalleryRepository;
import com.erns.canvaspre.model.ent.PictureEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class ListaPinturasFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private PictureAdapter adapter;
    private List<PictureEntity> pictureList;


    public static ListaPinturasFragment newInstance(String param1, String param2) {
        ListaPinturasFragment fragment = new ListaPinturasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        return inflater.inflate(R.layout.fragment_lista_pinturas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializar RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Inicializar la lista de imágenes
        pictureList = new ArrayList<>();
        loadDummyData(); // Método para agregar datos de ejemplo

        // Configurar el adapter
        adapter = new PictureAdapter(pictureList);
        recyclerView.setAdapter(adapter);
    }

    // Método para cargar datos de ejemplo
    private void loadDummyData() {

        GalleryRepository  repository = new GalleryRepository(AppDatabase.getInstance(requireContext()));
        Executors.newSingleThreadExecutor().execute(() -> {
            List<PictureEntity> data = repository.getPictures();
            Log.d("data", data.toString());
            pictureList.addAll(data);
        });

        //pictureList.add(new PictureEntity(2, "Pintura 2", "Autor 2", "Descripción 2", "link2", 1, 0.0f, 0.0f));
        //pictureList.add(new PictureEntity(3, "Pintura 3", "Autor 3", "Descripción 3", "link3", 1, 0.0f, 0.0f));

    }

}

