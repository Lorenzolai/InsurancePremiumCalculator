package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Calculate.setOnClickListener {
            val premium = getPeremium()
            editText.text = "%.2f".format(premium)
        }

        btn_reset.setOnClickListener {
            spinner.setSelection(0)
            radioGroup.clearCheck()
            chkbox.toggle()
            editText.text = ""
        }
    }

  fun getPeremium() : Double{

      return when(spinner.selectedItemPosition) {
          0 -> 60.00
          1 -> 70.00 +
                  (if(radMale.isChecked) 50.00 else 0.00) +
                  (if(chkbox.isChecked) 100.00 else 0.00)
          2 -> 90.00 +
                  (if(radMale.isChecked) 100.00 else 0.00) +
                  (if(chkbox.isChecked) 150.00 else 0.00)
          3 -> 120.00 +
                  (if(radMale.isChecked) 150.00 else 0.00) +
                  (if(chkbox.isChecked) 200.00 else 0.00)
          4 -> 150.00 +
                  (if(radMale.isChecked) 200.00 else 0.00) +
                  (if(chkbox.isChecked) 250.00 else 0.00)
          else -> 150.00 +
                  (if(radMale.isChecked) 200.00 else 0.00) +
                  (if(chkbox.isChecked) 300.00 else 0.00)
      }
  }
}
