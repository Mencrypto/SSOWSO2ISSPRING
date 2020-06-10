package mx.com.mencrypto.wso2.is.sso.pocsso.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserModel {

	private String id;

	public UserModel(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
