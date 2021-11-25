package com.mintic.andariegos

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import java.util.ArrayList
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    private lateinit var mSitios: ArrayList<Sitios>
    private lateinit var mAdapter: SitiosAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.contact_list)
        setupRecyclerView()
        generateContacts()
//        mContacts = createMockContacts()
    }

    /**
     * Sets up the RecyclerView: empty data set, item dividers, swipe to delete.
     */
    private fun setupRecyclerView() {
        mSitios = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mAdapter = SitiosAdapter(mSitios, this) { contact ->
            contactOnClick(contact)
        }

        recycler.adapter = mAdapter
    }

    /* RecyclerView item is clicked. */
    private fun contactOnClick(sitios: Sitios) {
        Log.d(TAG, "Click on: $sitios")
    }

    /**
     * Generates mock contact data to populate the UI from a JSON file in the
     * assets directory, called from the options menu.
     */
    private fun generateContacts() {
        val contactsString = readContactJsonFile()
        try {
            val contactsJson = JSONArray(contactsString)
            for (i in 0 until contactsJson.length()) {
                val contactJson = contactsJson.getJSONObject(i)
                val contact = Sitios(
                    contactJson.getString("nombre"),
                    contactJson.getString("ubicacion"),
                    contactJson.getString("descripcion"),
                    contactJson.getString("imageUrl")
                )
                Log.d(TAG, "generateContacts: $contact")
                mSitios.add(contact)
            }

            mAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    /**
     * Reads a file from the assets directory and returns it as a string.
     *
     * @return The resulting string.
     */
    private fun readContactJsonFile(): String? {
        var contactsString: String? = null
        try {
            val inputStream = assets.open("lista_de_sitios.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            contactsString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return contactsString
    }

    private fun createMockContacts(): ArrayList<Sitios> {
        return arrayListOf(
            Sitios("parque", "colombia", "parquecolombia", ""),
            Sitios("parque", "colombia", "parquecolombia", ""),
            Sitios("parque", "colombia", "parquecolombia", ""),
            Sitios("parque", "colombia", "parquecolombia", "")
        )
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}