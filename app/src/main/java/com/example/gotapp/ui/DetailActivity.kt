package com.example.gotapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.gotapp.R
import com.example.gotapp.databinding.ActivityDetailBinding
import com.example.gotapp.domain.model.House
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailActivity : AppCompatActivity() {

    private val detailViewModel: DetailActivityViewModel by viewModel {
        parametersOf(intent.getParcelableExtra<House>(EXTRA_HOUSE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
            .apply {
                lifecycleOwner = this@DetailActivity
                viewModel = detailViewModel
            }

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        observeValues()
    }

    private fun observeValues() {
        detailViewModel.activityTitle.observe(this, Observer {
            title = it
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_HOUSE = "extraHouse"
    }
}
