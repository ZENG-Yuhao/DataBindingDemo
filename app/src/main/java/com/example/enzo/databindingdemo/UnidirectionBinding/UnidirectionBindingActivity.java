package com.example.enzo.databindingdemo.UnidirectionBinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.enzo.databindingdemo.BR;
import com.example.enzo.databindingdemo.R;
import com.example.enzo.databindingdemo.databinding.UnidirectionBindingActivityBinding;

public class UnidirectionBindingActivity extends Activity {
    private Button btn_new_user, btn_change_email;
    private UnidirectionBindingActivityBinding mBinding;
    private User                               mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_unidirection_binding);

        setTitle("UnidirectionBindingActivity");

        // with unidirection binding, we have to call setXXX() of binding object to update ui each time.
        btn_new_user = findViewById(R.id.btn_new_user);
        btn_new_user.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeTag = String.valueOf(System.currentTimeMillis());
                mUser = new User("User" + timeTag, timeTag + "@gmail.com");
                mBinding.setVariable(BR.user, mUser);
            }
        });

        btn_change_email = findViewById(R.id.btn_change_email);
        btn_change_email.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeTag = String.valueOf(System.currentTimeMillis());
                if (mUser != null)
                    mUser.setEmail(timeTag + "@gmail.com");

                String toastMsg = "Since its unidirection binding, if current bound user changes, information on ui " +
                        "will NOT be changed, the same reason, user will NOT be updated if information in EditText " +
                        "changes.";
                Toast.makeText(UnidirectionBindingActivity.this, toastMsg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
