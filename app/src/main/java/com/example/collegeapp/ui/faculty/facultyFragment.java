package com.example.collegeapp.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class facultyFragment extends Fragment {

    private RecyclerView csDepartment,eeDepartment,meDepartment,ceDepartment;
    private LinearLayout csNoData,eeNoData,meNoData,ceNoData;
    private List<TeacherData> list1,list2,list3,list4;
    private DatabaseReference reference,dbref;
    private TeacherAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_faculty, container, false);
        csDepartment=view.findViewById(R.id.csDepartment);
        eeDepartment=view.findViewById(R.id.eeDepartment);
        meDepartment=view.findViewById(R.id.meDepartment);
        ceDepartment=view.findViewById(R.id.ceDepartment);
        csNoData=view.findViewById(R.id.csNoData);
        eeNoData=view.findViewById(R.id.eeNoData);
        meNoData=view.findViewById(R.id.meNoData);
        ceNoData=view.findViewById(R.id.ceNoData);
        reference= FirebaseDatabase.getInstance().getReference().child("Teachers");
        csDepartment();
        eeDepartment();
        meDepartment();
        ceDepartment();
        return view;
    }

    private void csDepartment() {
        dbref=reference.child("Computer Science");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1=new ArrayList<>();
                if(!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }
                else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        TeacherData data=dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                        csDepartment.setHasFixedSize(true);
                        csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter=new TeacherAdapter(list1,getContext());
                        csDepartment.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eeDepartment() {
        dbref=reference.child("Electrical");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2=new ArrayList<>();
                if(!snapshot.exists()){
                    eeNoData.setVisibility(View.VISIBLE);
                    eeDepartment.setVisibility(View.GONE);
                }
                else{
                    eeNoData.setVisibility(View.GONE);
                    eeDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        TeacherData data=dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                        eeDepartment.setHasFixedSize(true);
                        eeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter=new TeacherAdapter(list2,getContext());
                        eeDepartment.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void meDepartment() {
        dbref=reference.child("Mechanical");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3=new ArrayList<>();
                if(!snapshot.exists()){
                    meDepartment.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                }
                else{
                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        TeacherData data=dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                        meDepartment.setHasFixedSize(true);
                        meDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter=new TeacherAdapter(list3,getContext());
                        meDepartment.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ceDepartment() {
        dbref=reference.child("Chemical");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4=new ArrayList<>();
                if(!snapshot.exists()){
                    ceDepartment.setVisibility(View.VISIBLE);
                    ceDepartment.setVisibility(View.GONE);
                }
                else{
                    ceNoData.setVisibility(View.GONE);
                    ceDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        TeacherData data=dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                        ceDepartment.setHasFixedSize(true);
                        ceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter=new TeacherAdapter(list4,getContext());
                        ceDepartment.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}