package lopez.francisco.fragment2019

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->


        var fragmento: Fragment? = null


        when (item.itemId) {
            R.id.navigation_home -> {

                fragmento = FragmenImagen.newInstance("", "")


            }
            R.id.navigation_dashboard -> {


                fragmento = FragmentNavegador.newInstance("", "")

            }
            R.id.navigation_notifications -> {

                fragmento = FragmentCreditos.newInstance("", "")


            }
        }
        if (fragmento != null){
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContenedor,fragmento).commitNow()
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navegacion.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
