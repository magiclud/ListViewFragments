package com.example.aga.listfragment;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by aga on 28.03.15.
 */
public class FragmentsHandler extends ListFragment {


    private ArrayList<Picture> pictures = new ArrayList<>();
    private int[] itemDrawables;        // ListView items list

    OnHeadlineSelectedListener listener;

    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
//        public void updateList();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            listener = (OnHeadlineSelectedListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        itemDrawables = new int[]{R.drawable.jelen, R.drawable.kot, R.drawable.mysz, R.drawable.pies, R.drawable.sarna, R.drawable.tygrys, R.drawable.sowa1, R.drawable.zaba,};
        String[] itemNames = new String[]{"jelen", "kot", "mysz", "pies", "sarna", "tygrys", "sowa", "zaba"};
        String[] itemDescriptions = getResources().getStringArray(R.array.animalDescriptions);

        setPicturesList(itemDrawables, itemNames, itemDescriptions);
        setListAdapter(new MyListAdapter(getActivity(), pictures));
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        return view;
    }

    private void setPicturesList(int[] drawables, String[] names, String[] description) {

        for (int i = 0; i < drawables.length; i++) {
            pictures.add(new Picture(names[i], drawables[i], description[i]));
        }
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Send the event to the host activity
        listener.onArticleSelected(position);

        Log.d("FRAGMENTTTTT ", "kliknięto: "+position);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }


    }


