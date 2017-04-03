package com.example.ankur.ChatarPatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ankur.ChatarPatar.Model.UserName;
import com.example.ankur.ChatarPatar.custome_view.BadgeView;
import com.squareup.picasso.Picasso;

/**
 * Created by ankur on 31-03-2017.
 */

public class FirebaseUser extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
    View mView;
    Context mContext;
    UserName userModel;

    public FirebaseUser(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindUser(UserName userModel) {
        this.userModel = userModel;
        ImageView imgUser = (ImageView) mView.findViewById(R.id.imgUser);
        TextView tvName = (TextView) mView.findViewById(R.id.tvName);
        TextView tvStatus = (TextView) mView.findViewById(R.id.tvStatus);
        BadgeView badgeChat = (BadgeView) mView.findViewById(R.id.badgeChat);
        badgeChat.setVisibility(View.GONE);
        Picasso.with(mContext)
                .load(userModel.getProfileImageUri())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(imgUser);
        tvName.setText(userModel.getFirstName());
        tvStatus.setText(userModel.getStatus());
        badgeChat.setText("" + userModel.getBadge());
    }

    @Override
    public void onClick(View view) {
        if (FriendList.from == 1) {
            Intent intent = new Intent(mContext, MainActivity.class);
            intent.putExtra("reciverUserName", userModel.getFirstName());
            intent.putExtra("reciverUid", userModel.getUserId());
            intent.putExtra("reciverProfilePic", userModel.getProfileImageUri());
            mContext.startActivity(intent);
            ((Activity) mContext).finish();
        }

    }
}
