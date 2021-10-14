package com.apolo.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apolo.businesscard.R
import com.apolo.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener(){
        binding.fab.setOnClickListener{
            val intent = Intent(this@MainActivity, AddBusinessCard::class.java)
            startActivity(intent)
        }
    }

}