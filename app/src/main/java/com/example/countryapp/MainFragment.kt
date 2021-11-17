package com.example.countryapp

import android.os.Bundle
import android.util.Log.d
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapp.model.ModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BlankFragment1 : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerAdapter
    lateinit var responseBody: MutableList<ModelItem>
    var retrofitBuilder = RetrofitCreator().getRetrofit()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerInFragment)
        getClient()
    }

    private fun getClient() {
        val retrofitData = retrofitBuilder.getCountryList()
        retrofitData.enqueue(object : Callback<List<ModelItem>?> {
            override fun onResponse(
                call: Call<List<ModelItem>?>,
                response: Response<List<ModelItem>?>
            ) {
                responseBody = (response.body() as MutableList<ModelItem>?)!!
                adapter = RecyclerAdapter(responseBody)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<ModelItem>?>, t: Throwable) {
                d("MainActivity", "onFailure: " + t.message)
            }
        })
    }


}