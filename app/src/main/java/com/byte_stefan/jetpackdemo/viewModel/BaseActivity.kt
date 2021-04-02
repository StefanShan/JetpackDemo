package com.byte_stefan.jetpackdemo.viewModel

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.byte_stefan.jetpackdemo.viewModel.api.IFactory
import com.byte_stefan.jetpackdemo.viewModel.api.IViewModelFactory
import com.byte_stefan.jetpackdemo.viewModel.api.IViewModelStore

/**
 *
 * @author chenshan
 * @date 2021.03.07
 * @since
 */
open class BaseActivity : Activity(), LifecycleOwner,
    IViewModelStore,
    IViewModelFactory {
    private val mLifecycleRegistry = LifecycleRegistry(this)

    private var mViewModelStore: ViewModelStore? = null

//    init {
//        mLifecycleRegistry.addObserver(object : LifecycleEventObserver {
//            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
//                Log.e("chenshan","source = $source & event = $event")
//                if (event == Lifecycle.Event.ON_DESTROY && !isChangingConfigurations) {
//                    //清理数据存储
//                    mViewModelStore?.clear()
//                }
//            }
//        })
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    override fun onStart() {
        super.onStart()
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
        mLifecycleRegistry.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                Log.e("chenshan","source = $source & event = $event")
                if (event == Lifecycle.Event.ON_DESTROY && !isChangingConfigurations) {
                    //清理数据存储
                    mViewModelStore?.clear()
                }
            }
        })
    }

    override fun onRetainNonConfigurationInstance(): Any? {
        var viewModelStore = mViewModelStore
        if (viewModelStore == null) {
            viewModelStore = lastNonConfigurationInstance as ViewModelStore
        }
        return viewModelStore
    }

    override fun onDestroy() {
        super.onDestroy()
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    override fun createStore(): ViewModelStore {
        return if (mViewModelStore != null) {
            mViewModelStore as ViewModelStore
        } else {
            mViewModelStore = if (lastNonConfigurationInstance != null) {
                lastNonConfigurationInstance as ViewModelStore
            } else null
            if (mViewModelStore == null) {
                mViewModelStore = ViewModelStore()
            }
            mViewModelStore as ViewModelStore
        }
    }

    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }

    override fun getDefaultFactory(): IFactory {
        return ViewModelManager.DefaultFactory()
    }
}