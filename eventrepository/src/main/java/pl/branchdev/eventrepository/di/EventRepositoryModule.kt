package pl.branchdev.eventrepository.di

import org.koin.dsl.module.module
import pl.branchdev.eventrepository.ApiEventRepository
import pl.branchdev.eventrepository.BuildConfig
import pl.branchdev.eventrepository.EventRepository
import pl.branchdev.eventrepository.MockEventRepository

val eventRepositoryModule by lazy {
    if (BuildConfig.BUILD_TYPE.contains("mock"))
        module {
            factory<EventRepository> {
                MockEventRepository()
            }
        }
    else
        module {
            factory<EventRepository> { ApiEventRepository(get()) }
        }
}