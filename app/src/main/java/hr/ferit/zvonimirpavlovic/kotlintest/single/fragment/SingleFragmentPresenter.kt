package hr.ferit.zvonimirpavlovic.kotlintest.single.fragment

class SingleFragmentPresenterImpl(private var singleFragmentView : SingleFragmentView) : SingleFragmentPresenter {

    private var title : String? = null
    private var description : String? = null
    private var url : String? = null


    override fun saveBundle(title: String?, description: String?, url: String?) {
        this.title = title
        this.description = description
        this.url = url
    }

    override fun getText() {
        singleFragmentView.putText(title,description,url)
    }

}

interface SingleFragmentPresenter {
    fun saveBundle(title: String?, description: String?, url: String?)

    fun getText()
}