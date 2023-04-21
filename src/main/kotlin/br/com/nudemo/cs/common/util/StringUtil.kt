package br.com.nudemo.cs.common.util

import java.text.Normalizer
import java.util.*
import java.util.regex.MatchResult
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.stream.Collectors
import java.util.stream.Stream

class StringUtil {

    companion object {

        private val ONLY_DIGITS_PATTERN = Pattern.compile("\\d+")
        private val NON_ASCII_PATTERN = Pattern.compile("[^\\p{ASCII}]");
        private const val EMPTY = "";

        fun removeNonDigits(input: String): String {
            return Optional.of(input)
                .map { value: String -> value.trim() }
                .map { value: String -> ONLY_DIGITS_PATTERN.matcher(value) }
                .map { value: Matcher -> value.results() }
                .map { value: Stream<MatchResult> -> value.map{ it: MatchResult -> it.group() } }
                .map { value: Stream<String> -> value.collect(Collectors.joining()) }
                .orElse(EMPTY)
        }

        fun removeAccents(input: String): String {
            return Optional.of(input)
                .map { value: String -> Normalizer.normalize(value, Normalizer.Form.NFKD) }
                .map { value: String -> NON_ASCII_PATTERN.matcher(value).replaceAll(EMPTY) }
                .orElse(EMPTY)
        }


    }

}