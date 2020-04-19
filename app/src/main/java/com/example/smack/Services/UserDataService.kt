package com.example.smack.Services

import android.content.Context
import android.graphics.Color
import com.example.smack.Controller.App
import java.util.*

object UserDataService {
    var id = ""
    var avatarColor = ""
    var avatarName = ""
    var email = ""
    var name = ""

    fun logout(){
        id = ""
        avatarColor = ""
        avatarName = ""
        email = ""
        name = ""
        App.prefs.authToken = ""
        App.prefs.userEmail = ""
        App.prefs.isLoggedIn = false
        MessageService.clearMessages()
        MessageService.clearChannel()
    }

    fun returnAvatarColor(components: String) : Int {
        //[0.133333333333, 0.758534561324, 0.134658957654, 1]

        val strippedColor = components
            .replace("[","")
            .replace("]","")
            .replace(",","")

        var r = 0
        var g = 0
        var b = 0

        val scanner = Scanner(strippedColor)

        if(scanner.hasNext()){
            r = (scanner.next().toDouble() * 255).toInt()
            g = (scanner.next().toDouble() * 255).toInt()
            b = (scanner.next().toDouble() * 255).toInt()
        }

        return  Color.rgb(r,g,b)
    }
}