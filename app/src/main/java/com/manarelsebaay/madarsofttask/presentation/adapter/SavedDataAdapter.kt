package com.manarelsebaay.madarsofttask.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manarelsebaay.madarsofttask.R
import com.manarelsebaay.madarsofttask.domain.model.DataEntryInfo

class SavedDataAdapter(
 private val layoutInflater: LayoutInflater
): RecyclerView.Adapter<SavedDataViewHolder>() {
    private var SavedDataList = mutableListOf<DataEntryInfo>()
    lateinit var context: Context

    override fun getItemCount(): Int =SavedDataList.size
    override fun onBindViewHolder(holder: SavedDataViewHolder, position: Int) = holder.bind(SavedDataList[position])
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedDataViewHolder = SavedDataViewHolder(layoutInflater,parent)

    fun clear() {
        this.SavedDataList.clear()
        notifyDataSetChanged() }

    fun add(DataList: List<DataEntryInfo>) {
        this.SavedDataList.addAll(DataList)
        notifyDataSetChanged() }

}

class SavedDataViewHolder (
    layoutInflater: LayoutInflater,
    parent: ViewGroup
        ):RecyclerView.ViewHolder(layoutInflater.inflate(R.layout.saved_data_item,parent,false)) {

    private val nameTextView: TextView = itemView.findViewById(R.id.name_txt)
    private val jobTextView: TextView = itemView.findViewById(R.id.job_title_txt)
    private val genderTextView: TextView = itemView.findViewById(R.id.gender_txt)
    private val ageTextView: TextView = itemView.findViewById(R.id.age_txt)

    fun bind(dataEntryInfo: DataEntryInfo) {
        nameTextView.text="Name : " + "  ${dataEntryInfo.name}"
        jobTextView.text="JobTitle : " + "  ${dataEntryInfo.job}"
        genderTextView.text="Gender : " + "  ${dataEntryInfo.gender}"
        ageTextView.text="Age : " + "  ${dataEntryInfo.age}"
    }

}


