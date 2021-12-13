package com.chenzy.learnarouter

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.chenzy.learnarouter.constant.Constants
import com.chenzy.learnarouter.manager.ThreadPoolManager
import com.chenzy.learnarouter.mvvm.DataActivity
import com.chenzy.route.Route
import io.flutter.embedding.android.FlutterActivity
import kotlinx.coroutines.*
import java.lang.Runnable


@Route(path = "/m/p")
class MainActivity : AppCompatActivity() {
    private lateinit var cs: Job
    private lateinit var gs: Job
    var a: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("onCreate()")

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        //GlobalScope 属于全局作用域，这意味着通过 GlobalScope 启动的协程的生命周期只受整个应用程序的生命周期的限制，
        // 只要整个应用程序还在运行且协程的任务还未结束，协程就可以一直运行

        //GlobalScope.launch 会创建一个顶级协程，尽管它很轻量级，但在运行时还是会消耗一些内存资源，且可以一直运行直到整个
        // 应用程序停止（只要任务还未结束），这可能会导致内存泄露，所以在日常开发中应该谨慎使用 GlobalScope
        gs = GlobalScope.launch {
            delay(1500)
            Log.d(Constants.TAG, "GlobalScope 起了一个协程，延时1.5s")


            coroutineScope {
                //这个协程属于GlobalScope.launch的协程的子携程
                launch {

                }
            }

            var asyncA = MainScope().async {
                1
                "asyncA 结尾"
            }
            Log.d(Constants.TAG, "asyncA的返回结果：${asyncA.await()}")
        }




        MainScope().launch {
            //Dispatchers.Main作为默认调度器
            Log.d(Constants.TAG, "MainScope 起了一个协程")
            repeat(5) {
                delay(2000)
                var imageView = findViewById<ImageView>(R.id.mhpab_fund_corner_iv)
                val curTranslationX: Float = imageView.getTranslationX()
                val animator = ObjectAnimator.ofFloat(
                    imageView,
                    "translationX",
                    curTranslationX,
                    -500f,
                    curTranslationX
                )
                animator.duration = 1000
                animator.start()
                Log.d(Constants.TAG, "repeat it: ${it}")

            }

            //这条日志会等repeat执行完5次之后才打出来
            Log.d(Constants.TAG, "MainScope 协程结束")
        }

        cs = CoroutineScope(Dispatchers.Default).launch {
            //创建一个通用作用域的协程
            Log.d(Constants.TAG, "CoroutineScope(Dispatchers.Default) 创建一个独立作用域的协程")

            supervisorScope {
                //创建一个主从作用域的协程
                launch {

                }
            }
        }

        addFragment()

        //跳到flutter页面去
//        startActivity(
//            FlutterActivity
//                .withNewEngine()
//                .initialRoute("/demo2")//指定页面
//                .build(this)
//        )

        startActivity(Intent(this, DataActivity::class.java))
        ThreadPoolManager.getInstance().execute {

        }
    }

    private fun addFragment() {

        val addTransaction = supportFragmentManager.beginTransaction()
        addTransaction.add(R.id.framelaout, AFragment())

        addTransaction.commitAllowingStateLoss()
    }

    override fun onDestroy() {
        super.onDestroy()
        gs.cancel()
        MainScope().cancel()
        cs.cancel()

    }
}