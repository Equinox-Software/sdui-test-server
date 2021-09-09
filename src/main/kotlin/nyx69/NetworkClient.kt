package nyx69

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

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

