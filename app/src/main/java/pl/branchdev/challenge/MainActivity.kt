package pl.branchdev.challenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import pl.branchdev.challenge.navigation.BaseMainScreenNavigation
import pl.branchdev.eventscreen.navigation.BaseEventScreenNavigation

class MainActivity : AppCompatActivity() {
    private val eventScreenNavigation: BaseEventScreenNavigation by inject()
    private val mainScreenNavigation: BaseMainScreenNavigation by inject()
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_events -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_schedule -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBottomTab.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        activityMainBottomTab.selectedItemId = R.id.navigation_events
    }

    override fun onResume() {
        super.onResume()
        findNavController(this, R.id.activityMainFragmentHost).run {
            bindNavigation(this)
        }
    }

    private fun bindNavigation(navController: NavController) {
        eventScreenNavigation.bind(navController)
        mainScreenNavigation.bind(navController)
    }

    private fun unBindNavigation() {
        eventScreenNavigation.unbind()
        mainScreenNavigation.unbind()
    }

    override fun onPause() {
        super.onPause()
        unBindNavigation()
    }
}
