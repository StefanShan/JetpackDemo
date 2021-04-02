package com.byte_stefan.jetpackdemo.viewModel.api

/**
 *
 * @author chenshan
 * @date 2021.03.07
 * @since
 */
interface IFactory {
    fun<T> createViewModel(clazz: Class<T>):T
}