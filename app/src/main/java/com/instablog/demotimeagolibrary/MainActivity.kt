package com.instablog.demotimeagolibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.timeagolibrary.Timeagolibrary

class MainActivity : AppCompatActivity() {
    public  var str_agodate : String ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        str_agodate =  Timeagolibrary.CalculateDatefromcurrentdate("08/07/2020")
        Log.e("check_ago_date" , "++++++++++++++++++++++++++++++++  $str_agodate");
    }
}