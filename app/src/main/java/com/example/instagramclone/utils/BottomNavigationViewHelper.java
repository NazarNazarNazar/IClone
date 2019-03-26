package com.example.instagramclone.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.instagramclone.home.HomeActivity;
import com.example.instagramclone.likes.LikesActivity;
import com.example.instagramclone.profile.ProfileActivity;
import com.example.instagramclone.R;
import com.example.instagramclone.search.SearchActivity;
import com.example.instagramclone.share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {
    private static final String TAG = BottomNavigationViewHelper.class.getSimpleName();

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");

        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ic_house:
                        Intent intent = new Intent(context, HomeActivity.class); //ACTIVITY_NUM = 0
                        context.startActivity(intent);
                        break;
                    case R.id.ic_search:
                        Intent intent1 = new Intent(context, SearchActivity.class); //ACTIVITY_NUM = 1
                        context.startActivity(intent1);
                        break;
                    case R.id.ic_circle:
                        Intent intent2 = new Intent(context, ShareActivity.class); //ACTIVITY_NUM = 2
                        context.startActivity(intent2);
                        break;
                    case R.id.ic_alert:
                        Intent intent3 = new Intent(context, LikesActivity.class); //ACTIVITY_NUM = 3
                        context.startActivity(intent3);
                        break;
                    case R.id.ic_android:
                        Intent intent4 = new Intent(context, ProfileActivity.class); //ACTIVITY_NUM = 4
                        context.startActivity(intent4);
                        break;
                }
                return false;
            }
        });

    }
}
