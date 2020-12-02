package seleniumTestProjects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Statement {
	

        public void postDetails()
        {
        	RequestSpecification requestSpec = RestAssured.given();
        	JSONArray list  = new JSONArray();
        	JSONObject requestParams = new JSONObject();
        	JSONObject statement = new JSONObject();
        	
        	try {
				requestParams.put("account_id", "101101");
			  	requestParams.put("amount", "20.00");
	        	requestParams.put("currency", "EUR");
	        	requestParams.put("date", "1594947905");
	        	statement.put("statement", requestParams);
	        	
	        	list.put(statement);
	        	requestParams = new JSONObject();
	        	statement = new JSONObject();
	        	requestParams.put("account_id", "101102");
			  	requestParams.put("amount", "20.00");
	        	requestParams.put("currency", "EUR");
	        	requestParams.put("date", "1594947905");
	        	statement.put("statement", requestParams);
	        	
	        	list.put(statement);
	        	requestParams = new JSONObject();
	        	statement = new JSONObject();
	        	requestParams.put("account_id", "101103");
			  	requestParams.put("amount", "20.00");
	        	requestParams.put("currency", "EUR");
	        	requestParams.put("date", "1594947905");
	        	statement.put("statement", requestParams);
	        	
	        	list.put(statement);
	        	requestParams = new JSONObject();
	        	statement = new JSONObject();
	        	requestParams.put("account_id", "101104");
			  	requestParams.put("amount", "20.00");
	        	requestParams.put("currency", "EUR");
	        	requestParams.put("date", "1594947905");
	        	statement.put("statement", requestParams);
	        	
	        	list.put(statement);
	        	requestParams = new JSONObject();
	        	statement = new JSONObject();
	        	requestParams.put("account_id", "101105");
			  	requestParams.put("amount", "20.00");
	        	requestParams.put("currency", "EUR");
	        	requestParams.put("date", "1594947905");
	        	statement.put("statement", requestParams);
	        	
	        	list.put(statement);
	        	System.out.println(requestParams);
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
        	
        	for(int i=0; i<list.length(); i++) {
        	try {
				requestSpec.body(list.get(i).toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}

        	io.restassured.response.Response response = requestSpec.post("http://localhost:9999/statements");
        	}

        }
}
