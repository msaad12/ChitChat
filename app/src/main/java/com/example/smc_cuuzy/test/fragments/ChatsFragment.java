package com.example.smc_cuuzy.test.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.activities.NewGroupActivity;
import com.example.smc_cuuzy.test.activities.SettingsActivity;
import com.example.smc_cuuzy.test.adapters.ChatsAdapter;
import com.example.smc_cuuzy.test.models.ChatsModel;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {

    public RecyclerView mChatsList;
    public View mView;
    public List<ChatsModel> mChatsModel;
    public ChatsAdapter mChatsAdapter;

    public ChatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_chats, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setShowHideAnimationEnabled(true);
        initUI();
        setHasOptionsMenu(true);
        return mView;
    }

    //Method to add menu items to the toolbar
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.chats_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.new_group) {
            Intent startIntent = new Intent(getActivity(), NewGroupActivity.class);
            this.startActivity(startIntent);
        }
        if (item.getItemId() == R.id.settings) {
            Intent startIntent = new Intent(getActivity(), SettingsActivity.class);
            this.startActivity(startIntent);
        }
        return true;
    }

    //Method and views initializer
    public void initUI() {

        mChatsList = (RecyclerView) mView.findViewById(R.id.chatsList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        mChatsModel = new ArrayList<ChatsModel>();
        mChatsAdapter = new ChatsAdapter(getActivity(), mChatsModel);
        mChatsList.setLayoutManager(layoutManager);
        mChatsList.setHasFixedSize(true);
        mChatsAdapter.notifyDataSetChanged();
        mChatsList.setAdapter(mChatsAdapter);
        prepareItems();
    }

    // Method to add dummy items to our recyclerview
    private void prepareItems() {
        mChatsModel.add( new ChatsModel(R.drawable.image1, "Haider ", "17:20", "what do you thing of this template?", "2"));
        mChatsModel.add( new ChatsModel(R.drawable.image2, "Shaoor", "17:10", "John Doe: Hello", "99", 2));
        mChatsModel.add( new ChatsModel(R.drawable.image3, "Saad ", "16:59", "Good Evening", "10"));
        mChatsModel.add( new ChatsModel(R.drawable.image4, "Ghufran ", "16:30", "Hey Cuzzy... Is it still on?", "1"));
        mChatsModel.add( new ChatsModel(R.drawable.image5, "Haseeb ", "12:05", "Pm", "1"));
        mChatsModel.add( new ChatsModel(R.drawable.image6, "Saaba ", "YESTERDAY", "Hey! long time"));
        mChatsModel.add( new ChatsModel(R.drawable.image7, "Tasmia ", "YESTERDAY", "Are you a Ghanaian?"));
        mChatsModel.add( new ChatsModel(R.drawable.image8, "fatima ", "YESTERDAY", "Where do you come from?"));
        mChatsModel.add( new ChatsModel(R.drawable.image9, "Muaz ", "YESTERDAY", "Off to work pal"));
        mChatsModel.add( new ChatsModel(R.drawable.image10, "XYZ ", "YESTERDAY", "Hey Sweetheart! am missing u already"));
        mChatsModel.add( new ChatsModel(R.drawable.image11, "Muazma ", "31/05/16", "Hmmm!"));
        mChatsModel.add( new ChatsModel(R.drawable.image12, "!@# ", "30/05/16", "Son, have you heard from your brother?"));
        mChatsModel.add( new ChatsModel(R.drawable.image13, "QWE ", "30/05/16", "Yo Bro! is mom at home"));
        mChatsModel.add( new ChatsModel(R.drawable.image14, "haaha ", "29/05/16", "Cuzzy are you coming to the beach?"));
        mChatsModel.add( new ChatsModel(R.drawable.image15, "Tauat", "29/05/16", "Did you come to school today?"));

    }

}
