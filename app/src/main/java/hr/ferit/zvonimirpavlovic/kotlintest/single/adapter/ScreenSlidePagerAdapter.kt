package hr.ferit.zvonimirpavlovic.kotlintest.single.adapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.Article
import hr.ferit.zvonimirpavlovic.kotlintest.single.fragment.SingleFragment

class ScreenSlidePagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

    private var articleArrayList = ArrayList<Article>()

    override fun getItem(p0: Int): Fragment {
        val title : String =articleArrayList[p0].title
        val description : String = articleArrayList[p0].description
        val url : String = articleArrayList[p0].urlToImage
        return SingleFragment.newInstance(title,description,url)
    }

    override fun getCount() : Int {
        return articleArrayList.size
    }

    fun setData(data : ArrayList<Article>){
        articleArrayList.clear()
        articleArrayList.addAll(data)
    }
}