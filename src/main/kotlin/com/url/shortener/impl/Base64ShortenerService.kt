package com.url.shortener.impl

import com.url.shortener.model.DecodeRequest
import com.url.shortener.model.DecodeResponse
import com.url.shortener.model.EncodeRequest
import com.url.shortener.model.EncodeResponse
import com.url.shortener.service.ShortenerService
import org.springframework.stereotype.Component
import java.util.*

@Component
class Base64ShortenerService : ShortenerService {
    override fun encode(encodeRequest: EncodeRequest): EncodeResponse {
        return EncodeResponse(Base64.getEncoder().encodeToString(encodeRequest.url.toByteArray(Charsets.UTF_8)))
    }

    override fun decode(decodeRequest: DecodeRequest): DecodeResponse {
        return DecodeResponse(Base64.getDecoder().decode(decodeRequest.encodedUrl).toString(Charsets.UTF_8));
    }
}