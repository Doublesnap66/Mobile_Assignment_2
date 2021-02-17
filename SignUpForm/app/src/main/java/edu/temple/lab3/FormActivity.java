package edu.temple.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.lang.reflect.Array;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import org.w3c.dom.Text;

public class FormActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText editText;

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
            Integer[][] view_list = new Integer[][]{{R.id.Name_view, R.id.Name_error}, {R.id.Email_view, R.id.Email_error}, {R.id.Password_view, R.id.Password_error}};
            try {
                for (Integer[] i : view_list) {
                    Login((int) Array.get(i, 0), (int) Array.get(i, 1));
                }
            }
            catch(Exception e) {
                Log.e("EditText loop", "Loop of EditText Views has returned an Exception" + e);
            }
            editText = findViewById(R.id.Password_view);
            String temp = editText.getText().toString();
            editText = findViewById(R.id.Confirmation_view);
            String temp2 = editText.getText().toString();
            if (!temp.equals(temp2)) {
                textView = findViewById(R.id.Confirmation_error);
                textView.setVisibility(View.VISIBLE);
            }
        }

        private void Login(int input, int error){
            editText = findViewById(input);
            textView = findViewById(error);
            if (editText.getText().toString().matches("")) {
                textView.setVisibility(View.VISIBLE);
            }
        }
    }
}