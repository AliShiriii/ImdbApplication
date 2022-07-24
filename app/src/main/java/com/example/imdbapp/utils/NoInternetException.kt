package com.example.imdbapp.utils

import java.io.IOException

class NoInternetException(message: String): IOException(message) {
}