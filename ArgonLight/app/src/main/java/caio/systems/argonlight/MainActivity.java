package caio.systems.argonlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String login;
    private String password;
    private EditText txtLogin, txtPwd;
    private TextView forget_password, create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = findViewById(R.id.usr);
        txtPwd = findViewById(R.id.pwd);
        forget_password = findViewById(R.id.txtForgotPass);
        create_account = findViewById(R.id.txtSignup);

        String link_1 = "http://www.google.com";
        String link_2 = "https://www.w3schools.com/";
        forget_password.setMovementMethod(LinkMovementMethod.getInstance());
        create_account.setMovementMethod(LinkMovementMethod.getInstance());
        Linkify.addLinks(forget_password, Linkify.ALL);
        Linkify.addLinks(create_account, Linkify.ALL);

    }

    public void logIn(View view) {
        Intent i = new Intent(getApplicationContext(), BasicDrawerActivity.class);
        startActivity(i);
    }
}
