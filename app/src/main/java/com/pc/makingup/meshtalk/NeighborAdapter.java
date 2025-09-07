package com.pc.makingup.meshtalk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NeighborAdapter extends RecyclerView.Adapter<NeighborAdapter.NeighborViewHolder> {

    private List<String> neighborList = new ArrayList<>();
    private Context context;

    public NeighborAdapter(Context context) {
        this.context = context;
        neighborList.add("Alice");
        neighborList.add("Bob");
        neighborList.add("Charlie");
    }

    @NonNull
    @Override
    public NeighborViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new NeighborViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NeighborViewHolder holder, int position) {
        String neighborName = neighborList.get(position);
        holder.nameText.setText(neighborName);

        holder.itemView.setOnClickListener(v -> {
            // Open ChatActivity and pass the neighbor name
            Intent intent = new Intent(context, ChatActivity.class);
            intent.putExtra("neighbor_name", neighborName);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return neighborList.size();
    }

    public void updateNeighbors(List<String> newList) {
        neighborList.clear();
        neighborList.addAll(newList);
        notifyDataSetChanged();
    }

    static class NeighborViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;

        NeighborViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(android.R.id.text1);
        }
    }
}
