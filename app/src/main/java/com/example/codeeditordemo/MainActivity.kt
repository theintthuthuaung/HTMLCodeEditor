package com.example.codeeditordemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var playgroundTV:AutoCompleteTextView
    lateinit var runBTN:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playgroundTV = findViewById(R.id.playground_code)
        runBTN = findViewById(R.id.run_btn)

        runBTN.setOnClickListener {
            run()
        }
    }

    private fun run() {
        var intent = Intent(this,WebBrowser::class.java)
        intent.putExtra("code",playgroundTV.text.toString())
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val DOCUMENT_HTMLCODE = " <!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h1>My First Heading</h1>\n" +
                "<p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html> "
        when(item.itemId){
            R.id.insert_item ->{
                playgroundTV.setText(DOCUMENT_HTMLCODE)
                return true
            }
            R.id.run_item ->{
                run()
                return true
            }
            R.id.clear_item ->{
                playgroundTV.setText("")
                return true
            }
            R.id.exit_item ->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}