package com.dualser.dadm.modulo4.proyecto.models

data class User (
    var username : String = "",
    var firstName : String = "",
    var lastName : String = "",
    var sex : String = "",
) : java.io.Serializable