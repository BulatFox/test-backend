package mobi.sevenwinds.app.author
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.joda.time.DateTime
import org.joda.time.LocalDateTime
object AuthorTable : IntIdTable("author") {
    val fio = varchar("fio", 256)
    val creationDate = datetime("creation_date").clientDefault { DateTime.now()
    }
}
class AuthorEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AuthorEntity>(AuthorTable)
    var fio by AuthorTable.fio
    var creationDate by AuthorTable.creationDate
    fun toRequest(): AuthorRequest {
        return AuthorRequest(fio)
    }
    fun toResponse(): AuthorResponse {
        return AuthorResponse(fio, creationDate)
    }
}
