package com.byte_stefan.jetpackdemo.viewModel.api

import com.byte_stefan.jetpackdemo.viewModel.api.IFactory

/**
 *
 * @author chenshan
 * @date 2021.03.07
 * @since
 */
interface IViewModelFactory {
    fun getDefaultFactory(): IFactory
}