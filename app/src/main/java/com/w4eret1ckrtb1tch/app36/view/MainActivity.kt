package com.w4eret1ckrtb1tch.app36.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.w4eret1ckrtb1tch.app36.appComponent
import com.w4eret1ckrtb1tch.app36.databinding.ActivityMainBinding
import com.w4eret1ckrtb1tch.app36.featureComponent
import com.w4eret1ckrtb1tch.app36.multibindings.Feature
import com.w4eret1ckrtb1tch.app36.multibindings.FormatExporter
import com.w4eret1ckrtb1tch.app36.multibindings.Two
import com.w4eret1ckrtb1tch.app36.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    // FIXME: 04.10.2021 Вот это не инжектится, почему???
    @Inject
    @Two
    lateinit var feature: Lazy<@JvmSuppressWildcards Feature>

    @Inject
    lateinit var formatSet: Set<@JvmSuppressWildcards FormatExporter>
    @Inject
    lateinit var formatMap: Map<@JvmSuppressWildcards String, @JvmSuppressWildcards FormatExporter>
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        featureComponent.inject(this)
        Log.d("TAG", "set: ${formatSet.size}")
        Log.d("TAG", "map: ${formatMap.entries}")
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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