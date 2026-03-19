package com.example.expensemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button expenseBtn, incomeBtn, transactionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   // aapke XML ka naam activity_main.xml hai

        expenseBtn = findViewById(R.id.button);
        incomeBtn = findViewById(R.id.button2);
        transactionBtn = findViewById(R.id.button3);

        // Expense Button Click
        expenseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Expense.class);
                startActivity(intent);
            }
        });

        // Income Button Click
        incomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Income.class);
                startActivity(intent);
            }
        });

        // Transaction Button Click
        transactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Transaction.class);
                startActivity(intent);
            }
        });
    }
}
