package mezzari.torres.lucas.motion_layout_test.ui.news

import androidx.lifecycle.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import mezzari.torres.lucas.motion_layout_test.model.Anime
import mezzari.torres.lucas.motion_layout_test.model.dispatcher.IAppDispatcher
import mezzari.torres.lucas.motion_layout_test.model.network.ResponseWrapper
import mezzari.torres.lucas.motion_layout_test.network.config.Resource
import mezzari.torres.lucas.motion_layout_test.network.service.IJikanService

class NewsViewModel(
    private val dispatchers: IAppDispatcher,
    private val service: IJikanService,
) : ViewModel() {
    private val seasonResource: MutableLiveData<Resource<ResponseWrapper<List<Anime>>>> =
        MutableLiveData()

    val seasonList: LiveData<List<Anime>> = Transformations.map(seasonResource) {
        if (it.status == Resource.Status.SUCCESS) {
            return@map it.data?.data
        }
        return@map null
    }

    val seasonError: LiveData<String> = Transformations.map(seasonResource) {
        if (it.status == Resource.Status.ERROR) {
            return@map it.message
        }
        return@map null
    }

    val isLoadingSeason: LiveData<Boolean> = Transformations.map(seasonResource) {
        return@map it.status == Resource.Status.LOADING
    }

    fun loadSeason() {
        viewModelScope.launch(dispatchers.io) {
            service.getService(2021, "spring").collect {
                seasonResource.postValue(it)
            }
        }
    }
}