package com.example.enzo.databindingdemo.EventHandling;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.enzo.databindingdemo.BidirectionBinding.ObservableUser;

/**
 * <p>
 * Created by ZENG Yuhao(Enzo)<br>
 * Contact: enzo.zyh@gmail.com
 * </p>
 */

public class EventHandler {
    private Context mContext;

    public EventHandler(Context context) {
        mContext = context;
    }

    public void onClick(View view) {
        Toast.makeText(mContext, "SimpleClickEvent received.", Toast.LENGTH_SHORT).show();
    }

    public void onClickWithArg(ObservableUser user) {
        if (user == null)
            Toast.makeText(mContext, "Argument with null value received.", Toast.LENGTH_SHORT).show();
        else {
            String msg = "Argument received : (ObservableUser) \n" +
                    "name = " + user.getName() + "\n" + "email = " + user.getEmail();
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
