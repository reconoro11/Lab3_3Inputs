package my.edu.tarc.lab3_3inputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale , radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    private int payment,smokerpayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender=findViewById(R.id.radioGroupGender);
        radioButtonMale=findViewById(R.id.radioButtonMale);
        radioButtonFemale=findViewById(R.id.radioButtonFemale);
        checkBoxSmoker=findViewById(R.id.checkBoxSmoker);
        textViewPremium=findViewById(R.id.textViewPremium);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_dropdown_item);
                spinnerAge.setAdapter(adapter);
                spinnerAge.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Position :" + position, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    public void calculatePremium (View view){
        int position;
        double money = 0;
        double premium=0.0;
        position = spinnerAge.getSelectedItemPosition();

        if(position == 0){
            premium = 50;
        }else if(position==1){
            premium = 55;
        }else if (position ==2){
            premium = 60;
        }else if(position==3){
            premium = 70;
        }else if (position ==4){
            premium = 120;
        }else if (position ==5){
            premium = 160;
        }else if (position ==6){
            premium = 200;
        }else if (position ==7){
            premium = 250;
        }
        int gender;
        gender=radioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale){
            //male
            if (position ==2){
                payment = 50;
            }else if(position==3){
                payment = 100;
            }else if (position ==4){
                payment = 100;
            }else if (position ==5){
                payment = 50;
            }else{
                payment=0;
            }
        }else {
            //female
        }
        if(checkBoxSmoker.isChecked()){
            //smoker calculation extra
            if(position==3){
                smokerpayment = 100;
            }else if (position ==4){
                smokerpayment = 150;
            }else if (position ==5){
                smokerpayment = 150;
            }else if (position ==6){
                smokerpayment = 250;
            }else if (position ==7){
                smokerpayment = 250;
            }
            else{
                smokerpayment=0;
            }
        }

        money = premium+payment+smokerpayment;
        textViewPremium.setText("Price : Rm " + money);
    }
}
