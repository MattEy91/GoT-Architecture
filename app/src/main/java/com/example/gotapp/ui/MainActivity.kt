package com.example.gotapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gotapp.R
import com.example.gotapp.databinding.ActivityMainBinding
import com.example.gotapp.domain.model.House
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainActivityViewModel by viewModel()

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            viewModel = mainViewModel
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val houseAdapter = HousesAdapter()
        binding.adapter = houseAdapter

        mainViewModel.allHouses.observe(this, Observer {
            houseAdapter.submitList(it.toMutableList())
            houseAdapter.notifyDataSetChanged()
        })
    }
}
