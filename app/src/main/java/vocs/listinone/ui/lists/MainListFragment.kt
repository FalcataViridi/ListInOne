package vocs.listinone.ui.lists

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vocs.listinone.R

class MainListFragment : Fragment() {

    companion object {
        fun newInstance() = MainListFragment()
    }

    private lateinit var viewModel: MainListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
