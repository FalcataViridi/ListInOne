package vocs.listinone.ui.lists


import org.koin.androidx.viewmodel.ext.android.viewModel
import vocs.listinone.BaseFragment

class MainListFragment : BaseFragment(), MainListView {

    val mainListViewModel: MainListViewModel by viewModel()

    companion object {
        fun newInstance() = MainListFragment()
    }

}
