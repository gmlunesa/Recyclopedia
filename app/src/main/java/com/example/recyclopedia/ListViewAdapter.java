package com.example.recyclopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<Game> gameList = null;
    private ArrayList<Game> arraylist;

    public ListViewAdapter(Context context, List<Game> animalNamesList) {
        mContext = context;
        this.gameList = animalNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Game>();
        this.arraylist.addAll(animalNamesList);
    }

    public class ViewHolder {
        TextView name;
        TextView typeOfTrash;
        TextView reco;
    }

    @Override
    public int getCount() {
        return gameList.size();
    }

    @Override
    public Game getItem(int position) {
        return gameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.typeOfTrash = (TextView) view.findViewById(R.id.typeOfTrash);
            holder.reco = (TextView) view.findViewById(R.id.recoText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(gameList.get(position).getGameItem());
        holder.reco.setText(gameList.get(position).getGameDetails());

        if (gameList.get(position).getGameItemType() == 1) {
            holder.typeOfTrash.setText("Biodegradable");
        } else if (gameList.get(position).getGameItemType() == 2) {
            holder.typeOfTrash.setText("Non-biodegradable");
        } else if (gameList.get(position).getGameItemType() == 3) {
            holder.typeOfTrash.setText("Recyclable");
        }
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        gameList.clear();
        if (charText.length() == 0) {
            gameList.addAll(arraylist);
        } else {
            for (Game wp : arraylist) {
                if (wp.getGameItem().toLowerCase(Locale.getDefault()).contains(charText)) {
                    gameList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}