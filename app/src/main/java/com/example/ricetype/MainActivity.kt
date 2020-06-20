package com.example.ricetype

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ricetype.AboutActivity

class MainActivity : AppCompatActivity() {

    private var title: String = "Mode List"

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }
            R.id.acction_about -> {
                title = "About"
                showAboutView()
            }
        }
        setActionBarTitle(title)
    }

    //UbahJudul
    private fun setActionBarTitle(title: String): Unit {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }


    private fun showSelectedBeras(rice: Rice) {
        val pindahhalaman = Intent(this@MainActivity, DetailActivity::class.java)
        // Kirimkan nilai menggungkan intent
        pindahhalaman.putExtra(DetailActivity.NAMA, rice.name)
        pindahhalaman.putExtra(DetailActivity.DETAIL, rice.detail)
        pindahhalaman.putExtra(DetailActivity.PHOTO, rice.photo)
        startActivity(pindahhalaman)
        Toast.makeText(this, "You Click " + rice.name, Toast.LENGTH_SHORT).show()

    }

    //ShowList
    private fun showRecyclerList() {
        rvRices.layoutManager = LinearLayoutManager(this)
        val listRiceAdapter = RiceListAdapter(riceList)
        rvRices.adapter = listRiceAdapter

        listRiceAdapter.setOnItemClickCallback(object : RiceListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Rice) {
                showSelectedBeras(data)
                /*gotoDetail()*/
            }
        })
    }

    //Show About
    private fun showAboutView() {
        val pindahabout = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(pindahabout)
    }

    private lateinit var rvRices: RecyclerView
    private var riceList: ArrayList<Rice> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ViewFromActivity_Main RecycleView ID
        rvRices = findViewById(R.id.rv_rices)
        rvRices.setHasFixedSize(true)

        riceList.addAll(RiceData.listData)
        showRecyclerList()
    }



    //Tombol Back pada Android Device
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Ingin keluar dari aplikasi?")
            .setCancelable(false)
            .setPositiveButton("Ya",
                DialogInterface.OnClickListener { arg0, arg1 -> finish() })
            .setNegativeButton("Tidak",
                DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
            .show()
    }

}