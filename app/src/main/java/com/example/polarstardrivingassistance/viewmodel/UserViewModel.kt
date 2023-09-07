package com.example.polarstardrivingassistance.viewmodel

import androidx.lifecycle.ViewModel
import com.example.polarstardrivingassistance.model.entity.UserInfoEntity

class UserViewModel: ViewModel() {

    var userInfo: UserInfoEntity?= null
        private set

    //是否已登录
    val logged: Boolean
        get() {
            return userInfo != null
        }

    /**
     *
     * 登录操作
     */
    fun login(onClose: () -> Unit) {
        //模拟网络请求数据回传
        userInfo = UserInfoEntity("user001")
        onClose()
    }
}