package com.example.datetimechecker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton(
                "Yes"
            ) { dialog, id -> super.onBackPressed() }
            .setNegativeButton("No", null)
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clearButton.setOnClickListener {
            dayEditText.text.clear();
            monthEditText.text.clear();
            yearEditText.text.clear();
        }
        checkButton.setOnClickListener {
            var day: Int = 0;
            var month: Int = 0;
            var year: Int = 0;
            try {
                day = dayEditText.text.toString().toIntOrNull()!!;

            } catch (err: Exception) {
                showDialog("Input data for day is incorrect format");
                return@setOnClickListener;
            }
            try {
                month = monthEditText.text.toString().toIntOrNull()!!;
            } catch (err: Exception) {
                showDialog("Input data for month is incorrect format");
                return@setOnClickListener;

            }
            try {
                year = yearEditText.text.toString().toIntOrNull()!!;
            } catch (err: Exception) {
                showDialog("Input data for year is incorrect format");
                return@setOnClickListener;

            }
            if (day <= 0 || day > 31) {
                showDialog("Input data for day is out of range");
                return@setOnClickListener;

            }
            if (month <= 0 || month > 12) {
                showDialog("Input data for month is out of range");
                return@setOnClickListener;

            }
            if (year < 1000 || year > 3000) {
                showDialog("Input data for year is out of range");
                return@setOnClickListener;
            }

            if (isValidDate(year, month, day)) {
                showDialog("$day/$month/$year is correct date time!", isError = false);
                return@setOnClickListener;
            } else {
                showDialog("$day/$month/$year is NOT correct date time!");
                return@setOnClickListener;
            }
        }
        nextScreenButton.setOnClickListener {
            val intent= Intent(this,MovieActivity::class.java);
            startActivity(intent);
        }
    }


    fun showDialog(message: String, isError: Boolean = true) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(if (isError) "Error" else "Message")
        builder.setMessage(message)
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton("OK") { dialog, which ->

        }



        builder.show()
    }

    fun daysInMonth(year: Int, month: Int): Int {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30
        } else if (month == 2) {
            return if (year % 400 == 0 || year % 4 == 0) {
                29
            } else if (year % 100 == 0) {
                28
            } else {
                28
            }
        }
        return 0
    }

    fun isValidDate(year: Int, month: Int, day: Int): Boolean {
        return if (month in 1..12) {
            if (day >= 1) {
                day <= daysInMonth(year, month)
            } else {
                false
            }
        } else {
            false
        }
    }
}