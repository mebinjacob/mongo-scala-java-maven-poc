package modelss

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import scala.reflect.BeanProperty

@Document
class Users(var userName:String, var userPassword:String) {
	 
	@BeanProperty
	@Id
	var id: String = _
	@BeanProperty 
	var name: String = userName
	@BeanProperty 
	var password: String = userPassword
}