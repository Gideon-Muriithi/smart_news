package com.pluralsight.smartnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class NewsDescription extends AppCompatActivity {
    String text, image;
    TextView mTextView;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_description);

        mTextView = findViewById(R.id.name_textView);
        mImageView = findViewById(R.id.news_image);


        Intent intent = getIntent();
        text = intent.getStringExtra("text");
        image = intent.getStringExtra("image");


//       use bundle to handle images
//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            image = intent.getStringExtra("image");
//        } else {
//            Toast.makeText(this, "No image found", Toast.LENGTH_SHORT).show();
//        }

        //Toast.makeText(this, "Text and image" + " " + image + " " + text, Toast.LENGTH_SHORT).show();

        mTextView.setText("A significant proportion of healthcare in Myanmar is now being delivered outside state hospitals, by doctors and nurses who oppose the military and are loyal to the National Unity Government challenging the junta's legitimacy, medical workers in the country told the BBC.");
//        mImageView.setImageResource();

        Glide.with(this)
                .load(image)
                .placeholder(R.drawable.news)
                .into(mImageView);

    }
}