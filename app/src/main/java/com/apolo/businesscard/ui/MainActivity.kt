package com.apolo.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.apolo.businesscard.App
import com.apolo.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
   private val mainViewModel: MainViewModel by viewModels {
       MainViewModelFactory((application as App).repositoy)
   }

    private val adapter by lazy { BusinessCardAdapter() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListener()
    }

    private fun insertListener(){
        binding.fab.setOnClickListener{
            val intent = Intent(this@MainActivity, AddBusinessCard::class.java)
            startActivity(intent)
        }
    }
    private fun getAllBusinessCard(){
        mainViewModel.getAll().observe(this,{businessCards ->
            adapter.submitList(businessCards)
        })
    }


}