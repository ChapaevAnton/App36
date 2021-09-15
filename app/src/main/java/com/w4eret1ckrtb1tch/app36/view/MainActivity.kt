package com.w4eret1ckrtb1tch.app36.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.w4eret1ckrtb1tch.app36.App
import com.w4eret1ckrtb1tch.app36.databinding.ActivityMainBinding
import com.w4eret1ckrtb1tch.app36.di.DaggerAppComponent
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //private val mainViewModel = App.instance.mainViewModel
    @Inject
    lateinit var mainViewModel: MainViewModel
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerAppComponent.create().inject(this)

        mainViewModel.db().observe(this) { list ->
            val text = list.toString()
            binding.textView.text = text
        }


        binding.buttonGet.setOnClickListener {
            mainViewModel.getDb()
        }

        binding.buttonPut.setOnClickListener {
            val string = binding.editText.text.toString()
            mainViewModel.putToDb(string)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}