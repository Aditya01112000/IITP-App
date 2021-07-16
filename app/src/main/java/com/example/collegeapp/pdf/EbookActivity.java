package com.example.collegeapp.pdf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    private RecyclerView ebookRecycle;
    private DatabaseReference reference;
    private List<ebookData> list;
    private ebookAdapter ebookAdapter;
    LinearLayout shi;
    ShimmerFrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        ebookRecycle=findViewById(R.id.ebookRecycle);
        container= findViewById(R.id.shimmerView);
        shi=findViewById(R.id.shi);
        reference= FirebaseDatabase.getInstance().getReference().child("pdf");
        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()) {
                    ebookData data = dataSnapshot.getValue(ebookData.class);
                    list.add(data);
                }
                //progressBar.setVisibility(View.GONE);
                ebookRecycle.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookAdapter=new ebookAdapter(EbookActivity.this,list);
                ebookRecycle.setAdapter(ebookAdapter);
                container.stopShimmer();
                shi.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //progressBar.setVisibility(View.GONE);
                Toast.makeText(EbookActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}