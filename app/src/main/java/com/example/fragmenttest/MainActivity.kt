package com.example.fragmenttest

import kotlinx.android.synthetic.main.left_fragment.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            replaceFragment(AnotherRightFragment())
        }
        replaceFragment(RightFragment())
    }

    /**
     * Use the designated Fragment to show in the rightLayout
     */
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout, fragment)
        // 在事务提交之前调用了FragmentTransaction的addToBackStack()方法，它可以
        // 接收一个名字用于描述返回栈的状态，一般传入null即可。
        transaction.addToBackStack(null)
        transaction.commit()

        // How to get a instance of any Fragment?
        val leftFragment1 = supportFragmentManager.findFragmentById(R.id.leftFrag) as LeftFragment
        // The statement above is equal to below one
        val leftFragment2 = leftFrag as LeftFragment
    }
}