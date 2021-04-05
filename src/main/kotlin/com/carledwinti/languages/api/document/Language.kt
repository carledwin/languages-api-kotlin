package com.carledwinti.languages.api.document

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Document
data class Language(@Id var id: String?,
                    @NotEmpty(message ="The Name can't be empty")
                    @NotNull(message ="The Name can't be null") var name: String,
                    var description: String?,
                    val createdDate: LocalDateTime = LocalDateTime.now())
