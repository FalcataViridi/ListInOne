package vocs.listinone.ui.lists

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import vocs.listinone.BaseViewModel
import vocs.listinone.model.MainListItemData

class MainListViewModel( private val mainListRepository: MainListRepository) :  BaseViewModel<MainListView>() {
    private val mainListItemData = MutableLiveData<MainListItemData?>()
    private val mainlistItemDataSaved = MutableLiveData<Boolean>()
    private val mainListItemObserver: Observer<in MainListItemData?> = Observer {
        getView().onList(it)
    }

    fun getMainListItem(id: String) {
        mainListRepository.getMainListItem(id){
            //mainListItemData.postValue(it)
        }
    }

}
