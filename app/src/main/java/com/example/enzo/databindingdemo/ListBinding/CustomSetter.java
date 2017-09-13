package com.example.enzo.databindingdemo.ListBinding;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.enzo.databindingdemo.ListBinding.ListBindingActivity.UserListAdapter;

/**
 * <p>
 * Created by ZENG Yuhao(Enzo)<br>
 * Contact: enzo.zyh@gmail.com
 * </p>
 */

public class CustomSetter {
    /**
     * Since binding variable in xml does not support generic type (type will be erased, e.g. ObservableList&lt;
     * User&gt; ---> ObservableArrayList) , if we specify a type here for {@link ObservableArrayList}, data binding
     * framework will not be able to find this method correctly, an error occurs.
     */
    @BindingAdapter({"bind:items"})
    public static void setListItems(RecyclerView view, ObservableArrayList items) {
        view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        view.setAdapter(new UserListAdapter(view.getContext(), items));
    }
}
