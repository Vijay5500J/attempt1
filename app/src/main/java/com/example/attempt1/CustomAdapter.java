package com.example.attempt1;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyVieHolder> {
    ArrayList<ListBean> list;
    Context context;

    public CustomAdapter(ArrayList<ListBean> list) {
        this.list=list;
    }

    @NonNull
    @Override
    public MyVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.row,parent,false);



        return new MyVieHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVieHolder holder, final int position) {

        holder.price.setText(list.get(position).getPrice());holder.location.setText(list.get(position).getLocation());
        holder.type.setText(list.get(position).getType());
        holder.constr.setText(list.get(position).getConstrctr());
       holder.date.setText(list.get(position).getDate());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    context.startActivity(new Intent(context,DetailsActivity.class));
                }
                else if (position==1){
                    context.startActivity(new Intent(context,Details2Activity.class));
                }
                else if(position==2){
                    context.startActivity(new Intent(context,Details3Activity.class));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyVieHolder extends RecyclerView.ViewHolder{
        TextView price;
        TextView location;
        TextView type;
        TextView constr;
        TextView date;
        LinearLayout layout;


        public MyVieHolder(View itemView) {
            super(itemView);
            price=itemView.findViewById(R.id.price);
            location=itemView.findViewById(R.id.location);
            type=itemView.findViewById(R.id.type);
            constr=itemView.findViewById(R.id.constr);
            date=itemView.findViewById(R.id.date);
            layout=itemView.findViewById(R.id.layout);

        }
    }
}


