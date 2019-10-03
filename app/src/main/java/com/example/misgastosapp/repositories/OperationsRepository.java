package com.example.misgastosapp.repositories;

import com.example.misgastosapp.model.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationsRepository {

    public static List<Operation> operations;

    static{
        operations = new ArrayList<>();
    }

    public static List<Operation> getOperations() {
        return operations;
    }

}
