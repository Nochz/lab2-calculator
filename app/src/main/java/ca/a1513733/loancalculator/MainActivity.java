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
    LoanCalculator loanCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        loanCalc = new LoanCalculator();

    }

    private void getViewValues() {
        etLoanAmt = (EditText) findViewById(R.id.loanAmt);
        etYears = (EditText) findViewById(R.id.years);
        etYears.setFilters(new InputFilter[] {new InputFilter.LengthFilter(3)});
        etRate= (EditText) findViewById(R.id.rate);
        etRate.setFilters(new InputFilter[] {new InputFilter.LengthFilter(4)});
        result = (TextView) findViewById(R.id.res);
    }

    public void calcLoan(View v) {
        getViewValues();
        loanCalc.setLoanAmount(Double.parseDouble(etLoanAmt.getText().toString()));
        loanCalc.setNumberOfYears(Integer.parseInt(etYears.getText().toString()));
        loanCalc.setYearlyInterestRate(Double.parseDouble(etRate.getText().toString()));

    }

    public void displayLoanInfo() {

    }

}
