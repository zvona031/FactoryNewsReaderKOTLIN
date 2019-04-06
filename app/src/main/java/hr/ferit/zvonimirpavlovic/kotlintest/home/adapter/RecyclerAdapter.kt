package hr.ferit.zvonimirpavlovic.kotlintest.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import hr.ferit.zvonimirpavlovic.kotlintest.R
import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.Article


class RecyclerAdapter(private val recyclerclicklistener : RecyclerItemClickListener) : RecyclerView.Adapter<ViewHolder>() {

    private var articleArrayList = ArrayList<Article>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.article_cell,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return articleArrayList.size
    }

    override fun onBindViewHolder(viewHolder : ViewHolder, i: Int) {
        viewHolder.tvTitle.text = articleArrayList[i].title
        viewHolder.tvDescription.text = articleArrayList[i].description
        Picasso.with(viewHolder.ivImage.context).load(articleArrayList[i].urlToImage).fit().centerInside().into(viewHolder.ivImage)
        viewHolder.itemView.setOnClickListener { recyclerclicklistener.onItemClick(i) }
    }

    fun setData(data : ArrayList<Article>){
        articleArrayList.clear()
        articleArrayList.addAll(data)
    }
}