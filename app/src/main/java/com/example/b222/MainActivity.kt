package com.example.b222

import android.content.ContentValues
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.b222.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var helper = MyDbHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS", null)
//con trỏ nhảy đến dòng đầu tiên
        if (rs.moveToLast()){
            Toast.makeText(applicationContext, rs.getString(2), Toast.LENGTH_LONG).show()
        }
        binding.btnAdd.setOnClickListener {
            var cv = ContentValues()

            cv.put("UNAME", binding.edtUserName.text.toString())
            cv.put("PWD", binding.edtPassWord.text.toString())

            db.insert("USERS", null, cv)
            Toast.makeText(applicationContext, "Data Inserted", Toast.LENGTH_LONG).show()
            //reset data
            binding.edtUserName.setText("")
            binding.edtPassWord.setText("")
            binding.edtUserName.requestFocus()
        }
    }
}