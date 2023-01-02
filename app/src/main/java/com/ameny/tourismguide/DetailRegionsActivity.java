package com.ameny.tourismguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailRegionsActivity extends AppCompatActivity {
    TextView detailDesc, detailTitle;
    ImageView detailImage;
    RecyclerView recyclerView;
    List<VilleModel> dataList;
  VilleAdapter adapter;
    VilleModel androidData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_regions);
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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(DetailRegionsActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);


if(!list.isEmpty()) {
    adapter = new VilleAdapter(DetailRegionsActivity.this, list);
    recyclerView.setAdapter(adapter);
}
    }

}