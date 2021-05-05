package com.sample.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseMessage {
	public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    
    private int status;
    private String message;
    private Map<String,Object> result;
     

	public ResponseMessage() {
    	result = new LinkedHashMap<String,Object>();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
    public void addPayload(String key, Object value){
        if (result == null )
        	result = new HashMap<String,Object>();
            result.put(key, value);
    }
}
