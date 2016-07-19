
package com.gracenote.gnsdk;

/** 
* Content types 
*/ 
 
public enum GnContentType {
 
 
  kContentTypeNull(0),
 
 
  kContentTypeUnknown(1),
 
 
  kContentTypeImageCover,
 
 
  kContentTypeImageArtist,
 
 
  kContentTypeImageVideo,
 
 
  kContentTypeBiography,
 
 
  kContentTypeReview,
 
 
  kContentTypeNews,
 
 
  kContentTypeArtistNews,
 
 
  kContentTypeListenerComments,
 
 
  kContentTypeReleaseComments;

  protected final int swigValue() {
    return swigValue;
  }

  protected static GnContentType swigToEnum(int swigValue) {
    GnContentType[] swigValues = GnContentType.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (GnContentType swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + GnContentType.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private GnContentType() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private GnContentType(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private GnContentType(GnContentType swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

