package vocs.listinone.ui.lists

import vocs.listinone.BaseRepository

class MainListRepository  private constructor() : BaseRepository() {

    fun getMainListItem (id: String, itemList: ((MainListViewModel?) -> Unit)){

    }

    fun addListItem() { }

    fun deleteListItem() { }

    fun updateListItem() { }
}
