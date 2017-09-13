package com.example.enzo.databindingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.enzo.databindingdemo.BidirectionBinding.BidirectionBindingActivity;
import com.example.enzo.databindingdemo.EventHandling.EventHandlingActivity;
import com.example.enzo.databindingdemo.ListBinding.ListBindingActivity;
import com.example.enzo.databindingdemo.UnidirectionBinding.UnidirectionBindingActivity;

import java.util.List;

public class MainActivity extends Activity {
    private final ListItem[] mListItems = {
            new ListItem("UnidirectionBinding", UnidirectionBindingActivity.class),
            new ListItem("BidirectionBinding", BidirectionBindingActivity.class),
            new ListItem("EventHandling", EventHandlingActivity.class),
            new ListItem("ListBinding", ListBindingActivity.class)
    };

    private RecyclerView list_activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_activities = findViewById(R.id.list_activities);
        list_activities.setAdapter(new ListAdapter());
        list_activities.setLayoutManager(new LinearLayoutManager(this));
    }


    /**
     * ListItem
     */
    private class ListItem {
        public String   activityName;
        public Class<?> activityClass;

        public ListItem(String activityName, Class<?> activityClass) {
            this.activityName = activityName;
            this.activityClass = activityClass;
        }
    }


    /**
     * ItemViewHolder
     */
    private class ItemViewHolder extends ViewHolder {
        public ItemViewHolder(TextView itemView) {
            super(itemView);
        }

        public void setText(String text) {
            ((TextView) itemView).setText(text);
        }
    }


    /**
     * UserListAdapter
     */
    private class ListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView view = (TextView) getLayoutInflater().inflate(R.layout.activity_main_list_item, parent, false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, final int position) {
            holder.setText(mListItems[position].activityName);
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, mListItems[position].activityClass));
                }
            });
        }

        @Override
        public int getItemCount() {
            return mListItems.length;
        }
    }
}
