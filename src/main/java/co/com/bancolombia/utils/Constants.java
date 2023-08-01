package co.com.bancolombia.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Constants {

    public static final String PLUGIN_TASK_GROUP = "ScreenPlay Architecture";
    public static final String APP_SERVICE = "app-service";

    public enum BooleanOption {
        TRUE,
        FALSE
    }

    public enum Language {
        JAVA,
        KOTLIN
    }

    public static final int Java11 = 11;

    public enum ProjectType {
        REST,
        UX
    }

    public static final String PLUGIN_VERSION = "1.0.0";
    public static final String BUILD_GRADLE = "./build.gradle";
    public static final String SERENITY_PROPERTIES = "./serenity.properties";
    public static final String BANCOLOMBIA_REPOSITORIES = "https://artifactory.apps.bancolombia.com/maven-bancolombia/";
    public static final String SERENITY_VERSION = "1.9.20";
    public static final String SERENITY_CUCUMBER_VERSION = "1.9.8";
    public static final String LOMBOK_VERSION = "1.18.22";
    public static final String JUNIT = "4.12";
    public static final String HAMCREST = "1.3";
    public static final List<String> INTERACTIONS = List.of(new String[]{"POST", "GET", "PUT", "OPTIONS", "PATCH"});
    public static final List<String> TASKS = List.of(new String[]{"UX", "REST"});


}
