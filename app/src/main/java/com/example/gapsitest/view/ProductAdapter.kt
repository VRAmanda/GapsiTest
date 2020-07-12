package com.example.gapsitest.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gapsitest.R
import com.example.gapsitest.model.ProductModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item_layout.view.*

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val products: MutableList<ProductModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_item_layout, parent, false))

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindModel(products[position])
    }

    fun setProduct(list: List<ProductModel>) {
        products.addAll(list)
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productNameTxt : TextView = itemView.productName
        val productPriceTxt : TextView = itemView.productPrice
        val productPositionTxt : TextView = itemView.productPosition
        val productImageView : ImageView = itemView.productImage
        lateinit var productUrl: String

        fun bindModel(prd: ProductModel) {
            productNameTxt.text = prd.productDisplayName
            productPriceTxt.text = prd.listPrice
            productPositionTxt.text = prd.skuRepositoryId
            productUrl = prd.smImage.toString()
            Picasso.get().load(productUrl).into(productImageView)
        }
    }
}