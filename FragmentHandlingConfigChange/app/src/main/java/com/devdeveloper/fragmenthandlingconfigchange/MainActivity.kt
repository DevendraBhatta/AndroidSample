package com.devdeveloper.fragmenthandlingconfigchange

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    val firstFragment: Fragment = FirstFragment()
    val secondFragment: Fragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val addButton: Button = findViewById(R.id.add_btn)
        val replaceButton: Button = findViewById(R.id.replace_btn)

//        if (savedInstanceState == null) {
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.fragment_container,firstFragment)
//                .commit()
//        }


        addButton.setOnClickListener {
            addFragment()

        }

        replaceButton.setOnClickListener {
            replaceFragment()
        }
    }


    fun addFragment(){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container,firstFragment)
            .commit()
    }

    fun replaceFragment(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,secondFragment)
            .commit()
    }


}