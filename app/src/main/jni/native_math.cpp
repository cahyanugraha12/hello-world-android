//
// Created by Cahya Nugraha on 07/12/2020.
//

#include <jni.h>
#include <android/log.h>

extern "C" jint Java_id_ac_ui_cs_mobileprogramming_cahyanugraha_myWarcraft_MainActivity_nativeAdd(
        JNIEnv* env,
        jobject /* this */,
        int first,
        int second
        ) {
        __android_log_print(
                ANDROID_LOG_INFO,
                "native_math_nativeAdd",
                "Adding: %d + %d = %d", first, second, first + second
        );
        return first + second;
}

extern "C" jint Java_id_ac_ui_cs_mobileprogramming_cahyanugraha_myWarcraft_MainActivity_nativeSubtract(
        JNIEnv* env,
        jobject /* this */,
        int first,
        int second
        ) {
        __android_log_print(
                ANDROID_LOG_INFO,
                "native_math_nativeSubtract",
                "Subtracting: %d - %d = %d", first, second, first - second
        );
        return first - second;
}