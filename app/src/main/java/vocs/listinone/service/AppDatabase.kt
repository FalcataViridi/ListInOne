package vocs.listinone.service

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import vocs.listinone.model.MainListItemData

class AppDatabase private constructor() {

    private lateinit var idList: String
    private lateinit var onListItem: ((MainListItemData?) -> Unit)
    private val database = FirebaseDatabase.getInstance()
    private val dbRootRef = database.reference

    //TODO: Manage this keys of database
    private val mainListName: String = "Lists"
    private val mainListNode = dbRootRef.child(mainListName)

    companion object {
        private var appDatabase: AppDatabase? = null

        fun getInstance(): AppDatabase {
            if (appDatabase == null)
                appDatabase = AppDatabase()
            return appDatabase!!
        }
    }

    private val valueEventListener = object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            val listItem = p0.child(idList).getValue(MainListItemData::class.java)
            onListItem(listItem)
            close()
        }

        override fun onCancelled(p0: DatabaseError) {
            //TODO: definir onCancelled
            close()
        }
    }

    //TODO: definir método guardar lista

    fun getMainListItem(id: String, onListItem: (MainListItemData?) -> Unit) {
        this.onListItem = onListItem
        this.idList = id
        mainListNode.addValueEventListener(valueEventListener)
    }

    private fun close() {
        mainListNode.removeEventListener(valueEventListener)
    }
}