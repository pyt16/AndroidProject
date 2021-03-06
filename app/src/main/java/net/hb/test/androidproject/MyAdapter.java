package net.hb.test.androidproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;

            public ViewHolder(View v){
            super(v);
            mTextView = (TextView) itemView.findViewById(R.id.mTextView);
        }
    }

    public MyAdapter(String[] myDataset){
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount(){
        return mDataset.length;
    }
}
