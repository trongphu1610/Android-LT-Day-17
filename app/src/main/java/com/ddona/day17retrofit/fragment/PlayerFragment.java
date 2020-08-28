package com.ddona.day17retrofit.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.ddona.day17retrofit.R;
import com.ddona.day17retrofit.adapter.PlayerAdapter;
import com.ddona.day17retrofit.model.Player;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PlayerFragment extends Fragment {
    private List<Player> arrPlayer;
    private PlayerAdapter adapter;
    private RecyclerView rvPlayer;
    private static PlayerFragment playerFragment;

    @SuppressLint("ValidFragment")
    private PlayerFragment() {

    }

    public static PlayerFragment getInstance() {
        if (playerFragment == null) {
            playerFragment = new PlayerFragment();
        }
        return playerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_viewpager_item, container, false);
        rvPlayer = view.findViewById(R.id.rv_matches);
        rvPlayer.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rvPlayer.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrPlayer = new ArrayList<>();
        arrPlayer.add(new Player(1, "Trung doan", "Vietnam", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png", "facebook.com"));
        arrPlayer.add(new Player(1, "Trung doan", "Vietnam", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png", "facebook.com"));
        arrPlayer.add(new Player(1, "Trung doan", "Vietnam", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png", "facebook.com"));
        arrPlayer.add(new Player(1, "Trung doan", "Vietnam", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png", "facebook.com"));
        adapter = new PlayerAdapter(arrPlayer, getContext());

    }
}
