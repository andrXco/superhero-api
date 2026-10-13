package com.example.superhero_api

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Inicializa el contenedor de dependencias de Hilt para toda la aplicación.
@HiltAndroidApp
class SuperheroApplication : Application()
