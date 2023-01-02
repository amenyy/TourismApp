package com.ameny.tourismguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StartPage extends AppCompatActivity {
Button im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
//ImageSlider
        ImageSlider imageSlider=findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.un, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.deux, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.trois, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.quatre, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cinq, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.six, ScaleTypes.FIT));


        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
        im=findViewById(R.id.start);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(StartPage.this, HomeActivity.class);

                startActivity(i);
            }
        });

    }
}