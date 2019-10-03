package com.example.misgastosapp.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.misgastosapp.R;
import com.example.misgastosapp.model.Operation;

public class NewOperationActivity extends AppCompatActivity {

    private Button registerButton;
    private EditText amountInput;
    private Spinner accountSpinner;
    private RadioGroup operationRadioGroup;
    private RadioButton ingressRadioButton;
    private RadioButton expenseRadioButton;
    private EditText dateInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);

        amountInput = findViewById(R.id.input_amount);
        accountSpinner = findViewById(R.id.spinner_account);
        operationRadioGroup = findViewById(R.id.radiogroup_operation);
        dateInput = findViewById(R.id.input_date);
        ingressRadioButton = findViewById(R.id.radiobutton_ingress);
        expenseRadioButton = findViewById(R.id.radiobutton_expense);
        registerButton = findViewById(R.id.button_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegister();
            }
        });
    }

    public void radioButtonClicked(View view) {
        // This check which radio button was clicked
        if (ingressRadioButton.isSelected()){
            String ope = ingressRadioButton.getText().toString();
        }else{
            String ope = expenseRadioButton.getText().toString();
        }
        return;
    }


    public void typeAccount(){
        String type_account = (String)accountSpinner.getSelectedItem();
        String t_account;
        int position = accountSpinner.getSelectedItemPosition();
        if(position==0) {
            t_account = "Tarjeta de credito";
        }else if (position==1){
            t_account = "Ahorro";
        }else{
            t_account = "Efectivo";
        }
    }


    private void callRegister(){
        Operation operation = new Operation();
        double amount = Double.parseDouble(amountInput.getText().toString());
        String account = accountSpinner.getSelectedItem().toString();
        String date = dateInput.getText().toString();
        String oper = operationRadioGroup.toString();

        if(account.isEmpty()){
            Toast.makeText(this, "Se tiene que completar el tipo de cuenta", Toast.LENGTH_LONG);
        }

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("amount", amount);
        intent.putExtra("account", account);
        intent.putExtra("date", date);
        intent.putExtra("oper", oper);
        startActivityForResult(intent, REGISTER_REQUEST_CODE);
    }

    private static final int REGISTER_REQUEST_CODE = 200;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REGISTER_REQUEST_CODE){
            if(resultCode == RESULT_OK){

            }
        }
    }

}
