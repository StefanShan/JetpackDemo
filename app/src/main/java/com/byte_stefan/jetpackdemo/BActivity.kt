package com.byte_stefan.jetpackdemo

import android.os.Bundle
import com.byte_stefan.jetpackdemo.viewModel.BaseActivity

/**
 *
 * @author chenshan
 * @date 2021.03.24
 * @since
 */
class BActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}