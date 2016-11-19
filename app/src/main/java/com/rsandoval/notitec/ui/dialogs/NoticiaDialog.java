package com.rsandoval.notitec.ui.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by lapprestamo on 12/11/16.
 */

public class NoticiaDialog extends DialogFragment {

    private static String ARG_TITULO = "titulo";
    private static String ARG_DESCRIPTION = "description";

    public static NoticiaDialog newInstance(String titulo, String descripcion){
        NoticiaDialog noticiaDialog = new NoticiaDialog();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITULO,titulo);
        bundle.putString(ARG_DESCRIPTION,descripcion);
        noticiaDialog.setArguments(bundle);

        return noticiaDialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String titulo = getArguments().getString(ARG_TITULO);
        String description = getArguments().getString(ARG_DESCRIPTION);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(description)
                .setTitle(titulo);

        return builder.create();

    }
}
