package vocs.listinone.service

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import vocs.listinone.model.MainListItemData

class AppDatabase private constructor() {

    private val database = FirebaseDatabase.getInstance()
    private val dbRootRef = database.reference

    //TODO:definir nombre de DB
    private val mainListNode = dbRootRef.child("definir DB name")

    private lateinit var mainList: String

    private val valueEventListener = object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            val mainListItemData = p0.child(mainList).getValue(MainListItemData::class.java)
            //TODO: definir onDataChange
            close()
        }

        override fun onCancelled(p0: DatabaseError) {
            //TODO: definir onCancelled
            close()
        }
    }

    //TODO: definir método guardar lista

    private fun close() {
        mainListNode.removeEventListener(valueEventListener)
    }

    companion object {
        private var appDatabase: AppDatabase? = null

        fun getInstance(): AppDatabase {
            if (appDatabase == null)
                appDatabase =
                    AppDatabase()
            return appDatabase!!
        }
    }
}