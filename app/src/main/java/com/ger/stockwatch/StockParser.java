package com.ger.stockwatch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
//Stock parser Class for parsing financial data quickly by use of hashmap
public class StockParser {
    static Map<String,String> stock_company;        //Static map for all financial data
    JSONArray array;                                //Array of Financial elements iteration

    //Initialize Parser with JSON array parser
    public StockParser(JSONArray jsonArray) {
        stock_company=new HashMap<String,String>();
        this.array=jsonArray;
        Parse();


    }
    //total number of stocks i the Hashmap
    public int size()
    {
        return stock_company.size();
    }
    //Parser
    //JSON Parsing  values are set on a Hashmap with Symbol as key and Company as the value
    //JSON ARRAY
    public void Parse()
    {
     for (int x=0;x<array.length();x++)
        {
            try
            {
                JSONObject Jobj=array.getJSONObject(x);
                String Stock=Jobj.getString("symbol");
                String Company=Jobj.getString("name");
                stock_company.put(Stock,Company);
            }catch (JSONException E)
            {
                E.printStackTrace();
            }
        }
    }

    //Search financial [query]
    //return Number of items in query results
    public int Search(String Stock_company)
    {
        Map<String,String> Results=new HashMap<String,String>();
        for(Map.Entry<String,String> set:stock_company.entrySet())
        {
            if(set.getKey().contains(Stock_company))
                Results.put(set.getKey(), set.getValue());

        }return Results.size();
    }

    //Search financial [query]
    //return a hashmap of query results
    public HashMap<String,String> Searchmap(String Stock_company)
    {
        HashMap<String,String> Results=new HashMap<String,String>();
        for(Map.Entry<String,String> set:stock_company.entrySet())
        {
            if(set.getKey().contains(Stock_company))
                Results.put(set.getKey(), set.getValue());

        }  return Results;
    }

}
