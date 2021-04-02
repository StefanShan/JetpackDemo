package com.byte_stefan.jetpackdemo

import android.net.Uri
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val str = "/passport/sso/confirm_qrcode/?csrf_token=6562373439303037376334346230336434303832633534663134313031653635a45810675faba743d6565846039209251bbcc47e94f004f1cc529e4797a6ebf0\\u0026csrf_ts=1617161191"
        val result = Uri.parse(str).getQueryParameter("csrf_token")
        print(result)
    }
}