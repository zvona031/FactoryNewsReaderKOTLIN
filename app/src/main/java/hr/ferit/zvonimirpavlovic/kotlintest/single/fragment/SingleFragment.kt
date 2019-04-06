package hr.ferit.zvonimirpavlovic.kotlintest.single.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import hr.ferit.zvonimirpavlovic.kotlintest.R
import hr.ferit.zvonimirpavlovic.kotlintest.base.MyApplication.Companion.DESCRIPTION
import hr.ferit.zvonimirpavlovic.kotlintest.base.MyApplication.Companion.TITLE
import hr.ferit.zvonimirpavlovic.kotlintest.base.MyApplication.Companion.URL
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SingleFragment : Fragment(),SingleFragmentView {

    private val singleFragmentPresenter : SingleFragmentPresenterImpl by inject{ parametersOf(this)}
    private var title : TextView? = null
    private var description : TextView?  = null
    private var image : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBundle()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_single, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(title : String, description : String, url : String) =
            SingleFragment().apply {
                arguments = Bundle().apply {
                    putString(TITLE,title)
                    putString(DESCRIPTION,description)
                    putString(URL,url)
                }
            }
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = view.findViewById(R.id.tvDetailedTitle)
        description = view.findViewById(R.id.tvDetailedDescription)
        image = view.findViewById(R.id.ivDetailImage)
        singleFragmentPresenter.getText()
    }

    override fun putText(title : String?, description : String?, url : String?) {
        this.title?.text = title
        this.description?.text = description
        Picasso.with(context).load(url).fit().centerInside().into(this.image)
    }


    private fun getBundle() {
        val bundle = arguments
        val title : String? = bundle?.getString(TITLE)
        val description : String? = bundle?.getString(DESCRIPTION)
        val url : String? = bundle?.getString(URL)
        singleFragmentPresenter.saveBundle(title,description,url)
    }


}
