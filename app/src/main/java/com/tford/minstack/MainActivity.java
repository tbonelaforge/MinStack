package com.tford.minstack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextWatcher textWatcher;
    private EditText valueBox;
    private MinStack minStack;
    private StackAdapter stackAdapter;
    private TextView minimumTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //minStack =
        minStack = new MinStack();
        stackAdapter = new StackAdapter(this, minStack.valuesToArray());
        ListView stackListView = (ListView) findViewById(R.id.stack_data_list);
        stackListView.setAdapter(stackAdapter);
        final Button pushButton = (Button) findViewById(R.id.push_button);
        pushButton.setEnabled(false);

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (pushButton != null) {
                    pushButton.setEnabled(true);
                }
            }
        };
        valueBox = (EditText) findViewById(R.id.value_box);
        valueBox.addTextChangedListener(textWatcher);
        minimumTextView = (TextView) findViewById(R.id.minimum_text_view);
    }

    public void pushValue(View view) {
        String valueString = valueBox.getText().toString();
        Integer value;
        try {
            value = Integer.parseInt(valueString);
            minStack.push(value);
            stackAdapter.setIntegers(minStack.valuesToArray());
            minimumTextView.setText(String.valueOf(minStack.getMin()));
        } catch (NumberFormatException e) {
            System.out.println("Inside MainActivity.pushValue, caught a number format exception...");
        }

    }

    public void popValue(View view) {
        Integer popped = minStack.pop();
        Integer newMin = minStack.getMin();
        stackAdapter.setIntegers(minStack.valuesToArray());
        if (newMin != null) {
            minimumTextView.setText(String.valueOf(newMin));
        } else {
            minimumTextView.setText("");
        }
    }
}
