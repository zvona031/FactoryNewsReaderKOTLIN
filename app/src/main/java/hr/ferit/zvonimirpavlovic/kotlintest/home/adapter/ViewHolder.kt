package hr.ferit.zvonimirpavlovic.kotlintest.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.article_cell.view.*

class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val ivImage : ImageView = itemView.ivImage
    val tvTitle : TextView = itemView.tvTitle
    val tvDescription : TextView = itemView.tvDescription
}