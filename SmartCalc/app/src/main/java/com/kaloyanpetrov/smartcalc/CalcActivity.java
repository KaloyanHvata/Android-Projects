package com.kaloyanpetrov.smartcalc;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class CalcActivity extends Activity{

    public enum Operation {
        ADD,
        SUBSTRACT,
        DIVIDE,
        MULTIIPLY,
        EQUALS
    }

    String runningNumber = "";
    TextView resultsView;
    String leftValueString = "";
    String rightValueString = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button)findViewById(R.id.oneBtn);
        Button twoBtn = (Button)findViewById(R.id.twoBtn);
        Button threeBtn = (Button)findViewById(R.id.treeBtn);
        Button fourBtn = (Button)findViewById(R.id.fourBtn);
        Button fiveBtn = (Button)findViewById(R.id.fiveBtn);
        Button sixBtn = (Button)findViewById(R.id.sixBtn);
        Button sevenBtn = (Button)findViewById(R.id.sevenBtn);
        Button eightBtn = (Button)findViewById(R.id.eightBtn);
        Button nineBtn = (Button)findViewById(R.id.nineBtn);
        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);

        ImageButton calcBtn = (ImageButton)findViewById(R.id.calcBtn);
        ImageButton divideBtn = (ImageButton)findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = (ImageButton)findViewById(R.id.multiplyBtn);
        ImageButton substractBtn = (ImageButton)findViewById(R.id.substractBtn);
        ImageButton addBtn = (ImageButton)findViewById(R.id.addBtn);

        Button clearBtn = (Button)findViewById(R.id.clearBtn);

        resultsView = (TextView)findViewById(R.id.resultsText);

        resultsView.setText("0");

        oneBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(1);
            }

        });
        twoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(2);
            }

        });
        threeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(3);
            }

        });
        fourBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(4);
            }

        });
        fiveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(5);
            }

        });
        sixBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(6);
            }

        });
        sevenBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(7);
            }

        });
        eightBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(8);
            }

        });
        nineBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(9);
            }

        });
        zeroBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(0);
            }

        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.ADD);
            }

        });
        substractBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.SUBSTRACT);
            }

        });
        multiplyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.MULTIIPLY);
            }

        });
        divideBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.DIVIDE);
            }

        });
        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                resultsView.setText("0");
                rightValueString = "";
                leftValueString = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;

            }

        });
        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.EQUALS);
            }

        });


    }

    void processOperation(Operation operation){

            if (currentOperation != null) {

                if (runningNumber != "") {
                    rightValueString = runningNumber;
                    runningNumber = "";

                    switch (currentOperation) {
                        case ADD:
                            result = Integer.parseInt(leftValueString) + Integer.parseInt(rightValueString);
                            break;
                        case SUBSTRACT:
                            result = Integer.parseInt(leftValueString) - Integer.parseInt(rightValueString);
                            break;
                        case MULTIIPLY:
                            result = Integer.parseInt(leftValueString) * Integer.parseInt(rightValueString);
                            break;
                        case DIVIDE:
                            result = Integer.parseInt(leftValueString) / Integer.parseInt(rightValueString);
                            break;
                    }

                    leftValueString = String.valueOf(result);
                    resultsView.setText(leftValueString);
                }

            }else {
                leftValueString = runningNumber;
                runningNumber = "";

            }
        currentOperation = operation;
    }

    void numberPressed(int number) {

        runningNumber += String.valueOf(number);
        resultsView.setText(runningNumber);

    }
}
