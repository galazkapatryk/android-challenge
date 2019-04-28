package pl.branchdev.challenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import pl.branchdev.challenge.navigation.BaseMainScreenNavigation
import pl.branchdev.eventscreen.navigation.BaseEventScreenNavigation

class MainActivity : AppCompatActivity() {
    private val eventScreenNavigation: BaseEventScreenNavigation by inject()
    private val mainScreenNavigation: BaseMainScreenNavigation by inject()
    private lateinit var navController: NavController
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_events -> {
//                mainScreenNavigation.navigateToEventScreen()
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_schedule -> {
//                mainScreenNavigation.navigateToScheduleScreen()
//                return@OnNavigationItemSelectedListener true
//            }
//        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        navController = findNavController(this, R.id.activityMainFragmentHost)
        bindNavigation()
    }

    private fun bindNavigation() {
        activityMainBottomTab.setupWithNavController(navController)
        eventScreenNavigation.bind(navController)
//        mainScreenNavigation.bind(navController)
    }

    private fun unBindNavigation() {
        eventScreenNavigation.unbind()
//        mainScreenNavigation.unbind()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }


    override fun onPause() {
        super.onPause()
        unBindNavigation()
    }
}
