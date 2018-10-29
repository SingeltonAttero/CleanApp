package com.yakov.weber.cleanapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.cleanapp.R
import com.yakov.weber.cleanapp.model.system.message.SystemMessageNotifier
import com.yakov.weber.cleanapp.model.system.message.SystemMessageType
import com.yakov.weber.cleanapp.presention.AppPresenter
import com.yakov.weber.cleanapp.presention.AppView
import com.yakov.weber.cleanapp.toothpick.DI
import com.yakov.weber.cleanapp.ui.global.BaseFragment
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.toast
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import toothpick.Toothpick
import javax.inject.Inject

class AppActivity : MvpAppCompatActivity(), AppView {

    @InjectPresenter
    lateinit var presenter: AppPresenter

    @ProvidePresenter
    fun providerPresenter(): AppPresenter = Toothpick
            .openScope(DI.APP_SCOPE)
            .getInstance(AppPresenter::class.java)

    @Inject
    lateinit var systemMessageNotifier: SystemMessageNotifier

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private var notifierDisposable: Disposable? = null
    private val currentFragment:BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.app_container) as BaseFragment

    private val navigator:Navigator by lazy {
        object : SupportAppNavigator(this,supportFragmentManager,R.id.app_container){
            override fun setupFragmentTransaction(command: Command?,
                                                  currentFragment: Fragment?,
                                                  nextFragment: Fragment?,
                                                  fragmentTransaction: FragmentTransaction?) {
                fragmentTransaction?.setReorderingAllowed(true)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this,Toothpick.openScope(DI.APP_SCOPE))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        subscribeOnSystemMessage()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        unsubscribeSystemMessage()
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    private fun subscribeOnSystemMessage() {
        notifierDisposable = systemMessageNotifier.notifier
                .subscribe { message ->
                    when (message.type) {
                        SystemMessageType.ALERT -> TODO()
                        SystemMessageType.TOAST -> toast(message.text)
                    }
                }
    }

    private fun unsubscribeSystemMessage() {
        notifierDisposable?.dispose()
    }
}
