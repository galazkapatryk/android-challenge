package pl.branchdev.challenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import pl.branchdev.eventscreen.navigation.EventScreenNavigation

class MainActivity : AppCompatActivity() {
    private val navigator: EventScreenNavigation by inject()
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
        navigator.bind(findNavController(this,R.id.activityMainFragmentHost))
    }

    override fun onPause() {
        super.onPause()
        navigator.unbind()
    }
}
