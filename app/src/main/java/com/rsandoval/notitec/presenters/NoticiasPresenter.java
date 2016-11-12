package com.rsandoval.notitec.presenters;

import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.rsandoval.notitec.model.Noticias;

/**
 * Created by lapprestamo on 11/11/16.
 */

public class NoticiasPresenter implements NoticiasContract.NoticiasListener{

    private Context context;
    private NoticiasContract.View view;
    private DatabaseReference databaseReference;


    public NoticiasPresenter(Context context, NoticiasContract.View view, DatabaseReference databaseReference) {
        this.context = context;
        this.view = view;
        this.databaseReference = databaseReference;
    }

    @Override
    public void getNoticias() {
        view.showLoading();
       databaseReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               view.hideLoading();
               Noticias noticias = dataSnapshot.getValue(Noticias.class);
               view.showSendNoticias(noticias.getNoticias());
           }

           @Override
           public void onCancelled(DatabaseError databaseError) {
               view.hideLoading();
               view.showError(databaseError.getMessage());
           }
       });
    }
}
