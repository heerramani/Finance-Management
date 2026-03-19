package com.example.expensemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Expense extends AppCompatActivity {

    EditText editTextExpense;
    Button btnSubtractExpense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        editTextExpense = findViewById(R.id.editTextText);
        btnSubtractExpense = findViewById(R.id.button4);

        btnSubtractExpense.setOnClickListener(v -> {
            String expenseStr = editTextExpense.getText().toString();

            if (expenseStr.isEmpty()) {
                Toast.makeText(this, R.string.please_enter_amount, Toast.LENGTH_SHORT).show();
                return;
            }

            new MaterialAlertDialogBuilder(this)
                    .setTitle(R.string.confirmation)
                    .setMessage(R.string.confirm_msg)
                    .setPositiveButton(R.string.yes, (dialog, which) -> {
                        // Save in SharedPreferences
                        SharedPreferences sp = getSharedPreferences("MyData", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("last_expense", expenseStr);
                        editor.apply();

                        Toast.makeText(this, R.string.amount_subtracted_success, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    })
                    .setNegativeButton(R.string.no, (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
}
