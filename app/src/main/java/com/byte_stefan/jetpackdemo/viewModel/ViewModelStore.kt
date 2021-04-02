package com.byte_stefan.jetpackdemo.viewModel

/**
 *
 * @author chenshan
 * @date 2021.03.07
 * @since
 */

class ViewModelStore{
    private val hashMap = HashMap<String, BaseViewModel>()

    fun put(key: String, viewModel: BaseViewModel){
        val oldValue = hashMap.put(key, viewModel)
        oldValue?.onClear()
    }

    fun get(key: String): BaseViewModel? {
        return hashMap[key]
    }

    fun clear(){
        hashMap.forEach {
            it.value.onClear()
        }
        hashMap.clear()
    }
}