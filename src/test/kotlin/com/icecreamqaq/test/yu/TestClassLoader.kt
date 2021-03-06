package com.icecreamqaq.test.yu

import com.IceCreamQAQ.Yu.hook.HookItem
import com.IceCreamQAQ.Yu.hook.HookMethod
import com.IceCreamQAQ.Yu.hook.HookRunnable
import com.IceCreamQAQ.Yu.hook.YuHook
import com.IceCreamQAQ.Yu.loader.AppClassloader


fun main(args: Array<String>) {
    YuHook.put(HookItem("com.icecreamqaq.test.yu.Ta", "g", "com.icecreamqaq.test.yu.HookTa"))

    val appClassLoader = AppClassloader(TestStarter::class.java.classLoader)

    val tac = appClassLoader.loadClass("com.icecreamqaq.test.yu.Ta")
    val ta = tac.newInstance()

    val g = tac.getMethod("g")
//    val g = tac.getMethod("g", Int::class.java, Int::class.java)

    println(g.invoke(ta))
}

class Ta {
    //    companion object{
//        @JvmStatic
//
//    }
    fun g() = 2.toLong()
}


class HookTa : HookRunnable {
    override fun preRun(method: HookMethod): Boolean {
        method.result = 3.toLong()

        return true
    }

    override fun postRun(method: HookMethod) {
    }

    override fun onError(method: HookMethod): Boolean {
        return true
    }
}
