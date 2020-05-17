package vocs.listinone.ui.lists

import vocs.listinone.model.MainListItemData

interface IMainListView {
    fun onListSaved(succes: Boolean)
    fun onListItem(mainListItem: MainListItemData?)
}
