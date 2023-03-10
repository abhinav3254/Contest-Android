package com.example.kontest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kontest.api.APIHandle;
import com.example.kontest.databinding.ActivityMainBinding;
import com.example.kontest.extra_stuffs.ExtraThings;
import com.example.kontest.recycler_view.CustomAdapter;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding binding;
    APIHandle.CallAPIInterface callAPIInterface;
    List<Pojo> list;
    CustomAdapter adapter;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle("Loading Data");
        dialog.show();

        binding.all.setOnClickListener(this);
        binding.codeforces.setOnClickListener(this);
        binding.leetCode.setOnClickListener(this);
        binding.codeforcesGym.setOnClickListener(this);
        binding.topCoder.setOnClickListener(this);
        binding.atCoder.setOnClickListener(this);
        binding.codeChef.setOnClickListener(this);
        binding.csAcademy.setOnClickListener(this);
        binding.hackerRank.setOnClickListener(this);
        binding.hackerEarth.setOnClickListener(this);
        binding.kickStart.setOnClickListener(this);


        byDefault("all");

    }

    void byDefault (String URL) {
        callAPIInterface = APIHandle.getAPIHandleMethod();
        callAPIInterface.getAll(URL).enqueue(new Callback<List<Pojo>>() {
            @Override
            public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {
                dialog.dismiss();
                if (response.body().size()>0) {
                    list = response.body();
                    binding.emptyImage.setVisibility(View.GONE);
                    binding.emptyText.setVisibility(View.GONE);
                    adapter = new CustomAdapter(MainActivity.this,list);
                    binding.recyclerMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    binding.recyclerMain.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                    binding.emptyImage.setVisibility(View.VISIBLE);
                    binding.emptyText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Pojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String URL = button.getText().toString();
        byDefault(URL);
        dialog.setTitle("Loading "+URL);
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_three_dots,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.show_bookmarks :
                startActivity(new Intent(MainActivity.this,BookMarkActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}