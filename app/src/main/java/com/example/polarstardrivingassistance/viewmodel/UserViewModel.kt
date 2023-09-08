package com.example.polarstardrivingassistance.viewmodel

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.polarstardrivingassistance.model.service.UserInfoManager
import com.example.polarstardrivingassistance.model.entity.UserInfoEntity
import com.example.polarstardrivingassistance.model.service.UserService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import java.lang.StringBuilder
import java.security.MessageDigest

class UserViewModel(context: Context): ViewModel() {

    private val userInfoManager = UserInfoManager(context)
    private val userService = UserService.instance()

    var userName by mutableStateOf("")

    var password by mutableStateOf("")
    var userInfo: UserInfoEntity?= null
        private set

    init {
        viewModelScope.launch {
            val userName = userInfoManager.userName.firstOrNull()
            userInfo = if (userName?.isNotEmpty() == true) {
                UserInfoEntity(userName)
            } else {
                null
            }
        }
    }

    //是否已登录
    val logged: Boolean
        get() {
            return userInfo != null
        }

    //是否正在登录
    var loading by mutableStateOf(false)
        private set

    var error by mutableStateOf("")
        private set

    /**
     *
     * 登录操作
     */
    suspend fun login(onClose: () -> Unit) {
        error = ""
        loading = true
        val res = userService.signIn(userName,md5(password))
        if (res.code == 0 && res.data != null) {
            userInfo = res.data
//            userInfoManager.save("user001")
            onClose()
        } else {
            //失败
            error = res.message
        }
        loading = false
    }

    fun md5(content: String): String {
        val hash = MessageDigest.getInstance("MD5").digest(content.toByteArray())
        val hex = StringBuilder(hash.size * 2)
        for (b in hash) {
            var str = Integer.toHexString(b.toInt())
            if (b < 0x10) {
                str = "0$str"
            }
            hex.append(str.substring(str.length - 2))
        }
        return hex.toString()
    }

    fun clear() {
        viewModelScope.launch {
            userInfoManager.clear() //清除本地数据存储
            userInfo = null //置空内存数据
        }
    }
}
