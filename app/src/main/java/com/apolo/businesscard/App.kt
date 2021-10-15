package com.apolo.businesscard

import android.app.Application
import com.apolo.businesscard.data.AppDataBase
import com.apolo.businesscard.data.BusinessCardRepositoy

class App : Application() {
    val dataBase by lazy { AppDataBase.getDataBase( this) }
    val repositoy by lazy { BusinessCardRepositoy(dataBase.businessDao()) }
}