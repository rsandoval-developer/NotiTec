package com.rsandoval.notitec.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rsandoval.notitec.R;
import com.rsandoval.notitec.model.Noticias;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lapprestamo on 11/11/16.
 */

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.ViewHolder> {

    private Context context;
    private List<Noticias.Noticia> noticiasList;

    public NoticiasAdapter(Context context, List<Noticias.Noticia> noticiasList) {
        this.context = context;
        this.noticiasList = noticiasList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_noticia, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Noticias.Noticia noticia = noticiasList.get(position);
        Glide.with(context)
                .load(noticia.getImagen())
                .centerCrop()
                .into(holder.imagenNoticia);
        holder.titulo.setText(noticia.getTitulo());
    }

    @Override
    public int getItemCount() {
        return noticiasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_noticia)
        ImageView imagenNoticia;
        @BindView(R.id.titulo)
        TextView titulo;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }
}
