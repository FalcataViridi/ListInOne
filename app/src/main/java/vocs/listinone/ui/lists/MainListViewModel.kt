package vocs.listinone.ui.lists

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import vocs.listinone.BaseViewModel
import vocs.listinone.model.MainListItemData

class MainListViewModel( private val mainListRepository: MainListRepository) :  BaseViewModel<IMainListView>() {
    private val mainListData = MutableLiveData<MainListItemData?>()
    private val mainlistItemDataSaved = MutableLiveData<Boolean>()
    private val mainListItemObserver: Observer<in MainListItemData?> = Observer {
        getView().onListItem(it)
    }
    private val mUserDataUpdateObserver: Observer<in Boolean> = Observer {
        getView().onListSaved(it)
    }

    fun getMainListItem(id: String) {
        mainListRepository.getMainListItem(id){
            mainListData.postValue(it)
        }
    }

    fun saveListItem(mainListItem: MainListItemData) {
        mainListRepository.saveListItem(mainListItem) {
            mainlistItemDataSaved.postValue(it)
        }
    }

    override fun attachView(view: IMainListView, lifecycleOwner: LifecycleOwner) {
        super.attachView(view, lifecycleOwner)

        mainListData.observe(lifecycleOwner, mainListItemObserver)
        mainlistItemDataSaved.observe(lifecycleOwner, mUserDataUpdateObserver)
    }

}
