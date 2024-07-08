package com.example.b222

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
//

/*
* factory SQLiteDataBase.CursorFactory?: để sử dụng tạo các đối tượng con trỏ,hoặc null cho mặc định
version Int : số của cơ sở dữ liệu( bắt đầu từ 1)
nếu cơ sở dữ liệu cũ hơn, onUpgrade sẽ được sử dụng để nâng cấp cơ sở dữ liệu
nếu cơ sở dữ liệu mới hơn, onDowngrade sẽ được sử dụng để hạ cấp cơ sở dữ liệu
* */
class MyDbHelper(context: Context): SQLiteOpenHelper(context,"USERSDB",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        //create table
        p0?.execSQL("CREATE TABLE USERS (ID INTEGER PRIMARY KEY AUTOINCREMENT,  UNAME TEXT, PWD TEXT)")
        //ADD DATA
        p0?.execSQL("INSERT INTO USERS (UNAME,PWD) VALUES ('admin','1234')")
        p0?.execSQL("INSERT INTO USERS (UNAME,PWD) VALUES ('admin1','1234')")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}