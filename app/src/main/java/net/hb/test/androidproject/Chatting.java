package net.hb.test.androidproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Chatting extends Fragment {
    EditText edt_send;
    Button btn_send;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.chatting, container, false);

        edt_send = (EditText)v.findViewById(R.id.edt_send);





        return v;
    }

}
