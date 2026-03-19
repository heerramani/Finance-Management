package com.example.expensemanagement;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Transaction extends AppCompatActivity {

    TextView textIncome, textExpense, textBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        textIncome = findViewById(R.id.textViewIncome);
        textExpense = findViewById(R.id.textViewExpense);
        textBalance = findViewById(R.id.textViewBalance);

        // SharedPreferences se data nikaalna
        SharedPreferences sp = getSharedPreferences("MyData", MODE_PRIVATE);

        String incomeStr = sp.getString("last_income", "0");
        String expenseStr = sp.getString("last_expense", "0");

        try {
            int income = Integer.parseInt(incomeStr);
            int expense = Integer.parseInt(expenseStr);
            int balance = income - expense;

            textIncome.setText(getString(R.string.last_income, String.valueOf(income)));
            textExpense.setText(getString(R.string.last_expense, String.valueOf(expense)));
            textBalance.setText(getString(R.string.total_balance, String.valueOf(balance)));
        } catch (NumberFormatException e) {
            textIncome.setText(getString(R.string.last_income, "0"));
            textExpense.setText(getString(R.string.last_expense, "0"));
            textBalance.setText(getString(R.string.total_balance, "0"));
        }
    }
}
