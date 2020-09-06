package vocs.listinone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import vocs.listinone.R
import vocs.listinone.service.AppDatabase.Companion.getInstance
import vocs.listinone.ui.lists.MainListFragment
import vocs.listinone.ui.lists.MainListRepository
import vocs.listinone.ui.lists.MainListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainListFragment: MainListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKoin()
        setContentView(R.layout.home_activity)

        //launchMainListFragment()
    }

    private fun initKoin() {
        val myModule = module {
            viewModel {
                MainListViewModel(get())
            }
            single {
                MainListRepository.getInstance()
            }
        }
        // start Koin!
        startKoin {
            androidContext(applicationContext)
            modules(myModule)
        }
    }

    fun launchMainListFragment() {
        mainListFragment = MainListFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace( R.id.container, mainListFragment)
            .commitNow()
    }
}
