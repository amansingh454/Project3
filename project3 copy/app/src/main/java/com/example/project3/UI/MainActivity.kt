package com.example.project3.UI

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project3.FoodPacket
import com.example.project3.R

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    var items = arrayOf<String?>("item1", "item2", "item3", "item4")

    private lateinit var newRecyclerView: RecyclerView
    lateinit var imageId:ArrayList<Int>
    lateinit var companyName:ArrayList<String>
    lateinit var productName:ArrayList<String>
    lateinit var size:ArrayList<String>
    lateinit var star:ArrayList<Int>
    lateinit var retailPrice:ArrayList<Int>
    lateinit var weight:ArrayList<Int>
    lateinit var ratings:ArrayList<Int>
    lateinit var description:ArrayList<String>
    lateinit var markedPrice:ArrayList<Int>
    lateinit var discountPercent:ArrayList<Int>
    private lateinit var newList: ArrayList<FoodPacket>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.spinner)

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
                this,
                android.R.layout.simple_spinner_item,
                items)
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=ad
        spinner.onItemSelectedListener =this

        /// data preparation

        var imageId= arrayOf(R.drawable.food_packet, R.drawable.food_packet1, R.drawable.food_packet2,
                R.drawable.food_packet3, R.drawable.food_packet4)
        val companyName= arrayOf('A','B','C','D','E')
        val productName= arrayOf("sabudana","sweets","lemon","orange","grapes")
        val size= arrayOf("Medium","Medium","Large","Large","Small")
        val star= arrayOf(3,4,5,6,2)
        val retailPrice= arrayOf(2000,345,123,45,123)
        val weight= arrayOf(2,3,5,6,7)
        val ratings= arrayOf(123,234,567,124,654)
        val markedPrice= arrayOf(123,432,455,789,124)
        val discountPercent= arrayOf(33,12,45,34,65)
        val description= arrayOf("nice","nice","nice","nice","nice")

        val newRecyclerView=findViewById<RecyclerView>(R.id.recview)

        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        var newList = arrayListOf<FoodPacket>()
        GetData()


    }
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            Toast.makeText(this, items[position], Toast.LENGTH_LONG).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    private fun GetData(){
        for (i in imageId.indices){
            val item= FoodPacket(companyName[i],productName[i],size[i],star[i],retailPrice[i],
                    weight[i], ratings[i],markedPrice[i],discountPercent[i],imageId[i],description[i])
            newList.add(item)

        }
        newRecyclerView.adapter= Adapter(newList)
    }






}

