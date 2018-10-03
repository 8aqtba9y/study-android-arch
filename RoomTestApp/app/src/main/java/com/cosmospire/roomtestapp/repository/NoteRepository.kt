package com.cosmospire.roomtestapp.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import com.cosmospire.roomtestapp.room.Note
import com.cosmospire.roomtestapp.room.NoteDao
import com.cosmospire.roomtestapp.room.NoteDatabase
import org.jetbrains.anko.doAsync


class NoteRepository(application: Application) {
    var noteDao: NoteDao
    var allNotes: LiveData< List<Note> >

    init {
        val database: NoteDatabase = NoteDatabase.getInstance(application)
        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note) {
        doAsync {
            noteDao.insert(note)
        }
    }

    fun update(note: Note) {
        doAsync {
            noteDao.update(note)
        }
    }

    fun delete(note: Note) {
        doAsync {
            noteDao.delete(note)
        }
    }

    fun deleteAllNotes() {
        doAsync {
            noteDao.deleteAllNotes()
        }
    }

}