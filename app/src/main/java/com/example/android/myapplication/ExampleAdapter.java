package com.example.android.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from (parent.getContext ()).inflate (R.layout.example_item,parent, false);
        ExampleViewHolder evh=new ExampleViewHolder (v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem CurrentItem= mExampleList.get(position);
        holder.mImageView.setImageResource ( CurrentItem.getmImageResource ());
        holder.mTextView1.setText (CurrentItem.getmText1 ());
        holder.mTextView2.setText (CurrentItem.getmText2 ());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size ();
    }

    public  static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public  TextView mTextView2;

        public ExampleViewHolder(View itemView) {
            super (itemView);

            mImageView=itemView.findViewById (R.id.imageView1);
            mTextView1=itemView.findViewById (R.id.tv1);
            mTextView2=itemView.findViewById (R.id.tv2);
        }
    }
    public  ExampleAdapter(ArrayList<ExampleItem> exampleList){

        mExampleList=exampleList;
    }
}
