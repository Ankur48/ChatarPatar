package com.example.ankur.ChatarPatar.chat;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ankur.ChatarPatar.R;
import com.example.ankur.ChatarPatar.cardstack.SwipeDeck;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private FirebaseDatabase database;
    private SwipeDeck cardStack;
    private Context context;
    private SwipeDeckAdapter adapter;
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        cardStack.setHardwareAccelerationEnabled(true);

        //Button sendBtn= (Button) findViewById(R.id.sendBtn);
        // final EditText messageTxt= (EditText) findViewById(R.id.messageTxt);
        // ListView userList= (ListView) findViewById(R.id.userList);
        database = FirebaseDatabase.getInstance();
        //   final DatabaseReference ref = database.getReference().child("chat");
        // final DatabaseReference firebase = database.getReference().child("users");


        data = new ArrayList<>();
        data.add("0");
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");

        adapter = new SwipeDeckAdapter(data, this);
        cardStack.setAdapter(adapter);

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
        // final ArrayList<UserModel> users=new ArrayList<>();


      /*  final ArrayAdapter<UserModel> userAdapter=new ArrayAdapter<UserModel>(
                this,android.R.layout.two_line_list_item,users
        ){
            @NonNull
            @Override
            public View getView(int position, View view, ViewGroup parent) {
                if(view ==null){view=getLayoutInflater().inflate(android.R.layout.two_line_list_item,parent,false);
                }
                UserModel user=users.get(position);
                ((TextView)view.findViewById(android.R.id.text1)).setText(user.getFirstName());

                ((TextView)view.findViewById(android.R.id.text2)).setText(user.getStatus());
                return view;
            }
        };

       // userList.setAdapter(userAdapter);

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
        });
        {}

        // Firebase.setAndroidContext(this);
        //   final Firebase ref=new Firebase("https://chattingapp-3daae.firebaseio.com/");
        // ref.child("users");



        //  Query recent=ref.limitToLast(5);
     /* FirebaseListAdapter<ChatMessage> adapter=new FirebaseListAdapter<ChatMessage>(this,ChatMessage.class,android.R.layout.two_line_list_item,recent) {
            @Override
            protected void populateView(View view, ChatMessage chat, int i) {
                ((TextView)view.findViewById(android.R.id.text1)).setText(chat.getName());
                ((TextView)view.findViewById(android.R.id.text2)).setText(chat.getMessage());*/
             /*   RelativeLayout.LayoutParams lp= (RelativeLayout.LayoutParams) view.getLayoutParams();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.setBackground(getDrawable(R.drawable.ch));
                }
                else
                {view.setBackground(getDrawable(R.drawable.ch));}*/
         /*   }
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


 /*   private class CardStackTransformer implements ViewPager.PageTransformer {
        @Override
        public void transformPage(View page, float position) {
            if (position>=0)
            {
                page.setScaleX(0.8f - 0.02f * position);
                page.setScaleY(0.8f);
                page.setTranslationX(- page.getWidth()*position);
                page.setTranslationY(30*position);


            }
        }
    }*/

    private class SwipeDeckAdapter extends BaseAdapter {

        private List<String> data;
        private Context context;


        public SwipeDeckAdapter(List<String> data, Context context) {
            this.data = data;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater inflater = getLayoutInflater();
                //can use viewholder
                v = inflater.inflate(R.layout.profile, parent, false);
            }

            ImageView imageView = (ImageView) v.findViewById(R.id.offer_image);
            Picasso.with(context).load(R.drawable.user_default).fit().centerCrop().into(imageView);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Layer type: ", Integer.toString(v.getLayerType()));
                    Log.i("Hardware Accel type: ", Integer.toString(View.LAYER_TYPE_HARDWARE));
                    Intent i = new Intent(v.getContext(), ChatActivity.class);
                    v.getContext().startActivity(i);

                }
            });
            return v;
        }

    }

}
