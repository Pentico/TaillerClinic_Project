package com.tamcyber.taillerclinic_.view.fragment;

import android.app.Fragment;
import android.widget.Toast;

import com.tamcyber.taillerclinic_.internal.di.HasComponent;

/**
 * Created by Tuane on 2016/12/14.
 */

/**
 * Base {@link android.app.Fragment} class for every fragment in this application.
 */

public class BaseFragment extends Fragment {

    /**
     * Shows a {@link android.widget.Toast} message.
     *
     * @param message An string representing a message to be shown.
     */
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

}
