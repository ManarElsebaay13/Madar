package com.manarelsebaay.madarsofttask.presentation.fragments.saved_data_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.manarelsebaay.madarsofttask.R
import com.manarelsebaay.madarsofttask.databinding.SavedDataFragmentBinding
import com.manarelsebaay.madarsofttask.presentation.adapter.SavedDataAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedDataFragment : Fragment(R.layout.saved_data_fragment){
    val TAG = "SavedDataFragment"
    lateinit var binding: SavedDataFragmentBinding
    private val viewModel : SavedDataViewModel  by viewModels()
    val savedDataAdapter by lazy { SavedDataAdapter(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SavedDataFragmentBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initData() }

       fun initData() {
           viewModel.onLoading()
           viewModel.SavedDataListState().observe(viewLifecycleOwner, { InfoListState ->
             savedDataAdapter.clear()
             savedDataAdapter.add(InfoListState) }) }

    private fun initViews() {
        val marsPhotosManager: LinearLayoutManager? = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        binding.SavedataRv.layoutManager=marsPhotosManager
        binding.SavedataRv.addItemDecoration(DividerItemDecoration(context, marsPhotosManager?.getOrientation() ?: 0))
        binding.SavedataRv.adapter=savedDataAdapter }

    }









