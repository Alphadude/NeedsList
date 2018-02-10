package com.ng.needslist.needslist.Util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ng.needslist.needslist.R;

/**
 * Created by user on 2/3/2018.
 */

public class AuthErrorDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialog = inflater.inflate(R.layout.error_dialog, null);
        builder.setView(dialog);
        final AlertDialog errorDialog = builder.create();

        TextView message = (TextView) dialog.findViewById(R.id.message);
        message.setText(getArguments().getString("msg"));
        Button register = (Button) dialog.findViewById(R.id.buttonRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button try_again = (Button) dialog.findViewById(R.id.try_again);
        try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorDialog.dismiss();
            }
        });


        return errorDialog;
    }

    public static AuthErrorDialog newInstance(String msg) {
        AuthErrorDialog fragment = new AuthErrorDialog();

        Bundle bundle = new Bundle();
        bundle.putString("msg", msg);
        fragment.setArguments(bundle);

        return fragment;
    }
}
