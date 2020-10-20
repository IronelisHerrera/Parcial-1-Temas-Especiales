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
    private FragmentManager is_vertical;
    private FragmentManager is_horizontal;


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
        show_dec.setText(array_description[position_id]);
        when_click_vertical_fragment();
    }

    //portrait function

    public void check_orientation(){
        vertical= findViewById(R.id.main_activity_horizontal);
        horizontal = findViewById(R.id.main_activity_vertical);
        if(vertical == null){
            is_vertical = this.getSupportFragmentManager();
            is_vertical.beginTransaction().show(Objects.requireNonNull(is_vertical.findFragmentById(R.id.fragment_list))).hide(Objects.requireNonNull(is_vertical.findFragmentById(R.id.fragment_description))).commit();
            return;
        }
       if (horizontal == null){
           is_horizontal = this.getSupportFragmentManager();
           is_horizontal.beginTransaction().show(Objects.requireNonNull(is_horizontal.findFragmentById(R.id.fragment_description))).commit();
       }
    }

    public void when_click_vertical_fragment(){
        vertical = findViewById(R.id.main_activity_horizontal);
        is_horizontal = this.getSupportFragmentManager();
        if(vertical == null){
            is_horizontal.beginTransaction().hide(Objects.requireNonNull(is_vertical.findFragmentById(R.id.fragment_list))).show(Objects.requireNonNull(is_horizontal.findFragmentById(R.id.fragment_description))).addToBackStack(null).commit();
        }

    }


}