package com.example.ankur.ChatarPatar.chat;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.ankur.ChatarPatar.Model.UserModel;
import com.example.ankur.ChatarPatar.R;
import com.example.ankur.ChatarPatar.cardstack.ui.TinderCardView;
import com.example.ankur.ChatarPatar.cardstack.ui.TinderStackLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class UserCardView extends AppCompatActivity {
    final public static List<String> profileUrl = new ArrayList<String>();
    final public static List<String> userName = new ArrayList<String>();

    private static final String TAG = "MainActivity";
    static UserModel details;
    int index = 0;
    TinderCardView tc;
    private FirebaseDatabase database;
    private TinderStackLayout tinderStackLayout;
    private Context context = this;
    private ArrayList<String> data;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        profileUrl.add("https://scontent.xx.fbcdn.net/v/t1.0-1/p100x100/12717169_1663646807190961_7655999365176970067_n.jpg?oh=75dfe919c3cb6d289a0fb9338329da2e&oe=5927E564");
        database = FirebaseDatabase.getInstance();
        Toast.makeText(UserCardView.this, "database", Toast.LENGTH_LONG).show();
        final DatabaseReference ref = database.getReference().child("users");
        imgGet(ref);
        tinderStackLayout = (TinderStackLayout) findViewById(R.id.tsl);


        TinderCardView tc;


    }

    public void imgGet(DatabaseReference ref) {
        Toast.makeText(UserCardView.this, "imgGet", Toast.LENGTH_LONG).show();
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {
                    //  Toast.makeText(UserCardView.this,dir,Toast.LENGTH_LONG).show();
                    Log.d("Output", dataSnapshotChild.toString());

                    Log.d("Output1", dataSnapshotChild.child("profileImageUri").getValue().toString());
                    String dir = dataSnapshotChild.child("profileImageUri").getValue().toString();
                    profileUrl.add(dir);
                    String username = dataSnapshotChild.child("firstName").getValue().toString();
                    userName.add(username);
                    Log.d("Output2", String.valueOf(userName));

                    Log.d("Output3", profileUrl.toString());


                }
                //   ImageView imageView = (ImageView) findViewById(R.id.offer_image);
                Log.d("helo", String.valueOf(profileUrl));
                Toast.makeText(UserCardView.this, "ksksk", Toast.LENGTH_LONG).show();
                Log.d("Datasize", String.valueOf(profileUrl.size()));
                // Log.d("Dize", String.valueOf(details.getProfileImageUri()));

                for (int i = index; index < i + (userName.size()); index++) {
                    tc = new TinderCardView(UserCardView.this);
                    tc.bind(getUser(index));
                    tinderStackLayout.addCard(tc);
                }
                tinderStackLayout.getPublishSubject()
                        .observeOn(AndroidSchedulers.mainThread()) // UI Thread
                        .subscribe(new Subscriber<Integer>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Integer integer) {
                                if (integer == 1) {
                                    TinderCardView tc;
                                    for (int i = index; index < i + (userName.size()); index++) {
                                        tc = new TinderCardView(UserCardView.this);
                                        tc.bind(getUser(index));
                                        tinderStackLayout.addCard(tc);
                                    }
                                }
                            }
                        });
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private UserModel getUser(int index) {
        UserModel user = new UserModel();
        user.setProfileImageUri(profileUrl.get(index));
        user.setFirstName(userName.get(index));
        return user;
    }

}
