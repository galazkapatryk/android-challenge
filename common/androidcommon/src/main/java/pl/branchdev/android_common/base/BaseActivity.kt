package pl.branchdev.android_common.base

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

class BaseActivity : AppCompatActivity() {
    var uiSubscriptionComposite = CompositeDisposable()
    override fun onDestroy() {
        super.onDestroy()
        uiSubscriptionComposite.clear()
    }
}