-assumenosideeffects class timber.log.Timber {
    public static void v(...);
    public static void d(...);
    public static void i(...);
    public static void w(...);
}
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao interface * { *; }
-keepattributes *Annotation*, InnerClasses
-keepclassmembers class * { @kotlinx.serialization.Serializable <fields>; }
-keepclassmembers class * { *** Companion; }
-keepclasseswithmembers class * { kotlinx.serialization.KSerializer serializer(...); }
-keepattributes Signature, Exceptions
-keepclassmembers class androidx.security.crypto.** { *; }
