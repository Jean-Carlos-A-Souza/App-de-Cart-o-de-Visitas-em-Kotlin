package com.apolo.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apolo.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCard : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}