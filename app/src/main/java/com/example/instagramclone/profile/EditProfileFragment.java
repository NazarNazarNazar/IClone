package com.example.instagramclone.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.instagramclone.R;
import com.example.instagramclone.utils.UniversalImageLoader;

public class EditProfileFragment extends Fragment {
    private static final String TAG = EditProfileFragment.class.getSimpleName();


    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        mProfilePhoto = view.findViewById(R.id.profile_photo);

        setProfileImage();

        // back arrow for navigation back to ProfileActivity
        ImageView backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating back to ProfileActivity");
                if (getActivity() != null) {
                    getActivity().finish();

//                    getActivity().getSupportFragmentManager().beginTransaction().remove(EditProfileFragment.this).commit();
//                    getActivity().findViewById(R.id.relLayout1).setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }

    private void setProfileImage() {
        Log.d(TAG, "setProfileImage: setting profile image.");
        String imgUrl = "https://cdnb.artstation.com/p/assets/images/images/015/389/309/large/ernesto-perlingeiro-chigurgh-close-dof.jpg?1548157425";
        UniversalImageLoader.setImageWithGlide(imgUrl, mProfilePhoto, getContext(), null);
    }
}
