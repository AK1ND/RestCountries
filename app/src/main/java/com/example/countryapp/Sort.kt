package com.example.countryapp

import com.example.countryapp.model.ModelItem

private var flag: Boolean = true

class Sort {


    fun sortButton(responseBody: MutableList<ModelItem>, adapter: RecyclerAdapter) {
        flag = if (flag) {
            sortUp(responseBody, adapter)
            false
        } else {
            sortDown(responseBody, adapter)
            true
        }
    }

    private fun sortUp(responseBody: MutableList<ModelItem>, adapter: RecyclerAdapter) {
        responseBody.sortBy { it.population }
        adapter.notifyDataSetChanged()
    }


    private fun sortDown(responseBody: MutableList<ModelItem>, adapter: RecyclerAdapter) {
        responseBody.sortByDescending { it.population }
        adapter.notifyDataSetChanged()
    }
//why doesn't work sortedByDescending???

}