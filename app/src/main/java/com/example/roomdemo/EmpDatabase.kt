package com.example.roomdemo

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [EmployeeEntity::class], version = 1)
abstract class EmpDatabase: RoomDatabase() {
    abstract fun employeeDao():EmployeeDao
}