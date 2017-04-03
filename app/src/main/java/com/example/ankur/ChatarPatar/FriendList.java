package com.example.ankur.ChatarPatar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.example.ankur.ChatarPatar.Model.UserName;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FriendList extends AppCompatActivity {
    private static final String TAG = "UserList";
    public static int from = 0;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private RecyclerView my_recycler_view;
    private LinearLayoutManager mLayoutManager;
    private FirebaseRecyclerAdapter<UserName, FirebaseUser> mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);

        mAuth = FirebaseAuth.getInstance();
        Constant.USER_ID = mAuth.getCurrentUser().getUid();
        my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        my_recycler_view.setLayoutManager(mLayoutManager);
        database = FirebaseDatabase.getInstance();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            from = bundle.getInt("from");// from = 1 -> ChatConversationList , from = 2 -> GroupChatConversation
            getSupportActionBar().setTitle("Select Freind");
        }
    }

    private void getUserList() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (database != null) {
            final DatabaseReference firebase = database.getReference().child("users").child(mAuth.getCurrentUser().getUid()).child("status");
            firebase.setValue("online");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (database != null) {
            final DatabaseReference firebase = database.getReference().child("users").child(mAuth.getCurrentUser().getUid()).child("status");
            firebase.setValue("offline");
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*getMenuInflater().inflate(R.menu.user_activity, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);*/
        return true;
    }


    private void setUpFirebaseAdapter(Query query) {

        mFirebaseAdapter = new FirebaseRecyclerAdapter<UserName, FirebaseUser>
                (UserName.class, R.layout.row_user_list, FirebaseUser.class, query) {
            @Override
            protected void populateViewHolder(FirebaseUser viewHolder, UserName model, int position) {
                // customeLoaderDialog.hide();
                viewHolder.bindUser(model);
            }
        };

        my_recycler_view.setHasFixedSize(true);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        my_recycler_view.setAdapter(mFirebaseAdapter);

    }
}
