package pl.branchdev.challenge.di

import pl.branchdev.challenge.di.AppModules.navigationModule
import pl.branchdev.eventrepository.di.eventRepositoryModule
import pl.branchdev.eventscreen.di.eventScreenModule
import pl.branchdev.network.di.networkModule
import pl.branchdev.schedulescreen.di.scheduleScreenModule

object ModuleList {
    val modules =
        mutableListOf(networkModule, eventRepositoryModule, eventScreenModule, navigationModule, scheduleScreenModule)
}