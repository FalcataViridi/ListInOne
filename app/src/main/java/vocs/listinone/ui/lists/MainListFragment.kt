package vocs.listinone.ui.lists

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.AnimationUtils.loadAnimation
import android.widget.ArrayAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.mainlist_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import vocs.listinone.BaseFragment
import vocs.listinone.R
import vocs.listinone.model.MainListItemData
import java.util.*
import kotlin.collections.ArrayList


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

        return inflater.inflate( R.layout.mainlist_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configPermission()
        initListView()
    }

    private fun initListView() {
        var listOfLists= this.getLists()
        rv_mainlist.layoutManager = LinearLayoutManager(this.requireContext())

        var mainListAdapter: MainListAdapter = MainListAdapter(listOfLists, this.requireContext())

        rv_mainlist.adapter = mainListAdapter
    }

    override fun onListSaved(succes: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onListItem(mainListItem: MainListItemData?) {

    }

    private fun configPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.RECORD_AUDIO), 101)
        }
    }

    fun getLists(): ArrayList<MainListItemData> {
        var lists = ArrayList<MainListItemData>()
        lists.add(MainListItemData( "Item 1"))
        lists.add(MainListItemData( "Item 2"))
        lists.add(MainListItemData( "Item 3"))
        lists.add(MainListItemData( "Item 4"))
        lists.add(MainListItemData( "Item 5"))
        lists.add(MainListItemData( "Item 6"))
        lists.add(MainListItemData( "Item 7"))
        lists.add(MainListItemData( "Item 8"))

        return lists
    }
}

