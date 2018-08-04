package com.example.suhanshu.mitra.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suhanshu.mitra.interfaces.OnClickListener;
import com.example.suhanshu.mitra.R;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    OnClickListener onClickListener;
    int[] drawsid;
    String[] names;

    public AdapterClass(OnClickListener onClickListener, int[] drawsid, String[] names) {
        this.onClickListener = onClickListener;
        this.drawsid = drawsid;
        this.names = names;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       holder.imageView.setImageResource(drawsid[position]);
       holder.textView.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(getAdapterPosition(), textView.getText());
                }
            });
        }
    }
}
