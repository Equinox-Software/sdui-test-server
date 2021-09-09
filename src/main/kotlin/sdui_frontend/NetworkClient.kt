package sdui_frontend

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.DefaultRequest
import io.ktor.client.features.defaultRequest
import io.ktor.client.request.header
import io.ktor.client.request.host
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol


val client = HttpClient(CIO) {

    defaultRequest {
        host = "sdui-test-database.herokuapp.com/"
        url {
            protocol = URLProtocol.HTTPS
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}

