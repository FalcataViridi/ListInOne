package vocs.listinone.ui.lists

import vocs.listinone.model.MainListItemData

interface MainListView {
    fun onListSaved(succes: Boolean)
    fun onList(mainList: MainListItemData?)
}
