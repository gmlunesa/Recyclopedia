package com.example.recyclopedia;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mariz on 2/21/2017.
 */
public class TopicAdapter extends ArrayAdapter<Topic> {
    public TopicAdapter(Activity context, List<Topic> topicList) {
        super(context, 0, topicList);
    }

    public View getView(int position, View convertView, final ViewGroup parent) {
        final Topic topic = getItem(position);

        TextView title = (TextView) convertView.findViewById(R.id.list_item_title);

        return convertView;
    }

}
