package cristischeye.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends AppCompatActivity {
    EditText etSubtotal;
    EditText etOtherPercent;
    TextView tvTipAmount;
    double tipPercent = 0;
    double subtotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSubtotal = (EditText) findViewById(R.id.editTextSubtotal);
        etOtherPercent = (EditText) findViewById(R.id.editTextOtherPercent);
        tvTipAmount = (TextView) findViewById(R.id.textViewTipCalculation);

        setupEditTextHandlers();
        setTvTipAmount();
    }

    private void setupEditTextHandlers() {
        etSubtotal.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String subtotalText = v.getText().toString();
                subtotal = Double.parseDouble(subtotalText);

                setTvTipAmount();
                return false;
            }
        });

        etOtherPercent.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String percentText = v.getText().toString();
                tipPercent = Double.parseDouble(percentText) / 100;

                setTvTipAmount();
                return false;
            }
        });
    }


    public void onRadioGroupPercentClick(View v) {
        switch(v.getId()) {
            case R.id.radioPercentChoice10:
                tipPercent = .1;
                break;
            case R.id.radioPercentChoice15:
                tipPercent = .15;
                break;
            case R.id.radioPercentChoice20:
                tipPercent = .2;
                break;
            case R.id.radioPercentChoice25:
                tipPercent = .25;
                break;
        }

        setTvTipAmount();
    }
    
    public void setTvTipAmount() {
        double tipAmount = tipPercent * subtotal;
        String tipAmountText = "$" + String.format("%.2f", tipAmount);
        tvTipAmount.setText(tipAmountText);
    }
}
