package com.example.instagramclone.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.instagramclone.R;
import com.example.instagramclone.utils.BottomNavigationViewHelper;
import com.example.instagramclone.utils.GridImageAdapter;
import com.example.instagramclone.utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = ProfileActivity.class.getSimpleName();
    private static final int ACTIVITY_NUM = 4;
    private static final int NUM_GRID_COLUMNS = 3;

    private Context mContext = ProfileActivity.this;
    private ProgressBar mProgressBar;
    private ImageView mProfilePhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started");

        setupActivityWidgets();
        setupBottomNavigationView();
        setupToolbar();
        setProfileImage();

        tempGridSetup();
    }

    private void tempGridSetup() {
        ArrayList<String> imgUrls = new ArrayList<>();
        imgUrls.add("https://cdn.europosters.eu/image/750/posters/rick-morty-ship-i35959.jpg");
        imgUrls.add("https://cdn.europosters.eu/image/750/posters/rick-and-morty-i-want-to-believe-i33908.jpg");
        imgUrls.add("https://cdn.europosters.eu/image/750/posters/pulp-fiction-guns-i1381.jpg");
        imgUrls.add("https://cdn.europosters.eu/image/750/posters/rick-and-morty-free-rick-i49321.jpg");
        imgUrls.add("https://cdn.europosters.eu/image/750/posters/rick-and-morty-wrecked-son-i51114.jpg");
        imgUrls.add("https://cdn.europosters.eu/image/750/posters/rick-and-morty-schwifty-i48840.jpg");
        imgUrls.add("https://cdn.europosters.eu/image/750/posters/batman-the-killing-joke-cover-i30819.jpg");
        imgUrls.add("https://cdn.europosters.eu/image/750/posters/batman-harley-quinn-kiss-i61114.jpg");
        imgUrls.add("https://cdn.europosters.eu/image/750/posters/welcome-to-the-new-world-order-i50043.jpg");
        imgUrls.add("https://cdn.europosters.eu/image/750/posters/governments-should-be-afraid-of-thier-people-i47513.jpg");

        setupImageGrid(imgUrls);
    }

    private void setupImageGrid(ArrayList<String> imgUrls) {
        GridView gridView = findViewById(R.id.gridView);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imagesWidth = gridWidth / NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imagesWidth);

        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, imgUrls);
        gridView.setAdapter(adapter);
    }

    private void setProfileImage() {
        Log.d(TAG, "setProfileImage: setting profile photo");
        String imgUrl = "https://cdnb.artstation.com/p/assets/images/images/015/389/309/large/ernesto-perlingeiro-chigurgh-close-dof.jpg?1548157425";
        UniversalImageLoader.setImageWithGlide(imgUrl, mProfilePhoto, this, null);
    }

    private void setupActivityWidgets() {
        mProgressBar = findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        mProfilePhoto = findViewById(R.id.profile_image);
    }

    /**
     *
     * setup Profile Toolbar
     */
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to account settings");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     *
     * BottomNavigationView setup
     */
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
