package com.example.cardviewinrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardviewinrecycleview.databinding.CardCellBinding

class BookAdapter(private val books:List<Book>, private val clickListener: BookOnClickListener):RecyclerView.Adapter<BookAdapter.BookViewHolder>() {


    class BookViewHolder(  private var cardCellBinding:CardCellBinding,
                           private val clickListener:BookOnClickListener
    ):RecyclerView.ViewHolder(cardCellBinding.root){
        fun bind(book:Book){

            cardCellBinding.cover.setImageResource(book.cover)
            cardCellBinding.title.text=book.title
            cardCellBinding.author.text=book.auther

            cardCellBinding.cardView.setOnClickListener {
                clickListener.onclick(book)

            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val v = LayoutInflater.from(parent.context)
        val binding= CardCellBinding.inflate(v,parent,false)
        return BookViewHolder(binding,clickListener )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        holder.bind(books[position])

    }

    override fun getItemCount(): Int {
        return books.size
    }
}