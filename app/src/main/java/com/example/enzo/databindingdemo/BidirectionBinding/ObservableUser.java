package com.example.enzo.databindingdemo.BidirectionBinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.enzo.databindingdemo.BR;

/**
 * <p>
 * Created by ZENG Yuhao(Enzo)<br>
 * Contact: enzo.zyh@gmail.com
 * </p>
 */

public class ObservableUser extends BaseObservable {
    private String name;
    private String email;

    public ObservableUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
