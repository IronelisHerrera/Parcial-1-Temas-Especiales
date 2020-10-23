package com.example.fragmentsandlistview;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements list_fragment.ChessPieceListener {

    private TextView show_dec;
    LinearLayout vertical;
    LinearLayout horizontal;
    private FragmentManager orientation_manager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_dec = findViewById(R.id.text_view_desc_id);
        check_orientation();
    }

    @Override
    public void when_list_clicked(int position_id) {
        String [] array_description = getResources().getStringArray(R.array.frontend_description);
        when_click_vertical_fragment();
        show_dec.setText(array_description[position_id]);


    }

    public void check_orientation(){
        vertical= findViewById(R.id.main_activity_vertical);
        horizontal = findViewById(R.id.main_activity_horizontal);
        if(horizontal == null){
            orientation_manager = this.getSupportFragmentManager();
            orientation_manager.beginTransaction().show(Objects.requireNonNull(orientation_manager.findFragmentById(R.id.fragment_list))).hide(Objects.requireNonNull(orientation_manager.findFragmentById(R.id.fragment_description))).commit();
           return;
        }
       if (vertical == null){
           orientation_manager = this.getSupportFragmentManager();
           orientation_manager.beginTransaction().show(Objects.requireNonNull(orientation_manager.findFragmentById(R.id.fragment_list))).show(Objects.requireNonNull(orientation_manager.findFragmentById(R.id.fragment_description))).commit();
       }
    }


    public void when_click_vertical_fragment(){
        horizontal = findViewById(R.id.main_activity_horizontal);

        if(horizontal == null){
            orientation_manager.beginTransaction().hide(Objects.requireNonNull(orientation_manager.findFragmentById(R.id.fragment_list))).show(Objects.requireNonNull(orientation_manager.findFragmentById(R.id.fragment_description))).addToBackStack(null).commit();
        }
    }


}