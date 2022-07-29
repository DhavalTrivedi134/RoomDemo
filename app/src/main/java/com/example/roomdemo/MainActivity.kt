package com.example.roomdemo

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.roomdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            EmpDatabase::class.java, "database-name"
        ).build()



        binding?.btnAdd?.setOnClickListener {
            lifecycleScope.launch {
                val name = binding?.edName?.text.toString()
                val email = binding?.edEmail?.text.toString()
                db.employeeDao().insert(EmployeeEntity(0,name =name, email = email))
                Toast.makeText(this@MainActivity, "Data added successfully", Toast.LENGTH_SHORT).show()
            }
        }


    }
}