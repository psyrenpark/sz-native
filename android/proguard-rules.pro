    -keep class * extends java.util.ListResourceBundle {
        protected Object[][] getContents();
    }

    -keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
        public static final *** NULL;
    }

    -keepnames @com.google.android.gms.common.annotation.KeepName class *
    -keepclassmembernames class * {
        @com.google.android.gms.common.annotation.KeepName *;
    }

    -keepnames class * implements android.os.Parcelable {
        public static final ** CREATOR;
    }

    -keep class com.google.android.gms.ads.** { *; }
    -dontwarn com.google.android.gms.ads.**

    -keep class com.gomfactory.** { *; }
    -dontwarn com.gomfactory.**
    -dontwarn com.squareup.picasso.**
    -dontwarn com.bumptech.glide.**