package com.example.wikimipt

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import okhttp3.*
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import android.R.xml
import android.content.Context
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.row_layout.*
import kotlinx.android.synthetic.main.teachers_layout.*
import org.json.JSONException
import org.json.JSONObject
import org.json.XML

class Teachers : Fragment() {
    private lateinit var router : Router
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router = Router(requireActivity(), R.id.fragment_container)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout = inflater.inflate(R.layout.teachers_layout, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.SearchButton)
        val editText : EditText = view.findViewById(R.id.editSearchingText)
        var searching : String
        button.setOnClickListener {
            searching = editText.text.toString()
            searchAndDownload(searching)
        }
    }

    fun searchAndDownload(searching : String){
        val teext : TextView = view!!.findViewById(R.id.search_results)
        teext.text = searching
        val result = URL("http://wikimipt.org//api.php?action=opensearch&format=xml&search=" + searching).toString()
        teext.text = result
        val url = "http://wikimipt.org//api.php?action=opensearch&format=xml&search=" + searching

        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response){
                var res = response.body()?.string()
                teext.text = res

                var jsonObject: JSONObject? = null
                try {
                    jsonObject = XML.toJSONObject(res)
                } catch (e: JSONException) {
                    Log.e("JSON exception", e.message)
                    e.printStackTrace()
                }
                teext.text = jsonObject?.getJSONObject("SearchSuggestion")?.getJSONObject("Section")?.getJSONArray("Item")?.getJSONObject(0)?.getJSONObject("Text")?.getString("content")
                Log.d("XML", res)
                Log.d("JSON", jsonObject!!.toString())

                var i = 0
                val list = ArrayList<Teacher>()
                while(i < jsonObject.getJSONObject("SearchSuggestion").getJSONObject("Section").getJSONArray("Item").length()){
                    list.add(Teacher(
                            jsonObject.getJSONObject("SearchSuggestion").getJSONObject("Section").getJSONArray("Item").getJSONObject(i).getJSONObject("Text").getString("content"),
                            jsonObject.getJSONObject("SearchSuggestion").getJSONObject("Section").getJSONArray("Item").getJSONObject(i).getJSONObject("Url").getString("content")))
                    i++
                }
                val contextActivity = getActivity()!!.getApplicationContext()
                if(contextActivity != null){
                    val adapter = ListAdapte(contextActivity, list)
                    teacher_list.adapter = adapter//breaks here
                    adapter.notifyDataSetChanged();
                }

            }
        })
    }
}
