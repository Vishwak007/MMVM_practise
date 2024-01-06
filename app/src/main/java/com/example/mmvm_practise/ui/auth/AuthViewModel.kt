package com.example.mmvm_practise.ui.auth

import Product
import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mmvm_practise.data.Database.FullName
import com.example.mmvm_practise.data.Database.User
import com.example.mmvm_practise.data.Network.Response.ProductDetail
import com.example.mmvm_practise.data.Network.Response.UserDetail
import com.example.mmvm_practise.data.Repositories.UserRepository
import com.example.mmvm_practise.data.Repositories.UserRepositoryDb
import com.example.mmvm_practise.util.Coroutines
import retrofit2.Response

class AuthViewModel : ViewModel() {
    var email:String? = null;
    var password:String? = null;
    var context:Context? = null
    var listener:AuthListener? = null
    var userList:List<User>? = null
    fun onLoginBtnClick(view: View){
        listener?.onStarted()


        if (email?.isEmpty() == true || password?.isEmpty() == true){
            listener?.onFailed("kutch khali hai")
        }else{
            Coroutines.main {
                val loginRespo:Response<UserDetail>? = UserRepository().userLogin(email!!, password!!)
                if (loginRespo != null) {
                    if (loginRespo.isSuccessful)
                        listener?.onSuccess(loginRespo.body())
                    val userDetail:UserDetail? = loginRespo.body()
                    context?.let { UserRepositoryDb(it).insertSingleUser(User(userDetail?.id,
                        userDetail?.username,
                        userDetail?.email,
                        userDetail?.firstName,
                        userDetail?.lastName,
                        userDetail?.gender,
                        userDetail?.image,
                        userDetail?.token

                    )) }
                }
            }

            //            CoroutineScope(Dispatchers.Main).launch {
            //                val loginRespo:Response<UserDetail>? = UserRepository().userLogin(email!!, password!!)
            //                if (loginRespo != null) {
            //                    if (loginRespo.isSuccessful)
            //                        listener?.onSuccess(loginRespo.body())
            //                }
            //            }

        }
//
    }
    fun onGetProductDetail(view: View){
        listener?.onStarted()
        Coroutines.main {
//            val response: Response<ProductDetail>? = UserRepository().getAllProdDetail()
//            if (response != null) {
//                if (response.isSuccessful){
//                    val productDetail:ProductDetail? = response.body()
//                    listener?.showMessage("total products : ${productDetail?.total.toString()}")
//                }else{
//                    listener?.onFailed(response.code().toString())
//                }
//
//            }

            if (context != null){
                userList= UserRepositoryDb(context!!).getAllUser()
            }

            if (userList != null){
                listener?.showMessage("Firstname : ${userList!![0].firstName}, Lastname : ${userList!![0].lastName}")
            }else{
                listener?.onFailed("not gettiing full name")
            }

        }
    }
    fun onGetSingleProd(view: View){
        Coroutines.main {
//            val response = UserRepository().getSingleProduct(1)
//            if (response != null){
//                if (response.isSuccessful){
//                    val product:Product? = response.body()
//                    listener?.showMessage(product?.title!!)
//
//                }
//            }
            if (userList != null){
                listener?.showMessage("Firstname : ${userList!![0].firstName}, Lastname : ${userList!![0].lastName}")
            }else{
                listener?.onFailed("not gettiing full name")
            }
        }
    }

    fun retrieveAllUserDataFromDb(view: View){
        Coroutines.main {
            if (context!=null){
                val allUser:List<User>? = UserRepositoryDb(context!!).getAllUser()
                if (allUser != null){
                    listener?.showMessage(allUser[0].firstName.toString())
                }else{
                    listener?.onFailed("getting nothing")
                }

            }

        }
    }
}


