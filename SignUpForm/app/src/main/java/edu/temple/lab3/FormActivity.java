package edu.temple.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Array;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FormActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText editText;
    Toast toast;
    Context context;
    CharSequence text;
    int duration = Toast.LENGTH_LONG;
    boolean success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.Login_button);

        View.OnClickListener onClickListener = new ButtonClickListener();
        button.setOnClickListener(onClickListener);
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            success = true;
            context = getApplicationContext();
            Integer[][] view_list = new Integer[][]{{R.id.Name_view, R.id.Name_error}, {R.id.Email_view, R.id.Email_error}, {R.id.Password_view, R.id.Password_error}};
            try {
                for (Integer[] i : view_list) {
                    if (!Login((int) Array.get(i, 0), (int) Array.get(i, 1))) {
                        success = false;
                    }
                }
            }
            catch(Exception e) {
                Log.e("EditText loop", "Loop of EditText Views has returned an Exception" + e);
            }
            editText = findViewById(R.id.Password_view);
            String temp = editText.getText().toString();
            editText = findViewById(R.id.Confirmation_view);
            String temp2 = editText.getText().toString();
            editText = findViewById(R.id.Name_view);
            text = "Welcome, " + editText.getText() + ", to the SignUpForm App";
            if (!temp.equals(temp2)) {
                textView = findViewById(R.id.Confirmation_error);
                textView.setVisibility(View.VISIBLE);
            }
            else if (success) {
                textView = findViewById(R.id.Confirmation_error);
                textView.setVisibility(View.INVISIBLE);
                toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else {
                textView = findViewById(R.id.Confirmation_error);
                textView.setVisibility(View.INVISIBLE);
            }
        }

        private boolean Login(int input, int error){
            editText = findViewById(input);
            textView = findViewById(error);
            if (editText.getText().toString().matches("")) {
                textView.setVisibility(View.VISIBLE);
                return false;
            }
            else {
                textView.setVisibility(View.INVISIBLE);
                return true;
            }
        }
    }
}