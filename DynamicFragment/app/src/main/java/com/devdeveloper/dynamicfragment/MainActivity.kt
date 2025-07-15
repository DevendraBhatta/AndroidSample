package com.devdeveloper.dynamicfragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val fragmentInstance: BlankFragment = BlankFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val addButton: Button = findViewById<Button>(R.id.add_frag_btn)
        val removeButton: Button = findViewById<Button>(R.id.rem_frag_btn)

        addButton.setOnClickListener { View ->
            addClicked()
        }

        removeButton.setOnClickListener { View ->
            removeClicked()
        }
    }

    fun addClicked() {
        if (!fragmentInstance.isAdded) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_layout, fragmentInstance, "Dynamic Fragment").commit()
        }

    }

    fun removeClicked() {
        supportFragmentManager.beginTransaction().remove(fragmentInstance).commit()
    }
}