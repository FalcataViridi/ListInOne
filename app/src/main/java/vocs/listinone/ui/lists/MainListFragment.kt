package vocs.listinone.ui.lists

import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import vocs.listinone.BaseFragment
import vocs.listinone.model.MainListItemData

class MainListFragment : BaseFragment(), MainListView {

    val mainListViewModel: MainListViewModel by viewModel()

    companion object {
        fun newInstance() = MainListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // mProfileViewModel = ViewModelProviders.of(this)[ProfileViewModel::class.java]
        mainListViewModel.attachView(this, this)
        //mainListViewModel.getMainListItem("xxxxxxxx")
    }

    override fun onListSaved(succes: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onList(mainList: MainListItemData?) {
        TODO("Not yet implemented")
    }


}
