package com.w4eret1ckrtb1tch.app36.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.w4eret1ckrtb1tch.app36.appComponent
import com.w4eret1ckrtb1tch.app36.databinding.ActivityMainBinding
import com.w4eret1ckrtb1tch.app36.featureComponent
import com.w4eret1ckrtb1tch.app36.multibindings.Feature
import com.w4eret1ckrtb1tch.app36.multibindings.Two
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import dagger.Lazy
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    @Two
    lateinit var feature: Lazy<Feature>
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        featureComponent.inject(this)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("TAG", "set: ${appComponent.getFormatExporterSet().size}")
        Log.d("TAG", "map: ${appComponent.getFormatExporterMap().entries}")
        Log.d("TAG", "lazy: ${feature.get().getString()}")

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