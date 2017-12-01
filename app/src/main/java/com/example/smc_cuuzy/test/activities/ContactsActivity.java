package com.example.smc_cuuzy.test.activities;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.adapters.ChatsAdapter;
import com.example.smc_cuuzy.test.adapters.ContactsAdapter;
import com.example.smc_cuuzy.test.helpers.ClickListener;
import com.example.smc_cuuzy.test.helpers.RecyclerItemClickListener;
import com.example.smc_cuuzy.test.models.ChatsModel;
import com.example.smc_cuuzy.test.models.ContactsModel;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity  implements View.OnClickListener{
    public RecyclerView mContactsList;
    public View mView;
    public List<ContactsModel> mContactsModel;
    GestureDetectorCompat gestureDetector;
    public ContactsAdapter mContactsAdapter;
    public LinearLayout search, searchLayout, toolbarLayout, back;
    public ImageView backIcon, searchIcon;
    public TextView title;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        initUI();
        setupToolbar();

    }

    //Method and views initializer
    public void initUI() {

        mContactsList = (RecyclerView) findViewById(R.id.contactsList);
        search = (LinearLayout) findViewById(R.id.btnRight);
        back = (LinearLayout) findViewById(R.id.btnLeft);
        backIcon = (ImageView) findViewById(R.id.iconLeft);
        searchIcon = (ImageView) findViewById(R.id.iconRight);
        title = (TextView) findViewById(R.id.title);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mContactsModel = new ArrayList<ContactsModel>();
        mContactsAdapter = new ContactsAdapter(this, mContactsModel);
        mContactsList.setLayoutManager(layoutManager);
        mContactsAdapter.notifyItemInserted(mContactsModel.size()-1);
        mContactsList.setAdapter(mContactsAdapter);

         //This is our custom RecyclerItemClickListener that can be used to perform certain click events such as long clicks and short clicks
        mContactsList.addOnItemTouchListener(new RecyclerItemClickListener(this, mContactsList, new ClickListener() {
        @Override
        public void onClick(View view, int position) {

        }

        @Override
        public void onLongClick(View view, int position) {
            // Start the CAB using the ActionMode.Callback defined above

        }
        }));
        back.setOnClickListener(this);

        prepareItems();
}

    // This is a simple method to add items to our recyclerview
    private void prepareItems() {
        mContactsModel.add(new ContactsModel(R.drawable.image12, "Haider ", "MOBILE", "aaaaaaaa"));
        mContactsModel.add(new ContactsModel(R.drawable.image6, "Shaoor ", "MOBILE", "aaaaaaaa"));
        mContactsModel.add(new ContactsModel(R.drawable.image10, "Ghufran ", "MOBILE", "aaaaaaaa"));
        mContactsModel.add(new ContactsModel(R.drawable.image7, "Saad ", "MOBILE", "aaaaaaaa"));
        mContactsModel.add(new ContactsModel(R.drawable.image8, "Saba ", "MOBILE", "aaaaaaaa"));
        mContactsModel.add(new ContactsModel(R.drawable.image9, "Muaz ", "MOBILE", "aaaaaaaa"));
        mContactsModel.add(new ContactsModel(R.drawable.image13, "Haseeb", "MOBILE", "aaaaaaaa"));
        mContactsModel.add(new ContactsModel(R.drawable.user, "Tasmia ", "MOBILE", "aaaaaaaa"));
        mContactsModel.add(new ContactsModel(R.drawable.user, "Ali ", "MOBILE", R.string.invite));
        mContactsModel.add(new ContactsModel(R.drawable.user, "Ahmed ", "MOBILE", R.string.invite));
    }
    /*Method setup the toolbar
    /*Here we add the icons and give it a title
    */
    private void setupToolbar() {
        backIcon.setImageResource(R.drawable.ic_action_back);
        searchIcon.setImageResource(R.drawable.ic_search);
        title.setText("Contacts");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLeft:
                finish();
                break;
            default:
                break;
        }
    }
}
