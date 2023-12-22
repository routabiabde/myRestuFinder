package com.elmernissi.myrestufinder.MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elmernissi.myrestufinder.R;
import com.elmernissi.myrestufinder.model.Magasin;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Magasin> magasinsList;

    private Context context;


    public void setData(List<Magasin> paysList) {
        this.magasinsList = paysList;
        this.notifyDataSetChanged();
    }



    public MyAdapter(Context context, List<Magasin> paysList ) {
        this.context = context;
        this.magasinsList = paysList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_magasin_item, parent, false);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Magasin magasin = magasinsList.get(position);
        holder.nomText.setText(magasin.getNomRes());
        holder.cityText.setText(magasin.getNomVill());
        holder.teleText.setText(magasin.getTel());
    }

    @Override
    public int getItemCount() {
        return magasinsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nomText,cityText,teleText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomText = itemView.findViewById(R.id.nomTextView);
            cityText = itemView.findViewById(R.id.adresseTextView);
            teleText = itemView.findViewById(R.id.telephoneTextView);

        }
    }
}
