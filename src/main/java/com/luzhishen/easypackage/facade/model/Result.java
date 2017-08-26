package com.luzhishen.easypackage.facade.model;

import java.lang.reflect.Type;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.luzhishen.easypackage.facade.constant.ErrorCode;
import com.luzhishen.easypackage.facade.util.BaseJavaBean;

public class Result extends BaseJavaBean {
    private int code;
    private String message;
    private Object data;

    public static Result newInstance(ErrorCode errorCode, Object... data) {
        return new Result(errorCode, data);
    }

    private Result(ErrorCode errorCode, Object... data) {
        this(errorCode.getCode(), errorCode.getMessage(), data);
    }

    private Result() {
    }

    private Result(int code, String message, Object... data) {
        this.code = code;
        this.message = message;
        if (data != null && data.length > 0) {
            this.data = data[0];
        }
    }

    private static class ResultSerialiser implements JsonSerializer<Result> {
        @Override
        public JsonElement serialize(Result result, Type typeOfSrc,
                JsonSerializationContext context) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("code", result.code);
            jsonObject.addProperty("message", result.message);
            if (result.data != null) {
                if (result.data instanceof JSONObject) {
                } else if (result.data instanceof JSONArray) {
                }
            }
            return jsonObject;
        }

    }

    public String toJson() {
        return new Gson().toJson(this).toString();
    }

    @Override
    public String toString() {
        return toJson();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
