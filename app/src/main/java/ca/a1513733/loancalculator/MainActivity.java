package ca.a1513733.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText etLoanAmt, etYears, etRate;
    TextView result;
    double amt, year, rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        etLoanAmt = (EditText) findViewById(R.id.loanAmt);
        etYears = (EditText) findViewById(R.id.years);
        etYears.setFilters(new InputFilter[] {new InputFilter.LengthFilter(3)});
        etRate= (EditText) findViewById(R.id.rate);
        etRate.setFilters(new InputFilter[] {new InputFilter.LengthFilter(4)});
        result = (TextView) findViewById(R.id.res);
    }

    public void calcLoan(View v) {
        amt = Double.parseDouble(etLoanAmt.getText().toString());
        year = Double.parseDouble(etYears.getText().toString());
        rate = Double.parseDouble(etRate.getText().toString());
        result.setText(Double.toString(amt*(1+(year*rate))));
        //a=loan (1+rt)
    }

}
