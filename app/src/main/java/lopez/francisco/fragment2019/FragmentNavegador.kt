package lopez.francisco.fragment2019


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_fragment_navegador.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

var etUrl: EditText?= null
var btnIr2: Button?=null
var wvone: WebView?=null

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentNavegador.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FragmentNavegador : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val contenedor:View = inflater.inflate(R.layout.fragment_fragment_navegador, container, false)

        etUrl = contenedor.findViewById(R.id.eturl)
        btnIr2 = contenedor.findViewById(R.id.btngo)
        wvone = contenedor.findViewById(R.id.wv1)

        wvone!!.webChromeClient = WebChromeClient()

        val ajustes  = wvone!!.settings
        ajustes.javaScriptEnabled = true

        btnIr2!!.setOnClickListener {

            wvone!!.loadUrl((procesaUrl(etUrl!!.text.toString())))
            mensaje("Funciona")

            //wvone.loadUrl("http://"+etlink.text.toString())


        }
        return contenedor


    }
    fun procesaUrl(url:String):String{

        if(url.startsWith("https://")) {
            return url
        }else if (url.startsWith("www")){

            return "https://$url"
        }else{
            return "https://www.google.com/search?q=hola&oq=$url"
        }

        return url
    }

    fun mensaje(mensaje:String){
        Toast.makeText(activity!!.applicationContext,mensaje, Toast.LENGTH_LONG).show()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentNavegador.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentNavegador().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
