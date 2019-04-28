package pl.branchdev.challenge.di

import androidx.navigation.NavController
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import pl.branchdev.challenge.Navigation
import pl.branchdev.eventscreen.navigation.EventScreenNavigation

object AppModules {
    val navigationModule = module {
        single<EventScreenNavigation> { Navigation() }
        single { NavController(androidContext()) }
    }
}