package com.rsandoval.notitec.ui.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rsandoval.notitec.R;
import com.rsandoval.notitec.models.Noticias;
import com.rsandoval.notitec.ui.dialogs.NoticiaDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lapprestamo on 12/11/16.
 */

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.ViewHolder> {

    private List<Noticias.Noticia> noticias;
    private Context context;
    private FragmentManager fragmentManager;

    public NoticiasAdapter(List<Noticias.Noticia> noticias, Context context, FragmentManager fragmentManager) {
        this.noticias = noticias;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_noticias, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Noticias.Noticia noticia = noticias.get(position);
        holder.titulo.setText(noticia.getTitulo());
        Glide.with(context)
                .load(noticia.getImagen())
                .centerCrop()
                .into(holder.imagenNoticia);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoticiaDialog noticiaDialog = NoticiaDialog.newInstance(noticia.getTitulo(),noticia.getDescripcion());
                noticiaDialog.show(fragmentManager, NoticiaDialog.class.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imagen_noticia)
        ImageView imagenNoticia;
        @BindView(R.id.titulo)
        TextView titulo;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

}
