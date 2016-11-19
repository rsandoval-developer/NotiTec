package com.rsandoval.notitec.presenters;

import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.rsandoval.notitec.models.Noticias;

import java.util.List;

/**
 * Created by lapprestamo on 12/11/16.
 */

public class NoticiasPresenter implements NoticiasContract.NoticiasListener {

    private NoticiasContract.View view;
    private Context context;
    private DatabaseReference databaseReference;

    public NoticiasPresenter(NoticiasContract.View view, DatabaseReference databaseReference, Context context) {
        this.view = view;
        this.databaseReference = databaseReference;
        this.context = context;
    }

    @Override
    public void getNoticias() {
        view.showLoading();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Noticias.Noticia> noticias = dataSnapshot.getValue(Noticias.class).getNoticias();
                view.showSendNoticias(noticias);
                view.hideLoading();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
