package com.example.enzo.databindingdemo.ListBinding;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.enzo.databindingdemo.BidirectionBinding.ObservableUser;
import com.example.enzo.databindingdemo.R;
import com.example.enzo.databindingdemo.databinding.ListBindingActivityBinding;
import com.example.enzo.databindingdemo.databinding.UserListItemBinding;

public class ListBindingActivity extends Activity {
    private ListBindingActivityBinding mBinding;
    private RecyclerView               list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_binding);
        setTitle("ListBindingActivity");

        mBinding.setUserItems(createNewList(20));
        Toast.makeText(this, "You can edit each item and verify whether underlying data has been changed properly",
                Toast.LENGTH_LONG).show();
    }

    private ObservableArrayList<ObservableUser> createNewList(int size) {
        ObservableArrayList<ObservableUser> users = new ObservableArrayList<>();
        long time = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            String timeTag = String.valueOf(time);
            ObservableUser user = new ObservableUser("User " + timeTag, timeTag + "@gmail.com");
            time++;
            users.add(user);
        }
        return users;
    }

    /**
     * UserViewHolder
     */
    private static class UserViewHolder extends ViewHolder {
        private UserListItemBinding mViewHolderBinding;
        private Button              button;

        public UserViewHolder(final View itemView) {
            super(itemView);
            // bind binding class separately.
            mViewHolderBinding = UserListItemBinding.bind(itemView);
            button = itemView.findViewById(R.id.btn_view_underlying_data);
        }

        public UserListItemBinding getBinding() {
            return mViewHolderBinding;
        }
    }


    /**
     * UserListAdapter
     */
    public static class UserListAdapter extends Adapter<UserViewHolder> {
        private Context                             mContext;
        private ObservableArrayList<ObservableUser> mUsers;

        public UserListAdapter(Context mContext, ObservableArrayList<ObservableUser> users) {
            this.mContext = mContext;
            this.mUsers = users;
        }

        @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_list_binding_list_item, parent, false);
            return new UserViewHolder(view);
        }

        @Override
        public void onBindViewHolder(UserViewHolder holder, final int position) {
            ObservableUser user = mUsers.get(position);
            holder.getBinding().setUser(user);
            holder.getBinding().executePendingBindings();

            holder.button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new Builder(mContext);
                    builder.setTitle("Item " + position);
                    builder.setMessage("name = " + mUsers.get(position).getName() + "\n" +
                            "email = " + mUsers.get(position).getEmail());
                    builder.setNegativeButton("Close", null);
                    builder.create().show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mUsers == null ? 0 : mUsers.size();
        }
    }
}
