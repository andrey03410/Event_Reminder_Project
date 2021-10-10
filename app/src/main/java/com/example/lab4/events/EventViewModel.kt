package com.example.lab4.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class EventViewModel  : ViewModel() {
    private val eventsReminder: MutableLiveData<List<EventReminder>> = MutableLiveData()

    init{
        loadEventReminder()
    }

    fun getEvents(): LiveData<List<EventReminder>> {
        return eventsReminder
    }

    private fun loadEventReminder(){
        val list = listOf(
            EventReminder("День Рождения", "День рождения Валеры", Date(122, 3, 15)),
            EventReminder("Сериал", "Дата выхода сериала X", Date(121, 10, 21)),
            EventReminder("Покупка", "Купить PS5", Date(121, 11, 15))
        )
        eventsReminder.postValue(list)
    }
}