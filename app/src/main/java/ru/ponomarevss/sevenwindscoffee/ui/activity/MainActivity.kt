package ru.ponomarevss.sevenwindscoffee.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.ponomarevss.sevenwindscoffee.R
import ru.ponomarevss.sevenwindscoffee.databinding.ActivityMainBinding
import ru.ponomarevss.sevenwindscoffee.model.api.IDataSource
import ru.ponomarevss.sevenwindscoffee.model.entity.User
import ru.ponomarevss.sevenwindscoffee.ui.App
import ru.ponomarevss.sevenwindscoffee.ui.BackButtonListener
import ru.ponomarevss.sevenwindscoffee.ui.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var api: IDataSource
    @Inject lateinit var navigatorHolder: NavigatorHolder
    val navigator = AppNavigator(this, R.id.container)

    private var vb: ActivityMainBinding? = null
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        setActionBar(vb?.toolbar)

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        vm = ViewModelProvider(this)[MainViewModel::class.java].apply {
            App.instance.appComponent.inject(this)
        }

        vm.setHomeFragment()

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()){
                return
            }
        }
        vm.backPressed()
    }

}

//Token(string=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBdXRoZW50aWNhdGlvbiIsImlzcyI6ImNvZmZlZSBiYWNrZW5kIiwiaWQiOjczLCJleHAiOjE2NDc2MTU3MzV9.XNhl9lLRmZAspsKOFeW3ud1nJmHDwXNeaYNfcrbaFg0, tokenLifetime=3600000)

//        api.menu("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBdXRoZW50aWNhdGlvbiIsImlzcyI6ImNvZmZlZSBiYWNrZW5kIiwiaWQiOjczLCJleHAiOjE2NDc2MTU3MzV9.XNhl9lLRmZAspsKOFeW3ud1nJmHDwXNeaYNfcrbaFg0", 2).enqueue(object: Callback<List<MenuItem>>{
//            override fun onResponse(call: Call<List<MenuItem>>, response: Response<List<MenuItem>>) {
//                println(response.body())
//            }
//            override fun onFailure(call: Call<List<MenuItem>>, t: Throwable) {
//                println(t.message)
//            }
//        })
//
//        api.locations("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBdXRoZW50aWNhdGlvbiIsImlzcyI6ImNvZmZlZSBiYWNrZW5kIiwiaWQiOjczLCJleHAiOjE2NDc2MTU3MzV9.XNhl9lLRmZAspsKOFeW3ud1nJmHDwXNeaYNfcrbaFg0").enqueue(object: Callback<List<Location>>{
//            override fun onResponse(call: Call<List<Location>>, response: Response<List<Location>>) {
//                println(response.body())
//            }
//            override fun onFailure(call: Call<List<Location>>, t: Throwable) {
//                println(t.message)
//            }
//        })
//
//        api.login(User("foo", "bar")).enqueue(object: Callback<Token>{
//            override fun onResponse(call: Call<Token>, response: Response<Token>) {
//                println(response.body())
//            }
//            override fun onFailure(call: Call<Token>, t: Throwable) {
//                println(t.message)
//            }
//        })
