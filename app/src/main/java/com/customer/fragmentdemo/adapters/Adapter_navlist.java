package com.customer.fragmentdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.customer.fragmentdemo.R;

import java.util.zip.Inflater;

/**
 * Created by tesark on 18/8/16.
 */
public class Adapter_navlist extends RecyclerView.Adapter<Adapter_navlist.ViewHolder> {
    Context context;
    String[] menu;

    public Adapter_navlist(Context context, String[] menu) {
        this.context = context;
        this.menu = menu;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_navlist, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(menu[position]);
    }

    @Override
    public int getItemCount() {
        return menu.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.tv_list);
        }
    }
}
