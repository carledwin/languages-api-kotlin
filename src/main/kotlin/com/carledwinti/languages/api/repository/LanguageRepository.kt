package com.carledwinti.languages.api.repository

import com.carledwinti.languages.api.document.Language
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface LanguageRepository: MongoRepository<Language, String> {
}