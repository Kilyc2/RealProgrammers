package com.example.realprogrammers.platform.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.realprogrammers.R
import com.example.realprogrammers.presentation.ProgrammerItemView
import com.example.realprogrammers.presentation.presenters.MainPresenter
import kotlinx.android.synthetic.main.view_programmer_item.view.*

class ProgrammerListAdapter(private val presenter: MainPresenter) :
    RecyclerView.Adapter<ProgrammerListAdapter.ProgrammerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_programmer_item, null)
        return ProgrammerViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = presenter.numberOfItems

    override fun onBindViewHolder(holder: ProgrammerViewHolder, position: Int) {
        presenter.configureViewHolder(viewHolder = holder, position = position)
    }

    class ProgrammerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        ProgrammerItemView {

        override fun displayName(name: String) {
            itemView.tvName.text = name
        }

        override fun displayInterviewDate(date: String) {
            itemView.tvDate.text = date
        }

        override fun displayFavourite(favourite: Boolean) {
            itemView.ivFavourite.setImageResource(
                if (favourite) {
                    R.drawable.ic_favorite_black_24dp
                } else {
                    R.drawable.ic_favorite_border_black_24dp
                }
            )
        }
    }
}