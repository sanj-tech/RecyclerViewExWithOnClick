package com.example.recyclerviewonclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),PersonAdapter.OnItemClick {
    lateinit var adapter:PersonAdapter
    var list= mutableListOf<PersonModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        var rv=findViewById<RecyclerView>(R.id.rv_info)

        list.add(PersonModel("Anu1","Mumbai1"))
        list.add(PersonModel("Anu2","Mumbai2"))
        list.add(PersonModel("Anu3","Mumbai3"))
        list.add(PersonModel("Anu4","Mumbai4"))

         adapter= PersonAdapter(this,list,this)
        rv.adapter=adapter


    }

    override fun onItemClick(position: Int) {
        var name=list[position].name
        var address=list[position].address
        Toast.makeText(this, "item clicked {$name}-{$address}", Toast.LENGTH_LONG).show()

    }
}