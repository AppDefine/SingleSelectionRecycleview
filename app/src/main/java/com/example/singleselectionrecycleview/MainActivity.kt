package com.example.singleselectionrecycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.singleselectionrecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var list = ArrayList<TextDataClass>()

    val textAdapter by lazy {
        TextAdapter(list)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycleView()
        addData()

        textAdapter.callBack = {
            textAdapter.Single(it)
        }
    }

    private fun setRecycleView() = with(binding) {
        recycleView.adapter = textAdapter
        recycleView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
    }

    private fun addData() {
        list.clear()
        list.add(TextDataClass("Test 1"))
        list.add(TextDataClass("Test 2"))
        list.add(TextDataClass("Test 3"))
        list.add(TextDataClass("Test 4"))
        list.add(TextDataClass("Test 5"))
        list.add(TextDataClass("Test 6"))
        list.add(TextDataClass("Test 7"))
        list.add(TextDataClass("Test 8"))
        list.add(TextDataClass("Test 9"))
        list.add(TextDataClass("Test 10"))
        textAdapter.notifyDataSetChanged()
    }

}