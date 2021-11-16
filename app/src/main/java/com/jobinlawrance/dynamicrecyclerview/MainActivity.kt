package com.jobinlawrance.dynamicrecyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jobinlawrance.dynamicrecyclerview.data.api.apiService
import com.jobinlawrance.dynamicrecyclerview.databinding.ActivityMainBinding
import com.jobinlawrance.dynamicrecyclerview.ui.DynamicListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DynamicListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DynamicListAdapter()

        binding.rvDynamic.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvDynamic.adapter = adapter

        apiService.getDynamicList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.data.toBaseUIList() }
            .subscribe({
                Log.w("###Dynamic", it.toString())
                adapter.setUIList(it)
            }, {
                Log.e("###Dynamic", "Error", it)
            })
    }
}