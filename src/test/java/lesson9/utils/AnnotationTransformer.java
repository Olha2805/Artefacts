package test.java.lesson9.utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import test.java.DataProviders;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
       /* iTestAnnotation.getDataProviderClass(DataProviders.class);
        iTestAnnotation */

    }
}