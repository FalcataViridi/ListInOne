package vocs.listinone.ui.lists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import vocs.listinone.BaseFragment
import vocs.listinone.R
import vocs.listinone.model.MainListItemData

class MainListFragment : BaseFragment(), IMainListView {

    val mainListViewModel: MainListViewModel by viewModel()
    val mainListName: String = "main list"

    companion object {
        fun newInstance() = MainListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainListViewModel.attachView(this, this)
        mainListViewModel.getMainListItem(mainListName)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate( R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //TODO: define buttons' listener
    }

    override fun onListSaved(succes: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onListItem(mainListItem: MainListItemData?) {

    }


}
