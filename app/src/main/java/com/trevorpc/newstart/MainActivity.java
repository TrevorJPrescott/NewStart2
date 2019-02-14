package com.trevorpc.newstart;

import android.Manifest;
import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.trevorpc.newstart.adapters.ResponseAdapter;
import com.trevorpc.newstart.viewmodel.ResponseViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ResponseViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ResponseViewModel viewModel = new ResponseViewModel(this.getApplication(),this);
//        viewModel.fetchLocation();

        RecyclerView recyclerView = findViewById(R.id.recycle_responses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final ResponseAdapter adapter = new ResponseAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ResponseViewModel(this.getApplication(),this);
        viewModel.fetchLocation();




    }


}
