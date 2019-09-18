package temple.edu.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class FormActivity extends AppCompatActivity {

    EditText uName;
    EditText pass;
    EditText confirm;
    EditText email;
    Button button;
    ArrayList<EditText> allInputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        uName = findViewById(R.id.userName);
        pass = findViewById(R.id.pass);
        confirm = findViewById(R.id.passConfirm);
        email = findViewById(R.id.email);

        button = findViewById(R.id.button);
        allInputs = new ArrayList<>();
        allInputs.add(uName);
        allInputs.add(pass);
        allInputs.add(confirm);
        allInputs.add(email);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean filled = true;
                for(EditText x : allInputs){
                    if(x.getText().length() == 0) filled = false;
                }
                if(!filled){
                    Toast.makeText(getApplicationContext(),"All field must be filled",Toast.LENGTH_SHORT).show();
                }
                else if(!pass.getText().toString().equals(confirm.getText().toString())){
                    Toast.makeText(getApplicationContext(),"2 passwords are not the same",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Welcome, " + uName.getText() +" to the SignUpForm App!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
