package pl.branchdev.android_common.base

import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

open class BaseFragment : Fragment() {
    var uiSubscriptionComposite = CompositeDisposable()

    override fun onDestroyView() {
        super.onDestroyView()
        uiSubscriptionComposite.clear()
    }
}