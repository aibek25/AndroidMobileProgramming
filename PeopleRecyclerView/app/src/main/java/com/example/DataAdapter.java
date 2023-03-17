package com.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context context;
    private int rowId;
    private Person[] people;
    private IRecyclerView recyclerView;

    public DataAdapter(Context context, int rowId, Person[] people, IRecyclerView recyclerView) {
        this.context = context;
        this.rowId = rowId;
        this.people = people;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(this.rowId, parent, false);

        return new ViewHolder(v, recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        // populate holder with data at position
        holder.name.setText(this.people[position].getName());

        String iconName = this.people[position].getImage();
        iconName = iconName.substring(0, iconName.indexOf('.'));

        int imageId = this.context.getResources()
                .getIdentifier(iconName, "drawable", this.context.getPackageName());

        holder.icon.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return this.people.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView icon;

        public ViewHolder(@NonNull View itemView, IRecyclerView recyclerView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView);
            icon = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(v -> {
                // call the interface method

                if (recyclerView == null) return;

                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    recyclerView.onClickItem(position);
                }
            });
        }
    }
}
