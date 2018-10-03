package com.cosmospire.roomtestapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.cosmospire.roomtestapp.repository.NoteRepository
import com.cosmospire.roomtestapp.room.Note

class NoteViewModel(application: Application)
    : AndroidViewModel(application) {

    var repository: NoteRepository
    var allNotes: LiveData< List<Note> >

    init {
        repository = NoteRepository(application)
        allNotes = repository.allNotes
    }

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun update(note: Note) {
        repository.update(note)
    }

    fun delete(note: Note) {
        repository.delete(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

}