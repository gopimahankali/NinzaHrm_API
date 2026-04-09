 package com.Ninza.Hrm.api.Json_Utility;

import java.util.List;

import com.Ninza.Hrm.api.File_Utility.PropertyFile;

import io.restassured.response.Response;

public class Json_Utility {

	PropertyFile file = new PropertyFile();

	public String getDataOnJsonPath(Response resp, String jsonXpath) {

		List<Object> list = resp.jsonPath().getList(jsonXpath);

		return list.get(0).toString();
	}

	public String getDataOnJsonPath(Response resp, String jsonXpath, int index){
		return resp.jsonPath().getList(jsonXpath).get(index).toString();
	}

}
