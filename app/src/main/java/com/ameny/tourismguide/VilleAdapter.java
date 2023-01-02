package com.ameny.tourismguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class VilleAdapter extends RecyclerView.Adapter<VilleViewHolder> {
    private Context context;
    private List<VilleModel> dataList;
    public void setSearchList(List<VilleModel> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }
    public VilleAdapter(Context context, List<VilleModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public VilleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ville_item, parent, false);
        return new VilleViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull VilleViewHolder holder, int position) {

            holder.image.setImageResource(dataList.get(position).getDataImage());
            holder.title.setText(dataList.get(position).getNom());
            holder.recCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, LocationDetailsActivity.class);
                    intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                    intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getNom());
                    intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getDataDesc());

                    context.startActivity(intent);
                }
            });


    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
class VilleViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView title, recDesc, recLang;
    CardView recCard;
    public VilleViewHolder(@NonNull View itemView) {
        super(itemView);
       image = itemView.findViewById(R.id.imageville);
       title = itemView.findViewById(R.id.titleville);

        recCard = itemView.findViewById(R.id.card);
    }
}