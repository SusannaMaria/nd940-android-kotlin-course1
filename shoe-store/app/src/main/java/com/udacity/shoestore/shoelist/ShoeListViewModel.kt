package com.udacity.shoestore.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel()  {
    private val _listLiveData = MutableLiveData<List<Shoe>>()
    val listLiveData: LiveData<List<Shoe>>
        get() = _listLiveData

    init {
        _listLiveData.value = PREDEFINED_SHOE_LIST
    }

    companion object {

    //https://7esl.com/types-of-shoes/
    val PREDEFINED_SHOE_LIST = mutableListOf<Shoe>(
        Shoe("Knee high boots",2.5,"Susanna","footwear products across the world",listOf<String>()),
        Shoe("Boots",3.0,"Maria","Lorem ipsum dolor sit amet",listOf<String>()),
        Shoe("Cowboy boots",3.5,"Nike","sadipscing elitr, sed diam ",listOf<String>()),
        Shoe("Wellington boots",4.0,"Reebok","et ea rebum. Stet clita kasd gubergren",listOf<String>()),
        Shoe("Uggs",5.0,"Converse","At vero eos et accusam et justo ",listOf<String>()),
        Shoe("Timberland boots",5.5,"Puma","invidunt ut labore et dolore magna aliquyam erat",listOf<String>()),
        Shoe("Work boots",6.0,"New Balance","Lorem ipsum dolor sit amet.",listOf<String>()),
        Shoe("Laced booties",6.5,"Toms","At vero eos et accusam et justo duo",listOf<String>()),
        Shoe("Scarpin heels",9.0,"Vans","sanctus est Lorem ipsum dolor",listOf<String>()),
        Shoe("Court shoes",10.0,"Dr. Martens","Stet clita kasd gubergren",listOf<String>()),
        Shoe("Mary Jane Platforms",7.0,"Under Armour","invidunt ut labore et dolore magna ",listOf<String>()),
        Shoe("Stilettos",8.0,"Timberland","sadipscing elitr, sed diam nonumy ",listOf<String>()),
        Shoe("Wedges",8.5,"Jimmy Choo","et justo duo dolores et ea rebum",listOf<String>())
    )
    }
}