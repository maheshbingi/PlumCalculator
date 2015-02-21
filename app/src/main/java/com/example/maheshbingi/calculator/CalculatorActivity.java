package com.example.maheshbingi.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class CalculatorActivity extends ActionBarActivity implements View.OnClickListener {

    private Button button0,button1,button2,button3,button4,button5,button6;
    private Button button7,button8,button9,buttonClear,buttonPlus,buttonMinus,buttonEqual;
    private TextView textValues;
    private boolean isOperator = true;
    String previousNumber = "0", currentNumber ="", operator="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initializeLayouts();
        registerListeners();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putString("previousNumber", previousNumber);
        savedInstanceState.putString("currentNumber", currentNumber);
        savedInstanceState.putString("operator", operator);
        savedInstanceState.putBoolean("isOperator", isOperator);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        previousNumber = savedInstanceState.getString("previousNumber");
        currentNumber = savedInstanceState.getString("currentNumber");
        operator = savedInstanceState.getString("operator");
        isOperator = savedInstanceState.getBoolean("isOperator");

        Log.d("key1",previousNumber +" "+ currentNumber + " "+ operator);

        if(currentNumber.isEmpty() && previousNumber.isEmpty())
            textValues.setText("0");
        else if(currentNumber.isEmpty())
            textValues.setText(previousNumber);
        else
            textValues.setText(currentNumber);

    }

    // Initialise all layouts
    private void initializeLayouts() {
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        buttonPlus = (Button)findViewById(R.id.button_plus);
        buttonMinus = (Button)findViewById(R.id.button_minus);
        buttonEqual = (Button)findViewById(R.id.button_equal);
        buttonClear = (Button)findViewById(R.id.button_clear);

        textValues = (TextView)findViewById(R.id.text_values);
    }

    // Register Listeners on buttons
    private void registerListeners() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id)
        {
            case R.id.button0:

                // Handling preceding ZEROs condition
                if(!textValues.getText().toString().equals("0") && !currentNumber.isEmpty())
                    handleInputNumber(button0);
                break;

            case R.id.button1:

                handleInputNumber(button1);
                break;

            case R.id.button2:

                handleInputNumber(button2);
                break;

            case R.id.button3:

                handleInputNumber(button3);
                break;

            case R.id.button4:

                handleInputNumber(button4);
                break;

            case R.id.button5:

                handleInputNumber(button5);
                break;

            case R.id.button6:

                handleInputNumber(button6);
                break;

            case R.id.button7:

                handleInputNumber(button7);
                break;

            case R.id.button8:

                handleInputNumber(button8);
                break;

            case R.id.button9:

                handleInputNumber(button9);
                break;

            case R.id.button_plus:

                // If OPERATOR Flag is not SET -> Handling multiple operators input
                if(!getOperator()){

                    // Handling initial condition of Calculator initialization
                    if(previousNumber.isEmpty() || previousNumber.equals("0")){

                        if(operator.equals("-"))
                            previousNumber = operator + currentNumber;
                        else
                            previousNumber = currentNumber;
                    }
                    else{
                        // Based on operator perform operation and store result in "previousNumber"
                        switch(this.operator)
                        {
                            case "+":
                                previousNumber = String.valueOf( Integer.parseInt(previousNumber) + Integer.parseInt(currentNumber) );
                                break;

                            case "-":
                                previousNumber = String.valueOf( Integer.parseInt(previousNumber) - Integer.parseInt(currentNumber) );
                                break;
                        }
                    }

                    currentNumber = "";
                }

                this.operator = "+";
                setOperator(true);
                textValues.setText(previousNumber);
                break;

            case R.id.button_minus:

                // Handling initial condition of Calculator initialization
                if(!getOperator()){
                    if(previousNumber.isEmpty() || previousNumber.equals("0")){

                        if(operator.equals("-"))
                            previousNumber = operator + currentNumber;
                        else
                            previousNumber = currentNumber;
                    }
                    else{
                        // Based on operator perform operation and store result in "previousNumber"
                        switch(this.operator)
                        {
                            case "+":
                                previousNumber = String.valueOf( Integer.parseInt(previousNumber) + Integer.parseInt(currentNumber) );
                                break;

                            case "-":
                                previousNumber = String.valueOf( Integer.parseInt(previousNumber) - Integer.parseInt(currentNumber) );
                                break;
                        }
                    }

                    currentNumber = "";
                }

                this.operator = "-";
                setOperator(true);
                textValues.setText(previousNumber);
                break;

            case R.id.button_equal:

                // Handling initial condition of Calculator initialization
                if(!getOperator()){
                    if(previousNumber.isEmpty() || previousNumber.equals("0")){

                        if(operator.equals("-"))
                            previousNumber = operator + currentNumber;
                        else
                            previousNumber = currentNumber;
                    }
                    else {
                        // Based on operator perform operation and store result in "previousNumber"
                        switch(this.operator)
                        {
                            case "+":
                                previousNumber = String.valueOf( Integer.parseInt(previousNumber) + Integer.parseInt(currentNumber) );
                                break;

                            case "-":
                                previousNumber = String.valueOf( Integer.parseInt(previousNumber) - Integer.parseInt(currentNumber) );
                                break;
                        }
                    }
                    currentNumber = "";
                }

                setOperator(true);
                textValues.setText(previousNumber);
                break;

            case R.id.button_clear:

                handleInputClear();
                break;
        }
    }

    // functionality for clearAll button
    private void handleInputClear() {

        currentNumber = "";
        previousNumber = "0";
        operator = "";
        setOperator(true);
        textValues.setText("0");
    }

    // functionality for input number
    private void handleInputNumber(Button b) {

        // Handling MAX 7 digit condition
        if (currentNumber.length() < 7) {

            // Operator is SET handle APPEND number for more than 1 digit length
            if (getOperator()) {
                currentNumber = b.getText().toString();
            } else {
                currentNumber += b.getText().toString();
            }

            setOperator(false);
            textValues.setText(currentNumber);
        }
        else
            Toast.makeText(CalculatorActivity.this,"Max Number length is 7", Toast.LENGTH_SHORT).show();
    }

    // Boolean "isOperator" attribute for checking Operator is SET
    public void setOperator(boolean val){
        this.isOperator = val;
    }

    public boolean getOperator(){
        return this.isOperator;
    }
}
