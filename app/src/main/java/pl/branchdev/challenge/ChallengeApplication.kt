package pl.branchdev.challenge

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.android.startKoin
import pl.branchdev.challenge.di.ModuleList

class ChallengeApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, ModuleList.modules)
    }
}