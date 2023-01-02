package com.ameny.tourismguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DetailsVilleActivity extends AppCompatActivity {
    TextView detailDesc, detailTitle;
    ImageView detailImage;
    RecyclerView recyclerView;
    List<VilleModel> dataList;
    VilleAdapter adapter;
    VilleModel androidData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_ville);
        detailDesc = findViewById(R.id.detailDesc);
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);
        Bundle bundle = getIntent().getExtras();
        List<VilleModel> list = (List<VilleModel>) bundle.getSerializable("LIST");
        if (bundle != null){
            detailDesc.setText(bundle.getInt("Desc"));
            detailImage.setImageResource(bundle.getInt("Image"));
            detailTitle.setText(bundle.getString("Title"));
        }


        //RecyclerView

        recyclerView = findViewById(R.id.recycler);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(DetailsVilleActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);


        if(!list.isEmpty()) {
            adapter = new VilleAdapter(DetailsVilleActivity.this, list);
            recyclerView.setAdapter(adapter);
        }
    }

}