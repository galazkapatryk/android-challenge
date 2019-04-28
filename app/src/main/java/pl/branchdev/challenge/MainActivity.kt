package pl.branchdev.challenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import pl.branchdev.eventscreen.navigation.BaseEventScreenNavigation

class MainActivity : AppCompatActivity() {
    private val eventScreenNavigation: BaseEventScreenNavigation by inject()
    private lateinit var navController: NavController

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
    }

    private fun unBindNavigation() {
        eventScreenNavigation.unbind()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }


    override fun onPause() {
        super.onPause()
        unBindNavigation()
    }
}
