package com.byte_stefan.jetpackdemo.viewModel.api

import com.byte_stefan.jetpackdemo.viewModel.ViewModelStore

/**
 *
 * @author chenshan
 * @date 2021.03.07
 * @since
 */
interface IViewModelStore {
    fun createStore(): ViewModelStore
}