package com.example.fragmentsandlistview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ListFragment;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;

public class list_fragment extends ListFragment {


    public list_fragment() {
        // Required empty public constructor
    }
    private ChessPieceListener show_description;
    private Fragment list_on_click;
    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //list_on_click = getFragmentManager().
        ArrayAdapter<String> item_list_adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.frontend));
        setListAdapter(item_list_adapter);


    }
    public interface ChessPieceListener {
        public void when_list_clicked(int position_id);
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        show_description = (ChessPieceListener) context;
    }

    @Override
    public void onListItemClick(@NonNull @NotNull ListView l, @NonNull @NotNull View v, int position, long id) {
        show_description.when_list_clicked(position);
    }
}