package com.example.cardviewinrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cardviewinrecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),BookOnClickListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        popularBooks()

        var adapter = BookAdapter(bookList,this)
        var gm = GridLayoutManager(applicationContext,3)

        binding.rcView.adapter= adapter
        binding.rcView.layoutManager=gm








    }

    override fun onclick(book: Book) {

        val intent= Intent(this,DetailActivity::class.java)
        intent.putExtra(Book_ID_EXTRA,book.id)
        startActivity(intent)


    }
}