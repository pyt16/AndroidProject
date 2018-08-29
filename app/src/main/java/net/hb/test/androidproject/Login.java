package net.hb.test.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Login extends Activity {
    EditText edt_id, edt_pw;

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.login);

        final EditText edt_id = (EditText) findViewById(R.id.edt_id);
        final EditText edt_pw = (EditText) findViewById(R.id.edt_pw);

        Button btn_login = (Button) findViewById(R.id.btn_login);
        TextView btn_register = (TextView) findViewById(R.id.btn_register);

        //로그인
        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //CustomTask task = new CustomTask();
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //회원가입
        btn_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

    class CustomTask extends AsyncTask<String, Void, String> {
        String sendMsg, receiveMsg;

        @Override
        public String doInBackground(String... strings) {
            try {
                edt_id = findViewById(R.id.edt_id);
                edt_pw = findViewById(R.id.edt_pw);

                strings[0] = edt_id.getText().toString();
                strings[1] = edt_pw.getText().toString();
                String str;
                URL url = new URL("http://192.168.5.65:8080/Web0714/loginSave.jsp");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                sendMsg = "id=" + strings[0] + "&pwd=" + strings[1];
                osw.write(sendMsg);
                osw.flush();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
            return receiveMsg;
        }
    }
}