package com.manarelsebaay.madarsofttask.presentation.fragments.data_entry_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.manarelsebaay.madarsofttask.R
import com.manarelsebaay.madarsofttask.core.utils.Extensions.toast
import com.manarelsebaay.madarsofttask.core.utils.Validation.Companion.isEditTextEmpty
import com.manarelsebaay.madarsofttask.databinding.DataEntryFragmentBinding
import com.manarelsebaay.madarsofttask.domain.model.DataEntryInfo


import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DataEntryFragment :Fragment(R.layout.data_entry_fragment),OnClickListener{
    val TAG = "DaataEntry Fragment"
    lateinit var binding: DataEntryFragmentBinding
    private val viewModel : DataEntryViewModel  by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataEntryFragmentBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews() }

    private fun initViews() { binding.Save.setOnClickListener(this) }

    override fun onClick(view: View?) {
        //validation
        if(isEditTextEmpty(binding.nameTxt)){ toast("Please Enter your Name")}
       else if(isEditTextEmpty(binding.jobTitleTxt)){ toast("Please Enter your Job Title")}
       else if(isEditTextEmpty(binding.genderTxt)){ toast("Please Enter your Gender")}
       else if(isEditTextEmpty(binding.ageTxt)){ toast("Please Enter your  Age")
       }else { viewModel.Saving(
                toDataInfo(
                    binding.nameTxt.text.toString(), binding.jobTitleTxt.text.toString(),
                    binding.genderTxt.text.toString(), binding.ageTxt.text.toString()))
                      toast("Data Saved Successfully")}
    }

    fun toDataInfo(name:String,job:String,gender:String,age:String):DataEntryInfo=
        DataEntryInfo(
            name = name,
            job = job,
            gender = gender,
            age = age )


}