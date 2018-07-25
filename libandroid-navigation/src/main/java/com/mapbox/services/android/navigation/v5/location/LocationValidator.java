package com.mapbox.services.android.navigation.v5.location;

import android.location.Location;
import android.support.annotation.NonNull;

public class LocationValidator {

  private static final int ONE_HUNDRED_METER_ACCURACY = 100;

  private Location lastValidLocation;

  public boolean isValidUpdate(@NonNull Location location) {
    return checkLastValidLocation(location) || location.getAccuracy() < ONE_HUNDRED_METER_ACCURACY;
  }

  /**
   * On the first location update, the last valid location will be null.
   * <p>
   * So set the last valid location and return true.  On the next update, there
   * will be a last update to compare against.
   *
   * @param location new location update
   * @return true if last valid location null, false otherwise
   */
  private boolean checkLastValidLocation(@NonNull Location location) {
    if (lastValidLocation == null) {
      lastValidLocation = location;
      return true;
    }
    return false;
  }
}
