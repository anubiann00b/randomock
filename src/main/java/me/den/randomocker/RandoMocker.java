package me.den.randomocker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import me.den.randomocker.anno.RandoMock;

public class RandoMocker {

   private Random mRandom;

   public RandoMocker() {
      mRandom = new Random();
   }

   public String fetch(Class<?> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
      Object instance = clazz.getConstructors()[0].newInstance();

      for (Field field : instance.getClass().getDeclaredFields()) {

         if (field.isAnnotationPresent(RandoMock.class)) {
            switch (field.getType().toString()) {
               case "int": {
                  processIntField(field, instance);
                  break;
               }
               case "String": {
                  processStringField(field, instance);
                  break;
               }
               case "long": {
                  processLongField(field, instance);
                  break;
               }
            }
         }
      }

      return instance.toString();
   }

   private void processIntField(Field field, Object instance) throws IllegalAccessException {
      Utils.patchAccessibility(field);

      RandoMock annotation = field.getAnnotation(RandoMock.class);

      int[] defaultKit = annotation.intKit();
      int result;

      if (defaultKit.length == 0) {
         int min, max;

         min = annotation.minInt();
         max = annotation.maxInt();

         result = Utils.getRandomInt(mRandom, min, max);
      } else {
         result = defaultKit[mRandom.nextInt(defaultKit.length)];
      }

      field.setInt(instance, result);
   }

   private void processStringField(Field field, Object instance) throws IllegalAccessException {
      Utils.patchAccessibility(field);

      RandoMock annotation = field.getAnnotation(RandoMock.class);

      String[] defaultKit = annotation.stringKit();
      String result;
      if (defaultKit.length == 0) {
         result = new NonsenseGenerator(mRandom).makeHeadline();
      } else {
         result = defaultKit[mRandom.nextInt(defaultKit.length)];
      }

      field.set(instance, result);
   }

   private void processLongField(Field field, Object instance) throws IllegalAccessException {
      Utils.patchAccessibility(field);

      RandoMock annotation = field.getAnnotation(RandoMock.class);

      long[] defaultKit = annotation.longKit();
      long result;
      if (defaultKit.length == 0) {
         long min, max;

         min = annotation.minLong();
         max = annotation.maxLong();

         result = Utils.getRandomLong(mRandom, min, max);
      } else {
         result = defaultKit[mRandom.nextInt(defaultKit.length)];
      }

      field.setLong(instance, result);
   }

   private void processDoubleField(Field field, Object instance) throws IllegalAccessException {
      Utils.patchAccessibility(field);

      RandoMock annotation = field.getAnnotation(RandoMock.class);

      long[] defaultKit = annotation.longKit();
      long result;
      if (defaultKit.length == 0) {
         long min, max;

         min = annotation.minLong();
         max = annotation.maxLong();

         result = Utils.getRandomLong(mRandom, min, max);
      } else {
         result = defaultKit[mRandom.nextInt(defaultKit.length)];
      }

      field.setLong(instance, result);
   }
}
