package com.example.recyclopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alpha on 2/21/2017.
 */

public class EncyclopediaAdapter  extends BaseExpandableListAdapter{
    private Context context;
    private HashMap<String, List<String>> TopicsHashMap;
    private List<String> subjects;
    public EncyclopediaAdapter(Context context, HashMap<String, List<String>> hashMap, List<String> list ){
        this.context = context;
        this.TopicsHashMap = hashMap;
        this.subjects = list;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String topic = (String)getGroup(groupPosition);
        // System.out.println("new subject" + topic + "numoftopics:" + getChildrenCount(groupPosition));
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.encyclopedia, null);
        }
        TextView topicText = (TextView) convertView.findViewById(R.id.exp_title);
        topicText.setText(topic);
        //ImageView topicImg = (ImageView) convertView.findViewById(R.id.exp_image);
        //topicImg.setImageResource(topic.getImageResourceId());
        return convertView;
    }
    @Override
    public View getChildView(int listPos, final int expandedListPos, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childTitle = (String) getChild(listPos, expandedListPos);
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.encylopedia_child,parent, false);
        }
        TextView childTextView = (TextView) convertView.findViewById(R.id.textViewChild);
        childTextView.setText(childTitle);
        return convertView;
    }
    @Override
    public int getChildrenCount(int listPos) {
        return this.TopicsHashMap.get(this.subjects.get(listPos)).size();
    }
    @Override
    public boolean isChildSelectable(int listPos, int expandedListPos) {
        return true;
    }
    @Override
    public int getGroupCount() {
        return this.subjects.size();
    }
    @Override
    public long getChildId(int listPos, int expandedListPos) {
        return expandedListPos;
    }
    @Override
    public boolean hasStableIds(){
        return true;
    }
    @Override
    public Object getChild(int listPos, int expandedListPos) {
        return this.TopicsHashMap.get(subjects.get(listPos)).get(expandedListPos);
    }
    @Override
    public long getGroupId(int listPos) {
        return listPos;
    }
    @Override
    public Object getGroup(int listPos) {
        return this.subjects.get(listPos);
    }


}
