package com.example.enzo.databindingdemo.BidirectionBinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.enzo.databindingdemo.R;
import com.example.enzo.databindingdemo.databinding.BidirectionBindingActivityBinding;
import com.example.enzo.databindingdemo.databinding.EventHandlingBinding.OnClickListenerImpl;

public class BidirectionBindingActivity extends Activity {
    private Button btn_new_user, btn_change_email, btn_show_user;
    private BidirectionBindingActivityBinding mBinding;
    private ObservableUser                    mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bidirection_binding);

        setTitle("BidirectionBindingActivity");

        btn_new_user = findViewById(R.id.btn_new_user);
        btn_new_user.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeTag = String.valueOf(System.currentTimeMillis());
                mUser = new ObservableUser("User" + timeTag, timeTag + "@gmail.com");
                mBinding.setObservableUser(mUser);
            }
        });

        btn_change_email = findViewById(R.id.btn_change_email);
        btn_change_email.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeTag = String.valueOf(System.currentTimeMillis());
                mUser.setEmail(timeTag + "@gmail.com");
            }
        });

        btn_show_user = findViewById(R.id.btn_show_user);
        btn_show_user.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String toastMsg = mUser.getName() + "\n" + mUser.getEmail();
                Toast.makeText(BidirectionBindingActivity.this, toastMsg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
