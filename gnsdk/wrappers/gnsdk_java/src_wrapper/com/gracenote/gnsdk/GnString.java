/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnString extends GnObject {
  private long swigCPtr;

  protected GnString(long cPtr, boolean cMemoryOwn) {
    super(gnsdk_javaJNI.GnString_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnString obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnString(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

		public String
		toString( )
		{
			String str = cStr( );
			return str;
		}
	
  public GnString() {
    this(gnsdk_javaJNI.new_GnString__SWIG_0(), true);
  }

  public GnString(String str) {
    this(gnsdk_javaJNI.new_GnString__SWIG_1(str), true);
  }

  public GnString(GnString str) {
    this(gnsdk_javaJNI.new_GnString__SWIG_2(GnString.getCPtr(str), str), true);
  }

  public GnString set(GnString str) {
    return new GnString(gnsdk_javaJNI.GnString_set__SWIG_0(swigCPtr, this, GnString.getCPtr(str), str), false);
  }

  public GnString set(String str) {
    return new GnString(gnsdk_javaJNI.GnString_set__SWIG_1(swigCPtr, this, str), false);
  }

  public String cStr() {
    return gnsdk_javaJNI.GnString_cStr(swigCPtr, this);
  }

  public boolean isEmpty() {
    return gnsdk_javaJNI.GnString_isEmpty(swigCPtr, this);
  }

  public static GnString manage(String str) {
    return new GnString(gnsdk_javaJNI.GnString_manage(str), true);
  }

}
