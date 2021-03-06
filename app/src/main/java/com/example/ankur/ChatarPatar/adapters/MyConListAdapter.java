package com.example.ankur.ChatarPatar.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ankur.ChatarPatar.R;
import com.example.ankur.ChatarPatar.chat.ChatActivity;
import com.example.ankur.ChatarPatar.chat.ChatConModel;

import java.util.List;


public class MyConListAdapter extends RecyclerView.Adapter<MyConListAdapter.MyViewHolder> implements View.OnClickListener {
    //private String[] mDataset;
    private Context mContext;
    private List<ChatConModel> conList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyConListAdapter(Context mContext, List<ChatConModel> conList) {
        this.mContext = mContext;
        this.conList = conList;

    }

    @Override
    public void onClick(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(context, ChatActivity.class);
        context.startActivity(intent);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // holder.mTextView.setText(mDataset[position]);
        ChatConModel chatConModel = conList.get(position);
        Log.d("onbind1", "" + chatConModel.getChat_id());
        Log.d("onbind2", "" + chatConModel.getDisplayName());
        Log.d("onbind3", "" + chatConModel.getLatestactivity());

//            holder.avator.setImageResource(Integer.parseInt(chatConModel.getProfilePic()));
        holder.description.setText(chatConModel.getLatestactivity());
        holder.name.setText(chatConModel.getDisplayName());
        //   holder.avator.setImageResource(R.drawable.a_avator);
        Glide.with(mContext).load(chatConModel.getProfilePic()).into(holder.avator);
        //crop image round
          /*  Glide.with(mContext)
                    .load(chatConModel.getProfilePic())
                    .asBitmap().fitCenter()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            holder.avator.setImageBitmap(ImageHelper.getRoundedCornerBitmap(mContext, resource, 200, 200, 200, false, false, false, false));
                        }
                    });
            Log.d("onbindglide", String.valueOf(chatConModel));*/

    }

    @Override
    public int getItemCount() {
        //  return mDataset.length;
        return conList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView avator;
        public TextView name;
        public TextView description;

        //public TextView mTextView;
        public MyViewHolder(View v) {
            super(v);
            // mTextView = v;
            avator = (ImageView) v.findViewById(R.id.list_avatar);
            name = (TextView) v.findViewById(R.id.list_title);
            description = (TextView) v.findViewById(R.id.list_desc);


        }
    }


}
