package com.rsandoval.notitec.presenters;

import com.rsandoval.notitec.model.Noticias;

import java.util.List;

/**
 * Created by lapprestamo on 11/11/16.
 */

public interface NoticiasContract {

    interface View {
        void showSendNoticias(List<Noticias.Noticia> noticias);
        void showError(String error);
        void showLoading();
        void hideLoading();
    }

    interface NoticiasListener {
        void getNoticias();
    }
}
