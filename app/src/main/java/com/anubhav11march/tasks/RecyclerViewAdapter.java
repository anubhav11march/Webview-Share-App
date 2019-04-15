package com.anubhav11march.tasks;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>{

    public Context context;
    List<item> items;
    RecyclerViewAdapter(List<item> items, Context context){
        this.items = items;
        this.context = context;

    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView itemName;
        ImageView itemPicture;
        TextView itemPrice;
        String url;
        Button butt ,wbutt;

        ItemViewHolder (View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            itemName = (TextView) itemView.findViewById(R.id.name);
            itemPicture = (ImageView) itemView.findViewById(R.id.image);
            itemPrice = (TextView) itemView.findViewById(R.id.ddprice);
            butt = (Button) itemView.findViewById(R.id.buttt);
            wbutt = (Button) itemView.findViewById((R.id.share));
        }
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ItemViewHolder ivh = new ItemViewHolder(view);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, final int i) {
        itemViewHolder.itemName.setText(items.get(i).name);
        itemViewHolder.itemPicture.setImageResource(items.get(i).logoid);
        itemViewHolder.itemPrice.setText(items.get(i).dprice);
        itemViewHolder.butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Searching " + items.get(i).name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, wbvw.class);
                intent.putExtra("url", items.get(i).url);
                context.startActivity(intent);
            }
        });

        itemViewHolder.wbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Buy " + items.get(i).name + " at " + items.get(i).dprice + " only. Click here: " +items.get(i).url);
                try {
                    context.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(context, "Whatsapp is not installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
