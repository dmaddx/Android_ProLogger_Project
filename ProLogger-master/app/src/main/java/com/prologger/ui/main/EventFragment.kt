package com.prologger.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.prologger.R
import com.prologger.dto.EventLog
import kotlinx.android.synthetic.main.event_fragment.*

class EventFragment : LogSuperclassFragment() {

    companion object {
        fun newInstance() = EventFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.event_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity.let {
            viewModel = ViewModelProvider(it!!).get(MainViewModel::class.java)
        }
        btnLogEventSave.setOnClickListener {
            saveEvent()
        }
    }

    private fun saveEvent() {
        val eventLog = EventLog()
        with(eventLog) {
            descriptionEvent = edtEventDescription.text.toString()
            workCompleted = edtWorkCompleted.text.toString()
            date = edtEventDate.text.toString()
            type = actEventLogType.text.toString()
        }
    }

    private fun clearAll() {
        edtEventDescription.setText("")
        edtWorkCompleted.setText("")
        edtEventDate.setText("")
        actEventLogType.setText("")

    }
}