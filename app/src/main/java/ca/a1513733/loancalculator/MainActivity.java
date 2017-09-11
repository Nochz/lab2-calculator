package ca.a1513733.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText etLoanAmt, etYears, etRate;
    TextView amt,years, yrInterest;
    TextView tlInterest, payment;
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
        result = (TextView) findViewById(R.id.costText);

        amt = (TextView) findViewById(R.id.amtText);
        years = (TextView) findViewById(R.id.yearsText);
        yrInterest = (TextView) findViewById(R.id.yrInterestText);
        tlInterest = (TextView) findViewById(R.id.tlInterestText);
        payment = (TextView) findViewById(R.id.paymentText);
    }

    public void calcLoan(View v) {
        getViewValues();
        loanCalc.setLoanAmount(Double.parseDouble(etLoanAmt.getText().toString()));
        loanCalc.setNumberOfYears(Integer.parseInt(etYears.getText().toString()));
        loanCalc.setYearlyInterestRate(Double.parseDouble(etRate.getText().toString()));

        displayLoanInfo(v);
    }

    public void displayLoanInfo(View v) {
        result.setText(loanCalc.getTotalCostOfLoan()+"");
        amt.setText(loanCalc.getLoanAmount()+"");
        years.setText(loanCalc.getNumberOfYears()+"");
        yrInterest.setText(loanCalc.getYearlyInterestRate()+"");
        tlInterest.setText(loanCalc.getTotalInterest()+"");
        payment.setText(loanCalc.getMonthlyPayment()+"");

    }

}
