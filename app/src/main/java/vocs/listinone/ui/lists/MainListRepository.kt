package vocs.listinone.ui.lists

import androidx.lifecycle.MutableLiveData
import vocs.listinone.BaseRepository
import vocs.listinone.model.MainListItemData

class MainListRepository  private constructor() : BaseRepository() {

    private val mMutableProfileData = MutableLiveData<MainListItemData?>()

    fun getMainListItem (id: String, onListItem: ((MainListItemData?) -> Unit)) {
        return appDatabase.getMainListItem(id, onListItem)
    }

    fun addListItem() { }

    fun deleteListItem() { }

    fun updateListItem() { }
}
