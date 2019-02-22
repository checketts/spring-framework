package org.springframework.test.web.servlet

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.mock.web.MockHttpSession
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.RequestPostProcessor
import org.springframework.util.MultiValueMap
import java.security.Principal
import java.util.*
import javax.servlet.http.Cookie

/**
 * @author Sebastien Deleuze
 */
open class MockHttpServletRequestDsl(private val builder: MockHttpServletRequestBuilder) {

	var contextPath: String? = null
		set(value) = builder.contextPath(value!!).let { contextPath = value }

	var servletPath: String? = null
		set(value) = builder.servletPath(value!!).let { servletPath = value }

	var pathInfo: String? = null
		set(value) = builder.pathInfo(value).let { pathInfo = value }

	var secure: Boolean? = null
		set(value) = builder.secure(value!!).let { secure = value }

	var characterEncoding: String? = null
		set(value) = builder.characterEncoding(value!!).let { characterEncoding = value }

	var contentAsByte: ByteArray? = null
		set(value) = builder.content(value!!).let { contentAsByte = value }

	var content: String? = null
		set(value) = builder.content(value!!).let { content = value }

	var accept: MediaType? = null
		set(value) = builder.accept(value).let { accept = value }

	var contentType: MediaType? = null
		set(value) = builder.contentType(value!!).let { contentType = value }

	fun headers(headers: HttpHeaders.() -> Unit) {
		builder.headers(HttpHeaders().apply(headers))
	}

	fun header(name: String, vararg values: Any) {
		builder.header(name, *values)
	}

	fun param(name: String, vararg values: String) {
		builder.param(name, *values)
	}

	fun params(params: MultiValueMap<String, String>) {
		builder.params(params)
	}

	fun cookie(vararg cookies: Cookie) {
		builder.cookie(*cookies)
	}

	fun locale(vararg locales: Locale) {
		builder.locale(*locales)
	}

	fun requestAttr(name: String, value: Any) {
		builder.requestAttr(name, value)
	}

	fun sessionAttr(name: String, value: Any) {
		builder.sessionAttr(name, value)
	}

	fun sessionAttrs(sessionAttributes: Map<String, Any>) {
		builder.sessionAttrs(sessionAttributes)
	}

	fun flashAttr(name: String, value: Any) {
		builder.flashAttr(name, value)
	}

	fun flashAttrs(flashAttributes: Map<String, Any>) {
		builder.flashAttrs(flashAttributes)
	}

	var session: MockHttpSession? = null
		set(value) = builder.session(value!!).let { session = value }

	var principal: Principal? = null
		set(value) = builder.principal(value!!).let { principal = value }

	fun with(processor: RequestPostProcessor) {
		builder.with(processor)
	}

}