package com.zandroid.mycalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.zandroid.mycalculator.databinding.ActivityHistoryBinding
import com.zandroid.mycalculator.room.CalcEntity
import com.zandroid.mycalculator.viewModel.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {

    //Binding
    private var _binding: ActivityHistoryBinding?=null
    private val binding get() = _binding!!

    private val viewModel:HistoryViewModel by viewModels()

    @Inject
    lateinit var historyAdapter: HistoryAdapter

    @Inject
    lateinit var entity: CalcEntity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            //get data
            viewModel.loadHistories.observe(this@HistoryActivity){
                it?.let {list->
                    historyAdapter.setData(list)
                }
                recyclerHistory.apply {
                    layoutManager=LinearLayoutManager(this@HistoryActivity)
                    adapter=historyAdapter
                }
            }

            //delete item
            historyAdapter.setOnItemClickListener {
                entity.id=it.id
                entity.expression=it.expression
                entity.result=it.result
                viewModel.deleteExpression(entity)
            }


            //clear All
            btnClear.setOnClickListener { viewModel.clearHistory() }
        }


    }



    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}