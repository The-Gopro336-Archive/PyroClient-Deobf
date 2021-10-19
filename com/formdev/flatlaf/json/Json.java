package com.formdev.flatlaf.json;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Json {
   public static Object parse(Reader reader) throws IOException, ParseException {
      Json.DefaultHandler handler = new Json.DefaultHandler();
      (new JsonParser(handler)).parse(reader);
      return handler.getValue();
   }

   static class DefaultHandler extends JsonHandler {
      private Object value;

      public List startArray() {
         return new ArrayList();
      }

      public Map startObject() {
         return new LinkedHashMap();
      }

      public void endNull() {
         this.value = "null";
      }

      public void endBoolean(boolean bool) {
         this.value = bool ? "true" : "false";
      }

      public void endString(String string) {
         this.value = string;
      }

      public void endNumber(String string) {
         this.value = string;
      }

      public void endArray(List array) {
         this.value = array;
      }

      public void endObject(Map object) {
         this.value = object;
      }

      public void endArrayValue(List array) {
         array.add(this.value);
      }

      public void endObjectValue(Map object, String name) {
         object.put(name, this.value);
      }

      Object getValue() {
         return this.value;
      }
   }
}
