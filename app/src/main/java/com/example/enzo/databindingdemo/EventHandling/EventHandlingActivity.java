package com.example.enzo.databindingdemo.EventHandling;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.enzo.databindingdemo.BR;
import com.example.enzo.databindingdemo.BidirectionBinding.ObservableUser;
import com.example.enzo.databindingdemo.R;
import com.example.enzo.databindingdemo.UnidirectionBinding.User;
import com.example.enzo.databindingdemo.databinding.EventHandlingBinding;

public class EventHandlingActivity extends Activity {
    private EventHandlingBinding mBinding;
    private Button               btn_new_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_event_handling);

        EventHandler handler = new EventHandler(this);
        mBinding.setHandler(handler);

        Button btn_new_user = findViewById(R.id.btn_new_user);
        btn_new_user.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeTag = String.valueOf(System.currentTimeMillis());
                ObservableUser user = new ObservableUser("User" + timeTag, timeTag + "@gmail.com");
                mBinding.setUser(user);
            }
        });
    }
}
