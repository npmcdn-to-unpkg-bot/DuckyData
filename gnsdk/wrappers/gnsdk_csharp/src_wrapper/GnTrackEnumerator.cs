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

public class GnTrackEnumerator : System.Collections.Generic.IEnumerator<GnTrack>, IDisposable {
  private HandleRef swigCPtr;
  protected bool swigCMemOwn;

  internal GnTrackEnumerator(IntPtr cPtr, bool cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = new HandleRef(this, cPtr);
  }

  internal static HandleRef getCPtr(GnTrackEnumerator obj) {
    return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
  }

  ~GnTrackEnumerator() {
    Dispose();
  }

  public virtual void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          gnsdk_csharp_marshalPINVOKE.delete_GnTrackEnumerator(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
    }
  }

			public bool
			MoveNext( )
			{
				return hasNext( );
			}

			public GnTrack Current {
				get {
					return next( );
				}
			}
			object System.Collections.IEnumerator.Current {
				get {
					return Current;
				}
			}
			public void
			Reset( )
			{
			}

		
  public GnTrack __ref__() {
    GnTrack ret = new GnTrack(gnsdk_csharp_marshalPINVOKE.GnTrackEnumerator___ref__(swigCPtr), false);
    if (gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Pending) throw gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public GnTrack next() {
    GnTrack ret = new GnTrack(gnsdk_csharp_marshalPINVOKE.GnTrackEnumerator_next(swigCPtr), true);
    if (gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Pending) throw gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public bool hasNext() {
    bool ret = gnsdk_csharp_marshalPINVOKE.GnTrackEnumerator_hasNext(swigCPtr);
    return ret;
  }

  public uint distance(GnTrackEnumerator itr) {
    uint ret = gnsdk_csharp_marshalPINVOKE.GnTrackEnumerator_distance(swigCPtr, GnTrackEnumerator.getCPtr(itr));
    if (gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Pending) throw gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public GnTrackEnumerator(GnTrackProvider provider, uint pos) : this(gnsdk_csharp_marshalPINVOKE.new_GnTrackEnumerator(GnTrackProvider.getCPtr(provider), pos), true) {
    if (gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Pending) throw gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Retrieve();
  }

}

}