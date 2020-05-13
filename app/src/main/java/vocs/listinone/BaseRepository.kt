package vocs.listinone

import vocs.listinone.service.AppDatabase

abstract class BaseRepository {
    protected val appDatabase = AppDatabase.getInstance()
}