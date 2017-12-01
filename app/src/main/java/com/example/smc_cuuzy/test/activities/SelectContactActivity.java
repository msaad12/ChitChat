package com.example.smc_cuuzy.test.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.adapters.AddContactsAdapter;
import com.example.smc_cuuzy.test.adapters.ContactsAdapter;
import com.example.smc_cuuzy.test.helpers.RecyclerViewFastScroller;
import com.example.smc_cuuzy.test.models.ContactsModel;
import com.futuremind.recyclerviewfastscroll.FastScroller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelectContactActivity extends AppCompatActivity {

    public RecyclerView mContactsList;
    public View mView;
    public List<ContactsModel> mContactsModel;
    FastScroller fastScroller;

    public ContactsAdapter mContactsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__contact);
        initUI();
    }


    public void initUI() {

        mContactsList = (RecyclerView) findViewById(R.id.contactsList);
        fastScroller = (FastScroller) findViewById(R.id.fastscroll);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mContactsModel = new ArrayList<ContactsModel>();
        mContactsAdapter= new ContactsAdapter(this, mContactsModel);
        mContactsList.setLayoutManager(layoutManager);
        mContactsList.setAdapter(mContactsAdapter);
        //has to be called AFTER RecyclerView.setAdapter()
        fastScroller.setRecyclerView(mContactsList);
        prepareItems();
    }

    private void prepareItems() {
        mContactsModel.add(new ContactsModel(R.drawable.image1, "Hiader ", "Cuzzy are you coming to the beach!", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image2, "Alo ", "Hey there! I am using ChatUp", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image3, "Shaoor ", "Hey there! I am using ChatUp", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image4, "Munir ", "Hey there! I am using ChatUp", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image5, "Ghufran ", "Hey there! I am using ChatUp", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image6, "Ahmad ", "Off to work", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image7, "Muaz ", "Hey there! I am using ChatUp", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image8, "Maqbool", "Thank you lord", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image9, "Muhammad Saad ", "Cuzzy are you coming to the beach!", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image10, "Tariq ", "Hey there! I am using ChatUp", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image11, "Haseeb ", "Hey there! I am using ChatUp", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image12, "Ahmed ", "Hey there! I am using ChatUp", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.user, "Fatima ", "Hmmm", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.user, "Khan ", "Son, have you heard from your brother?", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image13, "Tasmia ", "Hey there! I am using ChatUp", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image14, "Rana ", "Off to work", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image15, "Saba ", "Hey there! I am using ChatUp", "MOBILE"));
        mContactsModel.add(new ContactsModel(R.drawable.image13, "Asif", "Thank you lord", "MOBILE"));


        Collections.sort(mContactsModel, new Comparator<ContactsModel>() {
            @Override
            public int compare(ContactsModel lhs, ContactsModel rhs) {
                return lhs.getUsername().compareTo(rhs.getUsername());
            }
        });
        mContactsAdapter.notifyDataSetChanged();
    }
}
