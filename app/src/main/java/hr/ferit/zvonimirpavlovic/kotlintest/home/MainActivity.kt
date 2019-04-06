package hr.ferit.zvonimirpavlovic.kotlintest.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import hr.ferit.zvonimirpavlovic.kotlintest.R
import hr.ferit.zvonimirpavlovic.kotlintest.base.MyApplication.Companion.ARTICLELIST
import hr.ferit.zvonimirpavlovic.kotlintest.base.MyApplication.Companion.POSITION
import hr.ferit.zvonimirpavlovic.kotlintest.home.adapter.RecyclerItemClickListener
import hr.ferit.zvonimirpavlovic.kotlintest.home.adapter.RecyclerAdapter
import hr.ferit.zvonimirpavlovic.kotlintest.home.presenter.MainPresenterImpl
import hr.ferit.zvonimirpavlovic.kotlintest.model.data_model.Article
import hr.ferit.zvonimirpavlovic.kotlintest.single.SingleActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class MainActivity : AppCompatActivity(),MainView, RecyclerItemClickListener {

    private val presenter :MainPresenterImpl by inject { parametersOf(this) }
    private val adapter : RecyclerAdapter by inject { parametersOf(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        initProgressBar()
        presenter.requestDataFromServer()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        recyclerView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun setDataToRecyclerView(articleArrayList : ArrayList<Article>) {
        adapter.setData(articleArrayList)
        recyclerView.adapter = adapter
    }

    override fun onResponseFailure(throwable : Throwable) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.popup_title)
        builder.setMessage(R.string.popup_message)
        builder.setCancelable(true)
        builder.setNeutralButton(android.R.string.ok) {data,_ -> data.cancel()}
        builder.create()
        builder.show()
    }

    override fun launchSingle(articleArrayList : ArrayList<Article>, position : Int) {
        intent = Intent(this, SingleActivity::class.java)
        intent.putParcelableArrayListExtra(ARTICLELIST,articleArrayList)
        intent.putExtra(POSITION ,position)
        startActivity(intent)
    }

    override fun onItemClick(position: Int) {
        presenter.itemClicked(position)
    }

    private fun initRecycler() {
       recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun initProgressBar() {
        progressBar.visibility = View.VISIBLE
    }
}
