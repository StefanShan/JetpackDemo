package com.byte_stefan.jetpackdemo.viewModel

import com.byte_stefan.jetpackdemo.viewModel.api.IFactory
import com.byte_stefan.jetpackdemo.viewModel.api.IViewModelFactory
import com.byte_stefan.jetpackdemo.viewModel.api.IViewModelStore

/**
 *
 * @author chenshan
 * @date 2021.03.07
 * @since
 */
class ViewModelManager(private val owner: IViewModelStore) {

    private val mViewModelStore by lazy {
        owner.createStore()
    }

    private val mFactory by lazy {
        (owner as IViewModelFactory).getDefaultFactory()
    }

    fun <T : BaseViewModel> getViewModel(clazz: Class<T>): T? {
        val mapKey = "CustomViewModel: ${clazz.canonicalName}"
        var viewModel = mViewModelStore.get(mapKey)
        if (clazz.isInstance(viewModel)){
            return viewModel as T?
        }
        viewModel = mFactory.createViewModel(clazz)
        mViewModelStore.put(mapKey, viewModel)
        return viewModel
    }

    class DefaultFactory : IFactory {
        override fun <T> createViewModel(clazz: Class<T>): T {
            return clazz.newInstance()
        }

    }
}