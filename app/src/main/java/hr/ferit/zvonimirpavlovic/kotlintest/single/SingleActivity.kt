package hr.ferit.zvonimirpavlovic.kotlintest.single

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import hr.ferit.zvonimirpavlovic.kotlintest.R
import hr.ferit.zvonimirpavlovic.kotlintest.base.MyApplication.Companion.ARTICLELIST
import hr.ferit.zvonimirpavlovic.kotlintest.base.MyApplication.Companion.POSITION
import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.Article
import hr.ferit.zvonimirpavlovic.kotlintest.single.adapter.ScreenSlidePagerAdapter
import hr.ferit.zvonimirpavlovic.kotlintest.single.presenter.SinglePresenterImpl
import kotlinx.android.synthetic.main.activity_single.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class SingleActivity : AppCompatActivity(),SingleView,ViewPager.OnPageChangeListener {

    private val singlePresenter : SinglePresenterImpl by inject { parametersOf(this) }
    private val pagerAdapter : ScreenSlidePagerAdapter by inject { parametersOf(supportFragmentManager) }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        getDataFromIntent()
        setupToolbar()
        singlePresenter.getData()
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        singlePresenter.getTitle(p0)
    }

    override fun onPageSelected(p0: Int) {

    }

    override fun onPageScrollStateChanged(p0: Int) {

    }

    override fun onSupportNavigateUp() : Boolean {
        onBackPressed()
        return true
    }

    override fun loadDataToPager(articleArrayList: ArrayList<Article>) {
        pagerAdapter.setData(articleArrayList)
        viewPager.adapter = pagerAdapter
        singlePresenter.getFragmentPosition()
        viewPager.addOnPageChangeListener(this)
    }

    override fun setCurrentFragment(position : Int?) {
        viewPager.currentItem = position!!
    }

    override fun setTitle(title : String) {
        supportActionBar?.title = title
    }

    private fun getDataFromIntent() {
        val position : Int = intent.getIntExtra(POSITION ,0)
        singlePresenter.saveDataFromIntent(intent.getParcelableArrayListExtra(ARTICLELIST),position)
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

}
