package pl.branchdev.challenge.di

import org.koin.dsl.module.module
import pl.branchdev.challenge.navigation.BaseMainScreenNavigation
import pl.branchdev.challenge.navigation.EventScreenNavigation
import pl.branchdev.challenge.navigation.MainScreenNavigation
import pl.branchdev.eventscreen.navigation.BaseEventScreenNavigation

object AppModules {
    val navigationModule = module {
        single<BaseEventScreenNavigation> { EventScreenNavigation() }
        single<BaseMainScreenNavigation> { MainScreenNavigation() }
    }
}