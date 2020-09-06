package vocs.listinone.ui.lists

import androidx.lifecycle.MutableLiveData
import vocs.listinone.BaseRepository
import vocs.listinone.model.MainListItemData

class MainListRepository  private constructor() : BaseRepository() {

    private val mMutableProfileData = MutableLiveData<MainListItemData?>()

    fun getMainListItem (id: String, onListItem: ((MainListItemData?) -> Unit)) {
        return appDatabase.getMainListItem(id, onListItem)
    }

    fun saveListItem (lisItem: MainListItemData, onSucces: ((Boolean?) -> Unit)? = null) {
        return appDatabase.saveListItem(lisItem, onSucces)
    }

    companion object {
        private var instance: MainListRepository? = null

        fun getInstance(): MainListRepository {
            if (instance == null)
                instance = MainListRepository()
            return instance!!
        }
    }

    fun addListItem() { }

    fun deleteListItem() { }

    fun updateListItem() { }
}
