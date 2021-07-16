package com.example.collegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.collegeapp.R;
//import com.smarteist.autoimageslider.DefaultSliderView;
//import com.smarteist.autoimageslider.IndicatorAnimations;
//import com.smarteist.autoimageslider.SliderAnimations;
//import com.smarteist.autoimageslider.SliderLayout;

public class homeFragment extends Fragment {

    //private SliderLayout sliderLayout;
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        imageView=view.findViewById(R.id.map);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
//        sliderLayout=view.findViewById(R.id.slide);
//        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
//        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderLayout.setScrollTimeInSec(1);
//        setSliderView();
           return view;

    }

    private void openMap() {
        Uri uri= Uri.parse("geo:0, 0?q=Indian Institute Of Technology Patna");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

//    private void setSliderView() {
//        for(int i=0;i<5;i++){
//            DefaultSliderView sliderView=new DefaultSliderView(getContext());
//            switch (i){
//                case 0:
//                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-33964.appspot.com/o/Notice%2F3.jpeg?alt=media&token=7efffd10-7645-42cf-b571-74b1e1b28798");
//                    break;
//                case 1:
//                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-33964.appspot.com/o/Notice%2F1.jpg?alt=media&token=7c30eead-69ae-4bae-b807-eb4683b43fca");
//                    break;
//                case 2:
//                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-33964.appspot.com/o/Notice%2F4.jpeg?alt=media&token=4d74ba0c-71f7-4ed8-ab33-f532eaa01e99");
//                    break;
//                case 3:
//                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-33964.appspot.com/o/Notice%2F2.jpg?alt=media&token=309e33a2-3c4a-45f3-9edb-ce6f62614208");
//                    break;
//                case 4:
//                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-33964.appspot.com/o/Notice%2F5.jpg?alt=media&token=a7ecccd2-de8b-43be-b090-b9405523df6a");
//                    break;
//            }
//            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
//            sliderLayout.addSliderView(sliderView);
//        }
//    }
}