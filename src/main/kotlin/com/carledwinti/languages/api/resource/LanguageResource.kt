package com.carledwinti.languages.api.resource

import com.carledwinti.languages.api.LanguageService
import com.carledwinti.languages.api.document.Language
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class LanguageResource {

    @Autowired
    lateinit var languageService: LanguageService

    @GetMapping("/status")
    fun status(): String = "The application is running"

    @GetMapping("/")
    fun all(): ResponseEntity<Any> {

        val languageList: MutableList<Language> = languageService.all()

        if (languageList != null && languageList.isNotEmpty())
            return ResponseEntity.ok().body(languageList)

        return ResponseEntity("No Data Found", HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun create(@Valid @RequestBody language: Language): ResponseEntity<Any> {
        val savedLanguage: Language = languageService.save(language)
        return ResponseEntity(savedLanguage, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<Any> {
        val foundLanguage = languageService.findById(id)

        if (!foundLanguage.isPresent)
            return ResponseEntity("No Data Found", HttpStatus.NOT_FOUND)

        return ResponseEntity(foundLanguage, HttpStatus.OK)
    }

    @DeleteMapping("/")
    fun deleteAll(): ResponseEntity<Any> {
        languageService.deleteAll()
        return ResponseEntity("Deleted All Data", HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteAll(@PathVariable id: String): ResponseEntity<Any> {
        languageService.deleteById(id)
        return ResponseEntity("Deleted Data", HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody language: Language): ResponseEntity<Any>{
        language.id = id

        val updatedLanguage = languageService.update(language)
        if (updatedLanguage != null)
            return ResponseEntity("Updated Data Successfully", HttpStatus.OK)

        return ResponseEntity("Failure on Trying update the data", HttpStatus.INTERNAL_SERVER_ERROR)
    }
}