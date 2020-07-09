# DemotimeAgolibrary
ony display date time ago 

// maximam sdk version apply

compileSdkVersion 29
    buildToolsVersion "29.0.3"

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Add the dependency
  
 dependencies {
	        implementation 'com.github.popnitesh:DemotimeAgolibrary:0.1.0'
	}
