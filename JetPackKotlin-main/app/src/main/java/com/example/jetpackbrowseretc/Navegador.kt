package com.example.jetpackbrowseretc

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_navegador.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Navegador.newInstance] factory method to
 * create an instance of this fragment.
 */
class Navegador : Fragment() {
    //Private
    private val BASE_URL ="https://google.com"
    private val SEARCH_PATH = "/search?q="
    var estado =true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(estado) {
            override fun handleOnBackPressed() {
                if(webView.canGoBack()){
                    webView.goBack()
                }else{
                    findNavController().navigate(R.id.action_navegador_to_principal)
                }

            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_navegador, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Search


        //Refresh
        swipeRefresh.setOnRefreshListener {
            webView.reload()
        }

        //WebView
        webView.webChromeClient = object  : WebChromeClient(){

        }

        webView.webViewClient = object  : WebViewClient(){

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return  false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                swipeRefresh.isRefreshing = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                swipeRefresh.isRefreshing=false
            }

        }

        val settings = webView.settings
        settings.javaScriptEnabled=true

        webView.loadUrl(BASE_URL)
    }

}
