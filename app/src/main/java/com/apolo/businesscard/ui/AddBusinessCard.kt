package com.apolo.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.apolo.businesscard.App
import com.apolo.businesscard.R
import com.apolo.businesscard.data.BusinessCard
import com.apolo.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCard : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repositoy)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListeners()

    }

    private fun insertListeners(){
        binding.btnClose.setOnClickListener{
            finish()
        }

        binding.btnConfirm.setOnClickListener{
            val businessCard =  BusinessCard (
                nome = binding.tilName.editText?.text.toString(),
                empresa = binding.tilNomeEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}