package com.example.ankur.ChatarPatar.chat;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ankur.ChatarPatar.Model.UserModel;
import com.example.ankur.ChatarPatar.R;
import com.example.ankur.ChatarPatar.cardstack.SwipeDeck;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {
    final public static List<String> profileUrl = new ArrayList<String>();
    private static final String TAG = "MainActivity";
    static UserModel details;
    private FirebaseDatabase database;
    private SwipeDeck cardStack;
    private Context context = this;
    private SwipeDeckAdapter adapter;
    private ArrayList<String> data;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        profileUrl.add("https://scontent.xx.fbcdn.net/v/t1.0-1/p100x100/12717169_1663646807190961_7655999365176970067_n.jpg?oh=75dfe919c3cb6d289a0fb9338329da2e&oe=5927E564");
        database = FirebaseDatabase.getInstance();
        Toast.makeText(UserList.this, "database", Toast.LENGTH_LONG).show();
        final DatabaseReference ref = database.getReference().child("users");
        //fetchUserImage();

        imgGet(ref);



        //Button sendBtn= (Button) findViewById(R.id.sendBtn);
        // final EditText messageTxt= (EditText) findViewById(R.id.messageTxt);
        // ListView userList= (ListView) findViewById(R.id.userList);

        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        cardStack.setHardwareAccelerationEnabled(true);

        //
//
        //     final ArrayAdapter<UserModel> userAdapter=new ArrayAdapter<UserModel>(
        //            this,R.layout.profile,users
        //    ){
        //      @NonNull
        //    @Override
        //   public View getView(int position, View view, ViewGroup parent) {
        //     if(view ==null){view=getLayoutInflater().inflate(R.layout.profile,parent,false);
        //   }
        //    UserModel user=users.get(position);
        //  ((ImageView)view.findViewById(R.id.offer_image)).setImageAlpha(Integer.parseInt(user.getProfileImageUri()));            //setText(user.getFirstName());

        //     return view;
        // }
        // };

        // userList.setAdapter(userAdapter);

//    Toast.makeText(UserList.this, details.getProfileImageUri(), Toast.LENGTH_LONG).show();

        //  data = new ArrayList<>();
        //data.add();


        Toast.makeText(UserList.this, "swipeadapter BAADWALA", Toast.LENGTH_LONG).show();
        data = new ArrayList<>();
        // data.add("0");
        // data.add("1");
        // data.add("2");

        //data.add("3");

        cardStack.setEventCallback(new SwipeDeck.SwipeEventCallback() {
            @Override
            public void cardSwipedLeft(int position) {
                Log.i("MainActivity", "card was swiped left, position in adapter: " + position);
            }

            @Override
            public void cardSwipedRight(int position) {
                Log.i("MainActivity", "card was swiped right, position in adapter: " + position);
            }

            @Override
            public void cardsDepleted() {
                Log.i("MainActivity", "no more cards");
            }

            @Override
            public void cardActionDown() {
                Log.i(TAG, "cardActionDown");
            }

            @Override
            public void cardActionUp() {
                Log.i(TAG, "cardActionUp");
            }

        });


        //  String key=firebase.getKey();
        final ArrayList<UserModel> users = new ArrayList<>();


        final ArrayAdapter<UserModel> userAdapter = new ArrayAdapter<UserModel>(
                this, android.R.layout.two_line_list_item, users
        ) {
            @NonNull
            @Override
            public View getView(int position, View view, ViewGroup parent) {
                if (view == null) {
                    view = getLayoutInflater().inflate(android.R.layout.two_line_list_item, parent, false);
                }
                UserModel user = users.get(position);
                ((TextView) view.findViewById(android.R.id.text1)).setText(user.getFirstName());

                ((TextView) view.findViewById(android.R.id.text2)).setText(user.getStatus());
                return view;
            }
        };

        // userList.setAdapter(userAdapter);
/*
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                UserModel userModel = dataSnapshot.getValue(UserModel.class);
                //dataSnapshot.child("YSXSfLPWo0NAiocsDmLNhc4LzTV2");
                //  ChatMessage chat=new ChatMessage("Abhi","hello dummy");
                // UserModel userModel = new UserModel("Abhi","hello dummy");
                users.add(userModel);
                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/


        // Firebase.setAndroidContext(this);
        //   final Firebase ref=new Firebase("https://chattingapp-3daae.firebaseio.com/");
        // ref.child("users");


        //  Query recent=ref.limitToLast(5);
  /*    FirebaseListAdapter<ChatMessage> adapter=new FirebaseListAdapter<ChatMessage>(this,ChatMessage.class,android.R.layout.two_line_list_item) {
            @Override
            protected void populateView(View view, ChatMessage chat, int i) {
                ((TextView)view.findViewById(android.R.id.text1)).setText(chat.getName());
                ((TextView)view.findViewById(android.R.id.text2)).setText(chat.getMessage());
                RelativeLayout.LayoutParams lp= (RelativeLayout.LayoutParams) view.getLayoutParams();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.setBackground(getDrawable(R.drawable.ch));
                }
                else
                {view.setBackground(getDrawable(R.drawable.ch));}
            }
        };*/
        // messageLst.setAdapter(adapter);


      /*  userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UserModel u=users.get(i);
                Toast.makeText(UserList.this,u.getUserId(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(UserList.this,ChatActivity.class);
                intent.putExtra("reciverUserName",u.getFirstName());
                intent.putExtra("reciverUid", u.getUserId());
                intent.putExtra("reciverProfilePic", u.getProfileImageUri());
                UserList.this.startActivity(intent);

            }
        });
*/
    }

    public void imgGet(DatabaseReference ref) {
        Toast.makeText(UserList.this, "imgGet", Toast.LENGTH_LONG).show();
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {
                    //  Toast.makeText(UserList.this,dir,Toast.LENGTH_LONG).show();
                    Log.d("Output", dataSnapshotChild.toString());
                    Log.d("Output1", dataSnapshotChild.child("profileImageUri").getValue().toString());
                    String dir = dataSnapshotChild.child("profileImageUri").getValue().toString();
                    profileUrl.add(dir);

                    Log.d("Output2", dir);

                    Log.d("Output3", profileUrl.toString());

                    new SwipeDeckAdapter((ArrayList<String>) profileUrl, context);

                }
                //   ImageView imageView = (ImageView) findViewById(R.id.offer_image);
                Log.d("helo", String.valueOf(profileUrl));
                Toast.makeText(UserList.this, "ksksk", Toast.LENGTH_LONG).show();
                adapter = new SwipeDeckAdapter((ArrayList<String>) profileUrl, UserList.this);
                cardStack.setAdapter(adapter);


            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private class SwipeDeckAdapter extends BaseAdapter {

        private ArrayList<String> data;
        private Context context;

        public SwipeDeckAdapter(ArrayList<String> data, Context context) {
            this.data = data;
            Log.d("daaaa", String.valueOf(data));
            this.context = context;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View v = convertView;
            if (v == null) {
                LayoutInflater inflater = getLayoutInflater();
                // normally use a viewholder
                v = inflater.inflate(R.layout.profile, parent, false);

            }
            //((TextView) v.findViewById(R.id.textView2)).setText(data.get(position));
            ImageView imageView = (ImageView) v.findViewById(R.id.offer_image);
            Log.d("helllllo", String.valueOf(data));
            //  Toast.makeText(UserList.this, String.valueOf(profileUrl) ,Toast.LENGTH_LONG).show();
            for (int i = 0; i < data.size(); i++) {
                Picasso.with(context).load(String.valueOf(profileUrl.get(i))).fit().centerCrop().into(imageView);
            }

//            String item = (String)getItem(position);


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Layer type: ", Integer.toString(v.getLayerType()));
                    Log.i("Hwardware Accel type:", Integer.toString(View.LAYER_TYPE_HARDWARE));
                    Intent i = new Intent(v.getContext(), ChatActivity.class);
                    v.getContext().startActivity(i);
                }
            });
            return v;
        }

    }

}
