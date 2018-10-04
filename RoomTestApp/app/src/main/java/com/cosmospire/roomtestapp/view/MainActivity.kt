package com.cosmospire.roomtestapp.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.cosmospire.roomtestapp.R
import com.cosmospire.roomtestapp.viewmodel.NoteAdapter
import com.cosmospire.roomtestapp.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. create entity (room)
        // 2. create dao for entity (room)
        // 3. create database for entity (room)
        // 4. create handler for livedata(;note list) (repository)
        // 5. add database callback on created - optional (room)
        // 6. create viewModel to keep status for UI (viewmodel)
        // 7. use viewModel
        // 8. create recyclerview item.xml
        // 9. add recyclerview on main.xml
        // 10. create adapter for recyclerview
        // 11. user adapter

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val adapter: NoteAdapter = NoteAdapter()
        recyclerView.adapter = adapter

        val noteViewModel: NoteViewModel =
                ViewModelProviders.of(this).get(NoteViewModel::class.java)
        noteViewModel.allNotes.observe(this,
                Observer {
                    // update RecyclerView
                    println("List<Note>: $it")
                    adapter.addNotes(notes = it)
                })
    }

}
