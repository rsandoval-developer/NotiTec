package com.rsandoval.notitec.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by rsandoval on 04/11/2016.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
        initView(view, savedInstanceState);

    }

    public void initView(View view, Bundle savedInstanceState) {
    }

    private void bindViews(View rootView) {
        ButterKnife.bind(this, rootView);
    }


    protected abstract int getFragmentLayout();
}
