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
import kotlinx.android.synthetic.main.mainlist_fragment.*
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

        return inflater.inflate( R.layout.mainlist_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configPermission()
        initListView()
    }

    private fun initListView() {
        /*val falldownAnim = AnimationUtils.loadLayoutAnimation(
            context
            , R.anim.mainlist_anim_falldown)*/

        var commandList = ArrayList<String>()
        commandList.clear()
        commandList.add("testing 1")
        commandList.add("testing dog")
        commandList.add("MainListKeys.ACEPTAR.key")
        commandList.add("testing keys")

        var commandAdapter = ArrayAdapter<String>(requireContext(), R.layout.item_mainlist, commandList)

        val animFallDown = loadAnimation(this.context, R.anim.mainlist_anim_falldown)
        rv_mainlist.startAnimation(animFallDown)

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
}

