package com.example.ingredientmultiplier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button addIngredient;
    Button calculate;
    ArrayList<String> ingredients;
    EditText multiplier;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = findViewById(R.id.calculate);
        addIngredient = findViewById(R.id.addIngredient);
        name = findViewById(R.id.name);
        ingredients = new ArrayList<String>();
        multiplier = findViewById(R.id.multiplier);

        final Toast toast = Toast.makeText(this, "Ingredient Added", 0);
        addIngredient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                ingredients.add(MainActivity.this.name.getText().toString());
                name.setText("");
                toast.show();
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                goToCalculate();
            }
        });

    }
    public void goToCalculate() {
        Intent intent = new Intent(this, Calculate.class);
        intent.putExtra("Ingredients", ingredients);
        intent.putExtra("Multiplier", Double.valueOf(multiplier.getText().toString()));
        startActivity(intent);
    }
}