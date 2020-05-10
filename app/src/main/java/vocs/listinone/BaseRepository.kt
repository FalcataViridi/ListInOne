package vocs.listinone

import vocs.listinone.service.AppDatabase

abstract class BaseRepository {
    protected val mAppDatabase = AppDatabase.getInstance()
}