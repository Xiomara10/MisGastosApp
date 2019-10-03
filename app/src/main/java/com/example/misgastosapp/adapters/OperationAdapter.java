package com.example.misgastosapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import com.example.misgastosapp.model.Operation;
import com.example.misgastosapp.R;

public class OperationAdapter extends RecyclerView.Adapter<OperationAdapter.ViewHolder>{

    Operation operation = new Operation();

    private List<Operation> operations;

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public OperationAdapter() {
        this.operations = new ArrayList<>();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView dateText;
        TextView operationText;
        TextView amountText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateText=itemView.findViewById(R.id.textview_item_date);
            operationText=itemView.findViewById(R.id.textview_item_operacion);
            amountText=itemView.findViewById(R.id.textview_item_amount);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_operation, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        this.operations.get(i);
        viewHolder.dateText.setText(operation.getDate());
        viewHolder.operationText.setText(operation.getOperationType());
        viewHolder.amountText.setText(Double.toString(operation.getAmount()));
    }

    @Override
    public int getItemCount() {
        return this.operations.size();
    }
}
