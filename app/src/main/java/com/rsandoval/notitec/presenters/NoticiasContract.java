package com.rsandoval.notitec.presenters;

import com.rsandoval.notitec.models.Noticias;

import java.util.List;

/**
 * Created by lapprestamo on 12/11/16.
 */

public interface NoticiasContract {
    interface View {
        void showSendNoticias(List<Noticias.Noticia> noticias);

        void showLoading();

        void hideLoading();
    }

    interface NoticiasListener {
        void getNoticias();
    }
}
