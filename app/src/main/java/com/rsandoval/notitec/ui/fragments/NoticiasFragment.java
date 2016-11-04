package com.rsandoval.notitec.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.rsandoval.notitec.R;
import com.rsandoval.notitec.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasFragment extends BaseFragment {


    public NoticiasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_noticias;
    }

}
