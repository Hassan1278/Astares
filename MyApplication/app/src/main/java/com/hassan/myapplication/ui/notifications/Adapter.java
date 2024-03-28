package com.hassan.myapplication.ui.notifications;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hassan.myapplication.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    List<String> listItem;

    public Adapter(List<String> passedListItem){
        this.listItem = passedListItem;
    }

    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view, parent, false);

        return new myViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        int itemNumber = position+1;
        holder.itemTextView.setText("Item Number " + itemNumber + ": " + listItem.get(position));
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView itemTextView;

        public myViewHolder(View view){
            super(view);
            itemTextView = view.findViewById(R.id.tv_itemTextView);
        }
    }
}