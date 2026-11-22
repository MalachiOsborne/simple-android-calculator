package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity_calc extends AppCompatActivity implements View.OnClickListener {

    Button button_add, button_sub, button_mul, button_div;
    EditText et1, et2;
    TextView textView;
    int num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*findViewById is a function that returns a generated integer constant to
          connect the id we set in `activity_main.xml` to our code
          `R` is a class that contains a lot of subclasses that in turn contain
          integer constants that relate xml stuff to our code
          `R.id.button_add` is basically accessing the generated `button_add` inside the
          `id` class nested in the `R` class

          this code block is just finding the generated integer constants and assigning
          them to our previously declared objects before the `onCreate()` function
         */

        button_add=findViewById(R.id.button_add);
        button_sub=findViewById(R.id.button_sub);
        button_mul=findViewById(R.id.button_mul);
        button_div=findViewById(R.id.button_div);
        et1=findViewById(R.id.numero_uno);
        et2=findViewById(R.id.numero_dos);
        textView=findViewById(R.id.answer);

        //not sure what's happening here
        button_add.setOnClickListener(this);
        button_sub.setOnClickListener(this);
        button_mul.setOnClickListener(this);
        button_div.setOnClickListener(this);

    }

    //this is to convert a string into an int
    public int getNum(EditText et){
        if(et.getText().toString().equals("")){
            //toast is like when u save an image, sth pops on the bottom saying "image saved"
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            //parses (basically converts but not really) string into an int
            return Integer.parseInt(et.getText().toString());
    }
    @Override
    public void onClick(View v) {
        num1 = getNum(et1);
        num2 = getNum(et2);

        int id = v.getId();

        if (id == R.id.button_add) {
            textView.setText("" + (num1 + num2));
        } else if (id == R.id.button_sub) {
            textView.setText("" + (num1 - num2));
        } else if (id == R.id.button_mul) {
            textView.setText("" + (num1 * num2));
        } else if (id == R.id.button_div) {
            textView.setText("" + ((float) num1 / (float) num2));
        }
    }


}