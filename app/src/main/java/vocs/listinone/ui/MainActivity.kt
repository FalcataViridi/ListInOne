package vocs.listinone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import vocs.listinone.R
import vocs.listinone.ui.lists.MainListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.home_activity)
        initKoin()
        //TODO: fragments factory or launcher
    }

    private fun initKoin() {
        val myModule = module {
            //viewModel {
            //TODO: _ViewModel
            //}
            single {
                //TODO: _Repository
            }
        }
        // start Koin!
        startKoin {
            androidContext(applicationContext)
            modules(myModule)
        }
    }
}
