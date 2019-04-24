package pl.branchdev.eventrepository.di

import org.koin.dsl.module
import pl.branchdev.eventrepository.ApiEventRepository
import pl.branchdev.eventrepository.BuildConfig
import pl.branchdev.eventrepository.MockEventRepository

val eventRepositoryModule by lazy {
    if (BuildConfig.BUILD_TYPE.contains("mock"))
        module { MockEventRepository() }
    else
        module {
            single { ApiEventRepository(get()) }
        }
}