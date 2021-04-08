package com.unique.pak.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unique.pak.R
import kotlin.random.Random

class AdapterField(private val contTextView: TextView): RecyclerView.Adapter<AdapterField.ItemButton>() {

    private var array = mutableListOf<Int>()
    private var currentCoin: Int = 0
    private var coinCount = 0

    init {
        randomMatrix()
    }

    fun updateField(){
        randomMatrix()
        notifyDataSetChanged()
    }

    private fun randomMatrix(){
        if(array.isNotEmpty()){
            array.clear()
        }

        val randomNumber = Random.nextInt(10,100)
        currentCoin = Random.nextInt(0,36)
        for (i in 0 until 36){
            if (i == currentCoin){
                array.add(Random.nextInt(10,100))
            }else{
                array.add(randomNumber)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemButton {
        return ItemButton(LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false))
    }

    override fun getItemCount(): Int = 36

    override fun onBindViewHolder(holder: ItemButton, position: Int) {
        holder.coin.text = array[position].toString()

        holder.coin.setOnClickListener {
           if (currentCoin == position){
               Log.e("Coin","Current")
               updateField()
               coinCount += 5
               contTextView.text = coinCount.toString()
           } else {
               Log.e("Coin","Not current")
           }
        }
    }

    class ItemButton(itemView: View): RecyclerView.ViewHolder(itemView){
        val coin = itemView.findViewById<Button>(R.id.coin)
    }
}