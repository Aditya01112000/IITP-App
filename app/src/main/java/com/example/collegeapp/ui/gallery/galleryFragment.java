package com.example.collegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class galleryFragment extends Fragment {

    RecyclerView convocation,other;
    Galleryadapter adapter;
    DatabaseReference reference,dbref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        convocation=view.findViewById(R.id.convocationrecycle);
        other=view.findViewById(R.id.othersarecycle);
        reference= FirebaseDatabase.getInstance().getReference().child("gallery");
        getConvoImage();
        getOtherImage();
        return view;

    }

    private void getOtherImage() {
       reference.child("Others Events").addValueEventListener(new ValueEventListener() {
            List<String> ima=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                   String data=(String)dataSnapshot.getValue();
                   ima.add(data);
               }
               adapter=new Galleryadapter(getContext(),ima);
               other.setLayoutManager(new GridLayoutManager(getContext(),3));
               other.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),"Something",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener(){
            List<String> ima=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String data=(String)dataSnapshot.getValue();
                    ima.add(data);
                }
                adapter=new Galleryadapter(getContext(),ima);
                convocation.setLayoutManager(new GridLayoutManager(getContext(),3));
                convocation.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),"Something went Wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }

}