package com.dorizu.github.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dorizu.github.core.data.ResultState
import com.dorizu.github.domain.model.DetailUser
import com.dorizu.github.domain.model.RepositoryUser
import com.dorizu.github.domain.model.User
import com.dorizu.github.domain.usecase.IGithubUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class DetailUserViewModel @Inject constructor(
    private val githubUseCase: IGithubUseCase
): ViewModel() {

    private val _selectedUser = MutableLiveData<ResultState<DetailUser>>()
    val selectedUser: LiveData<ResultState<DetailUser>> get() = _selectedUser

    private val _listRepoUser = MutableLiveData<ResultState<List<RepositoryUser>>>()
    val listRepoUser: LiveData<ResultState<List<RepositoryUser>>> get() = _listRepoUser

    fun setSelectedUser(username: String){
        val getUser = githubUseCase.getDetailUser(username)
            .subscribe{res ->
                _selectedUser.value = res
            }
        val getRepoUser = githubUseCase.getRepositoryUser(username)
            .subscribe{res ->
                _listRepoUser.value = res
            }
        mCompositeDisposable.addAll(getUser, getRepoUser)
    }

    companion object{
        private val mCompositeDisposable = CompositeDisposable()
    }
}