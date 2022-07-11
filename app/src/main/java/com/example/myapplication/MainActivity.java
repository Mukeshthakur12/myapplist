package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.ListView;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
   ListView superListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    superListView = findViewById(R.id.superListView);
   superHeros();
}
private void superHeros(){
    Call<List<Results>> call= RetrofitClient.getInstance();
    call.enqueue(new Callback<List<Results>>() {
        @Override
        public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
            List<Results> myheroList = response.body();
            String[] oneHeroes = new String[myheroList.size()];

            for (int i = 0; i < myheroList.size(); i++) {
                oneHeroes[i] = myheroList.get(i).getName();
            }

            superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
        }

        @Override
        public void onFailure(Call<List<Results>> call, Throwable t) {
            Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
        }

    });
}
}