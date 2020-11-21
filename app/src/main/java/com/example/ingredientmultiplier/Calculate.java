package com.example.ingredientmultiplier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculate extends AppCompatActivity {

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        output = findViewById(R.id.output);
        Bundle bundle = getIntent().getExtras();
        ArrayList<String> Ingredients = bundle.getStringArrayList("Ingredients");
        double d = bundle.getDouble("Multiplier");
        int j = Ingredients.size();
        int i;
        for (i = 0; i < j; i++) {

            String[] amountIngredient = stringSplit(Ingredients.get(i));
            Double amount = Double.valueOf(amountIngredient[0]);
            String str = amountIngredient[1];

            TextView output = this.output;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.output.getText().toString());
            stringBuilder.append(amount * d);
            stringBuilder.append(str);
            stringBuilder.append("\n");
            output.setText(stringBuilder.toString());
        }

    }

    public String[] stringSplit(String ingredient) {
        String[] output = new String[2];
        output[0] = ingredient.replaceAll("\\D+", "");
        output[1] = ingredient.replace(output[0], "");
        return output;
    }
}