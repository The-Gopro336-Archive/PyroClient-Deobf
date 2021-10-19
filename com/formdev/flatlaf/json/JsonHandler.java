package com.formdev.flatlaf.json;

abstract class JsonHandler {
   JsonParser parser;

   protected Location getLocation() {
      return this.parser.getLocation();
   }

   public void startNull() {
   }

   public void endNull() {
   }

   public void startBoolean() {
   }

   public void endBoolean(boolean value) {
   }

   public void startString() {
   }

   public void endString(String string) {
   }

   public void startNumber() {
   }

   public void endNumber(String string) {
   }

   public Object startArray() {
      return null;
   }

   public void endArray(Object array) {
   }

   public void startArrayValue(Object array) {
   }

   public void endArrayValue(Object array) {
   }

   public Object startObject() {
      return null;
   }

   public void endObject(Object object) {
   }

   public void startObjectName(Object object) {
   }

   public void endObjectName(Object object, String name) {
   }

   public void startObjectValue(Object object, String name) {
   }

   public void endObjectValue(Object object, String name) {
   }
}
