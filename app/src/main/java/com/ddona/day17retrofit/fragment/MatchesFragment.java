package com.ddona.day17retrofit.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


import com.ddona.day17retrofit.R;
import com.ddona.day17retrofit.adapter.MatchesAdapter;
import com.ddona.day17retrofit.api.WorldCupUtil;
import com.ddona.day17retrofit.model.Match;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MatchesFragment extends Fragment {
    private List<Match> arrMatches;
    private MatchesAdapter adapter;
    private RecyclerView rvMatch;
    private static MatchesFragment matchesFragment;

    @SuppressLint("ValidFragment")
    private MatchesFragment() {

    }

    public static MatchesFragment getInstance() {
        if (matchesFragment == null) {
            matchesFragment = new MatchesFragment();
        }
        return matchesFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_viewpager_item, container, false);
        rvMatch = view.findViewById(R.id.rv_matches);
        rvMatch.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rvMatch.setAdapter(adapter);
        WorldCupUtil.getWorldCupService().getAllMatches().enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                if (response.isSuccessful()) {
                    arrMatches.clear();
                    arrMatches.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {

            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrMatches = new ArrayList<>();
        adapter = new MatchesAdapter(arrMatches, getActivity());
    }
}
