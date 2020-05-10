package vocs.listinone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vocs.listinone.R
import vocs.listinone.ui.lists.MainListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainListFragment.newInstance())
                    .commitNow()
        }
    }
}
