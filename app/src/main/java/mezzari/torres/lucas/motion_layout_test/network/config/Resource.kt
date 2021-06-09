package mezzari.torres.lucas.motion_layout_test.network.config

/**
 * @author Lucas T. Mezzari
 * @since 09/06/2021
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String?, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null)
        }
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }
}