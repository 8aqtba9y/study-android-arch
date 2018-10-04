package com.cosmospire.roomtestapp.viewmodel

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cosmospire.roomtestapp.R
import com.cosmospire.roomtestapp.room.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    var notes: List<Note> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteHolder, position: Int) {
        val currentNote: Note = notes.get(position)
        holder.textViewTitle.text = currentNote.title
        holder.textViewDescription.text = currentNote.description
        holder.textViewPriority.text = "${currentNote.priority}"
    }

    fun addNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView
        var textViewDescription: TextView
        var textViewPriority: TextView

        init {
            textViewTitle = itemView.findViewById(R.id.text_view_title)
            textViewDescription = itemView.findViewById(R.id.text_view_description)
            textViewPriority = itemView.findViewById(R.id.text_view_priority)
        }
    }
}
