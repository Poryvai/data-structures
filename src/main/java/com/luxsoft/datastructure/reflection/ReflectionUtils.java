package com.luxsoft.datastructure.reflection;

import java.lang.reflect.*;

public class ReflectionUtils {

    public static Object createInstanc(Class clazz) {
        Object obj = null;
        try {
            clazz = Class.forName(Object.class.getName());
            obj = (Object) clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void callAllMethodsWithoutParameters(Object object) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods){
            if(method.getParameterCount() == 0) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    public static void showFinalMethods(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if(Modifier.isFinal(method.getModifiers())) {
                System.out.println("Метод: "+method);
            }
        }
    }

    public static void showNonPublicMethods(Class clazz) {
        Method[] methods = clazz.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if(!Modifier.isPublic(method.getModifiers())) {
                System.out.println("Метод: "+method);
            }
        }
    }

    public static void showParentsAndInterfaces(Class clazz) {
        Class[] interfaces = clazz.getInterfaces();
        Class superClass = clazz.getSuperclass();

        System.out.println("Предок: "+superClass);

        for (Class anInterface : interfaces) {
            System.out.println("Интерфейс: "+anInterface);
        }
    }

    public static void changeFieldsToDefault(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(Modifier.isPrivate(field.getModifiers())){
                field.setAccessible(true);
                if(field.getType() == String.class){
                    field.set(object, null);
                }
                else if(field.getType() == int.class){
                    field.setInt(object, 0);
                }
                else if(field.getType() == boolean.class){
                    field.setBoolean(object, false);
                }
            }
        }
    }






}