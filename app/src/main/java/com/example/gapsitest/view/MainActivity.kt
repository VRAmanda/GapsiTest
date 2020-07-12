package com.example.gapsitest.view

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gapsitest.R
import com.example.gapsitest.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var productViewModel: ProductViewModel
    private var productAdp: ProductAdapter = ProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            // ViewModel
            productViewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)
            pgrBar.visibility = View.INVISIBLE

            searchText.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(newText: String?): Boolean {
                    if(!newText.isNullOrEmpty())
                        showList(newText.toString())
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    return false
                }
            })
        }
        catch (ex:Exception){

                Toast.makeText(applicationContext,ex.message, Toast.LENGTH_LONG).show()
            }
        }

    fun showList(search: String)
    {
        pgrBar.visibility = View.GONE
        pgrBar.visibility = View.VISIBLE

        productViewModel.resultListProduct(search).observe(this, Observer {
            productAdp = ProductAdapter()
            productsList.setLayoutManager(LinearLayoutManager(this, RecyclerView.VERTICAL, false))
            productsList.setItemAnimator(DefaultItemAnimator())
            productsList.setNestedScrollingEnabled(true)
            productsList.adapter = productAdp
            productAdp.setProduct(it)
            pgrBar.visibility = View.INVISIBLE
        })
    }
}