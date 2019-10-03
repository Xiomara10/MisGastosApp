package com.example.misgastosapp.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.misgastosapp.R;
import com.example.misgastosapp.adapters.OperationAdapter;
import com.example.misgastosapp.model.Operation;
import com.example.misgastosapp.repositories.OperationsRepository;

import java.util.ArrayList;

import static com.example.misgastosapp.repositories.OperationsRepository.operations;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerView = findViewById(R.id.reciclerview_operations_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        OperationAdapter adapter = new OperationAdapter();
        adapter.setOperations(OperationsRepository.getOperations());
        recyclerView.setAdapter(adapter);

        if(getIntent().getExtras() != null) {
            double amount = getIntent().getExtras().getDouble("amount");
            String account = getIntent().getExtras().getString("account");
            String date = getIntent().getExtras().getString("date");
            String oper = getIntent().getExtras().getString("oper");

            Operation operation = new Operation();
            operation.setAmount(amount);
            operation.setOperationType(oper);
            operation.setAccountType(account);
            operation.setDate(date);

            operations.add(operation);

        }
    }

}
