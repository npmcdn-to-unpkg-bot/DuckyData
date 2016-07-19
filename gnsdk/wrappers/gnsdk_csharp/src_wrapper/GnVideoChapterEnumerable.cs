/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

namespace GracenoteSDK {

using System;
using System.Runtime.InteropServices;

public class GnVideoChapterEnumerable : System.Collections.Generic.IEnumerable<GnVideoChapter>, IDisposable {
  private HandleRef swigCPtr;
  protected bool swigCMemOwn;

  internal GnVideoChapterEnumerable(IntPtr cPtr, bool cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = new HandleRef(this, cPtr);
  }

  internal static HandleRef getCPtr(GnVideoChapterEnumerable obj) {
    return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
  }

  ~GnVideoChapterEnumerable() {
    Dispose();
  }

  public virtual void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          gnsdk_csharp_marshalPINVOKE.delete_GnVideoChapterEnumerable(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
    }
  }

			System.Collections.Generic.IEnumerator<GnVideoChapter> System.Collections.Generic.IEnumerable<GnVideoChapter> .GetEnumerator( )
			{
				return GetEnumerator( );
			}
			System.Collections.IEnumerator System.Collections.IEnumerable.
			    GetEnumerator( )
			{
				return GetEnumerator( );
			}

		
  public GnVideoChapterEnumerable(GnVideoChapterProvider provider, uint start) : this(gnsdk_csharp_marshalPINVOKE.new_GnVideoChapterEnumerable(GnVideoChapterProvider.getCPtr(provider), start), true) {
    if (gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Pending) throw gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Retrieve();
  }

  public GnVideoChapterEnumerator GetEnumerator() {
    GnVideoChapterEnumerator ret = new GnVideoChapterEnumerator(gnsdk_csharp_marshalPINVOKE.GnVideoChapterEnumerable_GetEnumerator(swigCPtr), true);
    return ret;
  }

  public GnVideoChapterEnumerator end() {
    GnVideoChapterEnumerator ret = new GnVideoChapterEnumerator(gnsdk_csharp_marshalPINVOKE.GnVideoChapterEnumerable_end(swigCPtr), true);
    return ret;
  }

  public uint count() {
    uint ret = gnsdk_csharp_marshalPINVOKE.GnVideoChapterEnumerable_count(swigCPtr);
    return ret;
  }

  public GnVideoChapterEnumerator at(uint index) {
    GnVideoChapterEnumerator ret = new GnVideoChapterEnumerator(gnsdk_csharp_marshalPINVOKE.GnVideoChapterEnumerable_at(swigCPtr, index), true);
    return ret;
  }

  public GnVideoChapterEnumerator getByIndex(uint index) {
    GnVideoChapterEnumerator ret = new GnVideoChapterEnumerator(gnsdk_csharp_marshalPINVOKE.GnVideoChapterEnumerable_getByIndex(swigCPtr, index), true);
    return ret;
  }

}

}
