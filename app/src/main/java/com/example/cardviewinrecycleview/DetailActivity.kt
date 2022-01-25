package com.example.cardviewinrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardviewinrecycleview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookId = intent.getIntExtra(Book_ID_EXTRA,-1)
        val book = bookFromID(bookId)
        if (book!= null){
            binding.cover.setImageResource(book.cover)
            binding.title.text=book.title
            binding.description.text=book.description
            binding.author.text=book.auther
        }


    }

    private fun bookFromID(bookID:Int): Book? {
        for(book in bookList)
        {
            if(book.id == bookID)
                return book
        }
        return null
    }


}