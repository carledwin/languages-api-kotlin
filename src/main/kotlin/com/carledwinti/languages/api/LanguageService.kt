package com.carledwinti.languages.api

import com.carledwinti.languages.api.document.Language
import com.carledwinti.languages.api.repository.LanguageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LanguageService {

    @Autowired
    lateinit var languageRepository: LanguageRepository

    fun all(): MutableList<Language> = languageRepository.findAll()
    fun save(language: Language) = languageRepository.save(language)
    fun deleteAll() = languageRepository.deleteAll()
    fun findById(id: String) = languageRepository.findById(id)
    fun deleteById(id: String) = languageRepository.deleteById(id)
    fun update(language: Language): Language = languageRepository.save(language)
}