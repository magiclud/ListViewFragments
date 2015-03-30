package com.example.aga.listfragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * Created by aga on 22.03.15.
 */
public class DetailsAboutItem extends Activity  {

    private static final int REQ_CODE =123 ;//request code
    private Intent intent;
    private TextView textDescription;
    private TextView textName;
    private ImageView imageOfAnimal;
    private Picture picture;
    private  RatingBar ratingBar;
    private TextView ratingText;
    private int indexCurrentPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("cyklZycia", "onCreate_SecondActivity");
        setContentView(R.layout.item_details);

        setWidget();
        getDataFromMainActivity();
        listenAndChangeRatingar();
    }

    @Override
    public void onBackPressed() {
     //   Toast.makeText(this, "jestem w onStop", Toast.LENGTH_SHORT).show();
        Log.d("cyklZycia", "onBackPressed_SecondActivity");
        sendDataBackToMainActivity();
        super.onBackPressed();
    }

   public void sendDataBackToMainActivity(){
       intent = new Intent();
       intent.putExtra("indexChangedPicture", indexCurrentPicture);
       Log.d("NOWA OCENA ",String.valueOf(picture.getMark()));
       intent.putExtra("newMark", picture.getMark());
       setResult(REQ_CODE, intent);
       finish();
   }

    public void  setWidget(){
        textDescription = (TextView) findViewById(R.id.textDescription);
        imageOfAnimal = (ImageView) findViewById(R.id.bigPicture);
        textName = (TextView) findViewById(R.id.textName);
        ratingText=(TextView)findViewById(R.id.ratingText);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
    }

    public void getDataFromMainActivity() {
        intent = getIntent();
        picture = (Picture) intent.getSerializableExtra("pictureItem");
        indexCurrentPicture = intent.getIntExtra("inedexPicture", 0);
        if(picture.getFromResource()){
            Bitmap bitmap = BitmapFactory.decodeFile(picture.getPath());
            imageOfAnimal.setImageBitmap(bitmap);
        }else{
            imageOfAnimal.setImageResource(picture.getIconID());
        }
        textDescription.setText(picture.getDescription());
        textName.setText("Zwierzę: " + picture.getName());
        ratingText.setText(String.valueOf(picture.getMark()));

    }
    public void listenAndChangeRatingar(){
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //  Toast.makeText(getApplicationContext(), "oceniono zdjecie", Toast.LENGTH_SHORT).show();
                ratingText.setText(String.valueOf(rating));
                picture.setMark(rating);
            }


        });
    }
    @Override
    public  void onStart(){
        super.onStart();
        Log.d("cyklZycia", "onStart_SecondActivity");
    }
    @Override
    public  void onResume(){
        super.onResume();
        Log.d("cyklZycia", "onResume_SecondActivity");
    }
    @Override
    public  void onRestart(){
        super.onRestart();
        Log.d("cyklZycia", "onRestart_SecondActivity");
    }
    @Override
    public  void onPause(){
        super.onPause();
        Log.d("cyklZycia", "onPause_SecondActivity");
    }
    @Override
    public  void onStop(){
        super.onStop();
        Log.d("cyklZycia", "onStop_SecondActivity");
    }
    @Override
    public  void onDestroy(){
        super.onDestroy();
        Log.d("cyklZycia", "onDestroy_SecondActivity");
    }
}
