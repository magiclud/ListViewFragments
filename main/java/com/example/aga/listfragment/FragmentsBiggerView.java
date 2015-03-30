package com.example.aga.listfragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by aga on 29.03.15.
 */
public class FragmentsBiggerView  extends Fragment implements FragmentsHandler.OnHeadlineSelectedListener {
    private TextView textDescription;
    private TextView textName;
    private ImageView imageOfAnimal;
    private Picture picture;
    private RatingBar ratingBar;
    private TextView ratingText;


    /**
     * Create a new instance of DetailsFragment, initialized to
     * show the text at 'index'.
     */
    public static FragmentsBiggerView newInstance(int index) {
        FragmentsBiggerView f = new FragmentsBiggerView();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_details, container, false);

        return view;
//        ScrollView scroller = new ScrollView(getActivity());
//        TextView text = new TextView(getActivity());
//        int padding = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                4, getActivity().getResources().getDisplayMetrics());
//        text.setPadding(padding, padding, padding, padding);
//        scroller.addView(text);
//        text.setText(Shakespeare.DIALOGUE[getShownIndex()]);
  //      return scroller;
    }


    public void setViewDetails(Picture picture) {
        textName= (TextView) getView().findViewById(R.id.textName);
        imageOfAnimal =(ImageView) getView().findViewById(R.id.bigPicture);
        textDescription= (TextView)getView().findViewById(R.id.textDescription);
        ratingBar =(RatingBar) getView().findViewById(R.id.ratingBar);
        ratingText = (TextView)getView().findViewById(R.id.ratingText);
        this.picture = picture;
        Log.d("FRAGMENT picture", "null ? "+ picture);
        textDescription.setText(picture.getDescription());
        textName.setText("Zwierzę: " + picture.getName());
        ratingText.setText(String.valueOf(picture.getMark()));
//        if(picture.getFromResource()){
//            Bitmap bitmap = BitmapFactory.decodeFile(picture.getPath());
//            imageOfAnimal.setImageBitmap(bitmap);
//        }else{
            imageOfAnimal.setImageResource(picture.getIconID());
      //  }
    }


    @Override
    public void onArticleSelected(int position) {

    }


}
