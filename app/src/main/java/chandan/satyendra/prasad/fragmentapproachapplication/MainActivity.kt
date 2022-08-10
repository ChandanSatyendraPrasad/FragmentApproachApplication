package chandan.satyendra.prasad.fragmentapproachapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import chandan.satyendra.prasad.fragmentapproachapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val myFirstFragment = OneFragment()
    val mySecondFragment = TwoFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSubView()
        initButton()

        addNavigationListener()
    }

    private fun addNavigationListener() {
        binding.bottomNav.setOnClickListener { item ->
            when (item.id) {
                R.id.pageHome -> {
                    replaceFragment(myFirstFragment)
                    true
                }
                R.id.pageMusic -> {
                    replaceFragment(mySecondFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun initButton() {
        findViewById<Button>(R.id.button_change).setOnClickListener {
            showSecondFragment()
        }

        findViewById<Button>(R.id.button_remove).setOnClickListener {
            removeFragment(mySecondFragment)
        }

    }

    private fun removeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.remove(fragment)
        transaction.commit()
    }

    private fun showSecondFragment() {
        replaceFragment(mySecondFragment)
    }

    private fun initSubView() {
        addFragment(myFirstFragment)
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment)
        transaction.commit()

    }
}