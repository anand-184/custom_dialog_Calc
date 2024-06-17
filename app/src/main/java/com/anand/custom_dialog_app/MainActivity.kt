package com.anand.custom_dialog_app

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var etnumber: EditText? = null
    var calculate: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etnumber = findViewById(R.id.etnumber)
        calculate = findViewById(R.id.calculate)

        calculate?.setOnClickListener {
            if(etnumber?.text.toString().isNullOrEmpty()){
                etnumber?.error = "Enter a Value"
            } else{
                var num1 = etnumber?.text.toString().toInt()
                Dialog(this).apply {
                setContentView(R.layout.layout_dialog)

                show()
                    var dialognum = findViewById<EditText>(R.id.dialognum)
                    var btnadd = findViewById<Button>(R.id.btnadd)
                    var btnsub = findViewById<Button>(R.id.btnsub)
                    var btnsubmit = findViewById<Button>(R.id.btnsubmit)
                    dialognum?.setText(num1.toString())
                    btnadd.setOnClickListener {
                        var result = etnumber?.text.toString().toDouble().plus(num1)
                        etnumber?.setText(result.toString())
                    }
                    btnsub.setOnClickListener {
                        var result = etnumber?.text.toString().toDouble().minus(num1)
                        etnumber?.setText(result.toString())
                    }
                    btnsubmit.setOnClickListener {
                        this.dismiss()
                    }
            }

            }
        }
    }
}