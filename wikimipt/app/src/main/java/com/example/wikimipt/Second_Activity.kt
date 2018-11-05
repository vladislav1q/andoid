package com.example.wikimipt

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_second_.*
import kotlinx.android.synthetic.main.app_bar_second_.*



class Second_Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var mywebview : WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        mywebview = findViewById(R.id.webview)
        mywebview?.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
        mywebview!!.loadUrl("http://wikimipt.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0")
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.second_, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.main_page -> {
                mywebview = findViewById(R.id.webview)
                mywebview?.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }
                mywebview!!.loadUrl("http://wikimipt.org")
            }
            R.id.current_events -> {
                mywebview = findViewById(R.id.webview)
                mywebview?.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }
                mywebview!!.loadUrl("http://wikimipt.org/wiki/%D0%92%D0%B8%D0%BA%D0%B8%D0%A4%D0%B8%D0%B7%D1%82%D0%B5%D1%85:%D0%A2%D0%B5%D0%BA%D1%83%D1%89%D0%B8%D0%B5_%D1%81%D0%BE%D0%B1%D1%8B%D1%82%D0%B8%D1%8F")
            }
            R.id.new_changes -> {
                mywebview = findViewById(R.id.webview)
                mywebview?.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }
                mywebview!!.loadUrl("http://wikimipt.org/wiki/%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:%D0%A1%D0%B2%D0%B5%D0%B6%D0%B8%D0%B5_%D0%BF%D1%80%D0%B0%D0%B2%D0%BA%D0%B8")
            }
            R.id.new_pages -> {
                mywebview = findViewById(R.id.webview)
                mywebview?.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }
                mywebview!!.loadUrl("http://wikimipt.org/wiki/%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:%D0%9D%D0%BE%D0%B2%D1%8B%D0%B5_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D1%8B")
            }
            R.id.faculties -> {
                mywebview = findViewById(R.id.webview)
                mywebview?.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }
                mywebview!!.loadUrl("http://wikimipt.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%A4%D0%B0%D0%BA%D1%83%D0%BB%D1%8C%D1%82%D0%B5%D1%82%D1%8B")
            }
            R.id.pulpit -> {
                mywebview = findViewById(R.id.webview)
                mywebview?.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }
                mywebview!!.loadUrl("http://wikimipt.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%9A%D0%B0%D1%84%D0%B5%D0%B4%D1%80%D1%8B_%D0%BF%D0%BE_%D0%B0%D0%BB%D1%84%D0%B0%D0%B2%D0%B8%D1%82%D1%83")
            }
            R.id.subjects -> {
                mywebview = findViewById(R.id.webview)
                mywebview?.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }
                mywebview!!.loadUrl("http://wikimipt.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%9F%D1%80%D0%B5%D0%B4%D0%BC%D0%B5%D1%82%D1%8B_%D0%BF%D0%BE_%D0%B0%D0%BB%D1%84%D0%B0%D0%B2%D0%B8%D1%82%D1%83")
            }
            R.id.teachers -> {
                mywebview = findViewById(R.id.webview)
                mywebview?.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }
                mywebview!!.loadUrl("http://wikimipt.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%9F%D1%80%D0%B5%D0%BF%D0%BE%D0%B4%D0%B0%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D0%B8_%D0%BF%D0%BE_%D0%B0%D0%BB%D1%84%D0%B0%D0%B2%D0%B8%D1%82%D1%83")
            }
            R.id.rating -> {
                mywebview = findViewById(R.id.webview)
                mywebview?.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }
                mywebview!!.loadUrl("http://wikimipt.org/wiki/%D0%92%D0%B8%D0%BA%D0%B8%D0%A4%D0%B8%D0%B7%D1%82%D0%B5%D1%85:%D0%A0%D0%B5%D0%B9%D1%82%D0%B8%D0%BD%D0%B3_%D0%BF%D1%80%D0%B5%D0%BF%D0%BE%D0%B4%D0%B0%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D0%B5%D0%B9")
            }
            R.id.add -> {
                mywebview = findViewById(R.id.webview)
                mywebview?.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }
                mywebview!!.loadUrl("http://wikimipt.org/wiki/%D0%A4%D0%BE%D1%80%D0%BC%D0%B0:%D0%9F%D1%80%D0%B5%D0%BF%D0%BE%D0%B4%D0%B0%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8C")
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}

