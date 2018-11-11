package com.example.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button btnRemove, btnInsert;
    private EditText editRemove, editInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        createExampleList ();
        buildRecyclerView ();
        btnInsert = (Button) findViewById (R.id.insert);
        btnRemove = (Button) findViewById (R.id.remove);
        editRemove = (EditText) findViewById (R.id.EditRemove);
        editInsert = (EditText) findViewById (R.id.EditInsert);
        btnInsert.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                int position=Integer.parseInt(editInsert.getText().toString ());
                insertItem (position);

            }
        });

        btnRemove.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                int position=Integer.parseInt(editRemove.getText().toString ());
                RemoveItem (position);


            }
        });}
        public void insertItem(int position){
        mExampleList.add (position ,new ExampleItem( R.drawable.ic_android, "New Item At Position"+position, " This is Line 2 "));
        mAdapter.notifyItemInserted (position);
        }
    public void RemoveItem(int position){
        mExampleList.remove (position);
        mAdapter.notifyItemInserted (position);
    }

    public void createExampleList(){
        mExampleList =new ArrayList<> ();
        mExampleList.add (new ExampleItem(R.drawable.ic_android,"Line 1", "Line 2"));
        mExampleList.add (new ExampleItem(R.drawable.ic_audiotrack_black_24dp,"Line 3", "Line 4"));
        mExampleList.add (new ExampleItem(R.drawable.ic_adjust_black_24dp,"Line 5", "Line 6"));
    }

    public void  buildRecyclerView(){
        RecyclerView mrecyclerView= (RecyclerView)findViewById (R.id.recyclerView);
        mrecyclerView.setHasFixedSize (true);
        mLayoutManager=new LinearLayoutManager (this);
        mAdapter=new ExampleAdapter (mExampleList);
        mrecyclerView.setLayoutManager (mLayoutManager);
        mrecyclerView.setAdapter (mAdapter);


    }

}
