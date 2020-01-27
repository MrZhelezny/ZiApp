package com.zhelezny.ziapp.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhelezny.ziapp.MainAdapter;
import com.zhelezny.ziapp.R;
import com.zhelezny.ziapp.model.Animal;
import com.zhelezny.ziapp.presenter.DataPresenter;

import java.util.List;

public class AnimalFragment extends Fragment implements MainInterface {
    private Context mContext;
    private RecyclerView recyclerView;
    private SharedPreferences sPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        mContext = view.getContext();
        recyclerView = view.findViewById(R.id.rv_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        DataPresenter dataPresenter = new DataPresenter(this);
        dataPresenter.getData(getKindOfAnimal());

        return view;
    }

    @Override
    public void showList(List<Animal> animals) {
        MainAdapter adapter = new MainAdapter(mContext, animals, this);
        recyclerView.setAdapter(adapter);
    }

    public void setKindOfAnimal(Context context, String kind) {
        sPref = context.getSharedPreferences("kind", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("kind", kind);
        ed.apply();
    }

    private String getKindOfAnimal() {
        sPref = mContext.getSharedPreferences("kind", Context.MODE_PRIVATE);
        return sPref.getString("kind", "0");
    }
}